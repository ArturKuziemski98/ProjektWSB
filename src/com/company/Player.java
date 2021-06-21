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
            System.out.println("Id: "+i+" Value: "+this.ownedCars.get(i).value+" Manufacturer: "+this.ownedCars.get(i).manufacturer);
        }
    }
    public void buyACar(){
        System.out.print("From the list of all Cars, what car do you want to buy(give the number assosiated to it): ");
        int i= sc.nextInt();
        this.cash = this.cash - this.allCars[i].value;
        this.ownedCars.add(allCars[i]);
    }
}
