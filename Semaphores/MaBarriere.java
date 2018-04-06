import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MaBarriere implements Barrier{

    volatile int count;
    Semaphore semaphore;
    Semaphore semaphoreCount;


    public MaBarriere(int n){
        count = 0; 
        semaphore = new Semaphore(0); 
        semaphoreCount = new Semaphore(1); 
    }

    public void await() throws InterruptedException {
        semaphoreCount.acquire();
        count++;
        if (count == 32){
            count = 0;
            semaphore.release(31);
            semaphoreCount.release();
        }else {
            semaphoreCount.release();
            semaphore.acquire();
        }
    }

}
