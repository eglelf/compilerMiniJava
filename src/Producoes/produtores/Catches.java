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
public class Catches extends Production {

    public Catches(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        CatchClause cc = new CatchClause(tokens);
        this.codigo = cc.handle(tokens);
        if(this.codigo==0){
            while(cc.accept(token) && this.codigo == 0){
                this.codigo = new CatchClause(tokens).handle(tokens);
                token = tokens.getFirstToken();
            }
        }
        
        return this.codigo;
    }

}
