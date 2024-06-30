import java.io.*;
import java.util.*;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    private static final Points A = new Points(800, 800);
    private static final Points B = new Points(4000,800);
    private static final Points C = new Points(2400, 2400);
    static Random rand = new Random();
    public static Points getA(){
        while(true){
            double r = 400 * Math.sqrt(rand.nextDouble());
            double theta = rand.nextDouble() * 2 * Math.PI;
            int  x =(int)(800 + r * Math.cos(theta));
            int  y =(int)(800 + r * Math.sin(theta));

            Points p = new Points(x, y);
            if(p.distant(A) < 400){
                return p;
            }
        }
    }
    public static Points getB(){
        while(true){
            double r = 500 * Math.sqrt(rand.nextDouble());
            double theta = rand.nextDouble() * 2 * Math.PI;
            int  x =(int)(4000 + r * Math.cos(theta));
            int  y =(int)(800 + r * Math.sin(theta));
            Points p = new Points(x, y);
            if(p.distant(B) < 500){
                return p;
            }
        }
    }
    public static Points getC(){
        while(true){
            double r = 600 * Math.sqrt(rand.nextDouble());
            double theta = rand.nextDouble() * 2 * Math.PI;
            int  x =(int)(2400 + r * Math.cos(theta));
            int  y =(int)(2400 + r * Math.sin(theta));
            Points p = new Points(x, y);
            if(p.distant(C) < 600){
                return p;
            }
        }
    }
    public static void toFile(List<Points> points){
        try{
            FileOutputStream fos = new FileOutputStream(new File("./src/output4.txt"));
            for(Points p : points){
                byte[] bytes = p.toString().getBytes();
                fos.write(bytes);
            }
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        HashSet<Points> spaceA = new HashSet<>();
        HashSet<Points> spaceB = new HashSet<>();
        HashSet<Points> spaceC = new HashSet<>();
        while(true){
            Points p = getA();
            if(!spaceA.contains(p)){
                spaceA.add(p);
            }
            if(spaceA.size() == 8000){
                break;
            }
        }
        System.out.println(spaceA.size());
        while(true){
            Points p = getB();
            if(spaceA.contains(p)){
                continue;
            }
            if(!spaceB.contains(p)){
                spaceB.add(p);
            }
            if(spaceB.size() == 10000){
                break;
            }
        }
        System.out.println(spaceB.size());
        while(true){
            Points p = getC();
            if(spaceA.contains(p) || spaceB.contains(p)){
                continue;
            }
            if(!spaceC.contains(p)){
                spaceC.add(p);
            }
            if(spaceC.size() == 12000){
                break;
            }
        }
        System.out.println(spaceC.size());
        List<Points> SF = new ArrayList<>();
        SF.addAll(spaceA);
        SF.addAll(spaceB);
        SF.addAll(spaceC);
        Collections.shuffle(SF);
        toFile(SF);
    }
}