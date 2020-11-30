package edu.eskisehir;

import org.junit.*;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @BeforeClass
    public static void connect2DB() {
        System.out.println("before class is called");
    }

    @Before
    public void before() {
        System.out.println("before is called");
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @After
    public void after() {
        System.out.println("after is called");
    }

    @Test
    public void simpleTest() {

        int input = -5;

        int expected = 5;

        assertEquals("informative message", expected, Math.abs(input));

    }

    @Test
    public void impossibleTest() {
        int input = new Random().nextInt();
        assertTrue("informative message", Math.abs(input) >= 0);
    }

    @AfterClass
    public static void closeDB() {
        System.out.println("after class is called");
    }

    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void testException() {
        int[] array = new int[3];
        array[3] = 0;
        assertEquals(array.length, 3);
    }

    @Test(expected = java.lang.OutOfMemoryError.class)
    public void testError() {
        double[] array = new double[Integer.MAX_VALUE];
        assertEquals(array.length, Integer.MAX_VALUE);
    }

    @Test
    public void testDivision() {
        int p = 9;
        int payda = 3;
        int sonuc = p / payda;
        assertEquals("9/3=3", 3, sonuc);
    }

    @Test
    public void testDelta() {

        double d = 6.6;
        double e = 1.1;
        double s = d / e;
        System.out.println(s);

        // When working with doubles and floats make sure to use delta
        // assertTrue(s == 6.0D); does not work

        assertEquals("6.6/1.1=6.0", 6.0D, s, 0.00001);
    }

}
