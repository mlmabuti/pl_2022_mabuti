import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LabAct5_SemanticAnalyzer {
    public static void main(String[] args) {
        System.out.print("Enter expression: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayList<String> lexemes = lex(input);

        if (analyzeSemantic(lexemes)) {
            System.out.println("Semantically Correct!");
            return;
        } System.out.println("Semantically Incorrect!");
    }

    public static boolean analyzeSemantic(ArrayList<String> lexemes) {
        String[] tokens = tokenize(lexemes).toArray(new String[0]);

        if (parse(tokens)){ // is correct syntax
            if (tokens.length == 3) return true; // e.g int x;
            try {
                String type = lexemes.get(0);
                String value = lexemes.get(3);

                if (type.equals("int")) {
                    Integer.parseInt(value);
                    return true;
                } else if (type.equals("double") && value.contains(".") && !value.contains("f")) {
                    Double.parseDouble(value);
                    return true;
                } else if (type.equals("String") && value.contains("\"")) {
                    return true;
                } else if (type.equals("boolean") && (value.equals("true")
                        || value.equals("false"))) {
                    return true;
                } else if (type.equals("float") && value.contains(".") && !value.contains("d")) {
                    Float.parseFloat(value);
                    return true;
                } else {
                    return (type.equals("char") && value.contains("'")
                            && value.length() == 3);
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    // FROM LAB ACTIVITY 3
    public static ArrayList<String> tokenize(ArrayList<String> lexemes) {
        ArrayList<String> dataTypes = new ArrayList<>(
                Arrays.asList("int", "double", "char", "String", "float", "boolean")),
                tokens = new ArrayList<>();

        for (String lexeme : lexemes) {
            if (dataTypes.contains(lexeme)) {
                tokens.add("<data_type>");
            } else if (lexeme.contains("=")) {
                tokens.add("<assignment_operator>");
            } else if (lexeme.contains("\"") || lexeme.contains("'") ||
                    Character.isDigit(lexeme.charAt(0)) || lexeme.contains(".") ||
                    lexeme.equals("true") || lexeme.equals("false")) {
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
                    lexemes.add(temp.toString());
                    temp = new StringBuilder();
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
        lexemes.add(temp.toString());
        lexemes.removeIf(n -> (n.equals("")));
        return lexemes;
    }

    // FROM LAB ACTIVITY 4
    public static boolean parse(String[] tokens) {
        String[][] correctSyntax = {{"<data_type>", "<identifier>",
                "<assignment_operator>", "<value>", "<delimiter>"},
                {"<data_type>", "<identifier>", "<delimiter>"}};

        boolean state = false;

        if (tokens.length > correctSyntax[0].length) return false;

        for (String[] syntax : correctSyntax) {
            for (int j = 0; j < syntax.length; j++) {
                try {
                    state = tokens[j].equals(syntax[j]);
                    if (!state) break;
                } catch (Exception e) {
                    state = false;
                }
            }
            if (state) {
                break;
            }
        }
        return state;
    }
}
