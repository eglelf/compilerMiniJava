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
 * @author Avell B154 PLUS
 */
public class Modifier extends Production {

    public Modifier(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("PUBLIC");
        nomes.add("PROTECTED");
        nomes.add("PRIVATE");
        nomes.add("STATIC");
        nomes.add("FINAL");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.contains(token)) {
            tokens.removeFirst();
        } else {
            this.codigo = 8;
        }
        
        return this.codigo;
    }

}
