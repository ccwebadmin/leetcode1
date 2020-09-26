package com.leetcode1.test6_8;

public class Test8 {
    public static void main(String[] args) {
        Test8 test = new Test8();
        String str = "  -0012a42";
        System.out.println(test.myAtoi(str));
    }

    public int myAtoi(String str) {
        str = str.trim();
        //符号位 ，默认为正
        boolean negative = false;
        int idx = 0;
        if(str.length()==0){
            return 0;
        }
        char[] chs = str.toCharArray();

        if (chs[0] == '+') {
            idx++;
        } else if (chs[0] == '-') {
            negative = true;
            idx++;
        } else if (!Character.isDigit(chs[0])) {
            return 0;
        }
        int ans = 0;
        for (int i = idx; i < chs.length; i++) {
            //char 和 int 的转换 减去字符'0'
            if(Character.isDigit(chs[i])){
                int digit = chs[i] - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                //上面的if条件推导：ans =ans*10+digit<max_value;
                ans = ans * 10 + digit;
            }else{
                break;
            }
        }
        return negative ? -ans : ans;
    }
}
