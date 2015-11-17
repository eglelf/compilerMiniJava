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
public class Type extends Production {

    public Type(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("BYTET");
        nomes.add("SHORTT");
        nomes.add("INTT");
        nomes.add("LONGT");
        nomes.add("CHART");
        nomes.add("FLOATT");
        nomes.add("DOUBLET");
        nomes.add("BOOLEANT");
        nomes.add("VOID");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.contains(token)) {
            tokens.removeFirst();
        } else {
            this.codigo = 13;
        }
        return this.codigo;
    }
}
