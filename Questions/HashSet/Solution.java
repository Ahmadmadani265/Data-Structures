package Questions.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //Q1:
    static void miss(int[] arr, int target) {
       HashSet<Integer>a=new HashSet();
       ArrayList<Integer>s=new ArrayList();
       for(int x:arr){
           a.add(x);
       }
       for(int i=1;i<=target;i++){
           if(!a.contains(i)){
               s.add(i);
           }
       }
        System.out.println(s);
    }
    
    //Q2:
    static void pair(int[] arr, int target) {
      HashSet<Integer>s=new HashSet();
      Set<List<Integer>>res=new HashSet();
      for(int x:arr){
          int com=target-x;
          if(s.contains(com)){
              List<Integer>pair=Arrays.asList(x,com);
              res.add(pair);
          }
          s.add(x);
      }
        System.out.println(res);
    }
    //Q3:
     static void comm(int[] arr, int[] arr1) {
        HashSet<Integer>a=new HashSet();
        for(int x:arr){
            a.add(x);
        }
        int c=0;
        for(int x:arr1){
            if(a.contains(x)){
                c++;
            }
        }
          System.out.println(c);
    }
     //Q4:
     static void uncomm(String s1, String s2) {
        HashSet<Character>a=new HashSet();
        HashSet<Character>b=new HashSet();
        ArrayList<Character>ch=new ArrayList();
         for (char x:s1.toCharArray()) {
             a.add(x);
         }
         for (char x:s2.toCharArray()) {
             b.add(x);
         }
         for(char x:s2.toCharArray()){
             if(!a.contains(x)){
                 ch.add(x);
             }
         }
           for(char x:s1.toCharArray()){
             if(!b.contains(x)){
                 ch.add(x);
             }
         }
         System.out.println(ch);
         
    }
     //Q5:
      static void removedup(String s) {
           HashSet<Character>a=new HashSet();
           String s1="";
           for(char ch:s.toCharArray()){
               if(!a.contains(ch)){
                   a.add(ch);
                   s1+=ch;
               }
               else{
                   a.clear();
                   
               }
           }
           System.out.println(s1);
        
    }


    public static void main(String[] args) {
        int arr[]={1,2,7,8,9};
        int arr1[]={1,2,3,5,6};
        pair(arr,6);
        miss(arr,6);
        comm(arr,arr1);
        uncomm("abcd","afgh");
        removedup("aabccbaa");
    } 
}
