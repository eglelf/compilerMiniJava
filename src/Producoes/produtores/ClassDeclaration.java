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
public class ClassDeclaration extends Production {

    public ClassDeclaration(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("CLASS");
    }
    
    @Override
    public boolean accept(String token) {
        return nomes.get(0).equals(token) || new ClassModifier(tokens).accept(token);
    }
    
    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        ClassModifier cm = new ClassModifier(tokens);
        if (cm.accept(token)) {
            this.codigo = cm.handle(tokens);
        }

        if (this.codigo == 0) {
            token = tokens.getFirstToken();
            if (nomes.contains(token)) {
                tokens.removeFirst();
                this.codigo = new Identifier(tokens).handle(tokens);
                if(this.codigo == 0){
                    this.codigo = new ClassBody(tokens).handle(tokens);
                }
            }
        }
        return this.codigo;
    }
}
