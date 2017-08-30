package Linkedin.phone;

import java.util.List;

public class FindFunctionTime {
    public static void findFunctionTime(List<String> logs, String funcName) {
        int startTime = 0;
        int totalTime = 0;
        int exclusiveTime = 0;
        boolean found = false;
        String midFunc = "";
        int midStart = 0;
        for(String log : logs) {
            String[] logEntries = log.split(",");
            if(logEntries[0].equals(funcName)) {
                if(found) {
                    totalTime = Integer.valueOf(logEntries[2]) - startTime;
                    break;
                }
                startTime = Integer.valueOf(logEntries[2]);
                found = true;
            }
            if(found) {
                if(midFunc.equals("")){
                    midFunc = logEntries[0];
                    midStart = Integer.valueOf(logEntries[2]);
                }else {
                    exclusiveTime += Integer.valueOf(logEntries[2]) - midStart;
                    midFunc = "";
                }
            }
        }
        System.out.println("Function Name:" + funcName);
        System.out.println("Total Time:" + totalTime);
        System.out.println("Exclusive Time:" + exclusiveTime);
    }
}
