//package com.craftinginterpreters.lox;

enum TokenType { 
    // Single-character tokens.
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
    LEFT_BRACKET, RIGHT_BRACKET,
    COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,

    // One or two character tokens.
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    // Literals.
    IDENTIFIER, STRING, NUMBER,

    // Keywords.
    SCAT, WHILE, IF, FOR, VAR, ZIP, OR, AND, FUNCTION,
    CLASS, ELSE, TRUE, FALSE, RETURN, GRAB, REPLACE, 
    COMBINE, PACK, EOF, THIS, SUPER
}

//Note! Might have to change because our set of keywords is different?