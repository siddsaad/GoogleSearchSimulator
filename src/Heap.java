
public class Heap {
	
	private int size;
	public void maxHeapify(Links[] heapArray, int i)
	{
		int l = left(i);
		int r = right(i);
		
		int largest;
		if( l < size && heapArray[l].getId() > heapArray[i].getId())
			largest = l;
		else 
			largest = i;
		
		if(r < size && heapArray[r].getId() > heapArray[largest].getId())
			largest = r;
		

		
		if (largest != i)
		{
			Links swap = heapArray[i];
			heapArray[i] = heapArray[largest];
			heapArray[largest] = swap;
			
			maxHeapify(heapArray, largest);
		}
	}
	
	public Links heapMaximum (Links[] heapArray)
	{
		return heapArray[0];
	}
	
	public int heapExtractMax (Links[] heapArray)
	{
		if (size < 1)
		{
			System.out.println("Heap underflow");
		}
		int max = heapArray[0].getId();
		heapArray[0].setId(heapArray[size].getId());
		size--;
		maxHeapify(heapArray, 0);
		return max;
	}
	
	public void heapIncreaseKey(Links[] heapArray, int i, int key)
	{
		if( key < heapArray[i].getId())
			System.out.println("New key is smaller than current key");
		
		heapArray[i].setId(key);
		
		Links exchange;
		while ( i > 0 && heapArray[parent(i)].getId() < heapArray[i].getId())
		{
			exchange = heapArray[i];
			heapArray[i] = heapArray[parent(i)];
			heapArray[parent(i)] = (exchange);
			
			i = parent(i);
		}
	}
	
	void maxHeapInsert(Links[] heapArray, int key)
	{
		size++;
		heapArray[size].setId(Integer.MIN_VALUE);
		heapIncreaseKey(heapArray, size, key);
	} 
	
	void buildMaxHeap(Links[] heapArray)
	{
		size = heapArray.length;
		for(int i = (heapArray.length / 2); i >= 0; i--)
		{
			maxHeapify(heapArray, i);
		}
	}
	
	void heapSort(Links[] heapArray)
	{
		buildMaxHeap(heapArray);
		
		
		Links exchange;
		
		for(int i = heapArray.length-1; i >= 1; i--)
		{
			exchange = heapArray[i];
			heapArray[i] = heapArray[0];
			heapArray[0] = exchange;
			
			size --;
			maxHeapify(heapArray, 0);
		}
	}
	
	int parent(int i)
	{
		return i/2;
	}
	
	int left(int i)
	{
		return 2*i ;
	}
	
	int right(int i)
	{
		return 2*i + 1;
}
	
}
