import java.util.ArrayList;

public class InsertionSort
{
	public static void sort(ArrayList<Integer> input)
	{
		int temp;
		for (int i = 1; i < input.size(); i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (input.get(j) < input.get(j - 1))
				{
					temp = input.get(j);
					input.set(j, input.get(j - 1));
					input.set(j - 1, temp);
				}
			}
		}
	}

}
