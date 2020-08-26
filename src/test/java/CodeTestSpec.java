
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
    import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"A", "B", "C"};

        // act
        final String[] actual = CodeTest.uppercaseArray(new String[] {"a", "b", "c"});
        
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
        Assert.assertEquals(2,CodeTest.findWordCount("the cat jumped over the mat","the"));
        Assert.assertEquals(1,CodeTest.findWordCount("the cat jumped over the mat","cat"));
        Assert.assertEquals(0,CodeTest.findWordCount("the cat jumped over the mat","ddddthe"));
    }

    @Test
    public void composeU_returnsExpectedResult() {
        int res = CodeTest.composeU(x -> x + 1, x -> x + 2).apply(1);
        Assert.assertEquals(4, res);
    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
        //New output for the system.out.printnl
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        CodeTest.writeContentsToConsole();
        
        //Default out
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        
        Assert.assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", buffer.toString().strip());
        buffer.reset();
    }

    @Test(expected = NumberFormatException.class)
    public void handleInvalidArgument_returnsExpectedResult() {
        CodeTest.input = new String[] {"1", "2", "a"};
        CodeTest.handleInvalidArgument();        
    }

    @Test
    public void puzzle_returnsExpectedResult() {
        //New output for the system.out.printnl
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        CodeTest.input = new String[] {"1", "2", "2", "5"};
        CodeTest.puzzle();
        
        //Default out
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        
        Assert.assertEquals("1,2,2,Snap", buffer.toString().strip());
        buffer.reset();
    }
}
