public class LabAct2_DeterministicFiniteAutomaton {
    public static void main(String[] args) {
        String state = "q0", input = "011101101";
        String[] states = {"q0", "q1", "q2"};
        char[] alphabet = {'0', '1'};

        for (int i = 0; i < input.length(); i++){
            if (state.equals(states[0]) && input.charAt(i) == alphabet[0]){
                state = states[1];
            } else if (state.equals(states[1]) && input.charAt(i) == alphabet[1]){
                state = states[2];
            } else if (state.equals(states[2]) && input.charAt(i) == alphabet[0]){
                state = states[1];
            } else if (state.equals(states[2]) && input.charAt(i) == alphabet[1]){
                state = states[0];
            }
            else if (state.equals(states[0]) && input.charAt(i) == alphabet[1] ||
                    state.equals(states[1]) && input.charAt(i) == alphabet[0]){
                continue; }
            else { System.out.println("Invalid input... exiting automaton."); return; }
        }

        if (state.equals(states[2])){
            System.out.println("String accepted.");
        } else {
            System.out.println("String not accepted.");
        }
    }
}
