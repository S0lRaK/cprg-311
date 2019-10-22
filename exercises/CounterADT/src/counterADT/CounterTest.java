package counterADT;
/**
 * ANNOTATIONS:
 *
 * @Test -  The annotation @Test identifies that a method is a test method.
 * @Ignore - Will ignore the test method. This is useful when the underlying code has been changed and
 * the test case has not yet been adapted. Or if the execution time of this test is too long to be included.
 * @Test(expected=Exception.class) - Fails, if the method does not throw the named exception.
 * @Test(timeout=100) - Fails, if the method takes longer than 100 milliseconds.
 *
 * ASSERTS: [] = optional message to display
 * fail([String]) - Let the method fail. Might be used to check that a certain part of the code is not reached.
 * Or to have failing test before the test code is implemented.
 * assertTrue(boolean) - Will always be true/false. Can be used to predefine a test result,
 * if the test is not yet implemented.
 * assertTrue([String], boolean condition) - Checks that the boolean condition is true.
 * assertsEquals([String], expected, actual) - Tests that two values are the same.
 * Note: for arrays the reference is checked not the content of the arrays.
 * assertsEquals([String], expected, actual, tolerance) - Test that float or double values match.
 * The tolerance is the number of decimals which must be the same.
 * assertNull([String], object) - Checks that the object is null.
 * assertNotNull([String], object) - Checks that the object is not null.
 * assertSame([String], expected, actual) - Checks that both variables refer to the same object.
 * assertNotSame([String], expected, actual) - Checks that both variables refer to different objects.
 *
 * For a list of all test classes - check out http://junit.org/javadoc/latest/
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author kitty
 *
 */
public class CounterTest {
    // test object
    Counter one;
    Counter two = new Counter(2);
    Counter zero = new Counter(0);

    /**
     * @BeforeClass - Will execute the method once, before the start of all tests.
     * 		This can be used to perform time intensive activities, for example to connect to a database.
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @AfterClass - Will execute the method once, after all tests have finished.
     * 		This can be used to perform clean-up activities, for example to disconnect from a database.
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @Before - Will execute the method before each test.
     * 		This method can prepare the test environment (e.g. read input data, initialize the class).
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        one = new Counter();
    }

    /**
     * @After - Will execute the method after each test.
     * 		This method can cleanup the test environment (e.g. delete temporary data, restore defaults).
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        one = null;
    }

    /**
     * Test method for {@link counterADT.Counter#getCounter()}.
     */
    @Test
    public void testGetCounter() {
        int expected = 2;
        int actual = two.getCounter();
        assertEquals("GetCounter method did not return the correct counter value.", expected, actual);
    }

    /**
     * Test method for {@link counterADT.Counter#setCounter(int)}.
     * @throws InvalidCounterException
     */
    @Test
    public void testSetCounterNonnegative() throws InvalidCounterException {
        int expected = 1;
        one.setCounter(1);
        int actual = one.getCounter();
        assertEquals("SetCounter method did not set the counter value correctly.", expected, actual);
    }

    /**
     * Test method for {@link counterADT.Counter#setCounter(int)}.
     * @throws InvalidCounterException
     */
    @Test
    public void testSetCounterBoundaryZero() throws InvalidCounterException {
        int expected = 0;
        one.setCounter(0);
        int actual = one.getCounter();
        assertEquals("SetCounter method did not set the counter value correctly.", expected, actual);
    }

    /**
     * Test method for {@link counterADT.Counter#setCounter(int)}.
     * @throws InvalidCounterException
     */
    @Test
    public void testSetCounterNegative() {
        try {
            one.setCounter(-1);
            fail("SetCounter failed to throw counterADT.InvalidCounterException.");
        } catch (InvalidCounterException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link counterADT.Counter#incCounter()}.
     */
    @Test
    public void testIncCounter() {
        int expected = 3;
        two.incCounter();
        int actual = two.getCounter();
        assertEquals("IncCounter method did not increment the counter value correctly.", expected, actual);
    }

    /**
     * Test method for {@link counterADT.Counter#decCounter()}.
     * @throws InvalidCounterException
     */
    @Test
    public void testDecCounterNonZero() throws InvalidCounterException {
        int expected = 1;
        two.decCounter();
        int actual = two.getCounter();
        assertEquals("DecCounter method did not decrement the counter value correctly.", expected, actual);
    }

    /**
     * Test method for {@link counterADT.Counter#decCounter()}.
     * @throws InvalidCounterException
     */
    @Test
    public void testDecCounterZero() {
        try {
            zero.decCounter();
            fail("DecCounter failed to throw counterADT.InvalidCounterException.");
        } catch (InvalidCounterException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link counterADT.Counter#isZero()}.
     */
    @Test
    public void testIsZero() {
        boolean actual = true;
        boolean expected = zero.isZero();
        assertEquals("IsZero method did not check zero value correctly.", expected, actual);
    }

    /**
     * Test method for {@link counterADT.Counter#isZero()}.
     */
    @Test
    public void testIsNotZero() {
        boolean actual = false;
        boolean expected = two.isZero();
        assertEquals("IsZero method did not check zero value correctly.", expected, actual);
    }

    /**
     * Test method for {@link Object#toString()}.
     */
    @Test
    public void testToString() {
        System.out.println(two.toString());
    }

}
