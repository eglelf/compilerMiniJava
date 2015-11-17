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
public class VariableDeclarators extends Production {

    public VariableDeclarators(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("COMMA");
    }
    
    @Override
    public boolean accept(String token) {
        return new VariableDeclarator(tokens).accept(token);
    }

    @Override
    public int nextProduction() { 
        this.codigo = new VariableDeclarator(tokens).handle(tokens);
        String token = tokens.getFirstToken();
        if(nomes.contains(token)){
            tokens.removeFirst();
            this.codigo = new Identifier(tokens).handle(tokens);
            if(this.codigo == 0)
                this.codigo = new VariableDeclarators(tokens).handle(tokens);
        }
        return this.codigo;
    }

}
