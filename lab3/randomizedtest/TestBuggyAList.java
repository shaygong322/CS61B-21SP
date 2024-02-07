package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> listExpected = new AListNoResizing<>();
        BuggyAList<Integer> list = new BuggyAList<>();

        listExpected.addLast(1);
        listExpected.addLast(2);
        listExpected.addLast(3);

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(listExpected.size(), list.size());

        assertEquals(listExpected.removeLast(), list.removeLast());
        assertEquals(listExpected.removeLast(), list.removeLast());
        assertEquals(listExpected.removeLast(), list.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
            if (L.size() == 0)
                continue;
            if (operationNumber == 2) {
                // getLast
                int val = L.getLast();
                assertEquals(L.getLast(), B.getLast());
            } else if (operationNumber == 3) {
                // removeLast
                int val = L.removeLast();
                assertEquals(val, (int) B.removeLast());
            }
        }
    }
}
