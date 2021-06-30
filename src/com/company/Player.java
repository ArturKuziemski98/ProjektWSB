package com.company;
import Cars.Cars;
import Mechanics.*;
import Clients.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    Scanner sc= new Scanner(System.in);
    private Integer id;
    private ArrayList<Clients> clients = new ArrayList<Clients>(2);
    private  Double cash = 100000.00;
    public Cars[] allCars = new Cars[15];
    private ArrayList<Cars> ownedCars = new ArrayList<Cars>(3);
    public Player(Integer id){
        this.id = id;
    }
    public Double getCash(){
        return this.cash;
    }
    public void setName(Double newCash){
        this.cash = newCash;
    }
    public void potentialC(){
       System.out.println("Potential buyers: "+this.clients);
    }
    public void addC(Clients c){
        this.clients.add(c);
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
        if (this.cash > this.allCars[i].value){
        this.cash = this.cash - this.allCars[i].value;
        this.ownedCars.add(allCars[i]);
        this.carWash(i);
        this.tax(i);
        System.out.println("Car bought successfully!");
        }
        else {
            System.out.println("You need more cash in order to afford that car!");
        }
    }
    public void repairJanusz(Double rCash,Integer g){
        this.ownedCars.get(g).setSum(this.ownedCars.get(g).getSum() + 5000.00);
        System.out.println("1.Transmission: "+this.ownedCars.get(g).transmission+" 2.Brakes: "+this.ownedCars.get(g).brakes+" 3.Suspension: "+this.ownedCars.get(g).suspension+" 4.Body: "+this.ownedCars.get(g).body+" 5.Engine: "+this.ownedCars.get(g).engine);
        System.out.println("From the list of the parts what part you want to repair: ");
        int x =sc.nextInt();
        if ( x == 1 && this.ownedCars.get(g).transmission == false ){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).transmission = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.5;
        }
        else if ( x == 2 && this.ownedCars.get(g).brakes == false ){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).brakes = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.1;
        }
        else if ( x == 3 && this.ownedCars.get(g).suspension == false ){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).suspension = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.2;
        }
        else if ( x == 4 && this.ownedCars.get(g).body == false ){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).body = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.5;
        }
        else if ( x == 5 && this.ownedCars.get(g).engine == false ){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).engine = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 2;
        }
        else {
            System.out.println("Please give proper numbers!(You cant repair something thats not broken(true))");
        }
    }
    public void repairMarian(Integer g){
        this.ownedCars.get(g).setSum(this.ownedCars.get(g).getSum() + 5000.00);
        int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
        if (randomNum >=1 && randomNum <=10){
            System.out.println("Marian didn't fix this part and had to call Janusz for help.");
            this.repairJanusz(5000.00,g);
        }
        else {
            System.out.println("Marian fixed this part!");
            this.repairJanusz(3000.00,g);
        }
    }
    public void repairAdrian(Integer g){
        this.ownedCars.get(g).setSum(this.ownedCars.get(g).getSum() + 5000.00);
        int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
        if (randomNum >=1 && randomNum <=10){
            System.out.println("Adrian didn't fix the part.");
        }
         if (randomNum >= 11 && randomNum <= 12){
            if(this.ownedCars.get(g).engine == true){
            System.out.println("Adrian broke the engine :(");
            this.ownedCars.get(g).engine = false;
            }
            else if(this.ownedCars.get(g).body == true){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).body = false;
            }
            else if(this.ownedCars.get(g).brakes == true){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).brakes = false;
            }else if(this.ownedCars.get(g).suspension == true){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).suspension = false;
            }
            else if(this.ownedCars.get(g).transmission == true){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).transmission = false;
            }
        }
         else {
             this.repairJanusz(1000.00,g);
         }
    }
    public void carWash(Integer h){
        System.out.println("Car has been washed! You washed it with your own hands.");
    }
    public void tax(Integer t){
        double ta = this.allCars[t].value * 0.02;
        this.cash = this.cash - ta;
        System.out.println("Tax has been paid! IRS is not looking for you, yet !"+ta);
    }
    public void cash(){
        System.out.println("Your cash: "+this.cash);
    }
    public void sumRAW(){
        System.out.println("What car do you want to see the sum of repairs and washes?");
        int i= sc.nextInt();
        System.out.println("Sum of repairs and washes for car with Id 0: "+this.ownedCars.get(i).getSum());
    }
}
