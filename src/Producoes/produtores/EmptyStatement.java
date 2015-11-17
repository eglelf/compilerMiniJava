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
public class EmptyStatement extends Production{

    public EmptyStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("SEMICOLON");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if(!nomes.contains(token)){
            tokens.removeFirst();
            this.codigo = 1;
        }
        return this.codigo;
    }
    
}
