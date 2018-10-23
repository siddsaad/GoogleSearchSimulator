import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider
{
  private static final int MAX_PAGES_TO_SEARCH = 30;
  private Set<String> pagesVisited = new HashSet<String>();
  
  public Set<String> getPagesVisited() {
	return pagesVisited;
}





private List<String> pagesToVisit = new LinkedList<String>();
 

  
public int getMaxPagesToSearch() {
	return MAX_PAGES_TO_SEARCH;
}


/**
   * Our main launching point for the Spider's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
   * @param searchWord
   *            - The word or string that you are searching for
   */


  public void search(String url, String searchWord)
  {
      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
      {
         
    	  String currentUrl;
          SpiderLeg leg = new SpiderLeg();
          if(this.pagesToVisit.isEmpty())
          {
              currentUrl = url;
              //getUrl = currentUrl;
              this.pagesVisited.add(url);
          }
          else
          {
              currentUrl = this.nextUrl();
              //getUrl = currentUrl;
          }
          leg.crawl(currentUrl); // Lots of stuff happening here. Look at the crawl method in
                                 // SpiderLeg
          
          boolean success = leg.searchForWord(searchWord);
          if(success)
          {
        	  //setGetUrl(currentUrl);
              System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
              
              break;
          }
          this.pagesToVisit.addAll(leg.getLinks());
      }
      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
  }
  
  



public List<String> getPagesToVisit() {
	return pagesToVisit;
}


/**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   * @return
   */
  public String nextUrl()
  {
      String nextUrl;
      do
      {
          nextUrl = this.pagesToVisit.remove(0);
      } while(this.pagesVisited.contains(nextUrl));
      this.pagesVisited.add(nextUrl);
      return nextUrl;
  }
  



}