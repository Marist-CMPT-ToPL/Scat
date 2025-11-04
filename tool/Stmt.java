//package com.craftinginterpreters.lox;

abstract class Stmt {
    interface Visitor<R> {
      R visitExpressionStmt(Expression stmt);
      R visitScatStmt(Scat stmt);
      R visitVarStmt(Var stmt);
      R visitBlockStmt(Block stmt);
    }
    static class Expression extends Stmt {
      Expression(Expr expression) {
        this.expression = expression;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitExpressionStmt(this);
      }
  
      final Expr expression;
    }
    static class Scat extends Stmt {
      Scat(Expr expression) {
        this.expression = expression;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitScatStmt(this);
      }
  
      final Expr expression;
    }
    static class Var extends Stmt {
      Var(Token name, Expr initializer) {
        this.name = name;
        this.initializer = initializer;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitVarStmt(this);
      }
  
      final Token name;
      final Expr initializer;
    }
    static class Block extends Stmt {
      Block(java.util.List<Stmt> statements) {
        this.statements = statements;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitBlockStmt(this);
      }
  
      final java.util.List<Stmt> statements;
    }
  
    abstract <R> R accept(Visitor<R> visitor);
  }