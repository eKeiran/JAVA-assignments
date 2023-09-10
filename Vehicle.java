package semIV;

import java.util.Scanner;

public class Vehicle {
    String registrationNumber;
    String color;
    String typeOfVehicle;
    static Scanner sc = new Scanner(System.in);
    public void getDetails() {
        
        System.out.println("Enter registration number:");
        registrationNumber = sc.nextLine();
        System.out.println("Enter color:");
        color = sc.nextLine();
        System.out.println("Enter type of vehicle:");
        typeOfVehicle = sc.nextLine();
    }

    public void printDetails() {
        System.out.println("Registration number: " + registrationNumber);
        System.out.println("Color: " + color);
        System.out.println("Type of vehicle: " + typeOfVehicle);
    }
}

class Car extends Vehicle {
    String make;
    int cc;
    String fuelType;

    public void getDetails() {
        super.getDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter make:");
        make = sc.nextLine();
        System.out.println("Enter CC:");
        cc = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter fuel type:");
        fuelType = sc.nextLine();
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Make: " + make);
        System.out.println("CC: " + cc);
        System.out.println("Fuel type: " + fuelType);
    }
}

class Truck extends Vehicle {
    String make;
    int cc;
    String fuelType;

    public void getDetails() {
        super.getDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter make:");
        make = sc.nextLine();
        System.out.println("Enter CC:");
        cc = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter fuel type:");
        fuelType = sc.nextLine();
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Make: " + make);
        System.out.println("CC: " + cc);
        System.out.println("Fuel type: " + fuelType);
    }
}

class Motorcycle extends Vehicle {
    String make;
    int cc;
    String fuelType;

    public void getDetails() {
        super.getDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter make:");
        make = sc.nextLine();
        System.out.println("Enter CC:");
        cc = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter fuel type:");
        fuelType = sc.nextLine();
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Make: " + make);
        System.out.println("CC: " + cc);
        System.out.println("Fuel type: " + fuelType);
    }
}

class DriverCode {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("Enter details for car:");
        car.getDetails();
        Motorcycle motorcycle = new Motorcycle();
        System.out.println("Enter details for motorcycle:");
        motorcycle.getDetails();
        Truck truck = new Truck();
        System.out.println("Enter details for truck:");
        truck.getDetails(); 
        
        System.out.println("\nCar details:");
        car.printDetails();
        System.out.println("\nTruck details:");
        truck.printDetails();
        System.out.println("\nMotocycle details:");
        truck.printDetails();
}
}