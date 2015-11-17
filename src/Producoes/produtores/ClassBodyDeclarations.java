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
public class ClassBodyDeclarations extends Production {
    public ClassBodyDeclarations(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }
    
    @Override
    public boolean accept(String token) {
        return new ClassBodyDeclaration(tokens).accept(token);
    }
    
    @Override
    public int nextProduction() {
        this.codigo = new ClassBodyDeclaration(tokens).handle(tokens);  
        if(this.codigo == 0){
            String token = tokens.getFirstToken();
            ClassBodyDeclaration cd = new ClassBodyDeclaration(tokens);
            while(cd.accept(token) && this.codigo == 0){
                this.codigo = cd.handle(tokens);
                token = tokens.getFirstToken();
            }
        }
        return this.codigo;
    }
}
    
   
