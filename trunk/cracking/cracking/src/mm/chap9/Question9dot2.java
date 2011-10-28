/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap9;

import java.util.*;


/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other
 *
 * @author mmathuria
 */
public class Question9dot2 {
    
    public String[] orderAnagrams(String[] input){
        Map<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        
        for(String str : input){
            String sortedString = sortCharsInString(str);
            
            ArrayList<String> list = map.get(sortedString);
            if(list == null){
                list = new ArrayList<String>();
                map.put(sortedString,list);
            }
            list.add(str);
        }
        
        
        String[] result = new String[input.length];
        int i=0;
        for(ArrayList<String> list : map.values()){
            for(String str : list){
                result[i++] = str;
            }
        }
        
        return result;
    }

    private String sortCharsInString(String str) {
        char[] chars =  str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    
    //book style
    public String[] _orderAnagrams(String[] input){
        Arrays.sort(input,new AnagramComparator());
        return input;
    }
    
    
}


class AnagramComparator implements Comparator<String> {

    public String sortChars(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(sortChars(o2));
    }
}
