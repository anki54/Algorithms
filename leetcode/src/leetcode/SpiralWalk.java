package leetcode;

/**
 * Performs spiral walk on a matrix of any size
 * @author anki
 *
 */
public class SpiralWalk {

	public static void main(String[] args) {
		
//		int mat[][] = {{7,7,3,8,1},{13,15,4,5,2},{9,2,12,3,9},{6,12,1,11,41}};
		int mat[][] = {{1,2,3,4,},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int r=mat.length;
		int c = mat[0].length;
		int i,j,m,n;
		String space = " ";
		
		int steps=0;
		m=r;
		n=c;
		
		while(m>r/2 && n>c/2) {
			
			
			// First row		
			i=0+steps;
			for(j=0+steps;j<n;j++)
				System.out.print(mat[i][j] + space);
			
			//Last column
			j=n-1;
			for(i=1+steps;i<m;i++)
				System.out.print(mat[i][j] + space);
			
			n--;
			
			// Last row
			i=m-1;
			for(j=n-1;j>=0+steps;j--)
				System.out.print(mat[i][j] + space);
			
			m--;
			
			//First column
			j=0+steps;
			for(i=m-1;i>=steps+1;i--) {
				System.out.print(mat[i][j] + space);
			}
			
			steps++;			
			
		}
		

	}

}
