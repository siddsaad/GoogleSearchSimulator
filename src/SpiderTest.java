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
    
    	String initUrl = "http://google.com/";
    	System.out.println("Enter word to search");
    	String wordToSearch = userInput.next();
    	
        Spider spider = new Spider();
        SpiderLeg linkN = new SpiderLeg();
        
        ArrayList<String> links = new ArrayList<String>();
        ArrayList<Integer> linksOnPage = new ArrayList<Integer>();
        
        spider.search(initUrl, wordToSearch);
        
       
        
        
        
        
        for(int i = 0; i < spider.getMaxPagesToSearch();i++){
        	links.add(spider.nextUrl());
        	linksOnPage.add(linkN.getNumOfLinks());
        	
        }
       
        for(int i = 0 ; i < links.size();i++){
        	String value = links.get(i);
        	int value2 = linksOnPage.get(i);
        	System.out.println(i + 1 + ": " + value + " Number of links: " + value2);
        }
        
        
 
        
        
    }
}