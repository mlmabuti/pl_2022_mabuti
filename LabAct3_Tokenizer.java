import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lab_activity_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Source Language: ");
        String input = sc.nextLine();

        System.out.print("Output is: ");
        for (String str : tokenizer(lexer(input))) {
            System.out.print(str + " ");
        }

    }

    public static ArrayList<String> tokenizer(ArrayList<String> lexemes){
        ArrayList<String> dataTypes = new ArrayList<>(
                Arrays.asList("int", "double", "char", "String")),
                tokens = new ArrayList<>();

        for (String str : lexemes){
            if (dataTypes.contains(str)){
                tokens.add("<data_type>");
            } else if (str.contains("=")){
                tokens.add("<assignment_operator>");
            } else if (str.contains("\"")|| str.contains("'")
                    || Character.isDigit(str.charAt(0))) {
                tokens.add("<value>");
            } else if (str.contains(";")){
                tokens.add("<delimiter>");
            } else {
                tokens.add("<identifier>");
            }
        }
        return tokens;
    }

    public static ArrayList<String> lexer(String input){
        String[] individualChars = input.split("");

        ArrayList<String> tokens = new ArrayList<>();

        StringBuilder temp = new StringBuilder(),
                quotedString = new StringBuilder();

        boolean isQuote = false;

        for (String c : individualChars){
            if (c.equals("=") && !isQuote){
                tokens.add(c);
            }
            else if (c.equals(";") && !isQuote){
                tokens.add(temp.toString());
                tokens.add(c);
                temp = new StringBuilder();
            }
            else if (c.equals(" ") && !isQuote){
                if (!temp.toString().equals("")){
                    tokens.add(temp.toString());
                }
                temp = new StringBuilder();
            }
            else if (c.equals("\"")) {
                quotedString.append(c);
                if (isQuote) {
                    tokens.add(quotedString.toString());
                    quotedString = new StringBuilder();
                    isQuote = false;
                }
                else { isQuote = true; }
            }
            else if (isQuote) { quotedString.append(c); }
            else { temp.append(c); }
        }

        tokens.removeIf(n -> (n.equals("")));
        return tokens;
    }
}
