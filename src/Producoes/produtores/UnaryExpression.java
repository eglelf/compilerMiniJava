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
public class UnaryExpression extends Production {

    public UnaryExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("SUM");
        nomes.add("MINUS");
    }
    
    @Override
    public boolean accept(String token) {
        return nomes.contains(token) || (new Identifier(tokens).accept(token));
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.get(0).equals(nomes) || nomes.get(1).equals(nomes)) {
            tokens.removeFirst();
        }
        this.codigo = new Identifier(tokens).handle(tokens);
        if (this.codigo == 0) {
            token = tokens.getFirstToken();
            MethodInvocation mi = new MethodInvocation(tokens);
            if (mi.accept(token)) {
                this.codigo = mi.handle(tokens);
            }
        }

        return this.codigo;
    }

}
