package com.practice.java8.streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        
//1.  Given a list of integers, separate odd and even numbers?
List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
Map<Boolean, List<Integer>> collect = listOfIntegers.stream().collect(Collectors.partitioningBy(i->i%2==0));
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

//2.  How do you remove duplicate elements from a list using Java 8 streams?
List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
List<String> collect2 = listOfStrings.stream().distinct().collect(Collectors.toList());
System.out.println(collect2);

//3. How do you find frequency of each character in a string using Java 8 streams?
String inputString = "Java Concept Of The Day";
Map<Character, Long> collect3 = inputString.chars().mapToObj(i-> (char)i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
System.out.println(collect3);

//4. How do you find frequency of each element in an array or a list?
List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
Map<String, Long> collect4 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
System.out.println(collect4);

//5.How do you sort the given list of decimals in reverse order?
List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
List<Double> collect5 = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println(collect5);

//6.Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
List<String> listOfStrings2 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
String collect6 = listOfStrings2.stream().collect(Collectors.joining(",","[","]"));
System.out.println(collect6);

//8. Given a list of integers, find maximum and minimum of those numbers?
List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
Optional<Integer> max = listOfIntegers2.stream().max(Comparator.naturalOrder());
Optional<Integer> min= listOfIntegers2.stream().min(Comparator.naturalOrder());
System.out.println(max.get()+" "+min.get());

//9. How do you merge two unsorted arrays into single sorted array using Java 8 streams?

int[] a = new int[] {4, 2, 7, 1};
         
int[] b = new int[] {8, 3, 9, 5};

List<Integer> collect7 = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().mapToObj(i->i).collect(Collectors.toList());
System.out.println(collect7);

//11.How do you get three maximum numbers and three minimum numbers from the given list of integers?
List<Integer> listOfIntegers4 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
List<Integer> max3Integers = listOfIntegers4.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
List<Integer> min3Integers = listOfIntegers4.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList());
System.out.println(max3Integers);
System.out.println(min3Integers);

//12.  Java 8 program to check if two strings are anagrams or not?
String s1 = "RaceCar";
String s2 = "CarRace";

s1= Arrays.stream(s1.split("")).map(String::toUpperCase).sorted(Comparator.naturalOrder()).collect(Collectors.joining());
s2 = Arrays.stream(s2.split("")).map(String::toUpperCase).sorted(Comparator.naturalOrder()).collect(Collectors.joining());
if(s1.equals(s2))
{
    System.out.println("Anagrams");
}
else
{
    System.out.println("Not Anagrams");
}

//**13. Find sum of all digits of a number in Java 8?
int i = 15623;
int reduce = String.valueOf(i).chars().mapToObj(c->(char)c).mapToInt(c->Character.getNumericValue(c)).reduce(0,(e,f)->(e+f));
System.out.println(reduce);

//14. Find second largest number in an integer array?
List<Integer> listOfIntegers5 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
Optional<Integer> first = listOfIntegers5.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst();
System.out.println(first.get());

//15.Given a list of strings, sort them according to increasing order of their length?
List<String> listOfStrings3 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
List<String> collect8 = listOfStrings3.stream().sorted((s3,s4)-> s3.length()>s4.length() ? 1 :-1).collect(Collectors.toList());
System.out.println(collect8);

//16. Given an integer array, find sum and average of all elements?
int[] ab = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
long sum2 = Arrays.stream(ab).summaryStatistics().getSum();
double average = Arrays.stream(ab).summaryStatistics().getAverage();
System.out.println(sum2+" "+average);

//17.How do you find common elements between two arrays?

List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
List<Integer> collect9 = list1.stream().filter(y->list2.contains(y)).collect(Collectors.toList());
System.out.println(collect9);

//18. Reverse each word of a string using Java 8 streams?
String str = "Java Concept Of The Day";
List<String> collect10 = Arrays.stream(str.split(" ")).map(s-> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
System.out.println(collect10);

//19.How do you find sum of first 10 natural numbers?
int reduce2 = IntStream.rangeClosed(1, 10).reduce(0,(g,h)->(g+h));
System.out.println(reduce2);

//**20.  Reverse an integer array
int[] array = new int[] {5, 1, 7, 3, 9, 6};
int[] array2 = IntStream.range(1, array.length).map(z-> array[array.length-z]).toArray();
System.out.println(Arrays.toString(array2));
String collect11 = Arrays.stream(array).boxed().map(p->p+"").collect(Collectors.joining(""));
StringBuilder sb = new StringBuilder(collect11);
String[] split = sb.reverse().toString().split("");
System.out.println(Arrays.toString(split));

//21.  Print first 10 even numbers
List<Integer> collect12 = IntStream.rangeClosed(1, 10).map(p->p*2).boxed().collect(Collectors.toList());
System.out.println(collect12);

//22.How do you find the most repeated element in an array?
List<String> listOfStrings4 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
listOfStrings4.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
.stream().max(Map.Entry.comparingByValue()).ifPresent(e->System.out.println(e.getKey()+" "+e.getValue()));

//23 Palindrome program using Java 8 streams

String str1 = "ROTATOR";
boolean isItPalindrome = IntStream.rangeClosed(1, str1.length()/2).noneMatch(t-> str1.charAt(t) != str1.charAt(str1.length()-t-1));

if (isItPalindrome)
{
    System.out.println(str1+" is a palindrome");
}
else
{
    System.out.println(str1+" is not a palindrome");
}

//**24. Given a list of strings, find out those strings which start with a number?
List<String> listOfStrings5 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
List<String> collect13 = listOfStrings5.stream().filter(str4-> Character.isDigit(str4.charAt(0))).collect(Collectors.toList());
System.out.println(collect13);

//25. How do you extract duplicate elements from an array?
List<Integer> listOfIntegers3 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
HashSet<Integer> set = new HashSet<>();
List<Integer> collect14 = listOfIntegers3.stream().filter(itr-> !set.add(itr)).collect(Collectors.toList());
System.out.println(collect14);

//27. Find first repeated character in a string?
String inputString2 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
Set<Character> set2 = new HashSet<>();
Arrays.stream(inputString2.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
.entrySet().stream().filter(entry1->entry1.getValue()>1).findFirst().ifPresent(entry2->System.out.println(entry2.getKey()));
}
}

