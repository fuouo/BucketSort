import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayUtil
{
	public static int[] toIntArray(List<Integer> integers)
	{
		int[] ret = new int[integers.size()];
		Iterator<Integer> iterator = integers.iterator();
		for (int i = 0; i < ret.length; i++)
		{
			ret[i] = iterator.next().intValue();
		}
		return ret;
	}

	public static ArrayList<Integer> toArrayList(int[] a)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
		{
			result.add(a[i]);
		}

		return result;
	}
}
