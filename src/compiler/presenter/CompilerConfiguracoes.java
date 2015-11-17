/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.presenter;

import Producoes.ClassWithTokens;
import Producoes.ProcessadorProducao;
import Producoes.produtores.Program;

/**
 *
 * @author Avell B154 PLUS
 */
public class CompilerConfiguracoes {
    
    private static void configurarProcessadorProducoes(){
        ProcessadorProducao processadora = ProcessadorProducao.getProcessadoraProducoes();
        ClassWithTokens tokens = ClassWithTokens.getClassWithTokens();
        
        Program program = new Program(tokens);
        
        processadora.addHandler(program);
    }
    
    public static void configurarCompilador(){
        configurarProcessadorProducoes();
    }
    
}
