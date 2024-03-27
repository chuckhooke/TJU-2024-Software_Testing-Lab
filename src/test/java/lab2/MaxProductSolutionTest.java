package lab2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxProductSolutionTest {

    private int input;
    private int expectedOutput;

    public MaxProductSolutionTest(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
        Collection<Object[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src\\test\\resources\\lab2\\testinput.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int input = Integer.parseInt(parts[0]);
            int expected = Integer.parseInt(parts[1]);
            data.add(new Object[] { input, expected });
        }
        reader.close();
        return data;
    }

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("BeforeClass: Run before all tests start.");
    }

    @Before
    public void setUp() {
        System.out.println("Before: Run before each test.");
    }

    @Test
    public void testMaxProduct() {
        MaxProductSolution solution = new MaxProductSolution();
        assertEquals(expectedOutput, solution.maxProduct(input));
        System.out.println(input + "'s largest product value is " + expectedOutput);
    }

    @After
    public void tearDown() {
        System.out.println("After: Run after each test.");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("AfterClass: Run after all tests have finished.");
    }

}