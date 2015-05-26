
public class Sort<AnyType extends Comparable<? super AnyType>> {
	public void insertSort(AnyType[] data) {
		for(int i=1; i<data.length; i++) {
			AnyType tmp = data[i];
			int j;
			for (j=i; j>0; j--) {
				if (tmp.compareTo(data[j-1]) < 0) {
					data[j] = data[j-1];
				}
				else {
					// Important, or the i will reduce to much
					break;
				}
			}
			data[j] = tmp;
		}
	}
	public void shellSort(AnyType[] data) {
		for(int gap=data.length/2; gap>0; gap=gap/2) {
			for(int j=gap; j<data.length; j++) {
				int k;
				AnyType tmp = data[j];
				for(k=j; k>=gap; k-=gap) {
					if(tmp.compareTo(data[k-gap]) < 0) {
						data[k] = data[k-gap];
					}
					else{
						break;
					}
				}
				data[k] = tmp;
			}
		}
	}
	
	private void swap(AnyType[] data, int left, int right) {
		AnyType tmp;
		tmp = data[left];
		data[left] = data[right];
		data[right] = tmp;
	}
	
	private AnyType getMiddleIndex(AnyType[] data, int left, int right) {
		int center = (left + right)/2;
		if(data[left].compareTo(data[center]) > 0) {
			swap(data, left, center);
		}
		if(data[left].compareTo(data[right]) > 0) {
			swap(data, left, right);
		}
		if(data[center].compareTo(data[right]) > 0) {
			swap(data, center, right);
		}
		swap(data, center, right-1);
		return data[right-1];
	}
	
	private void quickSort(AnyType[] data, int left, int right) {
		// Be care for here, left and right must cross 3 number
		if(left + 1 < right) {
			AnyType pirot = getMiddleIndex(data, left, right);
			int i = left;
			int j = right - 1;
			for( ; ; ) {
				while(data[++i].compareTo(pirot) < 0) {};
				while(data[--j].compareTo(pirot) > 0) {};
				if(i < j) {
					swap(data, i, j);
				}
				else {
					swap(data, i, right-1);
					break;
				}
			}
			quickSort(data, left, i);
			quickSort(data, i+1, right);
		}
		else {
			insertSort(data);
		}
	}
	
	public void quickSort(AnyType[] data) {
		quickSort(data, 0, data.length - 1);
	}
	
	private void merge(AnyType[] data, AnyType[] tmp, int left, int center, int right) {
		int rightStart = center + 1;
		int i = left;
		int mergeLen = right - left + 1;
		while(left <= center && rightStart < right) {
			if(data[left].compareTo(data[rightStart]) < 0) {
				tmp[i++] = data[left++];
			}
			else {
				tmp[i++] = data[rightStart++];
			}
		}
		while(left < center) {
			tmp[i++] = data[left++];
		}
		while(rightStart < right) {
			tmp[i++] = data[rightStart++];
		}
		for(int pos=right-1; pos > right - mergeLen; pos--) {
			data[pos] = tmp[pos];
		}
	}
	
	private void mergeSort(AnyType[] data, AnyType[] tmp, int left, int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(data, tmp, left, center);
			mergeSort(data, tmp, center + 1, right);
			merge(data, tmp, left, center, right);
		}
	}
	
	public void mergeSort(AnyType[] data) {
		@SuppressWarnings("unchecked")
		AnyType[] tmp = (AnyType[])new Comparable[data.length];
		mergeSort(data, tmp, 0, data.length - 1);
	}
	
	public void heapSort(AnyType[] data) {
		
	}
}
