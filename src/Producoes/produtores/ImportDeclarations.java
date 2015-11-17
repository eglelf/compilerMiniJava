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
public class ImportDeclarations extends Production {

    public ImportDeclarations(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }
    
    @Override
    public boolean accept(String token) {
        return new ImportDeclaration(tokens).accept(token);
    }

    @Override
    public int nextProduction() {
        this.codigo = new ImportDeclaration(tokens).handle(tokens);
        if (this.codigo == 0 && !tokens.isEmpity()) {
            String token = tokens.getFirstToken();
            ImportDeclaration id = new ImportDeclaration(tokens);
            while (id.accept(token)) {
                this.codigo = new ImportDeclaration(tokens).handle(tokens);
                token = tokens.getFirstToken();
            }
        }
        return codigo;
    }
}
