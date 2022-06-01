package com.company;

import java.util.LinkedList;

public class MN {

    public static void main(String args[])
    {

     int arr[][]=new int[5][5];
     int x=2;
     boolean found=false;
        for(int i=0;i<5;i++) {

            for (int j = i; j < 5; j++) {
                if(arr[i][j]==x){
                    System.out.println(i+" "+j);
                    found=true;
                    break;
                }
                if(arr[i+1][j+1]<=x){
                    i++;
                    continue;
                }

                if(arr[i][j+1]<=x){
                    continue;
                }
            }
           if(found)break;
        }

    }
}
