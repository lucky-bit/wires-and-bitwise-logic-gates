import com.exercise.CircuitAssembler;
import com.exercise.handler.InputFileParser;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dennis on 2016-01-13.
 */
public class InputFileReaderTest
{
    private static final int NUMBER_OF_LINES_IN_DEFAULT_FILE = 339;
    private static final String INVALID_INPUT_FILE = "src/test/InvalidInputFile.txt";
    private static final String DEFAULT_INPUT_FILE_NAME = "input.txt";

    @Test(expected=IOException.class)
    public void testIOExceptionThrownWhenInputFileNotExist() throws Exception
    {
        new CircuitAssembler().assemblyCircuit("NOT_EXISTING_FILE");
    }

    @Test
    public void testParsedNumberOfLinesEqualsToNumberOfLinesInFileByPath() throws Exception
    {
        String path = CircuitAssembler.class.getResource(DEFAULT_INPUT_FILE_NAME).getPath();

        int circuitSize = new CircuitAssembler().assemblyCircuit(path).size();
        Assert.assertTrue(circuitSize + " is not equal to " + NUMBER_OF_LINES_IN_DEFAULT_FILE,
                NUMBER_OF_LINES_IN_DEFAULT_FILE == circuitSize );
    }

    @Test
    public void testParsedNumberOfLinesEqualsToNumberOfLinesInDefaultFile() throws Exception
    {
        int circuitSize = new CircuitAssembler().assemblyCircuit(null).size();
        Assert.assertTrue(circuitSize + " is not equal to " + NUMBER_OF_LINES_IN_DEFAULT_FILE,
                NUMBER_OF_LINES_IN_DEFAULT_FILE == circuitSize );
    }

    @Test(expected=Exception.class)
    public void testExceptionThrownWhenInputFileIsInvalid() throws Exception
    {
        new InputFileParser().parseInputFileAndPerformOperation(new File(InputFileParserTest.class.getResource(INVALID_INPUT_FILE).getFile()));
    }


}
