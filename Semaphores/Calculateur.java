public class Calculateur extends Thread {

    int id;
    MaBarriere maBarriere1; 
    MaBarriere maBarriere2; 


    public Calculateur(MaBarriere bar1,MaBarriere bar2,int k){
        id= k;
        maBarriere1 = bar1;
        maBarriere2 = bar2;
    }


    @Override
    public void run() {
        for (int r = 1, s = 0; r < Main.tableau.length; r *= 2) {

            System.out.println("je suis le thread "+id);


            if (id>= r) {
                s = Main.tableau[id- r];
            }

           sleepAvecBarrierSemaphore(maBarriere1); // qst 3


            if (id>= r) {
                Main.tableau[id] += s;
            }

           sleepAvecBarrierSemaphore(maBarriere2);


        }
    }


    public void sleepAvecBarrierSemaphore(MaBarriere maBarriere){
        try {
            maBarriere.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
