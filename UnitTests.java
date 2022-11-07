import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @org.junit.jupiter.api.Test
    void parseTrueTest1(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                LabAct3_Tokenizer.lex("String str = \"Hello world a b\";"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest2(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("int x = '21';"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest3(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("double x = 213;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest4(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("float x = \"hello world a\";"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest5(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("boolean x = false;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest6(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("boolean x;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest7(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("String x;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest8(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("int x;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest9(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("char x;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest10(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("float x;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseTrueTest11(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("double x;"))
                .toArray(new String[0]);
        assertTrue(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticTrueIntTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("int x = 1;");
        assertTrue(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticTrueDoubleTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("double x = .1;");
        assertTrue(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticTrueBooleanTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("boolean x = false;");
        assertTrue(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticTrueStringTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("String x = \"Hello world a s v\";");
        assertTrue(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticTrueCharTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("char x = 'c';");
        assertTrue(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticTrueFloatTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("float x = .01;");
        assertTrue(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticFalseIntTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("int x = .1;");
        assertFalse(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticFalseDoubleTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("double x = 123;");
        assertFalse(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticFalseBooleanTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("boolean x = 1;");
        assertFalse(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticFalseStringTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("String x = 'chandler';");
        assertFalse(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticFalseCharTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("char x = \"1\";");
        assertFalse(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }

    @org.junit.jupiter.api.Test
    void analyzeSemanticFalseFloatTest(){
        ArrayList<String> lexemes = LabAct3_Tokenizer.lex("float x = 1.0d;");
        assertFalse(LabAct5_SemanticAnalyzer.analyzeSemantic(lexemes));
    }
}
