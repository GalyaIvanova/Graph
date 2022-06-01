package com.company;

class NumSequenceOf {


    public static int NumSequence(int num, int n){

        System.out.println(num+" "+n);

        if(num==1){return n;}
        ++n;


        if (num%2==0){
            return  NumSequence(num/2,n);
        }else{
            return  NumSequence(3*num+1,n);
        }

    }

    public static void main(String args[])
    {

        System.out.println(NumSequence(14,6));


    }
}
