import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MaBarriere implements Barrier{

    volatile int count;

    Lock lock = new ReentrantLock();
    Condition conditionFull  = lock.newCondition();
    Condition conditionEmpty  = lock.newCondition();


    public MaBarriere(int n){
        count = 0; // qst 3
    }

    public void lockConditionRead() throws InterruptedException { // qst 3 - 3
        lock.lock();
        try {

            count++;
            if (count < 32 ) conditionFull.await();
            else conditionFull.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void lockConditionWrite() throws InterruptedException { // qst 3 - 3
        lock.lock();
        try {

            count--;
            if (count > 0 ) conditionEmpty.await();
            else conditionEmpty.signalAll();

        } finally {
            lock.unlock();
        }
    }

}
