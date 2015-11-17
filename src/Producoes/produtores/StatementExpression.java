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
public class StatementExpression extends Production{

    public StatementExpression(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 1003;
    }

    @Override
    public int nextProduction() {
        Assignment as = new Assignment(tokens);
        MethodInvocation mi = new MethodInvocation(tokens);
        LabeledStatement ls = new LabeledStatement(tokens);
        String token = tokens.getFirstToken();
        if(as.accept(token)){
            this.codigo = as.handle(tokens);
        } else if(mi.accept(token)){
            this.codigo = mi.handle(tokens);
        } else if(ls.accept(token)){
            this.codigo = ls.handle(tokens);
        }
        return this.codigo;             
    }
    
}
