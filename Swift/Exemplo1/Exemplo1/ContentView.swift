//
//  ContentView.swift
//  Exemplo1
//
//  Created by Bruno on 14/11/19.
//  Copyright © 2019 Bruno Harnik. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        
        VStack {
            Text("Exemplo 1")
            Button(action: /*@START_MENU_TOKEN@*/{}/*@END_MENU_TOKEN@*/) {
                Text("Botãozinho")
            }
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
