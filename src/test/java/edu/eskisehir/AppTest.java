package edu.eskisehir;

import org.junit.*;

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
    @Ignore
    public void impossibleTest() {

        int input = 5; // ?

        assertTrue("informative message", Math.abs(input) < 0);
    }

    @AfterClass
    public static void closeDB() {
        System.out.println("after class is called");
    }

    @Ignore
    @Test(expected = java.lang.ArithmeticException.class)
    public void testException() {
        int p = 5;
        int payda = p - 5;
        double sonuc = (double) p / payda;
    }

    @Test
    public void testDivision() {
        int p = 9;
        int payda = 3;
        double sonuc = (double) p / payda;

        System.out.println(sonuc);

        assertEquals("9/3=3", 3.0D, sonuc, 0.00001);
    }

    @Test
    public void testDelta() {

        double d = 6.6;
        double e = 1.1;
        double s = d / e;
        System.out.println(s);

        // When working with doubles and floats make sure to use delta
        // assertTrue(s == 6.0D);

        assertEquals("6.6/1.1=6.0", 6.0D, s, 0.00001);
    }

}
