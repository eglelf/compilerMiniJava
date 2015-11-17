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
public class MultiplicativeExpression extends Production{

    public MultiplicativeExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("MULT");
        nomes.add("DIV");
        nomes.add("MOD");
        nomes.add("MULT");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if(nomes.contains(tokens)){
            tokens.removeFirst();
            this.codigo = new UnaryExpression(tokens).handle(tokens);
            if(this.codigo==0){
                this.codigo = new UnaryExpression(tokens).handle(tokens);
            }
        }        
        return this.codigo;
    } 
}
