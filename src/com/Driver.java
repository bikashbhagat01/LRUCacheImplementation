package com;

import java.util.Scanner;

public class Driver {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter Capacity for cache");
        int capacity = sc.nextInt();

        LRUCache lruCache = new LRUCache(capacity);
        System.out.println("\n Cache Created with capacity : " + capacity);

        while(true){
            System.out.println(" Enter new Element or -1 to exit !!! ");
            int element = sc.nextInt();
            if(element == -1){
                break;
            } else {
            lruCache.add(element);
            lruCache.displayCache();
            }
        }
    }
}
