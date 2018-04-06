import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MaCyclique extends CyclicBarrier {

    public MaCyclique(int parties, Runnable barrierAction) {
        super(parties, barrierAction);
    }

    public MaCyclique(int parties) {
        super(parties);
    }

    @Override
    public int await() throws InterruptedException, BrokenBarrierException {
        return super.await();
    }
}
