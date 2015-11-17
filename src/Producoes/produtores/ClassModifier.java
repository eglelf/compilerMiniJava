/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producoes.produtores;

import Producoes.ClassWithTokens;
import Producoes.Production;

/**
 *
 * @author Matheus
 */
public class ClassModifier extends Production {

    public ClassModifier(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("PUBLIC");
        nomes.add("ABSTRACT");
        nomes.add("FINAL");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (!nomes.contains(token)) {
            this.codigo = 5;
        } else {
            tokens.removeFirst();
        }
        
        return codigo;
    }
}
