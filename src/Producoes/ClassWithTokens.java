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
public class ClassWithTokens {

    private static ClassWithTokens classWithTokens;
    private ArrayList<String> tokens;

    private ClassWithTokens() {
        tokens = new ArrayList<String>();
    }

    public static ClassWithTokens getClassWithTokens() {
        if (classWithTokens == null) {
            classWithTokens = new ClassWithTokens();
        }
        return classWithTokens;
    }

    public void addToken(String token) {
        tokens.add(token);
    }

    public void removeToken(String token) {
        tokens.remove(token);
    }

    public ArrayList<String> getTokens() {
        return tokens;
    }

    public boolean isEmpity() {
        return tokens.isEmpty();
    }

    public String getFirstToken() {
        if(!tokens.isEmpty())
            return tokens.get(0);
        return null;
    }

    public void removeFirst() {
        tokens.remove(0);
    }

}
