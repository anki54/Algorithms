package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridGame {
	
	public static List<List<Integer>> gridGame(List<List<Integer>> grid, int k, List<String> rules) {
		int rows = grid.size();
		int cols = grid.get(0).size();
		
		int liveNe[][] = new int[rows][cols];
		
		for(int i = 0;i<rows;i++) {
			for(int j =0;j<cols;j++) {
				liveNe[i][j] = countliveNeigbours(grid, i, j, rows, cols);
			}
		}
		//print(liveNe);
		
		for(int i=0;i<rules.size();i++) {
			if(rules.get(i)=="dead") {
				grid = applyRule(grid,liveNe,i,0);
			}else {
				grid = applyRule(grid,liveNe,i,1);
			}
		}
		return grid;
		
	}	
	
	public static void print(List<List<Integer>> mat) {
		int rows = mat.size();
		int cols = mat.get(0).size();
		
		
		for(int i = 0;i<rows;i++) {
			for(int j =0;j<cols;j++) 
				System.out.print(mat.get(i).get(j)+" ");
			System.out.println();
		}
		
	}
	
	public static List<List<Integer>>  applyRule(List<List<Integer>> grid, int [][] neig, int ruleIdx, int newVal) {
		int rows = neig.length;
		int cols = neig[0].length;	
		
		
		for(int i = 0;i<rows;i++) {
			for(int j =0;j<cols;j++) {
				if(neig[i][j]==ruleIdx)
					grid.get(i).set(j,newVal);
			}
				
		}
		return grid;
		
	}
	
	public static int countliveNeigbours(List<List<Integer>> grid, int i, int j, int r, int c) {
		
		int liveNeihgbr = 0;
		if(i>0) {
			if(grid.get(i-1).get(j)==1)liveNeihgbr++;
			if(j>0) {
				if(grid.get(i-1).get(j-1)==1)liveNeihgbr++;				
			}
		}
		
		if(j>0 && grid.get(i).get(j-1)==1)liveNeihgbr++;
		if(j<c-1 && grid.get(i).get(j+1)==1)liveNeihgbr++;
		if(j<c-1 && i<r-1 &&  grid.get(i+1).get(j+1)==1)liveNeihgbr++;
		if(i<r-1 && grid.get(i+1).get(j)==1)liveNeihgbr++;
		if(j>0 && i<r-1 &&  grid.get(i+1).get(j-1)==1)liveNeihgbr++;
		if(i>0 && j<c-1 &&  grid.get(i-1).get(j+1)==1)liveNeihgbr++;
		return liveNeihgbr;
	}

	public static void main(String[] args) {
		//int[][] grid = {{0,1,0,0},{0,0,0,0}};
		List<Integer> grid1 = new ArrayList();
		grid1.add(0);
		grid1.add(1);
		grid1.add(0);
		grid1.add(0);
		List<Integer> grid2 = new ArrayList();
		grid2.add(0);
		grid2.add(0);
		grid2.add(0);
		grid2.add(0);
		
		List<List<Integer>> grid = new ArrayList();
		grid.add(grid1);
		grid.add(grid2);
		int k =1;
		String[] rules= {"dead","alive","dead","dead","dead","dead","dead","dead","dead"};
		gridGame(grid, k, Arrays.asList(rules));
		print(grid);

	}

}
