package com.company;
import Cars.*;
import Mechanics.*;
public class Player {
    private Integer id;
    private static Double cash = 2000.00;
    public Cars[] allCars = new Cars[15];
    private Cars[] ownedCars;
    public Player(Integer id){
        this.id = id;
    }
    public void carsToBuy(){
        for (int i=0;i< allCars.length ;i++) {
            System.out.println("Value: "+this.allCars[i].value+" Manufacturer: "+this.allCars[i].manufacturer);
        }
    }
    public void arturK(){
        System.out.println(this.cash);
    }
    public void listofownedCars(){
        for (int i=0;i< ownedCars.length;i++) {
            System.out.println(ownedCars[i]);
        }
    }

    public void addXD(Cars newCar){
    this.ownedCars[0] = newCar;
    }

}
