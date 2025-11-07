//package com.craftinginterpreters.lox;

abstract class Stmt {
    interface Visitor<R> {
      R visitExpressionStmt(Expression stmt);
      R visitScatStmt(Scat stmt);
      R visitVarStmt(Var stmt);
      R visitBlockStmt(Block stmt);
      R visitIfStmt(If stmt);
      R visitWhileStmt(While stmt);
      R visitForStmt(For stmt);
      R visitReturnStmt(Return stmt);
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
    static class If extends Stmt {
      If(Expr condition, Stmt thenBranch, Stmt elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitIfStmt(this);
      }
  
      final Expr condition;
      final Stmt thenBranch;
      final Stmt elseBranch;
    }
    static class While extends Stmt {
      While(Expr condition, Stmt body) {
        this.condition = condition;
        this.body = body;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitWhileStmt(this);
      }
  
      final Expr condition;
      final Stmt body;
    }
    static class For extends Stmt {
      For(Stmt initializer, Expr condition, Expr increment, Stmt body) {
        this.initializer = initializer;
        this.condition = condition;
        this.increment = increment;
        this.body = body;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitForStmt(this);
      }
  
      final Stmt initializer;
      final Expr condition;
      final Expr increment;
      final Stmt body;
    }
    static class Return extends Stmt {
      Return(Token keyword, Expr value) {
        this.keyword = keyword;
        this.value = value;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitReturnStmt(this);
      }
  
      final Token keyword;
      final Expr value;
    }
  
    abstract <R> R accept(Visitor<R> visitor);
  }