import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWord implements Callable<TreeMap<String, Integer>> {
    TreeMap<String, Integer> map;
    File file;
    public CountWord(File file) {
        this.map = new TreeMap<>();
        this.file = file;
    }
    public void readFile() throws IOException {
        StringBuffer sb = new StringBuffer();
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            int character;
            while ((character = br.read()) != -1) {
                sb.append((char)character);
            }
            br.close();
            fis.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Count(sb.toString());
//        System.out.println(sb.toString());
    }
    public void Count(String para) {
//        StringTokenizer st = new StringTokenizer(para, "^[a-zAZ09?><;,{}\\]_+=!@#$%&*|");
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(para);
        while (matcher.find()) {
            String word = matcher.group();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
//        while (st.hasMoreTokens()) {
//            String word = st.nextToken();
//            if (map.containsKey(word)) {
//                map.put(word, map.get(word) + 1);
//            }
//            else {
//                map.put(word, 1);
//            }
//        }
    }
    @Override
    public TreeMap<String, Integer> call() throws Exception {
        readFile();
        return map;
    }
}
