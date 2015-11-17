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
public class ComparationExpression extends Production {

    public ComparationExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }
    
    @Override
    public boolean accept(String token) {
        return new OperationalExpression(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        this.codigo = new OperationalExpression(tokens).handle(tokens);
        if (this.codigo == 0) {
            this.codigo = new RelationalExpression(tokens).handle(tokens);
        }

        return this.codigo;
    }

}
