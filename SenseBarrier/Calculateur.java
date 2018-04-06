public class Calculateur extends Thread {

    int id;
    MaBarriereQst4 maBarriereQst4; // qst 4


    public Calculateur(MaBarriereQst4 qst,int k){//qst 4
        id = k;
        maBarriereQst4 = qst;
    }

    @Override
    public void run() {
        for (int r = 1, s = 0; r < Main.tableau.length; r *= 2) {

            System.out.println("je suis le thread "+id);


            if (id>= r) {
                s = Main.tableau[id- r];
            }

            maBarriereQst4.await(); // qst 4


            if (id>= r) {
                Main.tableau[id] += s;
            }

            maBarriereQst4.await(); // qst 4


        }
    }

}
