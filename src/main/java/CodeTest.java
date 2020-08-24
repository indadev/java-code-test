import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CodeTest {
    public static void main(String[] args) {
        String[] input = new String[]{"First", "Second"};
        System.out.println(Arrays.toString(reverseArray(input)));
        System.out.println(Arrays.toString(uppercaseArray(input)));
        System.out.println(findWordCount("the cat jumped over the mat","the"));
        System.out.println(findWordCount("the cat jumped over the mat","cat"));
        System.out.println("Please replace this with calls to all completed tests.");
    }

    public static String[] reverseArray(String[] input) {
        List<String> listInput = Arrays.asList(input);
        Collections.reverse(listInput);
        return listInput.toArray(new String[0]);
    }

    public static String[] uppercaseArray(String[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].toUpperCase();
        }
        return input;
    }

    public static int findWordCount(String text, String wordToFind) {
        int res = 0;
        
        String[] words = text.trim().split("\\s+");
        for (String word:words){
            if (word.equalsIgnoreCase(wordToFind)){
                res ++;
            }
        }
        
        return res;
    }

    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){

        return f1.compose(f2);
    }

    public static void writeContentsToConsole() {
        // add code here
    }

    public static void handleInvalidArgument() {
        // add code here
    }

    public static void puzzle() {
        // add code here
    }
}