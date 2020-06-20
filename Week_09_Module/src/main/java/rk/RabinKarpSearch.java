package rk;

public class RabinKarpSearch {
    public final static int D = 256;
    public final static int Q = 9997;

    static int search(String txt, String pat) {
        int patLength = pat.length();
        int txtLength = txt.length();
        int i, j;
        int patHash = 0, txtHash = 0;
        for (i = 0; i < patLength; i++) {
            patHash = (D * patHash + pat.charAt(i)) % Q;
            txtHash = (D * txtHash + pat.charAt(i)) % Q;
        }
        //pow(256, M-1)
        int highestPow = 1;
        for (i = 0; i < patLength - 1; i++) {
            highestPow = (highestPow * D) % Q;
        }
        for (i = 0; i < txtLength - patLength; i++) {
            if (patHash == txtHash) {
                for (j = 0; j < patLength; j++) {
                    if (txt.charAt(j + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == patLength) {
                    return i;
                }
            }
            if (i < txtLength - patLength) {
                txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + patLength)) % Q;
                if (txtHash < 0) {
                    txt += Q;
                }
            }
        }
        return -1;
    }
}
