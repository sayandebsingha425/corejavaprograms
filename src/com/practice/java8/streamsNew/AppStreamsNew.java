package com.practice.java8.streamsNew;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppStreamsNew {
    public static void main(String[] args) {
        
        // 1. Given a list of integers, separate odd and even numbers?

/*List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
Map<Boolean, List<Integer>> collect = listOfIntegers.stream().collect(Collectors.partitioningBy(i->i%2==0));
Set<Entry<Boolean, List<Integer>>> entrySet = collect.entrySet();
for(Entry<Boolean, List<Integer> >  entry : entrySet)
{
    if(entry.getKey())
    {
        System.out.println(entry.getValue());
    }
    else
    {
        System.out.println(entry.getValue());
    }
*/
//2. Sum of all even Numbers
List<Integer> asList = Arrays.asList(1,2,3,4,5);
System.out.println(asList.stream().filter(i-> i%2==0).mapToInt(i->i).summaryStatistics().getSum());
System.out.println(asList.stream().filter(i->i%2==0).reduce(0, (a,b)->a+b));
    
//3.Sort a List of Strings in Alphabetical Order
List<String> asList2 = Arrays.asList("banana","apple","cherry");
List<String> collect = asList2.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
System.out.println(collect);

//4.Remove duplicate elements from A List
List<Integer> asList3 = Arrays.asList(1,2,2,3,4,4,5);
System.out.println(asList3.stream().distinct().collect(Collectors.toList()));


    }
}
