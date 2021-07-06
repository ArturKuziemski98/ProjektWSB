package com.company;
import java.lang.Class;
import Cars.Cars;
import Clients.*;
import Mechanics.Mechanic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    Scanner sc= new Scanner(System.in);

    private ArrayList<Clients> allClients = new ArrayList<Clients>(2);
    private ArrayList<Clients> clients = new ArrayList<Clients>(2);
    private ArrayList<Cars> ownedCars = new ArrayList<Cars>(3);
    private ArrayList<String> historyT = new ArrayList<String>(1);
    private ArrayList<String> historyR = new ArrayList<String>(1);
    public Cars[] allCars = new Cars[15];
    private Integer id;
    private  Double cash = 200000.00;
    public Player(Integer id){
        this.id = id;
    }
    public Double getCash(){
        return this.cash;
    }
    public void setCash(Double newCash){
        this.cash = newCash;
    }
    public void potentialC(){
        for (int i=0;i < this.clients.size();i++){
       System.out.println("Potential buyers cash: "+this.clients.get(i).getcCash()+", mark1: "+this.clients.get(i).getiMark1()+", mark2: "+this.clients.get(i).getiMark2()+", broken: "+this.clients.get(i).getBroken()+", brokenS: "+this.clients.get(i).getBrokenS());
        }
    }
    public void addC(Clients c){
        this.clients.add(c);
    }
    public void addAC(Clients c){
        this.allClients.add(c);
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
        this.tHistoryS(this.ownedCars.get(i),null,this.ownedCars.get(i).value,"bought");
        this.carWash(i);
        this.tax(i);
        System.out.println("Car bought successfully!");
        }
        else {
            System.out.println("You need more cash in order to afford that car!");
        }
    }
    public void repairJanusz(Double rCash,Integer g,String who){
        this.ownedCars.get(g).setSum(this.ownedCars.get(g).getSum() + 5000.00);
        System.out.println("1.Transmission: "+this.ownedCars.get(g).transmission+" 2.Brakes: "+this.ownedCars.get(g).brakes+" 3.Suspension: "+this.ownedCars.get(g).suspension+" 4.Body: "+this.ownedCars.get(g).body+" 5.Engine: "+this.ownedCars.get(g).engine);
        System.out.println("From the list of the parts what part you want to repair: ");
        int x =sc.nextInt();
        if ( x == 1 && !this.ownedCars.get(g).transmission){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).transmission = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.5;
            this.historyR(this.ownedCars.get(g).manufacturer,who,"transmission",rCash);
        }
        else if ( x == 2 && !this.ownedCars.get(g).brakes){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).brakes = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.1;
            this.historyR(this.ownedCars.get(g).manufacturer,who,"brakes",rCash);

        }
        else if ( x == 3 && !this.ownedCars.get(g).suspension){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).suspension = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.2;
            this.historyR(this.ownedCars.get(g).manufacturer,who,"suspension",rCash);

        }
        else if ( x == 4 && !this.ownedCars.get(g).body){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).body = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 1.5;
            this.historyR(this.ownedCars.get(g).manufacturer,who,"body",rCash);

        }
        else if ( x == 5 && !this.ownedCars.get(g).engine){
            this.cash = this.cash - rCash;
            this.ownedCars.get(g).engine = true;
            this.ownedCars.get(g).value = this.ownedCars.get(g).value * 2;
            this.historyR(this.ownedCars.get(g).manufacturer,who,"engine",rCash);

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
            this.repairJanusz(5000.00,g,"Janusz");
        }
        else {
            System.out.println("Marian fixed this part!");
            this.repairJanusz(3000.00,g,"Mariusz");

        }
    }
    public void repairAdrian(Integer g){
        this.ownedCars.get(g).setSum(this.ownedCars.get(g).getSum() + 5000.00);
        int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
        if (randomNum >=1 && randomNum <=10){
            System.out.println("Adrian didn't fix the part.");
        }
         if (randomNum >= 11 && randomNum <= 12){
            if(this.ownedCars.get(g).engine){
            System.out.println("Adrian broke the engine :(");
            this.ownedCars.get(g).engine = false;
            }
            else if(this.ownedCars.get(g).body){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).body = false;
            }
            else if(this.ownedCars.get(g).brakes){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).brakes = false;
            }else if(this.ownedCars.get(g).suspension){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).suspension = false;
            }
            else if(this.ownedCars.get(g).transmission){
                System.out.println("Adrian broke the engine :(");
                this.ownedCars.get(g).transmission = false;
            }
        }
         else {
             this.repairJanusz(1000.00,g,"Adrian");
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
        System.out.println("Sum of repairs and washes for car with Id: "+i+this.ownedCars.get(i).getSum());
    }
    public void AD(){
        int randomNum = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
        int randomNum1 = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
        int randomNum2 = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
        System.out.println("What type of Ad you want to run? 1.Newspaper AD / 2.Internet AD");
        int i= sc.nextInt();
        if (i==1){
            System.out.println("Newspaper AD");
            this.cash = this.cash - 1000.00;
            this.clients.add(this.allClients.get(randomNum));
            this.clients.add(this.allClients.get(randomNum1));
        }
        else if (i==2){
            System.out.println("Internet AD");
            this.cash = this.cash - 500.00;
            this.clients.add(this.allClients.get(randomNum2));
        }
        else {
            System.out.println("Please put a proper number!");
        }
    }
    public void sell(){
    System.out.println("Write the Id of the car you want to sell: ");
        int i= sc.nextInt();
        System.out.println("To whom are you selling that car, Id: ");
        int g= sc.nextInt();
        if(clients.get(g).getcCash() < this.ownedCars.get(i).value){
            System.out.println("Potential buyer cant afford that car!");
        }
        else if(this.clients.get(g).getBrokenS() == this.ownedCars.get(i).suspension || (!this.ownedCars.get(i).engine || !this.ownedCars.get(i).brakes || !this.ownedCars.get(i).body || !this.ownedCars.get(i).transmission)){
        System.out.println("This potential buyer only buys with broken suspension or working Cars!");
        }
        else if (this.clients.get(g).getBroken() ==(this.ownedCars.get(i).transmission && this.ownedCars.get(i).body && this.ownedCars.get(i).suspension && this.ownedCars.get(i).engine && this.ownedCars.get(i).brakes) ) {
            System.out.println("This potential buyer doesn't buy broken cars");
        }
        else if (this.ownedCars.get(i).getClass().getName() != this.clients.get(g).getType()){
            System.out.println("Potential buyer doesn't want the car type you are selling!");
        }
        else if (!clients.get(g).getiMark1().equals(this.ownedCars.get(i).manufacturer)) {
            System.out.println("Potential buyer doesn't want the car you are selling.1");
            if (!clients.get(g).getiMark2().equals(this.ownedCars.get(i).manufacturer)) {
                System.out.println("Potential buyer doesn't want the car you are selling.2");
            }
        }
        else {
            int randomNum = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
            int randomNum1 = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
            this.clients.add(this.allClients.get(randomNum));
            this.clients.add(this.allClients.get(randomNum1));
            System.out.println(this.ownedCars.get(i).getClass().getName());
            this.setCash(this.getCash()+this.ownedCars.get(i).value);
            this.tHistoryS(this.ownedCars.get(i),this.clients.get(g),this.ownedCars.get(i).value,"sold");
            this.carWash(i);
            this.tax(i);
            this.ownedCars.remove(i);
            System.out.println("Car sold to a potential buyer.");

        }
    }
    public void tHistoryS(Cars car,Clients client,Double price,String sb){
        this.historyT.add("Car: "+car.manufacturer+" Client: "+client+" Price: "+price+" Action: "+sb);
    }
    public void HistoryT(){
        for (String s : historyT) {
            System.out.println(s);
        }
    }
    public void historyR(String car,String mechanic,String what,Double price){
        this.historyR.add("Car: "+car+" Mechanic: "+mechanic+" What: "+what+" price:"+price);
    }
    public void historyRR(){
        for (String s : historyR) {
            System.out.println(s);
        }
    }
}