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
public class VariableDeclarator extends Production {

    public VariableDeclarator(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("ASSIGN");
    }
    
    @Override
    public boolean accept(String token) {
        return true;
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.contains(token)) {
            tokens.removeFirst();
            this.codigo = new Expression(tokens).handle(tokens);
        }
        return this.codigo;
    }
}
