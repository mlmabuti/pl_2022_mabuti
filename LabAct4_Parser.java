import java.util.Scanner;

public class LabAct4_Parser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter tokens: ");
        if (parse(sc.nextLine().split(" \\s*"))) {
            System.out.println("Syntax is Correct!");
        } else {
            System.out.println("Syntax Error!");
        }
    }

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
