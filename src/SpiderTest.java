import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class SpiderTest
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * 
     * @param args
     *            - not used
     */
    public static void main(String[] args)
    {
    	Scanner userInput = new Scanner(System.in);
    	
    	Heap heapArray = new Heap();
    
    	String initUrl = "http://google.com/";
    	System.out.println("Enter word to search");
    	String wordToSearch = userInput.next();
    	
        Spider spider = new Spider();
        int maxSize = spider.getMaxPagesToSearch();
        
        spider.search(initUrl, wordToSearch);
        
        // array containing index and the link
        
        
        // converting the set pages visited to an array
        String arr[] = new String[maxSize];
        System.arraycopy(spider.getPagesVisited().toArray(), 0, arr, 0, maxSize);
        
        Links[] linksAndId = new Links[maxSize] ;
        //int curretSize = 0;
        
        for(int i = 0; i < maxSize;i++){
        	Links newNode = new Links(i * 10, arr[i]);
        	linksAndId[i] =(newNode);
        }
        
        heapArray.buildMaxHeap(linksAndId);
        
        System.out.println("Heap array");
    	for (int i =0; i < linksAndId.length;i++)
    	{
    		System.out.println( linksAndId[i].getId() + "  " + linksAndId[i].getName());
    	}
    System.out.println();	
   
    heapArray.heapSort(linksAndId);
    
 
    System.out.println("Heap array");
	for (int i =0; i < linksAndId.length;i++)
	{
		System.out.println( linksAndId[i].getId() + "  " + linksAndId[i].getName());
	}
	System.out.println();	
	
	heapArray.heapIncreaseKey(linksAndId, 3, 5);
	
	System.out.println("Heap array");
	for (int i =0; i < linksAndId.length;i++)
	{
		System.out.println( linksAndId[i].getId() + "  " + linksAndId[i].getName());
	}
	System.out.println();	
	
	 heapArray.heapSort(linksAndId);
	    
	 
	    System.out.println("Heap array");
		for (int i =0; i < linksAndId.length;i++)
		{
			System.out.println( linksAndId[i].getId() + "  " + linksAndId[i].getName());
		}
		System.out.println();
        
 
        
        
    }
}