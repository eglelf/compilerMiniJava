/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.presenter;

import Producoes.ClassWithTokens;
import Producoes.ProcessadorProducao;
import Producoes.Production;
import Producoes.produtores.*;
import compiler.Arquivo;
import compiler.View.ViewTela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import jsyntaxpane.syntaxkits.JavaSyntaxKit;

/**
 *
 * @author Avell B154 PLUS
 */
public class PresenterTela {

    private ViewTela view;
    private DefaultTableModel tmTokens;
    private DefaultTableModel tmErros;
    private Arquivo arquivo;
    private ClassWithTokens tokens = ClassWithTokens.getClassWithTokens();
    private ArrayList<Production> producoes = new ArrayList<>();

    public PresenterTela() {
        iniciarTela();
    }

    public void iniciarTela() {
        view = new ViewTela();
        configurarTabelaDeTokens();
        configurarTabelaDeErros();

        //Adiciona um listener ao botão
        view.getBtnAnaliseLexica().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                analisarTexto();
                try {
                    ArrayList<String> texto = arquivo.lerArquivo();
                    exibirNaTabelaDeTokens(texto);
                    exibirNaTabelaDeErros(texto);
                    analisarSintaxe();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        //Configura o textAreaAlgoritmo
        jsyntaxpane.DefaultSyntaxKit.initKit();
        view.getTxtAreaAlgoritmo().setEditorKit(new JavaSyntaxKit());

        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    public void configurarTabelaDeTokens() {
        Object colunas[] = {"Token", "Lexema"};
        tmTokens = new DefaultTableModel(colunas, 0);
        view.getjTableTokens().setModel(tmTokens);
    }

    public void configurarTabelaDeErros() {
        Object colunas[] = {"Erros"};
        tmErros = new DefaultTableModel(colunas, 0);
        view.getjTableErros().setModel(tmErros);
    }

    private void exibirNaTabelaDeTokens(Collection<String> c) {
        tmTokens.setNumRows(0);
        Iterator<String> it = c.iterator();

        while (it.hasNext()) {
            String p = it.next();
            String[] linha = p.split("#");
            tokens.addToken(linha[0]);

            if (!linha[0].equals("ERROR") && !linha[0].equals("LINE")) {
                tmTokens.addRow(new Object[]{linha[0], linha[1]});
            }
        }
    }

    private void exibirNaTabelaDeErros(Collection<String> c) {
        tmErros.setNumRows(0);
        Iterator<String> it = c.iterator();

        while (it.hasNext()) {
            String p = it.next();
            String[] linha = p.split("#");

            if (linha[0].equals("ERROR")) {
                tmErros.addRow(new Object[]{linha[1]});
            }
        }
    }

    private ArrayList<String> analisarTexto() {
        try {
            arquivo = new Arquivo("src/compiler/arq1.txt");
            arquivo.gravarArquivo(view.getTxtAreaAlgoritmo().getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<String> getTokens() {
        return analisarTexto();
    }

    public ClassWithTokens getTokenList() {
        return this.tokens;
    }

    public void analisarSintaxe() {

        Program programProduction = new Program(tokens);
        int codigo = programProduction.handle(tokens);
        System.out.println("Cod: " + codigo);

    }

}
