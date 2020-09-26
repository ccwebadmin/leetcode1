package com.leetcode1.test6_8;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        Test6 test=new Test6();
        String str ="ABCDEFGHIJKLMNOPQRST";
        int numRows=4;
        System.out.println(test.convert(str,numRows));
    }
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        //有多少行数据
        List<StringBuilder> rows= new ArrayList<>();
        //实际z变化的行数
        int numRowsReal =Math.min(numRows,s.length());
        //初始化z字变换的行数
        for(int i=0;i<numRowsReal;i++){
            rows.add(new StringBuilder());
        }
        //当前的行号
        int curRow=0;
        //Z字变化无非是向上还是向下走
        boolean goingDown=false;
        //每次取一个字符
        for (char c:s.toCharArray()){
            //当前所在行号拼接上字符
            rows.get(curRow).append(c);
            //方向改变的依据是curRow为0，或者到达最后一行
            if(curRow==0||curRow==numRowsReal-1){
                //初始化向下走true ，当是最后一行的时候向上走false
                goingDown=!goingDown;
            }
            //向下走行号加一 向上走行号减一
            curRow+=goingDown?1:-1;
        }
        StringBuilder ret = new StringBuilder();
        //将每一行的数据拼接在一起返回
        for(StringBuilder sb:rows){
            ret.append(sb);
        }
        return ret.toString();
    }

}
