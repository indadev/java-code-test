import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodeTest {
    
    public static String[] input;
    
    public static void main(String[] args) {
        input = args;
        
        System.out.println(Arrays.toString(reverseArray(new String[]{"First", "Second"})));
        System.out.println(Arrays.toString(uppercaseArray(new String[]{"1toUpper", "2toUpper"})));
        System.out.println(findWordCount("the cat jumped over the mat","the"));
        System.out.println(findWordCount("the cat jumped over the mat","cat"));
        System.out.println(composeU(x -> x + 2, x -> x + 3).apply(1));
        writeContentsToConsole();
        handleInvalidArgument();
        puzzle();
        
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
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text.txt"));
            for(String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isNumeric(String num){
        boolean res = false;
        if (num == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(num); 
        } catch (NumberFormatException nfe) {
            return false;
        }
        res = true;
        return res;
    }
    
    public static void handleInvalidArgument() throws NumberFormatException{
        for (String arg: input){
            if (!isNumeric(arg)){
                throw new NumberFormatException(arg + " is not a number");
            }
        }
    }

    public static void puzzle() {
        handleInvalidArgument();
        String actual = "";
        for (String arg: input){
            if (actual.equals(arg)){
                System.out.print(arg + ",Snap");
                break;
            }else{
                System.out.print(arg + ",");
            }
            actual = arg;
        }
    }
}