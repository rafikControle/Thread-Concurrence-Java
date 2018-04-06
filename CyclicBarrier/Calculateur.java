import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Calculateur extends Thread {

    int id;
    CyclicBarrier cyclicBarrier;

    public Calculateur(CyclicBarrier cyc,int k){// qst 2
        id= k;
        cyclicBarrier = cyc;
    }


    @Override
    public void run() {
        for (int r = 1, s = 0; r < Main.tableau.length; r *= 2) {

            System.out.println("je suis le thread "+id);


            if (id>= r) {
                s = Main.tableau[id- r];
            }
            sliipAvecCyclique(); // qst 2


            if (id>= r) {
                Main.tableau[id] += s;
            }

           sliipAvecCyclique(); // qst 2


        }
    }

    public void sliipAvecCyclique(){ // qst 2
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
