import com.exercise.data.ParseResult;
import com.exercise.handler.BitwiseOperationExecutor;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Denis on 2016-01-15.
 */
public class BitwiseOperationExecutorTest
{
    @Test
    @SuppressWarnings("unchecked")
    public void testAndOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performAndOperation(new ParseResult(123, 456, "d"));
        Assert.assertTrue(result == 72);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOrOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performOrOperation(new ParseResult(123, 456, "e"));
        Assert.assertTrue(result == 507);
    }

    @Test
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public void testRshiftOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performRshiftOperation(new ParseResult(456, 2, "g"));
        Assert.assertTrue(result == 114);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testLshiftOperation() throws IOException
    {
        int result = new BitwiseOperationExecutor().performLshiftOperation(new ParseResult(123, 2, "f"));
        Assert.assertTrue(result == 492);
    }

}
