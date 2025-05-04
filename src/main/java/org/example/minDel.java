package org.example;

public class minDel {

    public static String revString(String str)
    {
        String rev="";
        for(int i=str.length()-1;i>=0;i--)
        {
            rev+=str.charAt(i);
        }
        return rev;
    }

    public static void main(String[] args) {
        String s="abea";
        int c1=0;
        int i=0;
        int l=s.length()-1;
        while(i<l)
        {
            if(s.charAt(i)!=s.charAt(l))
            {
                c1+=2;
            }
            i++;
            l--;
        }
        System.out.println(c1);
        //String r=revString(s);
        //System.out.println(r);
    }
}
