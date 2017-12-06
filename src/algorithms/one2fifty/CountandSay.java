package algorithms.one2fifty;

public class CountandSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String previous = countAndSay(n - 1);
            StringBuilder res = new StringBuilder();
            int count = 1;
            int length = previous.length();
            for (int i = 1; i < length; i++) {
                if (previous.charAt(i - 1) == previous.charAt(i)) {
                    count++;
                } else {
                    res.append(count).append(previous.charAt(i - 1));
                    count = 1;
                }
            }
            res.append(count).append(previous.charAt(length - 1));
            return res.toString();
        }
    }
}
