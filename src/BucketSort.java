import java.util.ArrayList;

public class BucketSort {
	
	InsertionSort is = new InsertionSort();
	
	/*
	step 1: Get size of Array
	Step 2: Get max value
	Step 3: Get amount of Buckets
	Step 4: Get Divider = ceil( (max+1) / bucket size)
	Step 5: Assigning to Buckets: assigned_bucket = floor(A[i] / divider)
	Step 6: Insetion Sort every buckets
	Step 7: Merge bucket
	*/
	
	public int[] doBucketSort(int[] arr){	
		int size = arr.length; //step 1
		int max = getMax(arr); //step 2
		ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[10]; //step 3
		int divider = String.valueOf(max).length();

		//step 5
		int assignedBucket = 0;
		for(int i=0; i<arr.length; i++){
			assignedBucket = (int) (arr[i] / Math.pow(10, divider-1));
			if(bucket[assignedBucket] == null){
				bucket[assignedBucket] = new ArrayList<Integer>();
			}
			bucket[assignedBucket].add(arr[i]);
		}
		
		//step 6
		for(int i=0; i<bucket.length; i++){
			if(bucket[i] != null && bucket[i].size() != 0){
				System.out.print("Bucket [" + i + "]: ");
				bucket[i] = is.doInsertionSort(bucket[i]);
				for(int j=0; j<bucket[i].size(); j++){
					System.out.print(bucket[i].get(j)+ " ");
				}
			}
			else{
				continue;
			}
			System.out.println();
		}
		
		//step 7
		return convertToArr(bucket, arr.length);
	}
	
	//TODO: Wrong Conversion to Array code. Under construction.
	public int[] convertToArr(ArrayList<Integer>[] bucket, int size){
		int[] output = new int[size];
		int index = 0;
		for(int i=0; i<bucket.length; i++){
			for(int j=0; bucket[i] != null && j< bucket[i].size(); j++){
				output[index] = bucket[i].get(j);
				index ++;
			}
		}
		return output;
		
	}
	
	public int getMax(int[] arr){
		int largest = arr[0];
		
		for(int i=1; i<arr.length; i++){
			if(largest < arr[i])
				largest = arr[i];
		}
		
		return largest;
		
	}
}
