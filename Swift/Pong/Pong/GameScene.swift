//
//  GameScene.swift
//  Pong
//
//  Created by Bruno on 16/11/19.
//  Copyright © 2019 Bruno Harnik. All rights reserved.
//

import SpriteKit
import GameplayKit

class GameScene: SKScene {
    
    var bola = SKSpriteNode()
    var inimigo = SKSpriteNode()
    var jogador = SKSpriteNode()
    
    var lblInimigo = SKLabelNode()
    var lblJogador = SKLabelNode()
    
    var placar = [Int]()
    
    override func didMove(to view: SKView) {
        
        iniciaJogo()
        
        lblInimigo = self.childNode(withName: "lblInimigo") as! SKLabelNode
        lblJogador = self.childNode(withName: "lblJogador") as! SKLabelNode
        
        bola = self.childNode(withName: "bola") as! SKSpriteNode
        
        inimigo = self.childNode(withName: "inimigo") as! SKSpriteNode
        inimigo.position.y = (self.frame.height / 2) - 50
        
        jogador = self.childNode(withName: "jogador") as! SKSpriteNode
        jogador.position.y = (-self.frame.height / 2) + 50
        
        bola.physicsBody?.applyImpulse(CGVector(dx: 20, dy: 20))
        
        let borda = SKPhysicsBody(edgeLoopFrom: self.frame)
        
        borda.friction = 0
        borda.restitution = 1
        
        self.physicsBody = borda
        
    }
    
    func iniciaJogo(){
        placar = [0,0]
        lblInimigo.text = "\(placar[1])"
        lblJogador.text = "\(placar[0])"
    }
    
    func adicionaPonto(jogadorQueGanhou : SKSpriteNode){
        
        bola.position = CGPoint(x: 0, y: 0)
        bola.physicsBody?.velocity = CGVector(dx: 0, dy: 0)
        
        if jogadorQueGanhou == jogador {
            placar[0] += 1
            bola.physicsBody?.applyImpulse(CGVector(dx: 20, dy: 20))
        }else if jogadorQueGanhou == inimigo {
            placar[1] += 1
            bola.physicsBody?.applyImpulse(CGVector(dx: -20, dy: -20))
        }
        
        lblInimigo.text = "\(placar[1])"
        lblJogador.text = "\(placar[0])"
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches {
            
            let local = touch.location(in: self)
            
            jogador.run(SKAction.moveTo(x: local.x, duration: 0.2))
            
        }
    }
    
    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches {
            
            let local = touch.location(in: self)
            
            jogador.run(SKAction.moveTo(x: local.x, duration: 0.2))
            
        }
    }
    
    override func update(_ currentTime: TimeInterval) {
        inimigo.run(SKAction.moveTo(x: bola.position.x, duration: 0.05))
        
        if bola.position.y <= jogador.position.y - 20{
            adicionaPonto(jogadorQueGanhou: inimigo)
        }else if bola.position.y >= inimigo.position.y + 20{
            adicionaPonto(jogadorQueGanhou: jogador)
        }
    }
}
