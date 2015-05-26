import java.util.Comparator;

class CaseCompare implements Comparator<String> {
	public int compare(String lhs, String rhs) {
		return lhs.compareToIgnoreCase(rhs);
	}
}
public class FuncObj {
	public static void testFuncObj() {
		String [] array = {"abc", "baf", "dksfjs"};
		String result = findMax(array, new CaseCompare());
		System.out.println(result);
	}
	
	public static <T> T findMax( T[] arr, Comparator<? super T> cmp) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (cmp.compare(arr[i], arr[max]) > 0) {
				max = i;
			}
		}
		return arr[max];
	}
}
