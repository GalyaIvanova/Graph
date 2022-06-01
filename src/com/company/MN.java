package com.company;

import java.util.LinkedList;

public class MN {
private static int StepCounter=0;
    public static void main(String args[])
    {
        int m=5;
        int n=5;

        int x=8;
        
        int arr[][]=new int[m][n];
        
        
//        инициализация и принтване на масива
//        int num=1;
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                arr[i][j]=num;
//                num++;
//            }
//        }
//
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                System.out.print( arr[i][j]+" ");
//
//            }
//            System.out.println('\n');
//        }


     
        boolean found=false;

        for(int i=0;i<(m-1);i++) {
            if(arr[0][0]>x || arr[m-1][n-1]<x)break;

            for (int j = i; j < (n-1); j++) {
                StepCounter++;

                if(arr[i][j]==x){
                    found=true;
                    break;
                }

                if(arr[i][j+1]<=x) {
                    
                    if(i!=(m-1)){
                        if(arr[i+1][j+1]<=x){
                            if(arr[i+1][j+1]==x){
                                found=true;
                                break;
                            }
                            break;
                        }
                    }
                    if (arr[i][j + 1] == x) {
                        found = true;
                        break;
                    }
                        if((j+1)==(n-1)){
                        j=-1;
                        i++;
                    }
                    continue;
                }
            }
            if(found)break;
        }

        System.out.println("Steps needed: "+StepCounter +" "+found);

    }
}
