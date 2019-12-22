package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Driver {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        LRUCacheImpl lruCache = new LRUCacheImpl(5);

        lruCache.setData("key1", 1);
        lruCache.setData("key2", 1);
        lruCache.setData("key3", 1);
        lruCache.setData("key4", 1);
        lruCache.setData("key5", 1);
        lruCache.setData("key6", 1);
        try {
            int value =  lruCache.get("key2");
            System.out.println("value:" + value);
        } catch (Exception e) {
            System.out.println("No such key");
            e.printStackTrace();
        }


    }
}
