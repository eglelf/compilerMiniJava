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
public class BlockStatement extends Production {

    public BlockStatement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("SEMICOLON");
        this.codigo = 0;
    }
    
    @Override
    public boolean accept(String token) {
        return new LocalVariableDeclaration(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        LocalVariableDeclaration lvd = new LocalVariableDeclaration(tokens);
        if (lvd.accept(token)) {
            this.codigo = lvd.handle(tokens);
            if (this.codigo == 0) {
                token = tokens.getFirstToken();
                if (nomes.contains(token)) {
                    tokens.removeFirst();
                } else {
                    this.codigo = 1;
                }
            }
        } else{
            this.codigo = new Statement(tokens).handle(tokens);
        }
        
        return this.codigo;
    }

}
