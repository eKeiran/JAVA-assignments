package semIV;

public class Student4 {
    String name;
    String city;
    int age;
    
    public void addData(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }
    
    public void printData() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Age: " + age);
    }
}

class Student4D {
    public static void main(String[] args) {
  
    	Student4 s0 = new Student4();
        s0.addData("Keera", "Pune", 20);
        s0.printData();
        
        Student4 s1 = new Student4();
        s1.addData("Percy Jackson", "New York", 21);
        s1.printData();
        
        Student4 s2 = new Student4();
        s2.addData("Aelin", "Terresan", 17);
        s2.printData();
    }
}