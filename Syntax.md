## Expression, Statement, Declaration, and program
program        → declaration* EOF ;  

declaration    → packDecl | classDecl  
               | funDecl  
               | varDecl  
               | statement ; 
               packDecl → "pack" IDENTIFIER "{" field* "}" ;  
               field → IDENTIFIER ";" ;  

classDecl      → "class" IDENTIFIER ( "<" IDENTIFIER )?  
                 "{" function* "}" ;  
funDecl        → "fun" function ;  
varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;    

statement      → exprStmt  
               | forStmt  
               | ifStmt  
               | printStmt  
               | returnStmt  
               | whileStmt  
               | block ;  

exprStmt       → expression ";" ;  
forStmt        → "for" "(" ( varDecl | exprStmt | ";" )  
                           expression? ";"  
                           expression? ")" statement ;  
ifStmt         → "if" "(" expression ")" statement  
                 ( "else" statement )? ;  
printStmt      → "scat" expression ";" ;  
returnStmt     → "return" expression? ";" ;  
whileStmt      → "while" "(" expression ")" statement ;  
block          → "{" declaration* "}" ;  
  
expression     → assignment ;  
  
assignment     → ( call "." )? IDENTIFIER "=" assignment  
               | logic_or ;  

logic_or       → logic_and ( "or" logic_and )* ;  
logic_and      → equality ( "and" equality )* ;  
equality       → comparison ( ( "!=" | "==" ) comparison )* ;  
comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;  
term           → factor ( ( "-" | "+" ) factor )* ;  
factor         → unary ( ( "/" | "*" ) unary )* ;  
  
unary          → ( "!" | "-" ) unary | call ;
call           → primary ( "(" arguments? ")" | "." IDENTIFIER )* ;  
primary        → "true" | "false" | "zip" | "this"  
               | NUMBER | STRING | IDENTIFIER | "(" expression ")"  
               | "super" "." IDENTIFIER | arrayLiteral | "grab" "(" expression ","  
               expression ")" | "replace" "(" expression "," expression "," expression  
               ")"; arrayLiteral → ["arguments?];
               
function       → IDENTIFIER "(" parameters? ")" block ;  
parameters     → IDENTIFIER ( "," IDENTIFIER )* ;  
arguments      → expression ( "," expression )* ;
