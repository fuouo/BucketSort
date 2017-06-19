import java.util.ArrayList;

public class InsertionSort {
	
	public ArrayList<Integer> doInsertionSort(ArrayList<Integer> arr){
		int key = 0;
		int j = 0;
		
		for(int i=0; i<arr.size(); i++){
			key = arr.get(i);
			j = i-1;
			while( j >= 0 && arr.get(j) > key){
				arr.set(j+1, arr.get(j));
				j--;
				arr.set(j+1, key);
				
			}
		}
		
		return arr;
	}
	
	public int[] doInsertionSort(int[] arr){
		int key = 0;
		int j = 0;
		
		for(int i=0; i<arr.length; i++){
			key = arr[i];
			j = i-1;
			while( j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
				arr[j+1] = key;
				
			}
		}
		
		return arr;
	}
}
