/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producoes;

import java.util.ArrayList;

/**
 *
 * @author Avell B154 PLUS
 */
public abstract class Production implements HandleProdution{
    protected ClassWithTokens tokens;
    protected ArrayList<String> nomes;
    protected int codigo;

    public Production(ClassWithTokens tokens) {
        this.tokens = tokens;
        nomes = new ArrayList<String>();
    }

    @Override
    public boolean accept(String token) {
        return nomes.contains(token);
    }

    @Override
    public int handle(ClassWithTokens tokens) {
        return nextProduction();
    }
    
    public abstract int nextProduction();
   
}
