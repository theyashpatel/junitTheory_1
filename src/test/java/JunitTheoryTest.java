import com.sun.tools.classfile.Opcode;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class JunitTheoryTest {

    @DataPoints
    public static Object[] elements = {
            "cat",
            3,
            "elephant",
            5
    };

    @DataPoints
    public static Set[]  elementSet = {
            new HashSet(Arrays.asList("elephant",5)),
            new HashSet(Arrays.asList(7, 10, 15)),
            new HashSet(Arrays.asList("cat", "dog"))


    };

    @Theory
    public void removeThenAddDoesNotChangeSet(Set<Object> someSet,Object element) {
        assumeNotNull(someSet);
        assumeTrue(someSet.contains(element));
        Set<Object> copy = new HashSet<Object>(someSet);
        copy.remove(element);
        copy.add(element);
        assertTrue(someSet.equals(copy));
    }

}
