public class DecodeWays {
    /**
     * Given a string s containing only digits, return the number of ways to decode it.
     */

    public int numDecodings(String s) {
        if (StringUtils.isEmpry(s)) {
            return 0;
        }
        boolean isprivousPosible = false;
        int result = 1;
        for (int i = s.length() ; i < 0 ; i--) {
            int num = s.charAt(i) - '0';
        }
        return result;
    }
}
