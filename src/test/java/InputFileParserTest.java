import com.exercise.handler.InputFileParser;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.util.Hashtable;

/**
 * Created by Dennis on 2016-01-14.
 */
public class InputFileParserTest
{
    private final String AND_GATE = "AndGate.txt";
    private final String OR_GATE = "OrGate.txt";
    private final String NOT_GATE = "NotGate.txt";
    private final String LSHIFT_GATE = "LShift.txt";
    private final String RSHIFT_GATE = "RShift.txt";
    private final String ASSIGNMENT = "Assignment.txt";
    private final String ONE_MISSING_VALUE = "OneMissingValue.txt";
    private final String TWO_MISSING_VALUES = "TwoMissingValues.txt";


    @Test
    public void testInputFileParserWhenAndGate() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(AND_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("d") == 72);
    }

    @Test
    public void testInputFileParserWhenOrGate() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(OR_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("e") == 507);
    }

    @Test
    public void testInputFileParserWhenNotGate() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(NOT_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("h") == 65412);
        Assert.assertTrue(wiresSignal.get("i") == 65079);
    }

    @Test
    public void testInputFileParserWhenLshiftGate() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(LSHIFT_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("f") == 492);
    }

    @Test
    public void testInputFileParserWhenRshiftGate() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(RSHIFT_GATE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("g") == 114);
    }

    @Test
    public void testInputFileParserWhenAssignmentOperation() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(ASSIGNMENT).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("x") == 123);
        Assert.assertTrue(wiresSignal.get("y") == 456);
    }

    @Test
    public void testInputFileParserWhenValueUsedBeforeItBeenAssigned() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(ONE_MISSING_VALUE).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("c") == 123);
        Assert.assertTrue(wiresSignal.get("t") == 492);
    }

    @Test
    public void testInputFileParserWhenBothValuesUsedBeforeAssignment() throws Exception
    {
        Hashtable<String,Integer> wiresSignal = new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(TWO_MISSING_VALUES).getFile()));
        Assert.assertNotNull(wiresSignal);
        Assert.assertTrue(wiresSignal.size() != 0);
        Assert.assertTrue(wiresSignal.get("b") == 1674);
        Assert.assertTrue(wiresSignal.get("o") == 1674);
        Assert.assertTrue(wiresSignal.get("n") == 1674);
    }
}
