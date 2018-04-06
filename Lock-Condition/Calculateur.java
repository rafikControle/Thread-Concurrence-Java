import java.util.concurrent.BrokenBarrierException;
public class Calculateur extends Thread {

    int id;
    MaBarriere maBarriere1; // qst 3



    public Calculateur(MaBarriere bar1,int k){// qst 3 - 2
        id= k;
        maBarriere1 = bar1;
    }


    @Override
    public void run() {
        for (int r = 1, s = 0; r < Main.tableau.length; r *= 2) {

            System.out.println("je suis le thread "+id);


            if (id>= r) {
                s = Main.tableau[id- r];
            }

            sliipAvecBarrierLockConditionRead(maBarriere1); // qst 3 - 3


            if (id>= r) {
                Main.tableau[id] += s;
            }


           sliipAvecBarrierLockConditionWrite(maBarriere1); // qst 3 - 3

        }
    }


    public void sliipAvecBarrierLockConditionRead(MaBarriere maBarriere){ // qst 3 - 3
        try {
            maBarriere.lockConditionRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sliipAvecBarrierLockConditionWrite(MaBarriere maBarriere){ // qst 3 - 3
        try {
            maBarriere.lockConditionWrite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
