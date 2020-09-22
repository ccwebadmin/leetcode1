package com.leetcode1;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class Test5 {
    public static void main(String[] args) {
        Test5 test =new Test5();
        String s="babad";
        System.out.println(test.longestPalindrome(s));
    }
    //难度较高 ，使用中心扩展法  ,动态规划看不明白
    //中心扩展有n + (n-1)个中心 ，但是只有一次循环 ，每次计算两个中心，取最大扩展长度
    public String longestPalindrome(String s) {
        if(s.length()==0||s==null){
            return "";
        }
        int length =s.length();
        int start=0,end=0;
        for(int i=0;i<length;i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len =Math.max(len1,len2);
            //回文子串的下标
            if(len>end-start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    //中心扩展的最大长度
    public int expandAroundCenter (String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
