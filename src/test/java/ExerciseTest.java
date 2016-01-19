import com.exercise.handler.InputFileParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Hashtable;

/**
 * Created by Denis on 2016-01-17.
 */
public class ExerciseTest
{
    private final String INPUT_FILE1 = "InputPart1.txt";
    private final String INPUT_FILE2 = "InputPart2.txt";

    @Test
    public void runPart1() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(INPUT_FILE1).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        System.out.println("\n\n***** Part 1 result: a = " + wiresSignal.get("a") +"\n");
    }

    @Test
    public void runPart2() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(INPUT_FILE2).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        System.out.println("\n\n***** Part 2 result: a = " + wiresSignal.get("a") +"\n");
    }
}
