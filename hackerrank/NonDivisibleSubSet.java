package algorithms.hackerrank

import java.io.*;
import java.util.*;

/**
 * Solution to problem at 
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 * Print the size of the largest subset not divisible by k.
 */
public class NonDivisibleSubSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.*/
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        
        int a[] = new int[k];
        for(int i=0;i<n;i++){
            a[s.nextInt()%k]++;
        }
        
        int count=0;
        if(k%2==0)
            a[k/2]=Math.min(1,a[k/2]);
        for(int i=1;i<=k/2;i++){
           count+=Math.max(a[i],a[k-i]);
        }
        
        count+=Math.min(a[0],1);
        System.out.println(count);
        
    }
}
