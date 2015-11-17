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
public class FieldDeclaration extends Production {

    public FieldDeclaration(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("SEMICOLON");
    }
    
    @Override
    public boolean accept(String token) {
        return new VariableDeclarators(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        this.codigo = new VariableDeclarators(tokens).handle(tokens);
        if (this.codigo == 0) {
            String token = tokens.getFirstToken();
            if (!nomes.contains(token)) {
                this.codigo = 1;
            }
        }
        return this.codigo;
    }
}
