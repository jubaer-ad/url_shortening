package com.spring_ui.springuiapp.urlshortner;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
		System.out.println("Hello World");
		int uniqueNumber = 1000000 + 1;
        
	}

    public String numberToString(int uniqueNumber){
        List<Integer> list = new ArrayList<Integer>();
        while(uniqueNumber > 0){
            int remainder = uniqueNumber % 62;
            list.add(remainder + 48);
            uniqueNumber = uniqueNumber / 62;
        }
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            if (num >=58 && num <= 64) {
                num += 7;
            }
            if (num >= 91 && num <= 96) {
                num += 6;
            }
            char ch = (char) (num);
            System.out.println(ch);
            sb.append(ch);
        }
        String shortURL = sb.toString();

        // print string
        System.out.println("String: " + shortURL);
        return "";
    }
}
