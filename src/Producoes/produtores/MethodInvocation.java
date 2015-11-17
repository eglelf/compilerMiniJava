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
public class MethodInvocation extends Production {

    public MethodInvocation(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("LEFTPARENTESIS");
        nomes.add("RIGHTPARENTESIS");
        nomes.add("SUPER");
        nomes.add("DOT");
    }

    @Override
    public boolean accept(String token) {
        return nomes.get(0).equals(token) || nomes.get(2).equals(token);
    }
    
    private int argumentListProduction(String token) {
        int codigo = 0;
        ArgumentList al = new ArgumentList(tokens);
        if (al.accept(token)) {
            codigo = al.handle(tokens);
        }
        return codigo;
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.get(0).equals(token)) {
            tokens.removeFirst();
            token = tokens.getFirstToken();
            this.codigo = this.argumentListProduction(token);
            if (this.codigo == 0) {
                token = tokens.getFirstToken();
                if (nomes.get(1).equals(token)) {
                    tokens.removeFirst();
                } else {
                    this.codigo = 12;
                }
            }
        } else if (nomes.get(2).equals(token)) {
            tokens.removeFirst();
            token = tokens.getFirstToken();
            if (nomes.get(3).equals(tokens)) {
                tokens.removeFirst();
                token = tokens.getFirstToken();
                if (nomes.get(0).equals(token)) {
                    tokens.removeFirst();
                    token = tokens.getFirstToken();
                    this.codigo = this.argumentListProduction(token);
                    if (this.codigo == 0) {
                        token = tokens.getFirstToken();
                        if (nomes.get(1).equals(token)) {
                            tokens.removeFirst();
                        } else {
                            this.codigo = 12;
                        }
                    }
                } else {
                    this.codigo = 11;
                }
            } else {
                this.codigo = 31;
            }

        } else {
            this.codigo = 11;
        }

        return this.codigo;
    }

}
