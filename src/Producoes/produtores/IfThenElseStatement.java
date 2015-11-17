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
public class IfThenElseStatement extends Production{

    public IfThenElseStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("ELSE");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if(nomes.contains(token)){
            this.codigo = new Statement(tokens).handle(tokens);
        } else {
            this.codigo = 16;
        }
        return this.codigo;
    }
    
}
