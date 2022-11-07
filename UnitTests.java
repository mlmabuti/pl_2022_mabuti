import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {
    /*
    * lex accepts String arguments and returns ArrayList<String>
    * tokenize accepts ArrayList<String> as arguments and returns ArrayList<String>
    * parse accepts String[] arguments and returns boolean
    * analyzeSemantic accepts ArrayList<String> as arguments and returns boolean
    */

    @org.junit.jupiter.api.Test
    void lexTest1(){
        String[] input = LabAct3_Tokenizer.lex("String s = \"Hello a bc d\";").toArray(new String[0]);
        assertEquals(Arrays.toString(new String[]{"String", "s", "=", "\"Hello a bc d\"", ";"}),
        Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void lexTest2(){
        String[] input = LabAct3_Tokenizer.lex(";;;...").toArray(new String[0]);
        assertEquals(Arrays.toString(new String[]{";", ";", ";", "..."}),
                Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void lexTest3(){
        String[] input = LabAct3_Tokenizer.lex("... 'hotdog 1 2'").toArray(new String[0]);
        assertEquals(Arrays.toString(new String[]{"...", "'hotdog","1", "2'"}),
                Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void lexTest4(){
        String[] input = LabAct3_Tokenizer.lex("int;String;char;boolean;.0=12;").toArray(new String[0]);
        assertEquals(Arrays.toString(new String[]{"int",";","String",";","char",";","boolean",";",".0","=","12",";"}),
                Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void lexTest5(){
        String[] input = LabAct3_Tokenizer.lex("12=0.1;Integer").toArray(new String[0]);
        assertEquals(Arrays.toString(new String[]{"12","=","0.1",";","Integer"}),
                Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void tokenizeTest1(){
        String[] input = LabAct3_Tokenizer.tokenize(
                LabAct3_Tokenizer.lex("int a;")).toArray(new String[0]);
        assertEquals("[<data_type>, <identifier>, <delimiter>]", Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void tokenizeTest2(){
        String[] input = LabAct3_Tokenizer.tokenize(
                LabAct3_Tokenizer.lex("int;;=.1\"a s d\"")).toArray(new String[0]);
        assertEquals("[<data_type>, <delimiter>, <delimiter>, <assignment_operator>, " +
                "<value>, <value>]", Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void tokenizeTest3(){
        String[] input = LabAct3_Tokenizer.tokenize(
                LabAct3_Tokenizer.lex("\"a s d\"=.1f'lol'")).toArray(new String[0]);
        assertEquals("[<value>, <assignment_operator>, <value>]", Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void tokenizeTest4(){
        String[] input = LabAct3_Tokenizer.tokenize(
                LabAct3_Tokenizer.lex("=;=.1 int")).toArray(new String[0]);
        assertEquals("[<assignment_operator>, <delimiter>, <assignment_operator>, " +
                "<value>, <data_type>]", Arrays.toString(input));
    }

    @org.junit.jupiter.api.Test
    void tokenizeTest5(){
        String[] input = LabAct3_Tokenizer.tokenize(
                LabAct3_Tokenizer.lex(".int=double\"a b c\"String\"a\"")).toArray(new String[0]);
        assertEquals("[<value>, <assignment_operator>, <data_type>, <value>, " +
                "<data_type>, <value>]", Arrays.toString(input));
    }

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
    void parseFalseTest1(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("String str =;"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest2(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("String str"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest3(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("String str"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest4(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("str"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest5(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("String;"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest6(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("=;"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest7(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex(";;"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest8(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("==;;"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest9(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("\"HELLO WORLD ADS ASD \";"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
    }

    @org.junit.jupiter.api.Test
    void parseFalseTest10(){
        String[] tokens = LabAct3_Tokenizer.tokenize(
                        LabAct3_Tokenizer.lex("..ada.sd. = 123;"))
                .toArray(new String[0]);
        assertFalse(LabAct4_Parser.parse(tokens));
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
