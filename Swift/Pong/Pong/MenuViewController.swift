//
//  MenuViewController.swift
//  Pong
//
//  Created by Bruno on 16/11/19.
//  Copyright © 2019 Bruno Harnik. All rights reserved.
//

import Foundation
import UIKit

enum tipoJogo{
    case facil
    case medio
    case dificil
    case jogadores2
}

class MenuViewController : UIViewController {
    
    @IBAction func Jogadores2(_ sender: Any) {
        irAoJogo(jogo: .jogadores2)
    }
    @IBAction func Facil(_ sender: Any) {
        irAoJogo(jogo: .facil)
    }
    @IBAction func Medio(_ sender: Any) {
        irAoJogo(jogo: .medio)
    }
    @IBAction func Dificil(_ sender: Any) {
        irAoJogo(jogo: .dificil)
    }
    
    func irAoJogo(jogo: tipoJogo){
        let jogoVC = self.storyboard?.instantiateViewController(identifier: "jogoVC") as! GameViewController
        
        tipoJogoAtual = jogo
        
        self.navigationController?.pushViewController(jogoVC, animated: true)
    }
}
