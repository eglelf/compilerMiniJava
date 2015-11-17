/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producoes;

/**
 *
 * @author Avell B154 PLUS
 */
public interface HandleProdution {
    public boolean accept(String token);
    public int handle(ClassWithTokens tokens);
}
