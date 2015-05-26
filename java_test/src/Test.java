public class Test {
	public static void testMyArrayList() {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		for (int i=0; i<200; i++) {
			list.append(i*10);
		}
		list.insert(5, 22);
		java.util.Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()) {
			if (iter.next() == 20) {
				iter.remove();
			}
		}
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	public static void main(String[] args) {
		//FuncObj.testFuncObj();
		//testMyArrayList();
		Integer[] data = new Integer[10];
		for(int i=0; i<data.length; i++) {
			//data[i] = 100-i;//(int) (Math.random() * 100);
			data[i] = (int) (Math.random() * 100);
			System.out.print(data[i]+"--");
		}
		System.out.println("Start sort");
		Sort<Integer> s = new Sort<Integer>();
		//s.insertSort(data);
		//s.shellSort(data);
		s.quickSort(data);
		System.out.println("After sort");
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
