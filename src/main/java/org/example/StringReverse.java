package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class StringReverse {

    public static void main(String[] args) {
        String str="Hello World";
        ArrayList<Character> list=new ArrayList<>();
        for(char c:str.toCharArray())
        {
            list.add(c);
        }
        Collections.reverse(list);
        String str1="";
        for(char c:list)
        {
            str1+=c;
        }
        System.out.println(str1);
    }
}
