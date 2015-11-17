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
public class AdditiveExpression extends Production {

    public AdditiveExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("SUM");
        nomes.add("MINUS");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.get(0).equals(token) || nomes.get(0).equals(token)) {
            tokens.removeFirst();
            this.codigo = new Term(tokens).handle(tokens);
            if (this.codigo == 0) {
                this.codigo = new AdditiveExpression(tokens).handle(tokens);
            }
        }

        return this.codigo;
    }

}
