package lab3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BubbleSortTest {

    private int[] input;
    private int[] expectedOutput;

    public BubbleSortTest(int[] input, int[] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
        Collection<Object[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src\\test\\resources\\lab3\\BubbleSortTestInput.txt"));

        String line;
        String[] inputParts = new String[0];
        String[] expectedParts = new String[0];

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#") || line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(";");

            // 否则都为空
            if(parts.length > 1){
                inputParts = parts[0].split(",");
                expectedParts = parts[1].split(",");
            }

            int[] input = new int[inputParts.length];
            for (int i = 0; i < inputParts.length; i++) {
                input[i] = Integer.parseInt(inputParts[i].trim());
            }

            int[] expected = new int[expectedParts.length];
            for (int i = 0; i < expectedParts.length; i++) {
                expected[i] = Integer.parseInt(expectedParts[i].trim());
            }

            data.add(new Object[] { input, expected });
        }
        reader.close();
        return data;
    }


    @Test
    public void testBubbleSort() {
        BubbleSort solution = new BubbleSort();
        assertArrayEquals (expectedOutput, solution.bubbleSort(input));
    }
}