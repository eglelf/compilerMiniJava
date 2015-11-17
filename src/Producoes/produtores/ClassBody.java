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
public class ClassBody extends Production {

    public ClassBody(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("LEFTKEY");
        nomes.add("RIGHTKEY");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.get(0).equals(token)) {
            tokens.removeFirst();
            token = tokens.getFirstToken();

            ClassBodyDeclarations cd = new ClassBodyDeclarations(tokens);
            if (cd.accept(token)) {
                this.codigo = cd.handle(tokens);
            }
            if (this.codigo == 0) {
                token = tokens.getFirstToken();
                if (nomes.get(1).equals(token)) {
                    tokens.removeFirst();
                } else {
                    this.codigo = 7;
                }
            }
        } else {
            this.codigo = 6;
        }
        return this.codigo;
    }
}
