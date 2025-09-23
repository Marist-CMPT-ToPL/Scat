# Lexical Specification for Scat Language


## Grammar
NUMBER         → DIGIT+ ( "." DIGIT+ )? ;  
STRING         → "\"" <any char except "\"">* "\"" ;  
IDENTIFIER     → ALPHA ( ALPHA | DIGIT )* ;  
ALPHA          → "a" ... "z" | "A" ... "Z" | "_" ;  
DIGIT          → "0" ... "9" ;  
BOOLEAN        → "true" | "false" ;  

## Expression and Statement  
function       → IDENTIFIER "(" parameters? ")" block ;  
parameters     → IDENTIFIER ( "," IDENTIFIER )* ;  
arguments      → expression ( "," expression )* ;    

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

declaration    → classDecl  
               | funDecl  
               | varDecl  
               | statement ;  

classDecl      → "class" IDENTIFIER ( "<" IDENTIFIER )?  
                 "{" function* "}" ;  
funDecl        → "fun" function ;  
varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;    
  
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
               | "super" "." IDENTIFIER ;  
               
## Keywords
Scat(replaces Print)  
While  
If  
For  
Var  
Zip  
Or  
And  
function  
class   

## Symbolic Operators
==, >=, <=, !=, <, >, !, =  

## Example Programs
var X = 23;  
scat(X);  
------------  
for(var z; z <= 3; z++) {  
    scat("Mumble");  
}  
------------  
fun dance(var text) {  
    scat("Dance: " + text);  
    var Dance = true;  
}   
------------  
class Holder {  
    init() {  
        var x = 10;  
        scat(x);  
    }  
}  
------------  
var questionmark = zip;  
if (questionmark == zip OR (questionmark > 1 AND questionmark < 1)) {  
    scat("What is the question?");  
}  