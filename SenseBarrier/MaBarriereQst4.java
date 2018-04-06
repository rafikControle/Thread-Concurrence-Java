import java.util.concurrent.atomic.AtomicInteger;

public class MaBarriereQst4  implements Barrier{

    private AtomicInteger count;
    private int size;
    private volatile Boolean sense;
    private ThreadLocal<Boolean> threadSense;

    public MaBarriereQst4(int n){

        count = new AtomicInteger(n);
        size = n;
        sense = false;

        threadSense = new ThreadLocal<Boolean>() {
            @Override
            protected Boolean initialValue() {
                return !sense;
            }
        };

    }

    public void await() {

        boolean mySense = threadSense.get();

            if (count.getAndDecrement() == 1) { // ou if (count.decrementAndGet() == 0)
                count.set(size);
                sense = mySense;
            } else {
                while (sense != mySense) {

                }
            }

            threadSense.set(!mySense);

        }


}

