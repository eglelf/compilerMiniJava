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
public class RelationalExpression extends Production{

    public RelationalExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("EQUAL");
        nomes.add("NOT");
        nomes.add("LT");
        nomes.add("LTE");
        nomes.add("GT");
        nomes.add("GTE");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if(nomes.contains(token)){
            this.codigo = new OperationalExpression(tokens).handle(tokens);
            if(this.codigo==0)
                this.codigo = new RelationalExpression(tokens).handle(tokens);
        }
        return this.codigo;
    }
}
