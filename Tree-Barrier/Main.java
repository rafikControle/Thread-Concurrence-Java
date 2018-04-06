import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		 int N = 32;
		 int[] table = new int[N];
		 for(int i=0; i<N; i++){
			 table[i] = i;
		 }
		 
		 TreeBarrier mabarrier = new TreeBarrier(N);
		 List<Thread> threads = new ArrayList<Thread>(N);

	     for (int i = 0; i < N; i++) {
	       Thread thread = new Thread(new Calcu(mabarrier,table,i));
	       threads.add(thread);
	       thread.start();
	     }

	     for (Thread thread : threads)
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		 System.out.println("apre ---------------------------------------- ");

	     for(int i=0; i<N; i++){
	         System.out.println("a["+i+"] : "+table[i]);
	     }

	}

}
