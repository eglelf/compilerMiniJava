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
public class TryStatement extends Production {

    public TryStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("TRY");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.contains(token)) {
            tokens.removeFirst();
            token = tokens.getFirstToken();
            this.codigo = new Block(tokens).handle(tokens);
            if(this.codigo==0){
                this.codigo = new CatcheStatement(tokens).handle(tokens);
            }

        } else {
            this.codigo = 22;
        }
        return this.codigo;
    }

}
