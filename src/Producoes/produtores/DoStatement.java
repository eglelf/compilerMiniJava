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
public class DoStatement extends Production {

    public DoStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("DO");
        nomes.add("WHILE");
        nomes.add("LEFTTPARENTESIS");
        nomes.add("RIGHTPARENTESIS");
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
            this.codigo = new Statement(tokens).handle(tokens);
            if (this.codigo == 0) {
                token = tokens.getFirstToken();
                if (nomes.get(1).equals(token)) {
                    tokens.removeFirst();
                    token = tokens.getFirstToken();
                    if (nomes.get(2).equals(token)) {
                        tokens.removeFirst();
                        this.codigo = new Expression(tokens).handle(tokens);
                        if (this.codigo == 0) {
                            token = tokens.getFirstToken();
                            if (nomes.get(3).equals(token)) {
                                tokens.removeFirst();
                                token = tokens.getFirstToken();
                                if (nomes.get(3).equals(token)) {
                                    tokens.removeFirst();
                                } else {
                                    this.codigo = 1;
                                }
                            } else {
                                this.codigo = 12;
                            }
                        }
                    } else {
                        this.codigo = 11;
                    }
                } else {
                    this.codigo = 17;
                }
            }
        } else {
            this.codigo = 18;

        }
        return this.codigo;
    }
}
