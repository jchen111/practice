package AirBnB.phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb
 */
public class TextJustification {
//    public static List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> result = new ArrayList<String>();
//        int i = 0;
//        int start = 0; // starting index of word in current page
//        while(i < words.length) {
//            int numberOfWords = 0;
//            int lengthWithoutJustification = 0;
//            int spacesToPad = maxWidth;
//            StringBuilder sb = new StringBuilder();
//            while(i < words.length && lengthWithoutJustification + words[i].length() <= maxWidth) {
//                spacesToPad -= words[i].length();
//                numberOfWords++;
//                lengthWithoutJustification += words[i++].length();
//                if(lengthWithoutJustification == maxWidth) {
//                    break;
//                }
//                lengthWithoutJustification++; // # of spaces between words should be at least 1
//            }
//
//            int extraSpacesToPad = numberOfWords > 1 ? spacesToPad % (numberOfWords - 1) : 0;
//
//            for(int j = start; j < i && i < words.length; j++) {
//                sb.append(words[j]);
//                for(int k = 0; numberOfWords > 1 && k < spacesToPad/(numberOfWords - 1) && sb.length() < maxWidth; k++) {
//                    sb.append(" ");
//                }
//                if(extraSpacesToPad > 0 && sb.length() < maxWidth) {
//                    sb.append(" ");
//                    extraSpacesToPad--;
//                }
//            }
//            if(i == words.length) { // process the last line
//                for(int j = start; j < i; j++) {
//                    if(j > start) sb.append(" ");
//                    sb.append(words[j]);
//                }
//            }
//
//            while(sb.length() < maxWidth) {
//                sb.append(" ");
//            }
//            result.add(sb.toString());
//            start = i;
//        }
//        return result;
//    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int minLength = 0;
        int wordsLength = 0;
        int wordsCount = 0;
        int prev = 0;
        while(prev < words.length) {
            minLength = 0;
            wordsLength = 0;
            wordsCount = 0;
            StringBuilder line = new StringBuilder();
            int i = prev;
            while(i < words.length && minLength + words[i].length() <= maxWidth) {
                minLength += words[i].length();
                wordsLength += words[i].length();
                wordsCount++;
                i++;
                if(minLength == maxWidth) {
                    break;
                }
                minLength += 1;
            }

            if(wordsCount > 1) {
                int spacesToPad = (maxWidth - wordsLength) / (wordsCount - 1);
                int extraSpaceToPad = spacesToPad % (wordsCount - 1);
                if(i == words.length) { // processing the last line
                    for(int j = prev; j < i; j++) {
                        if(j == i - 1) line.append(words[j]);
                        else line.append(words[j] + " ");
                    }
                } else { // processing other lines
                    for(int j = prev; j < i; j++) {
                        if(j == i - 1) {
                            line.append(words[j]);
                        } else {
                            line.append(words[j]);
                            for(int k = 0; k < spacesToPad; k++) {
                                line.append(" ");
                            }
                            if(extraSpaceToPad > 0) {
                                extraSpaceToPad--;
                                line.append(" ");
                            }
                        }
                    }
                }
            } else {
                line.append(words[prev]);
            }

            while(line.length() < maxWidth) {
                line.append(" ");
            }
            result.add(line.toString());
            prev =  i;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> res = fullJustify(words, 16);
        for(String line : res) {
            System.out.println(line);
        }
    }
}
