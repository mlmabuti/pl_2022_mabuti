import java.util.Scanner;

public class LabAct4_Parser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter tokens: ");
        if (parser(sc.nextLine().split(" "))) {
            System.out.println("Syntax is Correct!");
        } else {
            System.out.println("Syntax Error!");
        }

    }

    public static boolean parser(String[] tokens){
        String[][] correctSyntax = {{"<data_type>","<identifier>",
                "<assignment_operator>","<value>","<delimiter>"},
                {"<data_type>", "<identifier>", "<delimiter>"}};

        boolean state = false;

        for (int i = 0; i < correctSyntax.length; i++){
            for (int j = 0; j < correctSyntax[i].length; j++) {
                try {
                    state = tokens[j].equals(correctSyntax[i][j]);
                } catch (IndexOutOfBoundsException e){
                    state = false;
                }
            }
            if (state) { break; }
        }
        return state;
    }
}
