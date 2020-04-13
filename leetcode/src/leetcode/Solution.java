package leetcode;

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
     * Complete the 'rotateTheString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING originalString
     *  2. INTEGER_ARRAY direction
     *  3. INTEGER_ARRAY amount
     */

    public static String rotateTheString(String originalString, List<Integer> direction, List<Integer> amount) {
    // Write your code here
    
        String result = null;

        if(originalString!=null){

            result=originalString;
            
            for(int i=0;i<direction.size();i++){
                if(direction.get(i)==0){
                    result = leftRotate(result,amount.get(i));
                }
                else if(direction.get(i)==1){
                    result = rightRotate(result, amount.get(i));  
                }
            }
            
        }

        return result;

    }


    private static String leftRotate(String s, int steps){
        return s.substring(steps) + s.substring(0,steps);
    }

    private static String rightRotate(String s, int steps){
        if(s.length()>steps)
            return leftRotate(s, s.length()-steps);
        else
            return rightRotate(s,steps-s.length());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String originalString = bufferedReader.readLine();

        int directionCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> direction = IntStream.range(0, directionCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int amountCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> amount = IntStream.range(0, amountCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.rotateTheString(originalString, direction, amount);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
