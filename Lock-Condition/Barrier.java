public interface Barrier {

    public void lockConditionRead() throws InterruptedException ;

    public void lockConditionWrite() throws InterruptedException ;
}
