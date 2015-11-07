/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.Model;

/**
 *
 * @author Avell B154 PLUS
 */
public class Identifier {
    private String name;
    private int id;

    public Identifier(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" +id+ "," +name;
    }
    
    
    
    
}
