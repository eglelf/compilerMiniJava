/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import compiler.Model.Identifier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avell B154 PLUS
 */
public class Arquivo {

    private String path;
    private File file;
    private List<Identifier> tokenslist;

    public Arquivo(String path) {
        this.path = path;
        file = new File(path);
        tokenslist = new ArrayList<Identifier>();
    }

    public ArrayList<String> lerArquivo() throws IOException {

        Reader reader = new BufferedReader(new FileReader(path));
        Lexer lexer = new Lexer(reader);
        ArrayList<String> result = new ArrayList<>();
        String tokenName = "";

        int contIDs = 0;
        int lineCounter = 1;
        boolean flagLine;
        while (true) {
            Token token = lexer.yylex();
            if (token == null) {
                break;
            }
            flagLine = true;
            switch (token) {

                case SUM:
                    tokenName = "+";
                    break;
                case MINUS:
                    tokenName = "-";
                    break;
                case MULT:
                    tokenName = "*";
                    break;
                case DIV:
                    tokenName = "/";
                    break;
                case ASSIGN:
                    tokenName = "=";
                    break;
                case ERROR:
                    tokenName = "Erro! Linha: " + lineCounter + ".";
                    break;
                case INTT:
                    tokenName = "INT";
                    break;
                case ID: {
                    contIDs++;
                    Identifier tokenitem = new Identifier(lexer.lexema, contIDs);
                    //tokenslist.add(tokenitem);
                    tokenName = tokenitem.getName();
                    break;
                }
                case INT:
                    tokenName = lexer.lexema;
                    break;
                case OR:
                    tokenName = "OR";
                    break;
                case AND:
                    tokenName = "AND";
                    break;
                case LT:
                    tokenName = "LT";
                    break;
                case GT:
                    tokenName = "GT";
                    break;
                case NOT:
                    tokenName = "NOT";
                    break;
                case TRUE:
                    tokenName = "TRUE";
                    break;
                case FALSE:
                    tokenName = "FALSE";
                    break;
                case NULL:
                    tokenName = "NULL";
                    break;
                case ABSTRACT:
                    tokenName = "ABSTRACT";
                    break;
                case BOOLEANT:
                    tokenName = "BOOLEAN";
                    break;
                case BREAK:
                    tokenName = "BREAK";
                    break;
                case BYTET:
                    tokenName = "BYTE";
                    break;
                case CASE:
                    tokenName = "CASE";
                    break;
                case CATCH:
                    tokenName = "CATCH";
                    break;
                case CHART:
                    tokenName = "CHAR";
                    break;
                case CLASS:
                    tokenName = "CLASS";
                    break;
                case CONST:
                    tokenName = "CONST";
                    break;
                case CONTINUE:
                    tokenName = "CONTINUE";
                    break;
                case DEFAULT:
                    tokenName = "DEFAULT";
                    break;
                case DO:
                    tokenName = "DO";
                    break;
                case DOUBLE:
                    tokenName = lexer.lexema;
                    break;
                case DOUBLET:
                    tokenName = "DOUBLE";
                    break;
                case ELSE:
                    tokenName = "ELSE";
                    break;
                case FINAL:
                    tokenName = "FINAL";
                    break;
                case FINALLY:
                    tokenName = "FINALLY";
                    break;
                case VOID:
                    tokenName = "VOID";
                    break;
                case VOLATILE:
                    tokenName = "VOLTILE";
                    break;
                case WHILE:
                    tokenName = "WHILE";
                    break;
                case NATIVE:
                    tokenName = "NATIVE";
                    break;
                case NEW:
                    tokenName = "NEW";
                    break;
                case PACKAGE:
                    tokenName = "PACKAGE";
                    break;
                case PRIVATE:
                    tokenName = "PRIVATE";
                    break;
                case PROTECTED:
                    tokenName = "PROTECTED";
                    break;
                case PUBLIC:
                    tokenName = "PUBLIC";
                    break;
                case RETURN:
                    tokenName = "RETURN";
                    break;
                case MOD:
                    tokenName = "MOD";
                    break;
                case SHORTT:
                    tokenName = "SHORT";
                    break;
                case STATIC:
                    tokenName = "STATIC";
                    break;
                case SUPER:
                    tokenName = "SUPER";
                    break;
                case SWITCH:
                    tokenName = "SWITCH";
                    break;
                case SYNCHRONIZED:
                    tokenName = "SYNCHRONIZED";
                    break;
                case FLOATT:
                    tokenName = "FLOAT";
                    break;
                case FOR:
                    tokenName = "FOR";
                    break;
                case GOTO:
                    tokenName = "GOTO";
                    break;
                case IF:
                    tokenName = "IF";
                    break;
                case IMPLEMENTS:
                    tokenName = "IMPLEMENTS";
                    break;
                case IMPORT:
                    tokenName = "IMPORT";
                    break;
                case INSTANCEOF:
                    tokenName = "INSTANCEOF";
                    break;
                case INTERFACE:
                    tokenName = "INTERFACE";
                    break;
                case LONGT:
                    tokenName = "LONG";
                    break;
                case THIS:
                    tokenName = "THIS";
                    break;
                case THROW:
                    tokenName = "THROW";
                    break;
                case TRANSIENT:
                    tokenName = "TRANSIENT";
                    break;
                case TRY:
                    tokenName = "TRY";
                    break;
                case SEMICOLON:
                    tokenName = ";";
                    break;
                case LEFTPARENTESIS:
                    tokenName = "(";
                    break;
                case RIGHTPARENTESIS:
                    tokenName = ")";
                    break;
                case LEFTBRACKET:
                    tokenName = "[";
                    break;
                case RIGHTBRACKET:
                    tokenName = "]";
                    break;
                case SINGLEQUOTE:
                    tokenName = "'";
                    break;
                case DOUBLEQUOTE:
                    tokenName = "\"";
                    break;
                case TWOPOINTS:
                    tokenName = ":";
                    break;
                case LEFTKEY:
                    tokenName = "{";
                    break;
                case RIGHTKEY:
                    tokenName = "}";
                    break;
                case COMMA:
                    tokenName = ",";
                    break;
                case LINE:
                    flagLine = false;
                    lineCounter++;
                    break;
                case MULTASSIGN:
                    tokenName = "MULTASSIGN";
                    break;
                case DIVASSIGN:
                    tokenName = "DIVASSIGN";
                    break;
                case MODASSIGN:
                    tokenName = "MODASSIGN";
                    break;
                case MINUSASSIGN:
                    tokenName = "MINUSASSIGN";
                    break;
                case SUMASSIGN:
                    tokenName = "SUMASSIGN";
                    break;
                case LTE:
                    tokenName = "LTE";
                    break;
                case GTE:
                    tokenName = "GTE";
                    break;
                case ANDBIN:
                    tokenName = "ANDBIN";
                    break;
                case STRING:
                    tokenName = "STRING";
                    break;
                default:
                    tokenName = lexer.lexema;
            }
            if (flagLine) {
                result.add(token + "#" + tokenName);
            }

        }
        return result;
    }

    public void gravarArquivo(String texto) throws IOException {
        FileWriter w = new FileWriter(path, false);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(texto);
        bf.close();
    }

}
