/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import com.sun.org.apache.bcel.internal.generic.LSUB;

/**
 *
 * @author Avell B154 PLUS
 */
public enum Token {
    ID, INTT, INT, ERROR, ASSIGN, SUM, MULT, MINUS, DIV, EQUAL, OR, AND, LT, GT, NOT,
    TRUE, FALSE, NULL, ABSTRACT, BOOLEANT, BOOLEAN, BREAK, BYTE, BYTET, CASE,
    CATCH, CHAR, CHART, CLASS, CONST, CONTINUE, DEFAULT, DO, DOUBLE, DOUBLET, ELSE, FINAL,
    FINALLY, FLOAT, FLOATT, FOR, GOTO,
    IF, IMPLEMENTS, IMPORT, INSTANCEOF, INTERFACE, LONG, LONGT, THIS, THROW, THROWS,
    TRANSIENT, TRY, VOID, VOLATILE, WHILE, NATIVE, NEW, PACKAGE, PRIVATE,
    PROTECTED, PUBLIC, RETURN, SHORT, SHORTT, STATIC, SUPER, SWITCH, SYNCHRONIZED, SEMICOLON,
    LEFTPARENTESIS, RIGHTPARENTESIS, LEFTBRACKET, RIGHTBRACKET, SINGLEQUOTE, DOUBLEQUOTE, TWOPOINTS,
    LEFTKEY, RIGHTKEY,COMMA,LINE
}
