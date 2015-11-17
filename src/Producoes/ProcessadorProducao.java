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
public class ProcessadorProducao {
    private static ProcessadorProducao processadora;
    ArrayList<HandleProdution> tratadores;

    private ProcessadorProducao() {
        tratadores = new ArrayList<HandleProdution>();
    }
    
    public static ProcessadorProducao getProcessadoraProducoes(){
        if(processadora == null){
            processadora = new ProcessadorProducao();
        }
        return processadora;
    }

    public void addHandler(HandleProdution tratador) {
        tratadores.add(tratador);
    }

    public void removeHandler(HandleProdution tratador) {
        tratadores.remove(tratador);
    }

    public int handleRequest(ClassWithTokens tokens) {
        /*EGLE CONSERTE ESSA MINHA GAMBIARRA*/
        return tratadores.get(0).handle(tokens);
    }

}
