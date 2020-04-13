package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BFSshortSearch {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {

        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for(int j=0;j<=n;j++){
            list.add(j,new HashSet<>());
        }
        for(int j= 0;j<edges.length;j++){           
            for(int k=1;k<edges[0].length;k++){
                list.get(edges[j][0]).add(edges[j][k]);
                list.get(edges[j][k]).add(edges[j][0]);
            }
        } 

        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[n+1];
        int dist = 6;
        queue.add(s);
        visited.add(s);
        int start;
        while(!queue.isEmpty()){
             start = queue.remove();
             //System.out.println(start + "***");
                 
            for(int node: list.get(start)){
                //System.out.println(node);
                if(!visited.contains(node)){
                    res[node] = res[start]+dist;
                    queue.add(node);     
                    visited.add(node);        
                }      
            }               
            
        }
        int finalResult[] = new int[n-1];
        int j=0;
        for(int k=1;k<=n;k++){
            if(k==s)
                continue;
            if(res[k]==0)
                finalResult[j]=-1;
            else
                finalResult[j]=res[k];
            j++;
        }
        return finalResult;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
