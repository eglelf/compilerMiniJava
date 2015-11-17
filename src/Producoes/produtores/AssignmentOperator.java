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
public class AssignmentOperator extends Production {

    public AssignmentOperator(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        //= | *= | /= | %= | += | -= | <<= | >>= | >>>= | &= | ^= 
        nomes.add("ASSIGN");
        nomes.add("MULTASSIGN");
        nomes.add("DIVASSIGN");
        nomes.add("MODASSIGN");
        nomes.add("SUMASSIGN");
        nomes.add("MINUSASSIGN");
        nomes.add("LSHIFT");
        nomes.add("RSHIFT");
        nomes.add("RRSHIFT");
        nomes.add("POWASSIGN");
        nomes.add("ANDASSIGN");
    }

    @Override
    public int nextProduction() {
        String token = tokens.getFirstToken();
        if (nomes.contains(token)) {
            tokens.removeFirst();
        } else
            this.codigo = 25;
        return this.codigo;
    }

}
