package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 6/16/17.
 */
public class PrettyJSON {
    public static List<String> printPrettyJSON(String json) {
        List<String> result = new ArrayList<String>();
        String indents = "";
        String curStr = "";
        int i = 0;
        while(i < json.length()) {
            char cur = json.charAt(i);
            curStr += cur;
            switch(cur) {
                case ':':
                    i++;
                    if(json.charAt(i) == '{' || json.charAt(i) == '[') {
                        curStr += '\n';
                        result.add(curStr);
                        curStr = indents;
                    }
                    break;
                case ',':
                    curStr += '\n';
                    result.add(curStr);
                    curStr = indents;
                    i++;
                    break;
                case '[':
                case '{':
                    curStr += '\n';
                    result.add(curStr);
                    indents += '\t';
                    curStr = indents;
                    i++;
                    break;
                case '}':
                case ']':
                    if(curStr.charAt(curStr.length()-2) != '\t') {
                        curStr = curStr.substring(0, curStr.length() - 1);
                        curStr += '\n';
                        result.add(curStr);
                    }
                    if(indents.length() > 0) indents  = indents.substring(1);
                    result.add(indents + cur + '\n');
                    curStr = indents;
                    i++;
                    break;
                default:
                    i++;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        List<String> list = printPrettyJSON(str);
        for(String s : list) {
            System.out.print(s);
        }
    }
}
