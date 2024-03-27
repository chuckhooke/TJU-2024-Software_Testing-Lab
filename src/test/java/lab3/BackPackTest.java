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
public class BackPackTest {

    private int[] inputWeight;
    private int[] inputValue;
    private int inputCapacity;
    private int expectedOutput;

    public BackPackTest(int[] inputWeight, int[] inputValue, int inputCapacity, int expectedOutput) {
        this.inputWeight = inputWeight;
        this.inputValue = inputValue;
        this.inputCapacity = inputCapacity;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
        Collection<Object[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src\\test\\resources\\lab3\\BackPackTestInput.txt"));

        String[] inputWeight = new String[0];
        String[] inputValue = new String[0];
        String inputCapacity = null;
        String expectedOutput = null;

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#") || line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(";");

            // 否则都为空
            if(!parts[0].equals("")){
                inputWeight = parts[0].split(",");
                inputValue = parts[1].split(",");
            }

            inputCapacity = parts[2];
            expectedOutput = parts[3];

            int[] inputWeightInt = new int[inputWeight.length];
            for (int i = 0; i < inputWeight.length; i++) {
                inputWeightInt[i] = Integer.parseInt(inputWeight[i].trim());
            }

            int[] inputValueInt = new int[inputValue.length];
            for (int i = 0; i < inputValue.length; i++) {
                inputValueInt[i] = Integer.parseInt(inputValue[i].trim());
            }

            data.add(new Object[] { inputWeightInt, inputValueInt, Integer.parseInt(inputCapacity), Integer.parseInt(expectedOutput) });
        }
        reader.close();
        return data;
    }

    @Test
    public void testBackPack() {
        BackPack solution = new BackPack();
        assertEquals (expectedOutput, solution.backPack(inputWeight, inputValue, inputCapacity));
    }
}