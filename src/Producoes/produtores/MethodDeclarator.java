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
public class MethodDeclarator extends Production {

    public MethodDeclarator(ClassWithTokens tokens) {
        super(tokens);
        codigo = 108;
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
            FormalParameterList cd = new FormalParameterList(tokens);
            if (cd.accept(token)) {
                this.codigo = cd.handle(tokens);
            }
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
        return this.codigo;
    }
}
