class AstPrinter implements Expr.Visitor<String>, Stmt.Visitor<String> {
    
    String print(Expr expr) {
        return expr.accept(this);
    }
    
    String print(Stmt stmt) {
        return stmt.accept(this);
    }
    
    // Expression visitors
    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }
    
    // Statement visitors
    @Override
    public String visitExpressionStmt(Stmt.Expression stmt) {
        return "(expression " + print(stmt.expression) + ")";
    }
    
    @Override
    public String visitScatStmt(Stmt.Scat stmt) {
        return "(scat " + print(stmt.expression) + ")";
    }
    
    @Override
    public String visitVarStmt(Stmt.Var stmt) {
        String init = stmt.initializer != null ? print(stmt.initializer) : "nil";
        return "(var " + stmt.name.lexeme + " " + init + ")";
    }
    
    @Override
    public String visitBlockStmt(Stmt.Block stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(block");
        for (Stmt s : stmt.statements) {
            builder.append(" ").append(print(s));
        }
        builder.append(")");
        return builder.toString();
    }
    
    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();
        builder.append("(").append(name);
        for (Expr expr : exprs) {
            builder.append(" ");
            builder.append(expr.accept(this));
        }
        builder.append(")");
        return builder.toString();
    }
}