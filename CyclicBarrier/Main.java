public class Main {


    static int tableau [] = new int[32];

    public static void main(String[] args) {
        
        for (int i=0;i<32;i++){
            tableau[i] = i;
        }

        final int[] round = {0};

        for(int i = 0;i<32;i++){
            System.out.println("avant : "+i+" "+tableau[i]);
        }

        System.out.println("------------------------");

        MaCyclique cyclicBarrier = new MaCyclique(32, new Runnable() { // qst 2
            @Override
            public void run() {
                round[0]++;
                System.out.println("----------------Round : "+ round[0] +" ---------------");
                for(int i = 0;i<32;i++){
                    System.out.println("apres : "+i+" "+tableau[i]);
                }
            }
        });

        for (int i = 0;i<32;i++){
            new Calculateur(cyclicBarrier,i).start();  // qst 2
        }
    }
}
