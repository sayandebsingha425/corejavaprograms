package com.practice.java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.Set;
import java.util.stream.Collectors;

public class App2 {

    public static void main(String[] args) {
        

       //1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
      List<Integer> asList = Arrays.asList(10,15,8,49,25,98,32);
      Map<Boolean, List<Integer>> collect = asList.stream().collect(Collectors.partitioningBy(i->i%2==0));
      Set<Entry<Boolean, List<Integer>>> entrySet = collect.entrySet();
      for(Entry<Boolean, List<Integer>> entry: entrySet)
      {
          if(entry.getKey()== true)
          {
              System.out.println("Even Numbers: "+entry.getValue());
          }
          else
          {
              System.out.println("Odd Numbers: "+entry.getValue());
          }
  
      }

      //2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?

      List<Integer> asList2 = Arrays.asList(10,15,8,49,25,98,32);
      List<Integer> collect2 = asList2.stream().filter(a-> a.toString().startsWith("1")).collect(Collectors.toList());
    System.out.println(collect2);

    //3.How to find duplicate elements in a given integers list in java using Stream functions?

    List<Integer> asList3 = Arrays.asList(10,15,8,49,25,98,98,32,15);
    asList3.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
    .stream().filter(e->e.getValue()>1).forEach(e->System.out.println("Duplicate Element: "+e.getKey()+" Count: "+e.getValue()));
    
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> collect3 = asList3.stream().filter(i->  {
        if(set.add(i)== false)
        {    map.put(i,map.get(i)+1);
           
            return false;
        }
        else{
            map.put(i,1);
            return true;
        }

    }).collect(Collectors.toList());
    System.out.println("Duplicate Elements: "+map);
    }
    
}
