/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import compiler.presenter.PresenterTela;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Avell B154 PLUS
 */
public class Productions {

    private PresenterTela p;
    private ArrayList<String> tokens;
    private String[] tokensRead;

    public void readTokens() {
        Iterator<String> it = tokens.iterator();
        ArrayList<String> tokensName = new ArrayList<>();
        while (it.hasNext()) {
            String p = it.next();
            String[] t = p.split("#");
            tokensName.add(t[0]);
            
        }
        this.tokens = tokensName;
    }
    
    public Productions(){
        this.readTokens();
    }
    
    
    
}
