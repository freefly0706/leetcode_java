package algorithms.F1to50;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        int num1Len = num1.length(), num2Len = num2.length();
        int[] resInt = new int[num1Len + num2Len];
        for (int i = num1Len - 1; i >= 0; i--) {
            for (int j = num2Len - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = p1 + 1;
                tmp += resInt[p2];
                resInt[p2] = tmp % 10;
                resInt[p1] += tmp / 10;
            }
        }
        StringBuilder resStr = new StringBuilder();
        int i = -1;
        while (resInt[++i] == 0) ;
        for (; i < resInt.length; i++) {
            resStr.append(resInt[i]);
        }
        return resStr.toString();
    }
}
