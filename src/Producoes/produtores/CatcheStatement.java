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
public class CatcheStatement extends Production {

    public CatcheStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        Finally f = new Finally(tokens);
        if (f.accept(token)) {
            this.codigo = f.handle(tokens);
        } else {
            this.codigo = new Catches(tokens).handle(tokens);
            if (this.codigo == 0) {
                if(f.accept(token)){
                    this.codigo = f.handle(tokens);
                }
            }
        }
        
        return this.codigo;
    }

}
