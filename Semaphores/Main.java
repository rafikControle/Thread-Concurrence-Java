import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {


    static int tableau [] = new int[32];

    public static void main(String[] args) {

        for (int i=0;i<32;i++){
            tableau[i] = i;
        }


        MaBarriere maBarriereSemaphore1 = new MaBarriere(32);
        MaBarriere maBarriereSemaphore2 = new MaBarriere(32);

        ArrayList<Calculateur>arrayList = new ArrayList<>();

        for(int i = 0;i<32;i++){
            System.out.println("avant : "+i+" "+tableau[i]);
        }

        System.out.println("------------------------");

        for (int i = 0;i<32;i++){

            arrayList.add(new Calculateur(maBarriereSemaphore1,maBarriereSemaphore2,i)); // qst 3
     
        }

        for (int i = 0;i<32;i++){
            arrayList.get(i).start();
        }

        for (Calculateur calculateur : arrayList){
            try {
                calculateur.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0;i<32;i++){
            System.out.println("apres : "+i+" "+tableau[i]);
        }
    }
}
