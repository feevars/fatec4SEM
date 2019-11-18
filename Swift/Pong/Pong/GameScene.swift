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
        
        lblInimigo = self.childNode(withName: "lblInimigo") as! SKLabelNode
        lblJogador = self.childNode(withName: "lblJogador") as! SKLabelNode
        
        bola = self.childNode(withName: "bola") as! SKSpriteNode
        
        inimigo = self.childNode(withName: "inimigo") as! SKSpriteNode
        inimigo.position.y = (self.frame.height / 2) - 50
        
        jogador = self.childNode(withName: "jogador") as! SKSpriteNode
        jogador.position.y = (-self.frame.height / 2) + 50
        
        let borda = SKPhysicsBody(edgeLoopFrom: self.frame)
        
        borda.friction = 0
        borda.restitution = 1
        
        
        self.physicsBody = borda
        
        iniciaJogo()
        
    }
    
    func iniciaJogo(){
        placar = [0,0]
        lblInimigo.text = "\(placar[1])"
        lblJogador.text = "\(placar[0])"
        bola.physicsBody?.applyImpulse(CGVector(dx: Int.random(in: 5 ... 15), dy: Int.random(in: 5 ... 15)))
    }
    
    func adicionaPonto(jogadorQueGanhou : SKSpriteNode){
        
        bola.position = CGPoint(x: 0, y: 0)
        bola.physicsBody?.velocity = CGVector(dx: 0, dy: 0)
        
        if jogadorQueGanhou == jogador {
            placar[0] += 1
            bola.physicsBody?.applyImpulse(CGVector(dx: Int.random(in: 5 ... 15), dy: Int.random(in: 5 ... 15)))
        }else if jogadorQueGanhou == inimigo {
            placar[1] += 1
            bola.physicsBody?.applyImpulse(CGVector(dx: Int.random(in: -15 ... -5), dy: Int.random(in: -15 ... -5)))
        }
        
        lblInimigo.text = "\(placar[1])"
        lblJogador.text = "\(placar[0])"
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches {
            
            let local = touch.location(in: self)
            
            if tipoJogoAtual == .jogadores2 {
                if local.y > 0 {
                    inimigo.run(SKAction.moveTo(x: local.x, duration: 0.1))

                }
                if local.y < 0 {
                    jogador.run(SKAction.moveTo(x: local.x, duration: 0.1))
                }
                
            }else{
                jogador.run(SKAction.moveTo(x: local.x, duration: 0.1))
            }
            
        }
    }
    
    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches {
            
            let local = touch.location(in: self)
            
            if tipoJogoAtual == .jogadores2 {
                if local.y > 0 {
                    inimigo.run(SKAction.moveTo(x: local.x, duration: 0.1))

                }
                if local.y < 0 {
                    jogador.run(SKAction.moveTo(x: local.x, duration: 0.1))
                }
                
            }else{
                jogador.run(SKAction.moveTo(x: local.x, duration: 0.1))
            }
        }
    }
    
    override func update(_ currentTime: TimeInterval) {
        
        
        switch tipoJogoAtual {
        case .facil:
            inimigo.run(SKAction.moveTo(x: bola.position.x, duration: 0.4))
            break
        case .medio:
            inimigo.run(SKAction.moveTo(x: bola.position.x, duration: 0.2))
            break
        case .dificil:
            inimigo.run(SKAction.moveTo(x: bola.position.x, duration: 0.05))
            break
        case .jogadores2:
            
            break
        }
        
        if bola.position.y <= jogador.position.y - 20{
            adicionaPonto(jogadorQueGanhou: inimigo)
        }else if bola.position.y >= inimigo.position.y + 20{
            adicionaPonto(jogadorQueGanhou: jogador)
        }
    }
}
