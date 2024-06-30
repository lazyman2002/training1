import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = ConcurrentHashMap.newKeySet();
        Set<Integer> set2 = ConcurrentHashMap.newKeySet();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("./src/Random1.bin"));
            for(int i = 0; i < 2000000; i++){
                int data = dis.readInt();
                set1.add(data);
            }
            dis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("./src/Random2.bin"));
            for(int i = 0; i < 2000000; i++){
                int data = dis.readInt();
                set2.add(data);
            }
            dis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Set<Integer> dup = set1.parallelStream().filter(set2::contains).collect(Collectors.toSet());
        System.out.println(dup.size());
//        Set<Integer> dup2 = new HashSet<Integer>(set1);
//        dup2.addAll(set2);
        Set<Integer> dup2 = new HashSet<Integer>();
        dup2 = set2.parallelStream().filter(e->!set1.contains(e)).collect(Collectors.toSet());
        Set<Integer> dup3 = new HashSet<Integer>();
        dup3 = set1.parallelStream().filter(e->!set2.contains(e)).collect(Collectors.toSet());
        dup2.addAll(dup3);
        System.out.println(dup2.size());
    }
}