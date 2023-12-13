import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileCreation
{
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exe=Executors.newFixedThreadPool(5);
        Future<String> f=exe.submit(new Test());
        System.out.println(f.get());
        Future<String> f1=exe.submit(new Test());
        System.out.println(f1.get());
        Future<String> f2=exe.submit(new Test());
        System.out.println(f2.get());
        };
}
