package com.company;
import Cars.*;
import java.util.*;
import Mechanics.*;
import Clients.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Player p1 = new Player(1);
        Clients c1 = new Clients("Cars.NormalCar",20000.00,"BMW","Audi",false,false);
        Clients c2 = new Clients("Cars.NormalCar",15000.00,"BMW","Ford",true,true);
        Clients c3 = new Clients("Cars.NormalCar",19000.00,"Honda","Tesla",true,true);
        Clients c4 = new Clients("Cars.DeliveryTruck",20000.00,"Man","Dacia",false,false);
        Clients c5 = new Clients("Cars.DeliveryTruck",30000.00,"Dacia","Lexus",false,false);
        p1.addC(c1);p1.addC(c2);
        Clients ac1 = new Clients("Cars.NormalCar",20000.00,"BMW1","Audi",false,false);
        Clients ac2 = new Clients("Cars.DeliveryTruck",20000.00,"BMW2","Audi",false,false);
        Clients ac3 = new Clients("Cars.NormalCar",20000.00,"BMW3","Audi",false,false);
        Clients ac4 = new Clients("Cars.NormalCar",20000.00,"BMW4","Audi",false,false);
        Clients ac5 = new Clients("Cars.DeliverTruck",20000.00,"BMW5","Audi",false,false);
        Clients ac6 = new Clients("Cars.NormalCar",20000.00,"BMW6","Audi",false,false);
        Clients ac7 = new Clients("Cars.DeliveryTruck",20000.00,"BMW7","Audi",false,false);
        Clients ac8 = new Clients("Cars.NormalCar",20000.00,"BMW85","Audi",false,false);
        p1.addAC(ac1);p1.addAC(ac2);p1.addAC(ac3);p1.addAC(ac4);p1.addAC(ac5);p1.addAC(ac6);p1.addAC(ac7);p1.addAC(ac8);
        NormalCar n1 = new NormalCar(10000.00,"BMW",103000,"Black","Standard",true,true,true,false,true);
        NormalCar n2 = new NormalCar(10000.00,"BMW",120000,"White","Budged",false,false,true,true,true);
        NormalCar n3 = new NormalCar(30000.00,"Mercedes",200000,"Red","Budged",false,false,true,false,false);
        NormalCar n4 = new NormalCar(12900.00,"Tesla",106000,"Black","Premium",true,true,true,false,true);
        NormalCar n5 = new NormalCar(13801.00,"VW",100700,"Grey","Premium",true,false,true,false,false);
        NormalCar n6 = new NormalCar(65902.00,"Lexus",103000,"Black","Standard",true,true,true,true,false);
        NormalCar n7 = new NormalCar(43023.00,"Dacia",120000,"White","Budged",false,false,true,false,false);
        NormalCar n8 = new NormalCar(30014.00,"Mercedes",200000,"Red","Budged",false,true,false,false,false);
        NormalCar n9 = new NormalCar(42005.00,"Fiat",106000,"Black","Premium",true,true,true,false,false);
        NormalCar n10 = new NormalCar(28006.00,"Ford",100700,"Grey","Premium",false,true,true,false,true);
        DeliveryTruck d1 = new DeliveryTruck(2000.00,"Man",103000,"Black","Standard",320,true,true,true,false,true);
        DeliveryTruck d2 = new DeliveryTruck(1000.00,"Dacia",120000,"White","Budged",400,true,false,true,false,false);
        DeliveryTruck d3 = new DeliveryTruck(3000.00,"Mercedes",200000,"Red","Budged",120,true,true,false,true,false);
        DeliveryTruck d4 = new DeliveryTruck(4200.00,"Fiat",106000,"Black","Premium",560,false,false,false,false,false);
        DeliveryTruck d5 = new DeliveryTruck(2800.00,"Man",100700,"Grey","Premium",340,false,false,true,false,true);
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
                    System.out.println("Who will repair your car? 1. Janusz 2.Marian 3.Adrian");
                    int i= sc.nextInt();
                    if(i==1) {
                        System.out.print("From the list of your cars, give a number of the car you want to repair: ");
                        int g= sc.nextInt();
                        p1.repairJanusz(5000.00,g);
                    }
                    else if (i==2){
                        System.out.print("From the list of your cars, give a number of the car you want to repair: ");
                        int g= sc.nextInt();
                        p1.repairMarian(g);
                    }
                    else if (i==3){
                        System.out.print("From the list of your cars, give a number of the car you want to repair: ");
                        int g= sc.nextInt();
                        p1.repairAdrian(g);
                    }
                    else{
                        System.out.println("Please give a walid number from 1 to 3!");
                    }
                    break;
                case 5:
                    p1.potentialC();
                    break;
                case 6:

                    p1.sell();
                    break;
                case 7:
                    p1.AD();
                    break;
                case 8:
                    p1.cash();
                    break;
                case 9:
                    p1.HistoryT();
                    break;
                case 10:
                    System.out.println("10");
                    break;
                case 11:
                    p1.sumRAW();
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
