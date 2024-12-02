import java.util.*;

public class Bonus {

    public static void main(String[] args) {

        HashSet<Integer> secretNumber = randomNumberGenerator();
        String stringNumber = setToStringConverter(secretNumber);

        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in. Typ 'quit' om te stoppen");

        feedback(stringNumber);
    }

    private static HashSet<Integer> randomNumberGenerator() {

        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();

        //get new number if number is not unique
        while (numbers.size() < 4) {
            int randomNumber = random.nextInt(10);
            numbers.add(randomNumber);
        }
        return numbers;
    }

    private static String setToStringConverter(HashSet<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {sb.append(number);}
        return sb.toString();
    }

    private static void feedback(String stringNumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();

        while (true) {
            String guess = scanner.nextLine();
            feedback.delete(0, feedback.length()); //clear feedback

            //input validation
            if (guess.length() != 4 || !isNumeric(guess)) {
                feedback.append("Ongeldige invoer, voer 4 getallen in tussend de 0 en 9");
            }

            //correct input
            else if (Objects.equals(guess, stringNumber)) {
                System.out.println("gefeliciteerd je hebt het goed!");
                break;
            }

            //quit
            else if (Objects.equals(guess, "quit")) {
                feedback.append("tot ziens");
                break;
            }

            else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringNumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringNumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {return false;}
        return true;
    }
}