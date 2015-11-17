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
public class ClassInstanceCreationExpression extends Production {

    public ClassInstanceCreationExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("NEW");
        nomes.add("LEFTPARENTESIS");
        nomes.add("RIGHTPARENTESIS");
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
            this.codigo = new Identifier(tokens).handle(tokens);
            if (this.codigo == 0) {
                token = tokens.getFirstToken();
                if (nomes.get(1).equals(token)) {
                    tokens.removeFirst();
                    ArgumentList al = new ArgumentList(tokens);
                    if (al.accept(token)) {
                        this.codigo = al.handle(tokens);
                    }
                    if (this.codigo == 0) {
                        token = tokens.getFirstToken();
                        if (nomes.get(2).equals(token)) {
                            tokens.removeFirst();
                        } else {
                            this.codigo = 12;
                        }
                    }
                } else {
                    this.codigo = 11;
                }

            }
        } else {
            this.codigo = 32;
        }
        return this.codigo;
    }
}
