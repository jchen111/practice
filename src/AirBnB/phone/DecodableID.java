package AirBnB.phone;

/**
 * Created by z001ktb
 */
public class DecodableID {
    /**
     * Often, we want to encode raw IDs in our database by hiding them behind some
     * 2-way decodeable hash. So, a URL which would have at one time been:
     *
     * https://www.airbnb.com/rooms/848662
     *
     * becomes
     *
     * https://www.airbnb.com/rooms/kljJJ324hjkS_
     *
     * We decode the ID kljJJ324hjkS_ to 848662 on our backend and serve the
     * relevant content. at some point, we start getting 404 errors from clients
     * requesting a certain URL of the form
     *
     * https://www.airbnb.com/rooms/kljjj324hjks_
     *
     * This can happen if certain clients, email services, or url shorteners "sanitize" the url.
     * Unfortunately, this change breaks decoding and the resource cannot be found.
     * To assess how big of a deal this is, we may want to recover the IDs of the targets that were 404ing.
     *
     * Your task:
     * Given a method decode(testEncStr) which will return the decoded int id if
     * testEncStr is decodeable or will throw an exception or return null (depending on the language)
     * if not, implement a new method decodeFind(String badEncStr) which takes a string and
     * returns the decoded int id.
     */
    public static Integer decode(String testEncStr) {
        return testEncStr.equals("kljJJ324hjkS_") ? 848662 : null;
    }

    public static Integer decodeFind(String badEncStr) {
        if(badEncStr == null || badEncStr.length() == 0) {
            return null;
        }
        return backtrack(new StringBuilder(), badEncStr, 0);
    }

    private static Integer backtrack(StringBuilder solution, String badEncStr, int start) {
        if(start == badEncStr.length()) {
            return decode(solution.toString());
        }
        char c = badEncStr.charAt(start);
        Integer res;
        if(c >= '0' && c <= '9') {
            solution.append(c);
            res = backtrack(solution, badEncStr, start + 1);
            if(res != null) return res;
            solution.setLength(solution.length() - 1);
        } else {
            solution.append(Character.toLowerCase(c));
            res = backtrack(solution, badEncStr, start + 1);
            if(res != null) return res;
            solution.setLength(solution.length() - 1);

            solution.append(Character.toUpperCase(c));
            res = backtrack(solution, badEncStr, start + 1);
            if(res != null) return res;
            solution.setLength(solution.length() - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(decodeFind("kljjj324hjks_"));
        System.out.println(decodeFind("kljjj324hjkd_"));
    }
}
