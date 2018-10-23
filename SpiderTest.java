import java.util.Random;
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
    
    	
        Spider spider = new Spider();
        
        int maxSize = spider.getMaxPagesToSearch();
        
        
        
       
        
       
        // array containing index and the link
        Links[] linksAndId = new Links[maxSize] ;
        //int curretSize = 0;

			Scanner scanchoice = new Scanner(System.in);
		   int choiceentry = 0;
		   
		   while(choiceentry != -1){
				
			   System.out.println("Enter \"1\", \"2\", \"3\" , \"4\" \"5\" \"6\" ");
			   System.out.println("1. Crawl");
			   System.out.println("2. Build Max Heap");
			   System.out.println("3. HeapSort");
			   System.out.println("4. Increase Rank");
			   System.out.println("5. Display Heap Array");
			   System.out.println("6. Exit");
				
		
		       choiceentry = scanchoice.nextInt();

				
				     switch(choiceentry){
				        case 1:
				        	
				        	String initUrl = "http://google.com/";
				        	System.out.println("Enter word to search");
				        	String wordToSearch = userInput.next();
				        	spider.search(initUrl, wordToSearch);
				           break;
				        case 2:
				        	// converting the set pages visited to an array
				            String arr[] = new String[maxSize];
				            System.arraycopy(spider.getPagesVisited().toArray(), 0, arr, 0, maxSize);
				           //do logic
				            Random r = new Random();
				            int max = 30;
				            int min = 1;
				    		
				            for(int i = 0; i < maxSize;i++){
				            	Links newNode = new Links(r.nextInt((max - min) + 1) + min, arr[i]);
				            	linksAndId[i] =(newNode);
				            }
				            
				            heapArray.buildMaxHeap(linksAndId);
				            
				           break;
				        case 3:
				        	System.out.println("Sorting");
				        	heapArray.heapSort(linksAndId);
				        	break;
				        case 4:
				        	System.out.println("Enter index of array to increase Rank (1 for highest to 30 for lowest");
				        	int x = userInput.nextInt();
				        	System.out.println("Enter Rank");
				        	int y = userInput.nextInt();
				        	heapArray.heapIncreaseKey(linksAndId, x, y);
				           //do logic
				           break;
				        case 5 :
				        	System.out.println("Displaying");
				        	heapArray.displayHeap(linksAndId);
				        	break;
				        case 6 :
				        	System.out.println("Exiting");
				        	choiceentry = -1;
				        	break;
				   }  
		   }
    }
        
}