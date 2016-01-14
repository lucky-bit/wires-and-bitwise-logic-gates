import com.exercise.part1.CircuitAssembler;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Dennis on 2016-01-13.
 */
public class InputFileReaderTest
{
    private static final int NUMBER_OF_LINES_IN_DEFAULT_FILE = 339;

    @Test(expected=IOException.class)
    public void testIOExceptionThrownWhenInputFileNotExist() throws IOException
    {
        new CircuitAssembler().assemblyCircuit("NOT_EXISTING_FILE");
    }

    @Test
    public void testParsedNumberOfLinesEqualsToNumberOfLinesInDefaultFile() throws IOException
    {
        Assert.assertTrue(NUMBER_OF_LINES_IN_DEFAULT_FILE == new CircuitAssembler().assemblyCircuit(null));
    }


}
