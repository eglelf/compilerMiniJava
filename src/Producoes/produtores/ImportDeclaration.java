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
 * @author Egle
 */
public class ImportDeclaration extends Production {

    public ImportDeclaration(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("IMPORT");
        nomes.add("SEMICOLON");
    }
    
    @Override
    public boolean accept(String token) {
        return nomes.get(0).equals(token);
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.contains(token)) {
            tokens.removeFirst();
            this.codigo = new Identifier(tokens).handle(tokens);
                if (this.codigo == 0) {
                    token = tokens.getFirstToken();
                    if(nomes.contains(token)){
                        tokens.removeFirst();
                    } else {
                        this.codigo = 1;
                    }
                }
        }
        
        return this.codigo;
    }

}
