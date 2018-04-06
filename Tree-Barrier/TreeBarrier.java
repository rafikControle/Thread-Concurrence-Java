import java.util.concurrent.atomic.AtomicInteger;

public class TreeBarrier { 
	
	Node[] node ;
	int feuille ;
    ThreadLocal < Boolean > threadSense;
	
    public TreeBarrier(int n) {
    	feuille = 0; 
    	node = new Node[n/2]; 
    	int depth = 0; 
    	threadSense = new ThreadLocal < Boolean > () { 
    		protected Boolean initialValue () {
    			return true; 
    		} 
    	}; 

    	while (n > 1) { 
			depth++; 
			n = n / 2; 
    	} 
    	
    	Node root = new Node();
    	build(root, depth-1);
    }

    public void await(int id){
    	Node nodeTmp = node[id/2];
    	nodeTmp.await();
    }
  
    void build(Node pere, int depth) {
    	if (depth == 0) {
    		node[feuille++] = pere;
    	    //System.out.println("feuille"+feuille);
    	}else{
    		for(int i=0; i<2; i++){
    			Node child = new Node(pere);
    			build(child,depth -1);
    		}
    	}
    }
    
    private class Node{
        AtomicInteger count;
    	Node pere;
    	volatile boolean sense;

    	public Node(){
    		sense = false;
    		pere = null;
    		count = new AtomicInteger(2);
    	}

        public Node(Node tmp){
    	    this();
    	    pere = tmp;
    	}

		public void await(){
			boolean mySense = threadSense.get();


				int position = count.getAndDecrement();
				if (position == 1) {
					if(pere!=null){
						pere.await();
					}
					count.set(2);
					sense = mySense;

				}else{
					while(sense!=mySense){

					}
				}
				threadSense.set(!mySense);
			}

    	
    }



}
