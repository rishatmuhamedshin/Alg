package org.example.expressTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String expressionText = "22 + 3 - 2 * (2 * 5 + 2) * 4";
        List<Lexeme> lexemes = lexAnalyze(expressionText);

    }

    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        EOF;
    }

    public static class Lexeme {
        LexemeType type;
        String value;

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    public static class LexemeBuffer {
        private int pos;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public List<Lexeme> lexemes;

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                    pos++;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }

            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    public static int factor(LexemeBuffer lexemes){
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type){
            case NUMBER :
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET :
                int value = expr(lexemes);
                lexeme = lexemes.next();
                if(lexeme.type != LexemeType.RIGHT_BRACKET){
                    throw new RuntimeException("Unexpected token " + lexeme.value
                            + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token " + lexeme.value
                    + " at position: " + lexemes.getPos());
        }
    }
    public static int multdiv(LexemeBuffer lexemes){
        int value = factor(lexemes);
        while(true){
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type){
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }
    public static int plusminus(LexemeBuffer lexemes){
        int value = multdiv(lexemes);
        while(true){
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type){
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }
    public static int expr(LexemeBuffer lexemes){
        Lexeme lexeme = lexemes.next();
        if(lexeme.type == LexemeType.EOF){
            return 0;
        }
        else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }


}
