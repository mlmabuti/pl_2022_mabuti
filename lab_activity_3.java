import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lab_activity_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Source Language: ");
        String input = sc.nextLine();

        System.out.print("Output is: ");
        for (String str : tokenize(processInput(input))){
            System.out.print(str + " ");
        }
    }

    public static ArrayList<String> tokenize(ArrayList<String> processedInput){
        ArrayList<String> dataTypes = new ArrayList<>(Arrays.asList("int", "double", "char", "String"));
        int values = 0, identifiers = 0;

        ArrayList<String> tokens = new ArrayList<>();

        for (String str : processedInput){
            if (dataTypes.contains(str)){
            tokens.add("<data_type>");
            } else if (str.contains("=")){
                tokens.add("<assignment_operator>");
            } else if (values == 0 && (str.contains("\"") || str.contains("'") || Character.isDigit(str.charAt(0))) ){
                values++;
                tokens.add("<value>");
            } else if (str.contains(";")){
                tokens.add("<delimiter>");
            } else if (identifiers==0){
                identifiers++;
                tokens.add("<identifier>");
            }
        }
        return tokens;
    }

    public static ArrayList<String> processInput(String input){
        String[] inputSpecific = input.split(" ");
        String lastWord = inputSpecific[inputSpecific.length-1],
        lastCharacter = lastWord.split("")[lastWord.length()-1];
        
        lastWord = lastWord.substring(0, lastWord.length()-1);
        ArrayList<String> inputSpecificFinal = new ArrayList<>(
                Arrays.asList(inputSpecific).subList(0, inputSpecific.length - 1));

        inputSpecificFinal.add(lastWord);
        inputSpecificFinal.add(lastCharacter);

        return inputSpecificFinal;
    }
}
