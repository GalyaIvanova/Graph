package com.company;

import java.util.LinkedList;

public class ArrayFive {
    public static void main(String args[])
    {

        int arr[]={5,5,5,4,1};

        int countArr[]={0,0,0,0};
        int flag=6;

        for(int i=0;i<5;i++){
            int count=1;
            for(int j=1+i;j<5;j++){
                if(arr[i]==arr[j])count++;
            }

            if(count==5) {
                flag=1;
                break;
            }
            if(count==4){
                flag=2;
                break;
            }
            if(count==3){
                countArr[3]++;

            }
            if(count==2) {
                countArr[2]++;

            }

           if(countArr[2]+countArr[3]==3)flag=3;
           if(countArr[2]==2 && countArr[3]==0 )flag=4;
           if(countArr[2]==1 && countArr[3]==0 )flag=5;

        }

        System.out.println(flag);


    }
}
