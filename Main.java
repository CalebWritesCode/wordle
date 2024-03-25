import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final int Max_attempts = 12;
        int curr_attempts = 0;
        String answer = "table";
        String input;
        Scanner scanner = new Scanner(System.in);
        while (curr_attempts<Max_attempts) {
            System.out.println("Guess the word of the day! You have " + (Max_attempts - curr_attempts) + " tries left ");
            input = scanner.nextLine().toLowerCase();
            curr_attempts++;
            String exit = compare(answer, input);
            System.out.println(exit);
            if(exit.equals("Congratulations! you have solved today's Wordle")){
                break;
            };

        }
        if (curr_attempts == Max_attempts) {
            System.out.println("Sorry, you've run out of tries. The correct word was: " + answer);
        }
        scanner.close();
    }

    static String compare(String a, String b){
        if(b.length() != a.length()){
           return "invalid guess Please choose word with "+a.length()+" letters";
        }
        int rightspot = 0;
       for(int i = 0; i<5; i++){
           if(b.charAt(i)==a.charAt(i)){
               rightspot++;
           }
       }
        if (rightspot == a.length()) {
            return "Congratulations! you have solved today's Wordle";
        }
       return "You have "+rightspot+" in the right spot";
    }
}