import com.exercise.handler.InputLineParser;
import com.exercise.observation.impl.WireSignalObserver;
import com.exercise.observation.impl.WireSignalSubject;
import org.junit.Assert;
import org.junit.Test;
import java.util.Hashtable;

/**
 * Created by Denis on 2016-01-16.
 */
public class ObserverTest
{
    @Test
    public void testSignalAssignedOnAddSubject() throws Exception
    {
        WireSignalSubject wireSignalSubject = new WireSignalSubject();
        Hashtable<String,Integer> wiresSignals = new Hashtable<String,Integer>();
        InputLineParser inputLineParser = new InputLineParser(wiresSignals, wireSignalSubject);
        wireSignalSubject.addObserver(new WireSignalObserver("a", "a -> b", inputLineParser));
        wiresSignals.put("a", 1);
        wireSignalSubject.addSubject("a");
        Assert.assertTrue(wiresSignals.size() != 0);
        Assert.assertTrue(wiresSignals.get("a") == 1);
        Assert.assertTrue(wiresSignals.get("b") == 1);
    }

    @Test
    public void testMultipleSignalsAssignedOnAddSubject() throws Exception
    {
        WireSignalSubject wireSignalSubject = new WireSignalSubject();
        Hashtable<String,Integer> wiresSignals = new Hashtable<String,Integer>();
        InputLineParser inputLineParser = new InputLineParser(wiresSignals, wireSignalSubject);
        wireSignalSubject.addObserver(new WireSignalObserver("b", "b AND 1 -> c", inputLineParser));
        wireSignalSubject.addObserver(new WireSignalObserver("a", "a OR 0 -> b", inputLineParser));
        wireSignalSubject.addObserver(new WireSignalObserver("c", "NOT c -> d", inputLineParser));
        wiresSignals.put("a", 1);
        wireSignalSubject.addSubject("a");
        Assert.assertTrue(wiresSignals.size() != 0);
        Assert.assertTrue(wiresSignals.get("a") == 1);
        Assert.assertTrue(wiresSignals.get("b") == 1);
        Assert.assertTrue(wiresSignals.get("c") == 1);
        Assert.assertTrue(wiresSignals.get("d") == 65534);
    }
}
