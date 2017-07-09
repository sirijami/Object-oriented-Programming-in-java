package demos;

import java.util.Arrays;

public class selectionSort {

	public static void main(String[] args) {
		int[] array = new int[]{7,2,4,5,1, 6, -1, 10};
		sort(array);
	}

	private static void sort(int[] array) {
		for(int i = 0; i < array.length-1 ; i++){
			for(int j = i+1 ; j < array.length ; j++) {
				if(array[j] <= array[i]){
					swap(array, i , j);
				}
			}
			System.out.println(Arrays.toString(array));
		}
		System.out.println(Arrays.toString(array));
	}
	

	private static void swap(int[] array, int i, int j) {
		int temp = 0;
		temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

}
