package leetcode;

import java.io.*; 

class MinSwap 
{ 
	static int customSortArr(int arr[]) 
	{ 
		int swap=0;
		int left = 0, right = arr.length - 1; 
		while (left < right) 
		{ 
			while (arr[left]%2 == 0 && left < right) 
				left++; 

			while (arr[right]%2 == 1 && left < right) 
				right--; 

			if (left < right) 
			{ 
				int temp = arr[left]; 
				arr[left] = arr[right]; 
				arr[right] = temp; 
				left++; 
				right--; 
				swap++;
			} 
		} 
		return swap;
	} 

	/* Driver program to test above functions */
	public static void main (String[] args) 
	{ 
		int arr[] = {8,5,11,4,6}; 

		System.out.println(customSortArr(arr)); 

		System.out.print("Array after segregation "); 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+" "); 
	} 
} 
