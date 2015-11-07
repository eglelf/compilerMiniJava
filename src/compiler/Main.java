/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler; 

import compiler.View.ViewTela;
import compiler.presenter.PresenterTela;
import java.io.File;

/**
 *
 * @author Avell B154 PLUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "src/compiler/Lexer.flex";
        generateLexer(path);
        PresenterTela tela = new PresenterTela();
    }

    public static void generateLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);  
        
    }
    
}
