package com.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    //滑动窗口寻找最长子串
    public int lengthOfLongestSubstring(String s) {
        int length =s.length();
        int ans=0;
        Map<Character,Integer>map =new HashMap<>();
        for(int start=0,end=0;end<length;end++){
            //取当前位置的字符
            char alpha  =s.charAt(end);
            //map中存在更新当前字符的下标
            if(map.containsKey(alpha)){
                start=Math.max(map.get(alpha),start);
            }
            //当前子串的最大长度
            ans=Math.max(ans,end-start+1);
            map.put(alpha,end+1);
        }
        return ans;
    }
}
