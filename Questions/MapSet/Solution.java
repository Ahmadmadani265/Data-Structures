package Questions.MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
      //  Q1:
    static void frequency(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter word=");
        String s=in.nextLine();
        String word[]=s.split(" ");
        Map<String,Integer>m=new HashMap();
        for (int i = 0; i <word.length; i++) {
            m.put(word[i],m.getOrDefault(word[i],0)+1);
        }
        System.out.println(m);
    }
    //Q2:
    static void removeall_duplicate(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter word=");
        String s=in.next();
        String s1="";
        Map<Character,Boolean>m=new HashMap();
        for(char ch:s.toCharArray()){
            if(!m.containsKey(ch)){
                m.put(ch,true);
                s1+=ch;
            }
        }
        System.out.println(s1);
    }
   // Q3:
    static void merge(Map<Integer,Integer>m,Map<Integer,Integer>m1){
        for(Integer x:m1.keySet()){
            if(m.containsKey(x)){
                m.put(x,m.get(x)+m1.get(x));
            }
            else{
                m.put(x,m1.get(x));
            }
        }
        System.out.println(m);
    }
    //Q4:
    static void longest_Substring(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter word=");
        String s=in.next();
         Map<Character,Integer>m=new HashMap();
         int start=0,max=0;
         for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
             if(m.containsKey(ch)&&m.get(ch)>=start){
                 start=m.get(ch)+1;
             }
             m.put(ch, i);
             max=Math.max(max,i-start+1);
         }
         System.out.println(max);
    }
     static void frequency_character(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter word=");
        String s=in.next();
         Map<Character,Integer>m=new HashMap();
          for (char ch:s.toCharArray()) {
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
           Map<Integer,String>m1=new HashMap();
           for(Map.Entry x:m.entrySet()){
               m1.put((Integer) x.getValue(),m1.getOrDefault(x.getValue(),"")+x.getKey());
           }
           System.out.println(m1);
          
    }
    
    public static void main(String[] args) {
       Map<Integer,Integer>m=new HashMap();
       m.put(1,5);
       m.put(2,6);
       m.put(3,7);
       m.put(4,8);
       Map<Integer,Integer>m1=new HashMap();
       m1.put(1,5);
       m1.put(7,6);
       m1.put(3,2);
       m1.put(5,8);
       frequency();
       removeall_duplicate();
      merge(m,m1);
      longest_Substring();
      frequency_character();
    }
}
