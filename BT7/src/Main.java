import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final String baseLink = "https://www.google.com/";
        final String regex = "^(https?://)(www\\.)?[a-z0-9]+\\.[a-z]{2,6}(/\\S*)?$";
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(baseLink);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
        else {
            System.out.println("Not found");
        }
    }
}