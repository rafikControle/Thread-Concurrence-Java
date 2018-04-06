class Calcu extends Thread {

    int[] table;
    private TreeBarrier tree;
    int id;
    
    public Calcu(TreeBarrier tree,int[] table,int i) {
        this.table = table; 
        this.tree = tree;
        this.id = i;
    }

    @Override
    public void run() {
    	  System.out.println("je suis le thread : "+id);
        for (int r = 1, s = 0; r < this.table.length; r *= 2) {
            if (id >= r) {
               s = this.table[id - r];
               }
           tree.await(id);
            if (id >= r) {
               table[id] += s;
             //  System.out.println("Thread"+id+"table"+table[id]);
              } 
           tree.await(id);
           }
         }
    }


