import java.util.ArrayList;

public class BucketSort {
	
	InsertionSort is = new InsertionSort();
	
	public int[] doBucketSort(int[] arr){
		//step 1: Get size of Array
		//Step 2: Get max value
		//Step 3: Get amount of Buckets
		//Step 4: Get Divider = ceil( (max+1) / bucket size)
		//Step 5: Assigning to Buckets: assigned_bucket = floor(A[i] / divider)
		//Step 6: Insetion Sort every buckets
		//Step 7: Merge bucket
		
		int size = arr.length; //step 1
		int max = getMax(arr); //step 2
		ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[10]; //step 3
		int divider = (int) Math.ceil((float)(max+1)/bucket.length); //step 4
		
		//TODO: Divider doesn't work for 2 digit numbers???
		System.out.println("Max: " + max + " || Divider " + divider);

		//step 5
		int assignedBucket = 0;
		for(int i=0; i<arr.length; i++){
			assignedBucket = (int)Math.floor(arr[i]/divider);
			System.out.println("Number : " + arr[i] + " || Assigned Bucket : " + assignedBucket + " || Divider: " + divider);
			if(bucket[assignedBucket] == null){
				bucket[assignedBucket] = new ArrayList<Integer>();
			}
			bucket[assignedBucket].add(arr[i]);
		}
		
		//step 6
		for(int i=0; i<bucket.length; i++){
			System.out.print("Bucket [" + i + "]: ");
			if(bucket[i] != null && bucket[i].size() != 0){
				bucket[i] = is.doInsertionSort(bucket[i]);
				for(int j=0; j<bucket[i].size(); j++){
					System.out.print(bucket[i].get(j)+ " ");
				}
			}
			System.out.println();
		}
		
		//step 7
		return convertToArr(bucket, arr.length);
	}
	
	//TODO: Wrong Conversion to Array code. Under construction.
	public int[] convertToArr(ArrayList<Integer>[] bucket, int size){
		int[] output = new int[bucket.length];
		for(int i=0; i<bucket.length; i++){
			for(int j=0; bucket[i] != null && j< bucket[i].size(); j++){
				output[i] = bucket[i].get(j);
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
