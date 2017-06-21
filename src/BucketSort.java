import java.util.ArrayList;

public class BucketSort
{
	public static int[] bucketSort(int[] numberList)
	{
		int[] result = new int[numberList.length];
		final int max = getMax(numberList);
		final int bucketCount = 10;
		final int divider = (int) Math.ceil((max + 1) / (float) bucketCount);

		System.out.println("Max: " + max + " || Divider : " + divider);
		// Generate the buckets
		ArrayList<ArrayList<Integer>> bucketList = initBuckets(bucketCount);

		// Assign to buckets
		for (int i = 0; i < numberList.length; i++)
		{
			System.out.println(
					"# " + numberList[i] + " || Assigned Bucket: " + (int) Math.floor(numberList[i] / (float) divider));
			bucketList.get((int) Math.floor(numberList[i] / (float) divider)).add(numberList[i]);

		}
		// Sort + Merge the buckets
		int resultIndex = 0;
		for (int i = 0; i < bucketCount; i++)
		{
			if (bucketList.size() <= 0)
				continue;

			InsertionSort.sort(bucketList.get(i));
			// debug
			System.out.println("Bucket #" + i + " " + bucketList.get(i));

			ArrayList<Integer> currBucket = bucketList.get(i);
			for (int j = 0; j < currBucket.size(); j++)
				result[resultIndex++] = currBucket.get(j);
		}

		return result;
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
			if (negativeBucketList.size() <= 0)
				continue;

			InsertionSort.sort(negativeBucketList.get(i));

			ArrayList<Integer> currBucket = negativeBucketList.get(i);
			for (int j = 0; j < currBucket.size(); j++)
				result[resultIndex++] = currBucket.get(j);
		}

		for (int i = 0; i < bucketCount; i++)
		{
			if (positiveBucketList.size() <= 0)
				continue;

			InsertionSort.sort(positiveBucketList.get(i));

			ArrayList<Integer> currBucket = positiveBucketList.get(i);
			for (int j = 0; j < currBucket.size(); j++)
				result[resultIndex++] = currBucket.get(j);
		}

		return result;
	}

	private static int initialBit;

	public static int[] bucketSortRecursive(int[] numberList)
	{
		initialBit = getDivider(getMax(numberList));
		return bucketSort(numberList, initialBit);
	}

	private static int getDivider(int n)
	{
		int divider = 1;
		while (n / 10 > 0)
		{
			divider *= 10;
			n /= 10;
		}

		return divider;
	}

	private static String tabGenerator(int initialBit, int bit)
	{
		return new String(new char[Integer.toString(initialBit).length() - Integer.toString(bit).length()])
				.replace("\0", "\t");
	}

	public static int[] bucketSort(int[] numberList, int bit)
	{
		if (bit == 0)
			return numberList;

		if (numberList.length == 1)
			return numberList;

		int[] result = new int[numberList.length];
		final int bucketCount = 10;

		// Generate the buckets
		ArrayList<ArrayList<Integer>> bucketList = initBuckets(bucketCount);

		// Assign to buckets
		for (int i = 0; i < numberList.length; i++)
			bucketList.get((int) Math.floor(numberList[i] / (float) bit % 10)).add(numberList[i]);

		// Sort + Merge the buckets
		int resultIndex = 0;
		for (int i = 0; i < bucketCount; i++)
		{
			ArrayList<Integer> currBucket = bucketList.get(i);
			System.out.println(tabGenerator(initialBit, bit) + "Bucket # " + i + currBucket + " || bit : " + bit);

			if (currBucket.size() <= 0)
				continue;

			int[] sorted = bucketSort(ArrayUtil.toIntArray(currBucket), bit / 10);
			currBucket = ArrayUtil.toArrayList(sorted);

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
