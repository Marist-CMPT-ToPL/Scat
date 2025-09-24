# Lexical Specification for Scat Language


## Lexical Grammar
NUMBER         → DIGIT+ ( "." DIGIT+ )? ;  
STRING         → "\"" <any char except "\"">* "\"" ;  
IDENTIFIER     → ALPHA ( ALPHA | DIGIT )* ;  
ALPHA          → "a" ... "z" | "A" ... "Z" | "_" ;  
DIGIT          → "0" ... "9" ;  
BOOLEAN        → "true" | "false" ;  

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
```
var X = 23;  
scat(X);  
```
```
for(var z; z <= 3; z++) {  
    scat("Mumble");  
}  
```
```
var Dance = false;
fun dance(var text) {  
    scat("Dance: " + text);  
    Dance = true;  
}  
```
```
class Holder {  
    init() {  
        var x = 10;  
        scat(x);  
    }  
}  
```
```
var questionmark = zip;  
if (questionmark == zip OR (questionmark > 1 AND questionmark < 1)) {  
    scat("What is the question?");  
}  
```
