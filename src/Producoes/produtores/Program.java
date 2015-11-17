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
public class Program extends Production {

    public Program(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
    }
/*
    @Override
    public boolean accept(String token) {
        return     new PackageDeclaration(tokens).accept(token)
                || new ImportDeclaration(tokens).accept(token)
                || new ClassDeclaration(tokens).accept(token);
    }
 */   
    @Override
    public int nextProduction() {
        PackageDeclaration pd = new PackageDeclaration(tokens);
        ImportDeclarations id = new ImportDeclarations(tokens);
        ClassDeclaration cd = new ClassDeclaration(tokens);
        String token = tokens.getFirstToken();
        if (pd.accept(token)) {
            this.codigo = pd.handle(tokens);
        }
        token = tokens.getFirstToken();
        if (id.accept(token) && this.codigo == 0) {
            this.codigo = id.handle(tokens);
        }
        token = tokens.getFirstToken();
        if (cd.accept(token) && this.codigo == 0) {
            this.codigo = cd.handle(tokens);
        } 
        return this.codigo;
    }

}
