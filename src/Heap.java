
public class Heap {
	

	private int Parent(int i){
		return i/2;
	}
	
	private int Left(int i){
		return 2*i;
	}
	
	private int Right(int i){
		return 2*i + 1;
	}
	
	private void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	

	private void buildMaxHeap(int[] arr){
		int size = arr.length;
	
		for(int i = arr.length/2 ; i >= 1; i--){
			maxHeapify(arr,i,size);
		}
		
	}
	
	
	public void maxHeapify(int[] arr, int i,int size){
		int l = Left(i);
		int r = Right(i);
		
		int largest;
	
		if(l <= size && arr[l] > arr[i]){
			largest = l;
		}
		else
			largest = i;
		
		if(r <= size && arr[r] > arr[largest]){
			largest = r;
		}
		
		if(largest != i){
						
			
			swap(arr,i, largest);
			
			maxHeapify(arr, largest, size);
				
		}
	}
	
	
	public void heapSort(int[] arr, int size){
		
		buildMaxHeap(arr);
		
		for(int i = arr.length; i >= 2; i--){
			
			
			swap(arr, i , 1);
			size = size - 1;
			
			maxHeapify(arr,1, size);
		}
		
	}
	
	//Priority Queue
	
	public void maxHeapInsert(int[] arr, int key, int size){
		size = size + 1;
		
		arr[size] = Integer.MIN_VALUE;
		
		heapIncreaseKey(arr, size, key );
	}
	
	public int heapExtractMax(int[] arr, int size){
		
		if(size < 1){
			System.out.println( "Heap underflow");
		}
		
		int max = (int) arr[1];
		
		arr[1] = arr[size];
		
		size = size - 1;
		
		maxHeapify(arr,1, size);
		
		return max;
		
	}
	
	public void heapIncreaseKey(int[] arr, int i, int key){
		if(key < arr[i] ){
			System.out.println( "new key is smaller than current key");
		}
		arr[i] = key;
		
		while(i > 1 && arr[Parent(i)] < arr[i]){
			
			swap(arr, i , Parent(i));
			
			i = Parent(i);
		}
	}
	
	public int heapMaximum(int[] arr){
		
		return arr[1];
	}
	
}
