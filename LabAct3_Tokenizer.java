import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LabAct3_Tokenizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Source Language: ");
        String input = sc.nextLine();

        System.out.print("Output is: ");
        for (String str: tokenizer(lexer(input))) {
            System.out.print(str + " ");
        }
    }

    public static ArrayList < String > tokenizer(ArrayList < String > lexemes) {
        ArrayList < String > dataTypes = new ArrayList < > (
                Arrays.asList("int", "double", "char", "String")),
                tokens = new ArrayList < > ();

        for (String lexeme: lexemes) {
            if (dataTypes.contains(lexeme)) {
                tokens.add("<data_type>");
            } else if (lexeme.contains("=")) {
                tokens.add("<assignment_operator>");
            } else if (lexeme.contains("\"") || lexeme.contains("'") ||
                    Character.isDigit(lexeme.charAt(0))) {
                tokens.add("<value>");
            } else if (lexeme.contains(";")) {
                tokens.add("<delimiter>");
            } else {
                tokens.add("<identifier>");
            }
        }
        return tokens;
    }

    public static ArrayList < String > lexer(String input) {
        String[] individualChars = input.split("");

        ArrayList < String > tokens = new ArrayList < > ();

        StringBuilder temp = new StringBuilder(),
                quotedString = new StringBuilder();

        boolean isQuote = false;

        for (String c: individualChars) {
            if (c.equals("=") && !isQuote) {
                tokens.add(temp.toString());
                tokens.add(c);
                temp = new StringBuilder();
            } else if (c.equals(";") && !isQuote) {
                tokens.add(temp.toString());
                tokens.add(c);
                temp = new StringBuilder();
            } else if (c.equals(" ") && !isQuote) {
                tokens.add(temp.toString());
                temp = new StringBuilder();
            } else if (c.equals("\"")) {
                quotedString.append(c);
                if (isQuote) {
                    tokens.add(quotedString.toString());
                    quotedString = new StringBuilder();
                    isQuote = false;
                } else {
                    isQuote = true;
                }
            } else if (isQuote) {
                quotedString.append(c);
            } else {
                temp.append(c);
            }
        }
        tokens.removeIf(n -> (n.equals("")));
        return tokens;
    }
}