package AirBnB.phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb
 */
public class CSVParser {

    public static String parseCSV(String line) {
        List<String> items = new ArrayList<String>();
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < line.length(); i++) {
            if(inQuote) {
                if(line.charAt(i) == '\"') {
                    if(i < line.length() - 1 && line.charAt(i + 1) == '\"') {
                        sb.append('\"');
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(line.charAt(i));
                }
            } else {
                if(line.charAt(i) == '\"') {
                    inQuote = true;
                } else if(line.charAt(i) == ',') {
                    items.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(line.charAt(i));
                }
            }
        }
        if(sb.length() > 0) items.add(sb.toString());
        return String.join("|", items);
    }

    public static void main(String[] args) {
        System.out.println(parseCSV("\"\"\"Alexandra Alex\"\"\""));
        System.out.println(parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
        System.out.println(parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
        System.out.println(parseCSV("\"\"\"Alexandra\"\"\""));
    }
}
