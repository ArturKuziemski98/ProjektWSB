package com.company;
import Cars.*;
import Mechanics.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner sc= new Scanner(System.in);
    private Integer id;
    private static Double cash = 100000.00;
    public Cars[] allCars = new Cars[15];
    private ArrayList<Cars> ownedCars = new ArrayList<Cars>(3);
    public Player(Integer id){
        this.id = id;
    }
    public void carsToBuy(){
        for (int i=0;i< allCars.length ;i++) {
            System.out.println("Id: "+i+" Value: "+this.allCars[i].value+" Manufacturer: "+this.allCars[i].manufacturer);
        }
    }
    public void ownedCars(){
        for (int i=0;i< ownedCars.size() ;i++) {
            System.out.println("Id: "+i+" Value: "+this.ownedCars.get(i).value+" Manufacturer: "+this.ownedCars.get(i).manufacturer+" Engine: "+this.ownedCars.get(i).engine+" Brakes: "+this.ownedCars.get(i).brakes+" Suspension: "+this.ownedCars.get(i).suspension+" Transmission: "+this.ownedCars.get(i).transmission+" Body: "+this.ownedCars.get(i).body);
        }
    }
    public void buyACar(){
        System.out.print("From the list of all Cars, what car do you want to buy(give the number assosiated to it): ");
        int i= sc.nextInt();
        this.cash = this.cash - this.allCars[i].value;
        this.ownedCars.add(allCars[i]);
    }
    public void repairJanusz(){
        System.out.print("From the list of your cars, give a number of the car you want to repair: ");
        int i= sc.nextInt();
        System.out.println("1.Transmission: "+this.ownedCars.get(i).transmission+" 2.Brakes: "+this.ownedCars.get(i).brakes+" 3.Suspension: "+this.ownedCars.get(i).suspension+" 4.Body: "+this.ownedCars.get(i).body+" 5.Engine: "+this.ownedCars.get(i).engine);
        System.out.println("From the list of the parts what part you want to repair: ");
        int x =sc.nextInt();
        if ( x == 1 && this.ownedCars.get(i).transmission == false ){
            this.cash = this.cash - 5000.00;
            this.ownedCars.get(i).transmission = true;
            this.ownedCars.get(i).value = this.ownedCars.get(i).value * 1.5;
        }
        else if ( x == 2 && this.ownedCars.get(i).brakes == false ){
            this.cash = this.cash - 5000.00;
            this.ownedCars.get(i).brakes = true;
            this.ownedCars.get(i).value = this.ownedCars.get(i).value * 1.1;
        }
        else if ( x == 3 && this.ownedCars.get(i).suspension == false ){
            this.cash = this.cash - 5000.00;
            this.ownedCars.get(i).suspension = true;
            this.ownedCars.get(i).value = this.ownedCars.get(i).value * 1.2;
        }
        else if ( x == 4 && this.ownedCars.get(i).body == false ){
            this.cash = this.cash - 5000.00;
            this.ownedCars.get(i).body = true;
            this.ownedCars.get(i).value = this.ownedCars.get(i).value * 1.5;
        }
        else if ( x == 5 && this.ownedCars.get(i).engine == false ){
            this.cash = this.cash - 5000.00;
            this.ownedCars.get(i).engine = true;
            this.ownedCars.get(i).value = this.ownedCars.get(i).value * 2;
        }
        else {
            System.out.println("Please give proper numbers!(You cant repair something thats not broken(true))");
        }
    }
}
