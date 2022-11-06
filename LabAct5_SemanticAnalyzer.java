import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LabAct5_SemanticAnalyzer {
    public static void main(String[] args) {

        System.out.print("Enter expression: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayList<String> tokens = tokenize(lex(input)),
                lexemes = lex(input);

        if (parse(tokens)) { // check for incorrect syntax
            if (analyze(lexemes)) {
                System.out.println("Semantically Correct!");
                return;
            }
        }
        System.out.println("Semantically Incorrect!");
    }

    public static boolean analyze(ArrayList<String> tokens) {
        try {
            String type = tokens.get(0);
            String value = tokens.get(3);

            if (type.equals("int") || type.equals("Integer")) {
                Integer.parseInt(value);
                return true;
            } else if (type.equals("double") || type.equals("Double")) {
                Double.parseDouble(value);
                return true;
            } else if (type.equals("String") && value.contains("\"")) {
                return true;
            } else {
                return (type.equals("char") || type.equals("Character")) && value.contains("'")
                        && value.length() == 3;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean parse(ArrayList<String> tokens) {
        String[][] correctSyntax = {{"<data_type>", "<identifier>",
                "<assignment_operator>", "<value>", "<delimiter>"},
                {"<data_type>", "<identifier>", "<delimiter>"}};

        boolean state = false;

        for (String[] syntax : correctSyntax) {
            for (int j = 0; j < syntax.length; j++) {
                try {
                    state = tokens.get(j).equals(syntax[j]);
                } catch (IndexOutOfBoundsException e) {
                    state = false;
                }
            }
            if (state) {
                break;
            }
        }
        return state;
    }

    public static ArrayList<String> tokenize(ArrayList<String> lexemes) {
        ArrayList<String> dataTypes = new ArrayList<>(
                Arrays.asList("int", "double", "char", "String")),
                tokens = new ArrayList<>();

        for (String lexeme : lexemes) {
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

    public static ArrayList<String> lex(String input) {
        String[] individualChars = input.split("");

        ArrayList<String> lexemes = new ArrayList<>();

        StringBuilder temp = new StringBuilder(),
                quotedString = new StringBuilder();

        boolean isQuote = false;

        for (String c : individualChars) {
            if (c.equals("=") && !isQuote) {
                lexemes.add(temp.toString());
                lexemes.add(c);
                temp = new StringBuilder();
            } else if (c.equals(";") && !isQuote) {
                lexemes.add(temp.toString());
                lexemes.add(c);
                temp = new StringBuilder();
            } else if (c.equals(" ") && !isQuote) {
                lexemes.add(temp.toString());
                temp = new StringBuilder();
            } else if (c.equals("\"")) {
                quotedString.append(c);
                if (isQuote) {
                    lexemes.add(quotedString.toString());
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
        lexemes.removeIf(n -> (n.equals("")));
        return lexemes;
    }
}
