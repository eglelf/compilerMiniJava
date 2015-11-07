package compiler;
import static compiler.Token.*;
%%
%class Lexer
%type Token
W = [a-zA-Z_$]
N = [0-9]
FLit1    = {N}+ \. {N}*
FLit2    = \. {N}+
FLit3    = {N}+
TRUE = true
FALSE = false
BLANK=[ \t\r]
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
LineComment = "//".*
%{
public String lexema;
%}
%%
{BLANK}|{TraditionalComment}|{LineComment} {/*Ignore*/}

("^(-"{N}+")")|{N}+ [lL] {lexema=yytext(); return LONG;}
("^(-"{N}+")")|{N}+ {lexema=yytext(); return INT;}
({FLit1}|{FLit2}|{FLit3}) [fF] {lexema=yytext(); return FLOAT;}
({FLit1}|{FLit2}|{FLit3}) {lexema=yytext(); return DOUBLE;}

"=" {return ASSIGN;}
"+" {return SUM;}
"-" {return MINUS;}
"*" {return MULT;}
"/" {return DIV;}
"==" {return EQUAL;}
"||" {return OR;}
"&&" {return AND;}
"!=" {return NOT;}
"<" {return LT;}
">" {return GT;}
"null" {return NULL;}
"abstract" {return ABSTRACT;} 
"boolean" {return BOOLEANT;}
"break" {return BREAK;}
"byte" {return BYTET;}
"case" {return CASE;}
"catch" {return CATCH;}
"char" {return CHART;}
"class" {return CLASS;}
"const" {return CONST;}
"continue" {return CONTINUE;}
"default" {return DEFAULT;}
"do" {return DO;}
"else" {return ELSE ;}
"final" {return FINAL;}
"finally" {return FINALLY;}
"float" {return FLOATT;}
"for" {return FOR;}
"goto" {return GOTO;}
"if" {return IF;}
"implements" {return IMPLEMENTS;}
"import" {return IMPORT;}
"instanceof" {return INSTANCEOF;}
"interface" {return INTERFACE;}
"long" {return LONGT;}
"int" {return INTT;}
"double" {return DOUBLET;}
"this" {return THIS;}
"throw" {return THROW;}
"throws" {return THROWS;}
"transient" {return TRANSIENT;}
"try" {return TRY;}
"void" {return VOID;}
"volatile" {return VOLATILE;}
"while" {return WHILE;}
"native" {return NATIVE;}
"new" {return NEW;}
"package" {return PACKAGE;}
"private" {return PRIVATE;}
"protected" {return PROTECTED;}
"public" {return PUBLIC;}
"return" {return RETURN;}
"short" {return SHORTT;}
"static" {return STATIC;}
"super" {return SUPER;}
"switch" {return SWITCH;}
";" {return SEMICOLON;}
"synchronized" {return SYNCHRONIZED;}
"(" {return LEFTPARENTESIS;}
")" {return RIGHTPARENTESIS;}
"[" {return LEFTBRACKET;}
"]" {return RIGHTBRACKET;}
"'" {return SINGLEQUOTE;}
"\"" {return DOUBLEQUOTE;}
":" {return TWOPOINTS;}
"{" {return LEFTKEY;}
"}" {return RIGHTKEY;}
"," {return COMMA;}
"\n" {return LINE;}

{TRUE}|{FALSE} {lexema=yytext(); return BOOLEAN;}
{W}({W}|{N})* {lexema=yytext(); return ID;}

'.' {lexema=yytext(); return CHAR;}

. {return ERROR;}