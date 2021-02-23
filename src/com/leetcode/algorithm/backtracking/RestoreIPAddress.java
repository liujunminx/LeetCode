package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s){
        List<String> addresses = new ArrayList<>();
        if (s.length() > 12 || s.length() == 0)
            return addresses;
        backtracking(addresses, new ArrayList<String>(), s, 0);
        return addresses;
    }

    private void backtracking(List<String> addresses, List<String> temp, String s, int start){
        if (start == s.length() && temp.size() == 4){
            addresses.add(String.join(".", temp));
            return;
        }

        for (int i = 1; i <= 3; i++){
            if (start + i > s.length()){
                return;
            }

            String address = s.substring(start, start + i);
            if (validAddress(address)){
                temp.add(address);
                backtracking(addresses, temp, s, start + i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean validAddress(String address){
        return !((address.charAt(0) == '0' && address.length() > 1) || Integer.parseInt(address) > 255);
    }
}
