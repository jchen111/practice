package MS.OTS;

public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        String[] version1Split = version1.split("\\.");
        String[] version2Split = version2.split("\\.");
        int i = 0, j = 0;
        while(i < version1Split.length || j < version2Split.length) {
            while(i < version1Split.length && j < version2Split.length) {
                if(Integer.valueOf(version1Split[i]) > Integer.valueOf(version2Split[j])){
                    return 1;
                }else if(Integer.valueOf(version1Split[i]) < Integer.valueOf(version2Split[j])) {
                    return -1;
                }else {
                    i++;
                    j++;
                }
            }
            while(i < version1Split.length && Integer.valueOf(version1Split[i]) == 0) {
                i++;
            }
            while(j < version2Split.length && Integer.valueOf(version2Split[j]) == 0) {
                j++;
            }
            if(i < version1Split.length) return 1;
            else if(j < version2Split.length) return -1;
        }
        return 0;
    }
}
