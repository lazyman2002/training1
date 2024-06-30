import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream("./input_2/01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            int character;
            while ((character = br.read()) != -1) {
                sb.append((char) character);
            }
            br.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(sb.toString());
        StringTokenizer st1 = new StringTokenizer(sb.toString(), " .,!=+-\n", false);
        while (st1.hasMoreTokens()) {
            String word = st1.nextToken();
            if (hm.containsKey(word)) {
                hm.put(word, hm.get(word) + 1);
            }
            else {
                hm.put(word, 1);
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream("./input_2/output.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            StringBuffer strBuf = new StringBuffer();
            String defaultFirst = "Word:";
            String defaultMiddle = " : ";
            String defaultLast = "\n";
            for(String word : hm.keySet()) {
                if(word.contains("\r")){
                    word = word.replace('\r', ' ');
                }
                if (word != null && hm.get(word) != null) {
                    strBuf.append(defaultFirst);
                    strBuf.append(word);
                    strBuf.append(defaultMiddle);
                    strBuf.append(hm.get(word));
                    strBuf.append(defaultLast);
                    System.out.println(strBuf);
                }
            }
            System.out.println(strBuf);
            bw.write(strBuf.toString());
            bw.close();
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}