package com.company;

import java.util.LinkedList;

public class list {

    public static void main(String args[])
    {

        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.add(4);
        ll.add(34);
        ll.add(14);
        ll.add(3);

        int size=ll.size();
        for (Integer i:ll ) {
            System.out.println((i>size?i:""));
        }


    }
}
