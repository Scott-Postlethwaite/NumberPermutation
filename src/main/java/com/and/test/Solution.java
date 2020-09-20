package com.and.test;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {

        char[] chars = input.toCharArray();
        List<Character> s = new ArrayList<Character>();
        List<String> combos = new ArrayList<String>();
        String in = "";
        String ans ="";

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                s.add(chars[i]);
            }
        }
        if(s.size()!=0) {
            for (int i = 0; i < s.size(); i++) {
                in += s.get(i);
            }
            List<String>perms = new ArrayList<String>();
            List<String> p = permutation("", in,perms);

            for (int i = 0; i < p.size(); i++) {
                if(i==p.size()-1) {
                    ans += p.get(i);
                }
                else {
                    ans += p.get(i);
                    ans += ",";
                }
            }


        }
        else{
            System.out.println("Invalid format. This program only permutates numbers");
            return null;
        }
        System.out.println(ans);
        return ans;
    }

    private static List<String> permutation(String prefix, String str, List<String>perms) {
        int n = str.length();
        if (n == 0) {
            perms.add(prefix);
            return perms;
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n),perms);
            }
        }
        return perms;
    }

    public static void main(String args[]) {
        solution("T357ing");
    }

}
