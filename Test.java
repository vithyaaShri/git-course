import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class Test implements Callable<String> {
    
    static int i=0;
    @Override
    public String call() throws Exception {
        
        List<String> Filenames=new ArrayList<>(Arrays.asList("File1","File2","File3","File4"));
        String filename="C:\\Users\\vithy\\OneDrive\\Desktop\\javacode\\"+Filenames.get(i);
        i++;
        File file=new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
        
        e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return filename;
    }
    
}
