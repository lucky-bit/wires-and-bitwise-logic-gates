import com.exercise.part1.handler.InputFileParser;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by Denis on 2016-01-14.
 */
public class InputFileParserTest
{
    public static final String AND_GATE = "AndGate.txt";
    public static final String OR_GATE = "OrGate.txt";
    public static final String NOT_GATE = "NotGate.txt";
    public static final String LSHIFT_GATE = "LShift.txt";
    public static final String RSHIFT_GATE = "RShift.txt";
    public static final String ASSIGNMENT = "Assignment.txt";


    @Test
    public void testInputFileParserWhenAndGate() throws IOException
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndExecuteOperation(new File(InputFileParserTest.class.getResource(AND_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("d") == 72);
    }

    @Test
    public void testInputFileParserWhenOrGate() throws IOException
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndExecuteOperation(new File(InputFileParserTest.class.getResource(OR_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("e") == 507);
    }

    @Test
    public void testInputFileParserWhenNotGate() throws IOException
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndExecuteOperation(new File(InputFileParserTest.class.getResource(NOT_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("h") == 65412);
        Assert.assertTrue(wiresSignal.get("i") == 65079);
    }

    @Test
    public void testInputFileParserWhenLshiftGate() throws IOException
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndExecuteOperation(new File(InputFileParserTest.class.getResource(LSHIFT_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("f") == 492);
    }

    @Test
    public void testInputFileParserWhenRshiftGate() throws IOException
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndExecuteOperation(new File(InputFileParserTest.class.getResource(RSHIFT_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("g") == 114);
    }

    @Test
    public void testInputFileParserWhenAssignmentOperation() throws IOException
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndExecuteOperation(new File(InputFileParserTest.class.getResource(ASSIGNMENT).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("x") == 123);
        Assert.assertTrue(wiresSignal.get("y") == 456);
    }
}
