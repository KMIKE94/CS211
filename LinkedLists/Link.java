public class Link {
	private String data;
	
	public Link next;
	public Link prev;
	
	public Link(String domain){
		this.data = domain;
	}
	
	public String toString() {
	    return data;
	  }
	
	
}
