import com.exercise.part1.data.ParseResult;
import com.exercise.part1.handler.BitwiseOperationExecutor;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Denis on 2016-01-15.
 */
public class BitwiseOperationExecutorTest
{
    @Test
    public void testAndOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performAndOperation(new ParseResult(123, 456, "d"));
        Assert.assertTrue(result == 72);
    }

    @Test
    public void testOrOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performOrOperation(new ParseResult(123, 456, "e"));
        Assert.assertTrue(result == 507);
    }

    @Test
    public void testNotOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performNotOperation(new ParseResult(0, 123, "h"));
        if(result <=0)
            result += 65536;
        Assert.assertTrue(result == 65412);
        result = new BitwiseOperationExecutor().performNotOperation(new ParseResult(0, 456, "i"));
        if(result <=0)
            result += 65536;
        Assert.assertTrue(result == 65079);
    }

    @Test
    public void testRshiftOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performRshiftOperation(new ParseResult(456, 2, "g"));
        Assert.assertTrue(result == 114);
    }

    @Test
    public void testLshiftOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performLshiftOperation(new ParseResult(123, 2, "f"));
        Assert.assertTrue(result == 492);
    }

}
