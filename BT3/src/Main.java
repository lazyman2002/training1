import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        String originDirectory = "./input_3";
        File directory = new File(originDirectory);
        File[] files = directory.listFiles();
        List<Future<TreeMap<String, Integer>>> futures = new ArrayList<>();
        for (File file : files) {
            CountWord cw = new CountWord(file);
            Future<TreeMap<String, Integer>> f = pool.submit(cw);
            futures.add(f);
        }
        pool.shutdown();
        TreeMap<String, Integer> result = new TreeMap<String, Integer>() ;
        System.out.println(futures.size());
        for(Future<TreeMap<String, Integer>> f : futures){
            try {
                TreeMap<String, Integer> words = f.get();
                for(String word : words.keySet()){
                    Integer count = words.get(word);
                    if(result.containsKey(word) ){
//                        result.put(word, result.get(word)+count);
                        result.put(word, result.get(word)+count);
                    }

                    else {
                        result.put(word, count);
                    }
                }
            }catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(result.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        for (int i = 0; i < Math.min(10, entryList.size()); i++) {
            System.out.println(entryList.get(i).getKey() + " : " + entryList.get(i).getValue());
        }

        for (int i = entryList.size() - 1; i >= Math.max(0, entryList.size() - 10); i--) {
            System.out.println(entryList.get(i).getKey() + " : " + entryList.get(i).getValue());
        }
    }

}