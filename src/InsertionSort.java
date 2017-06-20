import java.util.ArrayList;

public class InsertionSort
{
	public static void sort(ArrayList<Integer> input)
	{	
		int key = 0;
		int j = 0;
		for(int i=0; i<input.size(); i++){
			key = input.get(i);
			j = i-1;
			while(j >= 0 && input.get(j)>key){
				input.set(j+1, input.get(j));
				j--;
				input.set(j+1, key);
				
			}
		}
	}

}
