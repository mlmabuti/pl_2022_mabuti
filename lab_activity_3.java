import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lab_activity_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Source Language: ");
        String input = sc.nextLine();

        System.out.print("Output is: ");
        for (String str : tokenize(getLexemes(input))) {
            System.out.print(str + " ");
        }
    }

    public static ArrayList<String> tokenize(ArrayList<String> processedInput){
        ArrayList<String> dataTypes = new ArrayList<>(
                Arrays.asList("int", "double", "char", "String")),
                tokens = new ArrayList<>();

        for (String str : processedInput){
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

    public static ArrayList<String> getLexemes(String input){
        ArrayList<String> inputSpecific = new ArrayList<>(
                Arrays.asList(input.split(" "))),
                inputSpecificFinal, inputSpecificTemp;

        inputSpecificTemp = extractSemiColon(inputSpecific);
        inputSpecificFinal = mergeStringValues(inputSpecificTemp);

        return inputSpecificFinal;
    }

    public static ArrayList<String> extractSemiColon(ArrayList<String> inputSpecific){
        ArrayList<String> inputSpecificTemp = new ArrayList<>();

        for (String str : inputSpecific){
            if (str.contains(";")){
                if (str.length() >= 2) {
                    String word = str.substring(0,str.indexOf(";"));
                    inputSpecificTemp.add(word);
                }
                inputSpecificTemp.add(";");
            } else {
                inputSpecificTemp.add(str);
            }
        }

        return inputSpecificTemp;
    }

    public static ArrayList<String> mergeStringValues(ArrayList<String> inputSpecificTemp){
        ArrayList<String> inputSpecificFinal = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int quote = 0;

        for (String str : inputSpecificTemp) {
            if (str.charAt(0) == '"' && str.charAt(str.length()-1)=='"'){
                inputSpecificFinal.add(str);
            } else if (str.charAt(0) == '"') {
                quote++;
                temp.append(str).append(" ");
            } else if (str.charAt(str.length() - 1) == '"') {
                temp.append(str).append(" ");
                inputSpecificFinal.add(temp.toString());
                temp = new StringBuilder();
                quote = 0;
            } else if (quote == 1) {
                temp.append(str).append(" ");
            } else {
                inputSpecificFinal.add(str);
            }
        }

        return inputSpecificFinal;
    }
}
