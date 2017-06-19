import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BucketSort bs = new BucketSort();
		
		Scanner sc = new Scanner(System.in);	
		int[] arr;
		int size = 0;
		
		System.out.print("Enter Size of Array: ");
		size = sc.nextInt();
		
		arr = new int[size];
		for(int i=0; i<size; i++){
			System.out.print("#"+i+": ");
			int temp = sc.nextInt();
			if(i != 0){
				//problem: negative number has length of 2 
				while(String.valueOf(arr[i-1]).length() != String.valueOf(temp).length()){
					System.out.print("Re-enter #"+i+": ");
					temp = sc.nextInt();
				}
			}
			arr[i] = temp;
		}
		
		int[] output = bs.doBucketSort(arr);
		printOutput(output);
	
	}
	
	public static void printOutput(int[] arr){
		System.out.println("\n\nResult: ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
	}

}
