//
//  GameScene.swift
//  JogoX
//
//  Created by Bruno on 14/11/19.
//  Copyright © 2019 Bruno Harnik. All rights reserved.
//

import SpriteKit
import GameplayKit
import CoreMotion

class GameScene: SKScene, SKPhysicsContactDelegate {
    
    var estrelas:SKEmitterNode!
    var jogador:SKSpriteNode!
    
    var placarLbl:SKLabelNode!
    var placar:Int = 0{
        didSet{
            placarLbl.text = "Placar: \(placar)"
        }
    }
    
    var temporizadorJogo:Timer!
    
    var aliensPossiveis = ["alien", "alien2", "alien3"]
    
    
    let categoriaAlien: UInt32 = 0x1 << 1
    let categoriaTorpedo: UInt32 = 0x1 << 0
    
    let gerenciadorMovimento = CMMotionManager()
    var aceleracaoX:CGFloat = 0
    
    override func didMove(to view: SKView) {
        
        estrelas = SKEmitterNode(fileNamed: "Estrelas")
        estrelas.position = CGPoint(x: 0, y: 1136)
        estrelas.advanceSimulationTime(30);
        addChild(estrelas)
        
        estrelas.zPosition = -1
        
        jogador = SKSpriteNode(imageNamed: "shuttle")
        
        jogador.position = CGPoint(x: self.frame.size.width / 2, y: jogador.size.height / 2 + 20)
        
        self.addChild(jogador)
        
        self.physicsWorld.gravity = CGVector(dx: 0, dy: 0)
        self.physicsWorld.contactDelegate = self
        
        placarLbl = SKLabelNode(text: "Placar 0")
        placarLbl.position = CGPoint(x: 60, y: self.frame.size.height - 20)
        placarLbl.fontName = "Courier New"
        placarLbl.fontSize = 18
        placarLbl.fontColor = UIColor.white
        placar = 0
        
        self.addChild(placarLbl)
        
        
        temporizadorJogo = Timer.scheduledTimer(timeInterval: 0.75, target: self, selector: #selector(addAlien), userInfo: nil, repeats: true)
        
        gerenciadorMovimento.accelerometerUpdateInterval = 0.2
        gerenciadorMovimento.startAccelerometerUpdates(to: OperationQueue.current!){
            (data:CMAccelerometerData?, error: Error?) in
            if let dadosAcelerometro = data {
                let aceleracao = dadosAcelerometro.acceleration
                self.aceleracaoX = CGFloat(aceleracao.x) * 0.75 + self.aceleracaoX * 0.25
            }
        }
        
    }
    
    
    
    @objc func addAlien(){
        aliensPossiveis = GKRandomSource.sharedRandom().arrayByShufflingObjects(in: aliensPossiveis) as! [String]
        
        let alien = SKSpriteNode(imageNamed: aliensPossiveis[0])
        
        let posicaoAlienAleatoria = GKRandomDistribution(lowestValue: 0, highestValue: 414)
        let position = CGFloat(posicaoAlienAleatoria.nextInt())
        
        alien.position = CGPoint(x: position, y: self.frame.size.height + alien.size.height)
        
        alien.physicsBody = SKPhysicsBody(rectangleOf: alien.size)
        alien.physicsBody?.isDynamic = true
        
        alien.physicsBody?.categoryBitMask = categoriaAlien
        alien.physicsBody?.contactTestBitMask = categoriaTorpedo
        alien.physicsBody?.collisionBitMask = 0
        
        self.addChild(alien)
        
        let duracaoAnimacao:TimeInterval = 6
        
        var vetorAcao = [SKAction]()
        
        vetorAcao.append(SKAction.move(to: CGPoint(x: position, y: -alien.size.height), duration: duracaoAnimacao))
        vetorAcao.append(SKAction.removeFromParent())
        
        alien.run(SKAction.sequence(vetorAcao))
    }
    
    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        atiraTorpedo()
    }
    
    func atiraTorpedo(){
        self.run(SKAction.playSoundFileNamed("torpedo.mp3", waitForCompletion: false))
        
        let torpedoNode = SKSpriteNode(imageNamed: "torpedo")
        torpedoNode.position = jogador.position
        torpedoNode.position.y += 5
        
        torpedoNode.physicsBody = SKPhysicsBody(circleOfRadius: torpedoNode.size.width / 2)
        torpedoNode.physicsBody?.isDynamic = true
        
        torpedoNode.physicsBody?.categoryBitMask = categoriaTorpedo
        torpedoNode.physicsBody?.contactTestBitMask = categoriaAlien
        torpedoNode.physicsBody?.collisionBitMask = 0
        torpedoNode.physicsBody?.usesPreciseCollisionDetection = true
        
        self.addChild(torpedoNode)
        
        let duracaoAnimacao:TimeInterval = 0.3
        
        var vetorAcao = [SKAction]()
        
        vetorAcao.append(SKAction.move(to: CGPoint(x: jogador.position.x, y: self.frame.size.height + 10), duration: duracaoAnimacao))
        
        torpedoNode.run(SKAction.sequence(vetorAcao))
    }
    
    func didBegin(_ contact: SKPhysicsContact) {
        var primeiroCorpo:SKPhysicsBody
        var segundoCorpo:SKPhysicsBody
        
        if contact.bodyA.categoryBitMask < contact.bodyB.categoryBitMask {
            primeiroCorpo = contact.bodyA
            segundoCorpo = contact.bodyB
        }else{
            primeiroCorpo = contact.bodyB
            segundoCorpo = contact.bodyA
        }
        
        if (primeiroCorpo.categoryBitMask & categoriaTorpedo) != 0 && (segundoCorpo.categoryBitMask & categoriaAlien) != 0 {
            torpedoColideAlien(torpedoNode: primeiroCorpo.node as! SKSpriteNode, alienNode: segundoCorpo.node as! SKSpriteNode)
        }
        
    }
    
    func torpedoColideAlien(torpedoNode:SKSpriteNode, alienNode:SKSpriteNode) {
        
        let explosao = SKEmitterNode(fileNamed: "Explosion")
        explosao!.position = alienNode.position
        self.addChild(explosao!)
        
        self.run(SKAction.playSoundFileNamed("explosion.mp3", waitForCompletion: false))
        
        torpedoNode.removeFromParent()
        alienNode.removeFromParent()
        
        self.run(SKAction.wait(forDuration: 2)) {
            explosao!.removeFromParent()
        }
         placar += 5
    }
    
    override func didSimulatePhysics() {
        jogador.position.x += aceleracaoX * 60
        if jogador.position.x < -20 {
            jogador.position = CGPoint(x: self.size.width + 20, y: jogador.position.y)
            
        }else if jogador.position.x > self.size.width + 20 {
            jogador.position = CGPoint(x: -20, y: jogador.position.y)
        }
    }
    

override func update(_ currentTime: TimeInterval) {
    // Called before each frame is rendered
    }
}
