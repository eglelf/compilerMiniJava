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
public class FieldMethodDeclaration extends Production{

    public FieldMethodDeclaration(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }
    
    public boolean accept(String token) {
        return new FieldDeclaration(tokens).accept(token) || new MethodDeclaration(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        FieldDeclaration fd = new FieldDeclaration(tokens);
        if(fd.accept(token)){
            this.codigo = fd.handle(tokens);
        } else{
            this.codigo = new MethodDeclaration(tokens).handle(tokens);
        }
        return this.codigo;
    } 
}