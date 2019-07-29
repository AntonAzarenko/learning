package com.azarenka.util;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    public List<String> getRefs(char[] chars) {
        List<String> list = new ArrayList<>();
        return list;
    }

    private char[] search(char[] chars){
        char[] refs = new char[1000];
        char[] temp = new char[5];
        for(int i = 0; i <chars.length; i++){
            if(check(chars[i])){
                int count = 0;
                refs[count++]= chars[i];
            }
        }
        return refs;
    }

    private boolean check(char c){
        boolean flag = false;
        char[] temp = new char[6];
        if(c == '"' && temp[4] != 0){

            return true;
        }
        if(c == 'h' && temp[0] == 0){
            temp[0] = c;
        }
        if(c == 'r' && temp[1] == 0){
            temp[1] = c;
        }
        if(c == 'e' && temp[2] == 0){
            temp[2] = c;
        }
        if(c == 'f' && temp[3] == 0){
            temp[3] = c;
        }
        if(c == '=' && temp[4] == 0){
            temp[4] = c;
        }
        return false;
    }
}
