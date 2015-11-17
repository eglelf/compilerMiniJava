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
public class ClassBodyDeclaration extends Production {

    public ClassBodyDeclaration(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }
    
    @Override
    public boolean accept(String token) {
        return new Modifier(tokens).accept(token) || new Type(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        Modifier modificador = new Modifier(tokens);
        if (modificador.accept(tokens.getFirstToken())) {
            this.codigo = modificador.handle(tokens);
        }
        if (this.codigo == 0) {
            this.codigo = new Type(tokens).handle(tokens);
            if (this.codigo == 0) {
                this.codigo = new Identifier(tokens).handle(tokens);
                if (this.codigo == 0) {
                    this.codigo = new FieldMethodDeclaration(tokens).handle(tokens);
                }
            }
        }

        return this.codigo;
    }
}
