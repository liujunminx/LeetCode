package com.leetcode.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path){
        if (path.length() == 0)
            return "";
        // 斜杠分离
        String[] arr = path.split("/", 0);
        Deque<String> st = new LinkedList<>();
        // 队列
        for (String a: arr){
            if (!(a.equals(""))){
                if (a.equals(".")){

                }else if (a.equals("..")){
                    if (!(st.isEmpty()))
                        st.removeLast();
                }else {
                    st.add(a);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (st.isEmpty())
            sb.append("/");
        while (!(st.isEmpty())){
            sb.append("/");
            sb.append(st.pop());
        }

        return sb.toString();
    }
}
