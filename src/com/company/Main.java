package com.company;
import Cars.*;
import java.util.*;
import Mechanics.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Player p1 = new Player(1);
        NormalCar n1 = new NormalCar(10000.00,"BMW",103000,"Black","Standard");
        NormalCar n2 = new NormalCar(50000.00,"Honda",120000,"White","Budged");
        NormalCar n3 = new NormalCar(30000.00,"Mercedes",200000,"Red","Budged");
        NormalCar n4 = new NormalCar(12900.00,"Tesla",106000,"Black","Premium");
        NormalCar n5 = new NormalCar(13801.00,"VW",100700,"Grey","Premium");
        NormalCar n6 = new NormalCar(65902.00,"Lexus",103000,"Black","Standard");
        NormalCar n7 = new NormalCar(43023.00,"Dacia",120000,"White","Budged");
        NormalCar n8 = new NormalCar(30014.00,"Mercedes",200000,"Red","Budged");
        NormalCar n9 = new NormalCar(42005.00,"Fiat",106000,"Black","Premium");
        NormalCar n10 = new NormalCar(28006.00,"Ford",100700,"Grey","Premium");
        DeliveryTruck d1 = new DeliveryTruck(2000.00,"Man",103000,"Black","Standard",320);
        DeliveryTruck d2 = new DeliveryTruck(1000.00,"Dacia",120000,"White","Budged",400);
        DeliveryTruck d3 = new DeliveryTruck(3000.00,"Mercedes",200000,"Red","Budged",120);
        DeliveryTruck d4 = new DeliveryTruck(4200.00,"Fiat",106000,"Black","Premium",560);
        DeliveryTruck d5 = new DeliveryTruck(2800.00,"Man",100700,"Grey","Premium",340);
        p1.allCars[0] = n1;p1.allCars[1] = n2;p1.allCars[2] = n3 ; p1.allCars[3] = n4;p1.allCars[4] = n5;p1.allCars[5] = n6;p1.allCars[6] = n7;p1.allCars[7] = n8;p1.allCars[8] = n9;p1.allCars[9] = n10;
        p1.allCars[10] = d1;p1.allCars[11] = d2; p1.allCars[12] = d3;p1.allCars[13] = d4;p1.allCars[14] = d5;

        int a=0;
        do {
            System.out.println("MENU");
            System.out.println("1. Cars to buy.");
            System.out.println("2. Buy a car.");
            System.out.println("3. Your cars.");
            System.out.println("4. Repair a car.");
            System.out.println("5. Potential buyers.");
            System.out.println("6. Sell a car to a potential buyer.");
            System.out.println("7. Buy an AD.");
            System.out.println("8. Check your account.");
            System.out.println("9. History of transactions.");
            System.out.println("10. History of repairs.");
            System.out.println("11. Sum of repairs and washes.");
            System.out.println("12. Exit");
            System.out.println("------------------------------------------");
            System.out.print("What option do you chose: ");
            a= sc.nextInt();
            switch (a) {
                case 1:
                    p1.carsToBuy();
                    break;
                case 2:
                    p1.buyACar();
                    break;
                case 3:
                    p1.ownedCars();
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("7");
                    break;
                case 8:
                    System.out.println("8");
                    break;
                case 9:
                    System.out.println("9");
                    break;
                case 10:
                    System.out.println("10");
                    break;
                case 11:
                    System.out.println("11");
                    break;
                case 12:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Please chose an option from the list!");
            }
        }
        while(a!=12);
    }
}
