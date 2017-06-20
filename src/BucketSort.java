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
		ArrayList<ArrayList<Integer>> bucketList = initBuckets(bucketCount);

		// Assign to buckets
		for (int i = 0; i < numberList.length; i++)
			bucketList.get((int) Math.floor(numberList[i] / (float) divider)).add(numberList[i]);

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

	private static ArrayList<ArrayList<Integer>> initBuckets(int size)
	{
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>(size);

		for (int i = 0; i < size; i++)
			bucketList.add(new ArrayList<>());

		return bucketList;
	}

	public static int[] bucketSortWithNegative(int[] numberList)
	{
		int[] result = new int[numberList.length];
		final int max = getMaxAbs(numberList);
		final int bucketCount = 10;
		final int divider = (int) Math.ceil((max + 1) / (float) bucketCount);

		// Generate the buckets
		ArrayList<ArrayList<Integer>> positiveBucketList = initBuckets(bucketCount);
		ArrayList<ArrayList<Integer>> negativeBucketList = initBuckets(bucketCount);

		// Assign to buckets
		for (int i = 0; i < numberList.length; i++)
		{
			ArrayList<ArrayList<Integer>> bucketList = numberList[i] < 0 ? negativeBucketList : positiveBucketList;
			bucketList.get((int) Math.floor(Math.abs(numberList[i] / (float) divider))).add(numberList[i]);
		}

		// Sort + Merge the buckets
		int resultIndex = 0;

		for (int i = bucketCount - 1; i >= 0; i--)
		{
			InsertionSort.sort(negativeBucketList.get(i));

			ArrayList<Integer> currBucket = negativeBucketList.get(i);
			for (int j = 0; j < currBucket.size(); j++)
				result[resultIndex++] = currBucket.get(j);
		}

		for (int i = 0; i < bucketCount; i++)
		{
			InsertionSort.sort(positiveBucketList.get(i));

			ArrayList<Integer> currBucket = positiveBucketList.get(i);
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

	private static int getMaxAbs(int[] a)
	{
		if (a == null || a.length == 0)
			return -1;

		int max = Math.abs(a[0]);
		for (int i = 1; i < a.length; i++)
			if (Math.abs(a[i]) > max)
				max = Math.abs(a[i]);

		return max;
	}
}
