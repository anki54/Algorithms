package leetcode;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        
        return uniquePathsCells(m-1,n-1);
    }
    
    public static int uniquePathsCells(int i,int j){
        int paths=0;
        if(i>=0 && j>=0){
            if(i==1 && j==0)
                return 1;
            if (j==1 && i==0)
                return 1;
            paths= uniquePathsCells(i,j-1)+ uniquePathsCells(i-1,j);
            System.out.println(paths);
        }
        return paths;
        
    }
    
    public static void main(String[] args) {
		System.out.println(uniquePaths(3,2));
	}
}