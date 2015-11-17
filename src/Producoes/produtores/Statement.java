/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producoes.produtores;

import Producoes.ClassWithTokens;
import Producoes.Production;

/**
 *
 * @author Matheus
 */
public class Statement extends Production {

    public Statement(ClassWithTokens tokens) {
        super(tokens);
        this.codigo = 0;
        nomes.add("SEMICOLON");
    }

    @Override
    public int nextProduction() {
        Block b = new Block(tokens);
        EmptyStatement es = new EmptyStatement(tokens);
        Identifier i = new Identifier(tokens);
        DoStatement ds = new DoStatement(tokens);
        BreakStatement bs = new BreakStatement(tokens);
        ContinueStatement cs = new ContinueStatement(tokens);
        ReturnStatement rs = new ReturnStatement(tokens);
        IfSstatement is = new IfSstatement(tokens);
        WhileStatement ws = new WhileStatement(tokens);
        TryStatement ts = new TryStatement(tokens);
        ClassInstanceCreationExpression cice = new ClassInstanceCreationExpression(tokens);
        String token = tokens.getFirstToken();
        
        if (b.accept(token)) {
            this.codigo = b.handle(tokens);
        } else if (es.accept(token)) {
            this.codigo = es.handle(tokens);
        } else if (i.accept(token)) {
            this.codigo = i.handle(tokens);
            if(this.codigo == 0){
                this.codigo = new StatementExpression(tokens).handle(tokens);
                if(this.codigo == 0){
                    token = tokens.getFirstToken();
                    if(nomes.contains(token)){
                        tokens.removeFirst();
                    }else{
                        this.codigo = 1;
                    }
                }
            }
        }else if (ds.accept(token)) {
            this.codigo = ds.handle(tokens);
        }else if (bs.accept(token)) {
            this.codigo = bs.handle(tokens);
        }else if (cs.accept(token)) {
            this.codigo = cs.handle(tokens);
        }else if (rs.accept(token)) {
            this.codigo = rs.handle(tokens);
        }else if (is.accept(token)) {
            this.codigo = is.handle(tokens);
        }else if (ws.accept(token)) {
            this.codigo = ws.handle(tokens);
        }else if (ts.accept(token)) {
            this.codigo = ts.handle(tokens);
        }else if (cice.accept(token)) {
            this.codigo = cice.handle(tokens);
        } else {
            this.codigo = 1002;
        }
        
        return this.codigo;

    }

}
