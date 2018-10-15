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
    
    	System.out.println("Enter word to search");
    	String wordToSearch = userInput.next();
    	
        Spider spider = new Spider();
        spider.search("http://google.com/", wordToSearch);
    }
}