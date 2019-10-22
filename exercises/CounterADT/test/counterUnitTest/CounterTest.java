package counterUnitTest;

import counterADT.Counter;
import counterADT.InvalidCounterException;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Project: CounterADT
 */
public class CounterTest {

    // Test objects
    Counter one;
    Counter two;
    static Counter zero;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        zero = new Counter(0);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        zero = null;
    }

    @Before
    public void setUp() throws Exception {
        one = new Counter();
        two = new Counter(2);
    }

    @After
    public void tearDown() throws Exception {
        one = null;
        two = null;
    }

    // Accessor methods
    @Test
    public void getCounter_ExistingCounter_ShouldGetValue() {
        int expected = 2;
        int actual = two.getCounter();
        assertEquals("GetCounter method did not return the correct counter value.", expected, actual);
    }

    // Mutator methods
    @Test
    public void setCounter_NonNegative_ShouldSetValue() {
        int expected = 1;
        try {
            one.setCounter(1);
        } catch (InvalidCounterException e) {
//            e.printStackTrace();
            fail("SetCounter method should not throw InvalidCounterException.");
        }
        int actual = one.getCounter();
        assertEquals("SetCounter method did not set the value correctly.", expected, actual);
    }

    @Test
    public void setCounter_BoundaryZero_ShouldSetValue() {
        int expected = 0;
        try {
            one.setCounter(0);
        } catch (InvalidCounterException e) {
//            e.printStackTrace();
            fail("SetCounter method should not throw InvalidCounterException");
        }
        int actual = one.getCounter();
        assertEquals("SetCounter method did not set the value correctly.", expected, actual);
    }

    @Test
    public void setCounter_Negative_ShouldThrowException() {
        try {
            one.setCounter(-1);
            fail("SetCounter method did not throw InvalidCounterException");
        } catch (InvalidCounterException e) {
//            e.printStackTrace();
            assertTrue(true);
        }
    }

    // Operational methods
    @Test
    public void incCounter() {
    }

    @Test
    public void decCounter() {
    }

    @Test
    public void isZero() {
    }

    @Test
    public void testToString() {
    }
}