//
//  JogoViewController.swift
//  Jogo1
//
//  Created by Bruno on 14/11/19.
//  Copyright © 2019 Bruno Harnik. All rights reserved.
//

import UIKit
import SpriteKit

class JogoViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        if let view = self.view as! SKView?{
            if let cena = SKScene(fileNamed: "Jogo.sks") {
                cena.scaleMode = .aspectFill
                view.presentScene(cena)
            }
            
            view.ignoresSiblingOrder = true
            view.showsFPS = true
            view.showsPhysics = true
            view.showsNodeCount = true
        }
    }
    
}
