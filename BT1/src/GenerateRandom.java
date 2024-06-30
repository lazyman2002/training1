import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Random;

public class GenerateRandom {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(set.size() < 2000000){
            set.add(new Random().nextInt(-10000000, 10000000));
        }
        try{
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("./src/Random1.bin")));
            for(Integer i : set){
                    dos.writeInt(i);
            }
            dos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
