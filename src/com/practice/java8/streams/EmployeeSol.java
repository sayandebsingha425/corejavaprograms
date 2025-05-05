package com.practice.java8.streams;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeSol {

    public static void main(String[] args) {
        

        List<Employee> employeeList = new ArrayList<Employee>();   
 employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    
//System.out.println(employeeList);

//Query 3.1 : How many male and female employees are there in the organization?
Map<String, Long> noOfMaleAndFemaleEmployees= employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
System.out.println(noOfMaleAndFemaleEmployees);

//Query 3.2 : Print the name of all departments in the organization?
List<String> allDEpartment = employeeList.stream().map(emp-> emp.getDepartment()).distinct().collect(Collectors.toList());
System.out.println(allDEpartment);

//Query 3.3 : What is the average age of male and female employees?
Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
System.out.println(avgAgeOfMaleAndFemaleEmployees);

//Query 3.4 : Get the details of highest paid employee in the organization?

Optional<Entry<Employee, Double>> max = employeeList.stream().collect(Collectors.toMap(Function.identity(), Employee::getSalary)).entrySet().stream()
.max(Map.Entry.comparingByValue());
System.out.println(max.get().getKey().getName() + " : " + max.get().getValue());

//Query 3.5 : Get the names of all employees who have joined after 2015?
List<String> collect = employeeList.stream().filter(emp->emp.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());
System.out.println(collect);

//Query 3.6 : Count the number of employees in each department?
Map<String, Long> employeeCountByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
System.out.println(employeeCountByDepartment);

//Query 3.7 : What is the average salary of each department?
Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
System.out.println(avgSalaryOfDepartments);

//Query 3.8 : Get the details of youngest male employee in the product development department?
Entry<Employee, Integer> entry = employeeList.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
.collect(Collectors.toMap(Function.identity(), Employee::getAge))
.entrySet()
.stream()
.min(Map.Entry.comparingByValue())
.get();
System.out.println(entry.getKey().getName() + " : " + entry.getValue());

employeeList.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
.min(Comparator.comparingInt(Employee::getAge)).ifPresent(e-> System.out.println(e.getName() + " : " + e.getAge()));


//Query 3.9 : Who has the most working experience in the organization?
employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).ifPresent(e-> System.out.println(e.getName() + " : " + e.getYearOfJoining()));
employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().ifPresent(e-> System.out.println(e.getName() + " : " + e.getYearOfJoining()));
employeeList.stream().collect(Collectors.toMap(Function.identity(), Employee::getYearOfJoining))
.entrySet()
.stream()
.sorted(Map.Entry.comparingByValue())
.findFirst()
.ifPresent(x-> System.out.println(x.getKey().getName() + " : " + x.getValue()));

//Query 3.10 : How many male and female employees are there in the sales and marketing team?
Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream().filter(f -> f.getDepartment()=="Sales And Marketing")
.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
System.out.println(countMaleFemaleEmployeesInSalesMarketing);

//Query 3.11 : What is the average salary of male and female employees?
Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
System.out.println(avgSalaryOfMaleAndFemaleEmployees);

//********Query 3.12 : List down the names of all employees in each department?
Map<String, List<String>> employeesByDepartment = employeeList.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
System.out.println(employeesByDepartment);

//***Query 3.13 : What is the average salary and total salary of the whole organization?
Double avgSal = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));  
System.out.println("Average Salary of the organization: " + avgSal);
double sum = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();
System.out.println("Total Salary of the organization: " + sum);

//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
Map<Boolean, List<Employee>> ageMap = employeeList.stream()
.collect(Collectors.partitioningBy(e->e.getAge()<=25));
ageMap.entrySet().stream().forEach(e->{
    if(e.getKey()){
        System.out.println("Younger or equal to 25 years: " );
        e.getValue().forEach(emp->System.out.println(emp.getName()));
        System.out.println("---------------------------------");
    }
    else{
        System.out.println("Older than 25 years: " );
        e.getValue().forEach(emp->System.out.println(emp.getName()));
        System.out.println("---------------------------------");
    }
    
});

//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
Employee employee = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
System.out.println("Oldest Employee: " + employee.getName() + " : " + employee.getAge() + " : " + employee.getDepartment());
}
 

}
