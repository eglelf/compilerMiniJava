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
public class FormalParameterList extends Production {

    public FormalParameterList(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("COLON");
    }
    
    @Override
    public boolean accept(String token){
        return new FormalParameter(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        this.codigo = new FormalParameter(tokens).handle(tokens);
        if (this.codigo == 0) {
            String token = tokens.getFirstToken();
            if (nomes.contains(token)) {
                tokens.removeFirst();
                this.codigo = new FormalParameterList(tokens).handle(tokens);
            }
        } 
        return this.codigo;
    }
}
