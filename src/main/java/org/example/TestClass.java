package org.example;

class TestClass
{
    public static void printOdd(int x, int y)
    {
        int i=0;
        int k=0;
        if(x<y)
        {
            i=x;
            k=y;
        }
        else {
            i=y;
            k=x;
        }

        int j=i+1;
        while(j<k)
        {
            if(j%2!=0)
            {
                System.out.println(j);
            }

            j++;
        }
    }

    public static void main(String[] args)
    {
        int x=1;
        int y=10;
        printOdd(x,y);
    }
}