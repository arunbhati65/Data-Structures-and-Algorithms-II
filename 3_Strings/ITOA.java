package main.java.String;

import java.util.Stack;

public class ITOA {//Integer to Alphabet
    public static void main(String args[]){
        String alphabetNumber=getStringFromNumber(12345);
        System.out.println(alphabetNumber);
    }

    private static String getStringFromNumber(int i) {
        if(i==0) return "0";
        StringBuilder sb=new StringBuilder();
        while (i!=0){
            int x=i%10;
            sb.append(x);
            i=i/10;
        }
        return reverse(sb.toString());
    }

    private static String reverse(String str) {
        char[] arr=str.toCharArray();
        int l=0,h=str.length()-1;
        while(l<h){
            char temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            ++l;
            --h;
        }
        return String.copyValueOf(arr);
    }
}
