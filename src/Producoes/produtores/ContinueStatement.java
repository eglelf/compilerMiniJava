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
public class ContinueStatement extends Production {

    public ContinueStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("CONTINUE");
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
            Identifier i = new Identifier(tokens);
            if (i.accept(token)) {
                this.codigo = i.handle(tokens);
            }
            if (this.codigo == 0) {
                token = tokens.getFirstToken();
                if (nomes.get(1).equals(token)) {
                    tokens.removeFirst();
                } else {
                    this.codigo = 1;
                }
            }
        } else {
            this.codigo = 20;
        }

        return this.codigo;
    }

}
