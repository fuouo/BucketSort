import java.util.ArrayList;

public class BucketSort
{
	public static int[] bucketSort(int[] numberList)
	{
		int[] result = new int[numberList.length];
		final int max = getMax(numberList);
		final int bucketCount = 10;
		final int divider = (int) Math.ceil((max + 1) / (float) bucketCount);

		// Generate the buckets
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>(bucketCount);

		for (int i = 0; i < bucketCount; i++)
			bucketList.add(new ArrayList<>());

		// Assign to buckets
		for (int i = 0; i < numberList.length; i++)
		{
			System.out.println("divider = " + divider);
			System.out.println((float) numberList[i] / (float) divider);
			bucketList.get((int) Math.floor(numberList[i] / (float) divider)).add(numberList[i]);
			System.out.println(bucketList.toString());
		}

		// Sort + Merge the buckets
		int resultIndex = 0;
		for (int i = 0; i < bucketCount; i++)
		{
			InsertionSort.sort(bucketList.get(i));

			ArrayList<Integer> currBucket = bucketList.get(i);
			for (int j = 0; j < currBucket.size(); j++)
				result[resultIndex++] = currBucket.get(j);
		}

		return result;
	}

	private static int getMax(int[] a)
	{
		if (a == null || a.length == 0)
			return -1;

		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];

		return max;
	}
}
