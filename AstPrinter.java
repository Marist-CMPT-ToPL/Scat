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
    
    @Override
    public String visitVariableExpr(Expr.Variable expr) {
        return expr.name.lexeme;
    }
    
    @Override
    public String visitAssignExpr(Expr.Assign expr) {
        return "(assign " + expr.name.lexeme + " " + print(expr.value) + ")";
    }
    
    @Override
    public String visitCallExpr(Expr.Call expr) {
        StringBuilder builder = new StringBuilder();
        builder.append("(call ").append(print(expr.callee));
        for (Expr arg : expr.arguments) {
            builder.append(" ").append(print(arg));
        }
        builder.append(")");
        return builder.toString();
    }
    
    @Override
    public String visitLogicalExpr(Expr.Logical expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }
    //Array expression visitors
    @Override
    public String visitArrayLiteralExpr(Expr.ArrayLiteral expr) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < expr.elements.size(); i++) {
            if (i > 0) builder.append(", ");
            builder.append(print(expr.elements.get(i)));
        }
        builder.append("]");
        return builder.toString();
    }
    
    // Statement visitors
    @Override
    public String visitExpressionStmt(Stmt.Expression stmt) {
        return "(expression " + print(stmt.expression) + ")";
    }
    
    @Override
    public String visitPrintStmt(Stmt.Print stmt) {
        return "(print " + print(stmt.expression) + ")";
    }
    
    @Override
    public String visitVarStmt(Stmt.Var stmt) {
        String init = stmt.initializer != null ? print(stmt.initializer) : "nil";
        return "(var " + stmt.name.lexeme + " " + init + ")";
    }
    
    @Override
    public String visitFunctionStmt(Stmt.Function stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(function ").append(stmt.name.lexeme).append("(");
        for (int i = 0; i < stmt.params.size(); i++) {
            if (i > 0) builder.append(" ");
            builder.append(stmt.params.get(i).lexeme);
        }
        builder.append(") ");
        for (Stmt bodyStmt : stmt.body) {
            builder.append(print(bodyStmt)).append(" ");
        }
        builder.append(")");
        return builder.toString();
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
    
    @Override
    public String visitIfStmt(Stmt.If stmt) {
        if (stmt.elseBranch == null) {
            return "(if " + print(stmt.condition) + " " + print(stmt.thenBranch) + ")";
        }
        return "(if " + print(stmt.condition) + " " + print(stmt.thenBranch) + " else " + print(stmt.elseBranch) + ")";
    }
    
    @Override
    public String visitWhileStmt(Stmt.While stmt) {
        return "(while " + print(stmt.condition) + " " + print(stmt.body) + ")";
    }
    
    @Override
    public String visitForStmt(Stmt.For stmt) {
        StringBuilder builder = new StringBuilder();
        builder.append("(for");
        if (stmt.initializer != null) {
            builder.append(" ").append(print(stmt.initializer));
        }
        builder.append(" ");
        if (stmt.condition != null) {
            builder.append(print(stmt.condition));
        }
        builder.append(" ");
        if (stmt.increment != null) {
            builder.append(print(stmt.increment));
        }
        builder.append(" ").append(print(stmt.body)).append(")");
        return builder.toString();
    }
    
    @Override
    public String visitReturnStmt(Stmt.Return stmt) {
        if (stmt.value == null) return "(return)";
        return "(return " + print(stmt.value) + ")";
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