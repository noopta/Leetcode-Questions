import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void merge(int[] inputArray, int[] left, int[] right, ArrayList<Integer> inversionList) {
        int i = 0;
        int j = 0;
        int k = 0;
        int inversionCount = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                inputArray[k] = left[i];
                i++;
            } else if (right[j] < left[i]) {
                inputArray[k] = right[j];
                inversionCount += (left.length - i);
                j++;
            }

            k++;
        }

        while (i < left.length) {
            inputArray[k++] = left[i++];
        }

        while (j < right.length) {
            inputArray[k++] = right[j++];
        }

        inversionList.add(inversionCount);
    }

    public static void mergeSort(int[] inputArray, ArrayList<Integer> inversionList) {
        if (inputArray.length == 1) {
            return;
        }

        int midPoint = inputArray.length / 2;
        int left[] = new int[midPoint];
        int right[] = new int[inputArray.length - midPoint];
        int i = 0;
        int j = 0;

        for (i = 0; i < midPoint; i++) {
            left[i] = inputArray[i];
        }

        for (i = midPoint; i < inputArray.length; i++) {
            right[j] = inputArray[i];
            j++;
        }

        mergeSort(left, inversionList);
        mergeSort(right, inversionList);

        merge(inputArray, left, right, inversionList);
    }

    public static long countInversions(List<Integer> arr) {
        long numInversions = 0;
        int i = 0;
        int j = 0;
        int numArr[] = new int[arr.size()];
        ArrayList<Integer> inversionList = new ArrayList<Integer>();

        for (i = 0; i < arr.size(); i++) {
            numArr[i] = arr.get(i);
        }

        mergeSort(numArr, inversionList);

        for (i = 0; i < inversionList.size(); i++) {
            numInversions += inversionList.get(i);
        }

        return numInversions;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = Result.countInversions(arr);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}