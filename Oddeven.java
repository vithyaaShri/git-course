public class Oddeven implements Runnable {
    Object lock;
    static int max=10;
    static int n=0;
    public Oddeven(Object lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        while (n < max) {
            
            if (n % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized(lock){
                System.out.println(n);
                n++;
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
            else if(n%2!=0 && Thread.currentThread().getName().equals("odd")){
                synchronized(lock){
                System.out.println(n);
                n++;
                lock.notify();
                }
            
            }    
        }
    }
    
    public static void main(String[] args) {
        Object lock=new Object();
        Runnable run1=new Oddeven(lock);
        Runnable run2=new Oddeven(lock);
        Thread t1=new Thread(run1,"even");
        Thread t2=new Thread(run2,"odd");
        t1.start();
        t2.start();
    }
}