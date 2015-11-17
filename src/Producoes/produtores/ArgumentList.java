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
public class ArgumentList extends Production {

    public ArgumentList(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("COMMA");
    }
    
    @Override
    public boolean accept(String token) {
        return new Expression(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        this.codigo = new Expression(tokens).handle(tokens);
        if (this.codigo == 0) {
            String token = tokens.getFirstToken();
            if(nomes.contains(token)){
                tokens.removeFirst();
                this.codigo = new ArgumentList(tokens).handle(tokens);
            }
        }
        return this.codigo;
    }

}
