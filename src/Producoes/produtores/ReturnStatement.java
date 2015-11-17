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
public class ReturnStatement extends Production {

    public ReturnStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("RETURN");
        nomes.add("SEMICOLON");
    }
    
    @Override
    public boolean accept(String token) {
        return nomes.get(0).equals(token);
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.get(0).equals(token)) {
            tokens.removeFirst();
            token = tokens.getFirstToken();
            Expression exp = new Expression(tokens);
            if (exp.accept(token)) {
                this.codigo = exp.handle(tokens);
                if (this.codigo == 0) {
                    token = tokens.getFirstToken();
                    if (nomes.get(1).equals(token)) {
                        tokens.removeFirst();
                    } else {
                        this.codigo = 1;
                    }
                }
            }
        } else {
            this.codigo = 21;
        }
        return this.codigo;
    }

}
