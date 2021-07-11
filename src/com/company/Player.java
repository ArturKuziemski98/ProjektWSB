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

    private final ArrayList<Clients> allClients = new ArrayList<Clients>(2);
    private final ArrayList<Clients> clients = new ArrayList<Clients>(2);
    private final ArrayList<Cars> ownedCars = new ArrayList<Cars>(3);
    private final ArrayList<String> historyT = new ArrayList<String>(1);
    private final ArrayList<String> historyR = new ArrayList<String>(1);
    private final ArrayList<Cars> allCars = new ArrayList<Cars>(1);
    private final ArrayList<Cars> carsToBuy = new ArrayList<Cars>(0);

    public Integer getMoves() {
        return moves;
    }

    public void setMoves(Integer moves) {
        this.moves = moves;
    }

    private Integer moves =0;
    private Integer id;
    private  Double cash = 100000.00;
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
    public void addCar(Cars c) {this.allCars.add(c);}
    public void addCarToBuy(Cars c){this.carsToBuy.add(c);}
    public void addCart(){
        int randomNum = ThreadLocalRandom.current().nextInt(1,this.carsToBuy.size());
        this.addCar(this.carsToBuy.get(randomNum));
    }
    public void carsToBuy(){
        for (int i=0;i< allCars.size() ;i++) {
            System.out.println("Id: "+i+" Value: "+this.allCars.get(i).getValue()+" Manufacturer: "+this.allCars.get(i).getManufacturer());
        }
    }
    public void ownedCars(){
        for (int i=0;i< ownedCars.size() ;i++) {
            System.out.println("Id: "+i+" Value: "+this.ownedCars.get(i).getValue()+" Manufacturer: "+this.ownedCars.get(i).getManufacturer()+" Engine: "+this.ownedCars.get(i).getEngine()+" Brakes: "+this.ownedCars.get(i).getBrakes()+" Suspension: "+this.ownedCars.get(i).getSuspension()+" Transmission: "+this.ownedCars.get(i).getTransmission()+" Body: "+this.ownedCars.get(i).getBody());
        }
    }
    public void buyACar(){
        System.out.print("From the list of all Cars, what car do you want to buy(give the number assosiated to it): ");
        int i= sc.nextInt();
        if ((this.allCars.size() -1) < i){
            System.out.println("Wrong Car ID.");
        }
        else if (this.cash > this.allCars.get(i).getValue()){
        this.cash = this.cash - this.allCars.get(i).getValue();
        this.ownedCars.add(allCars.get(i));
        this.tHistoryS(this.ownedCars.get(this.ownedCars.size()-1),null,this.ownedCars.get(this.ownedCars.size()-1).getValue(),"bought");
        this.carWash(i);
        this.tax(i);
        this.addCart();
        this.moves +=1;
        System.out.println("Car bought successfully!");
        }
        else {
            System.out.println("You need more cash in order to afford that car!");
        }
    }
    public void repairJanusz(Double rCash,Integer g,String who) throws Exception{
        if (a1(g)){
            throw new Exception("Wrong Car ID!");
        }
        this.ownedCars.get(g).setSum(this.ownedCars.get(g).getSum() + rCash);
        System.out.println("1.Transmission: "+this.ownedCars.get(g).getTransmission()+" 2.Brakes: "+this.ownedCars.get(g).getBrakes()+" 3.Suspension: "+this.ownedCars.get(g).getSuspension()+" 4.Body: "+this.ownedCars.get(g).getBody()+" 5.Engine: "+this.ownedCars.get(g).getEngine());
        System.out.println("From the list of the parts what part you want to repair: ");
        int x =sc.nextInt();
        if (this.getCash() > rCash) {
            this.moves +=1;
            if (x == 1 && !this.ownedCars.get(g).getTransmission()) {
                this.cash = this.cash - rCash;
                this.ownedCars.get(g).setTransmission(true);
                this.ownedCars.get(g).setValue(this.ownedCars.get(g).getValue() * 1.5);
                this.historyR(this.ownedCars.get(g).getManufacturer(), who, "transmission", rCash);

            } else if (x == 2 && !this.ownedCars.get(g).getBrakes()) {
                this.cash = this.cash - rCash;
                this.ownedCars.get(g).setBrakes(true);
                this.ownedCars.get(g).setValue(this.ownedCars.get(g).getValue() * 1.1);
                this.historyR(this.ownedCars.get(g).getManufacturer(), who, "brakes", rCash);

            } else if (x == 3 && !this.ownedCars.get(g).getSuspension()) {
                this.cash = this.cash - rCash;
                this.ownedCars.get(g).setSuspension(true);
                this.ownedCars.get(g).setValue(this.ownedCars.get(g).getValue() * 1.2);
                this.historyR(this.ownedCars.get(g).getManufacturer(), who, "suspension", rCash);

            } else if (x == 4 && !this.ownedCars.get(g).getBody()) {
                this.cash = this.cash - rCash;
                this.ownedCars.get(g).setBody(true);
                this.ownedCars.get(g).setValue(this.ownedCars.get(g).getValue() * 1.5);
                this.historyR(this.ownedCars.get(g).getManufacturer(), who, "body", rCash);

            } else if (x == 5 && !this.ownedCars.get(g).getEngine()) {
                this.cash = this.cash - rCash;
                this.ownedCars.get(g).setEngine(true);
                this.ownedCars.get(g).setValue(this.ownedCars.get(g).getValue() * 2);
                this.historyR(this.ownedCars.get(g).getManufacturer(), who, "engine", rCash);

            } else {
                System.out.println("Please give proper numbers!(You cant repair something that's not broken(true))");
            }
        }
        else System.out.println("You can't afford the repair");
    }
    public void repairMarian(Integer g) throws Exception {
        if (a1(g)){
            throw new Exception("Wrong Car ID!");
        }
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
    public void repairAdrian(Integer g) throws Exception {
        if (a1(g)){
            throw new Exception("Wrong Car ID!");
        }
        int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
        if (randomNum >=1 && randomNum <=10){
            System.out.println("Adrian didn't fix the part.");
        }
        else if (randomNum >= 11 && randomNum <= 12){

            if(this.ownedCars.get(g).getEngine()){
            System.out.println("Adrian broke the engine :(");
            this.ownedCars.get(g).setEngine(false);
            }
            else if(this.ownedCars.get(g).getBody()){
                System.out.println("Adrian broke the body :(");
                this.ownedCars.get(g).setBody(false);
            }
            else if(this.ownedCars.get(g).getBrakes()){
                System.out.println("Adrian broke the brakes :(");
                this.ownedCars.get(g).setBrakes(false);
            }else if(this.ownedCars.get(g).getSuspension()){
                System.out.println("Adrian broke the suspension :(");
                this.ownedCars.get(g).setSuspension(false);
            }
            else if(this.ownedCars.get(g).getTransmission()){
                System.out.println("Adrian broke the transmission :(");
                this.ownedCars.get(g).setTransmission(false);
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
        double ta = this.allCars.get(t).getValue() * 0.02;
        this.cash = this.cash - ta;
        System.out.println("Tax has been paid! IRS is not looking for you, yet !"+ta);
    }
    public void cash(){
        System.out.println("Your cash: "+this.cash);
    }
    public void sumRAW(){
        System.out.println("What car do you want to see the sum of repairs and washes?");
        int i= sc.nextInt();
        if(a1(i)){
            System.out.println("You don't have a car/wrong Car ID.");
        }
        else
        System.out.println("Sum of repairs and washes for car with Id: "+i+"Cash: "+this.ownedCars.get(i).getSum());
    }
    public void AD(){
        int randomNum = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
        int randomNum1 = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
        int randomNum2 = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
        System.out.println("What type of Ad you want to run? 1.Newspaper AD / 2.Internet AD");
        int i= sc.nextInt();
        if (this.getCash() > 500.00) {
            this.moves +=1;
            if (i == 1) {
                System.out.println("Newspaper AD");
                this.cash = this.cash - 1000.00;
                this.clients.add(this.allClients.get(randomNum));
                this.clients.add(this.allClients.get(randomNum1));
            } else if (i == 2) {
                System.out.println("Internet AD");
                this.cash = this.cash - 500.00;
                this.clients.add(this.allClients.get(randomNum2));
            } else {
                System.out.println("Please put a proper number!");
            }
        }
        else System.out.println("You can't afford the AD!");
    }
    public boolean a1(Integer j){
        return (this.ownedCars.size() - 1) < j;
    }
    public boolean a2(Integer j){
        return (this.clients.size() -1) < j;
    }
    public void sell(){
    System.out.println("Write the Id of the car you want to sell: ");
        int i= sc.nextInt();
        System.out.println("To whom are you selling that car, Id: ");
        int g= sc.nextInt();

        if (a1(i)){
            System.out.println("Wrong Car ID, try again.");
        }
        else if (a2(g)){
            System.out.println("Wrong Client ID, try again.");
        }
        else if(clients.get(g).getcCash() < this.ownedCars.get(i).getValue()){
            System.out.println("Potential buyer cant afford that car!");
        }
        else if(this.clients.get(g).getBrokenS() == this.ownedCars.get(i).getSuspension() || (!this.ownedCars.get(i).getEngine() || !this.ownedCars.get(i).getBrakes() || !this.ownedCars.get(i).getBody() || !this.ownedCars.get(i).getTransmission())){
        System.out.println("This potential buyer only buys with broken suspension or working Cars!");
        }
        else if (this.clients.get(g).getBroken() ==(this.ownedCars.get(i).getTransmission() && this.ownedCars.get(i).getBody() && this.ownedCars.get(i).getSuspension() && this.ownedCars.get(i).getEngine() && this.ownedCars.get(i).getBrakes()) ) {
            System.out.println("This potential buyer doesn't buy broken cars");
        }
        else if (this.ownedCars.get(i).getClass().getName() != this.clients.get(g).getType()){
            System.out.println("Potential buyer doesn't want the car type you are selling!");
        }
        else if (!clients.get(g).getiMark1().equals(this.ownedCars.get(i).getManufacturer())) {
            System.out.println("Potential buyer doesn't want the car you are selling.1");
            if (!clients.get(g).getiMark2().equals(this.ownedCars.get(i).getManufacturer())) {
                System.out.println("Potential buyer doesn't want the car you are selling.2");
            }
        }
        else {
            int randomNum = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
            int randomNum1 = ThreadLocalRandom.current().nextInt(1, this.allClients.size());
            this.clients.add(this.allClients.get(randomNum));
            this.clients.add(this.allClients.get(randomNum1));
            System.out.println(this.ownedCars.get(i).getClass().getName());
            this.setCash(this.getCash()+this.ownedCars.get(i).getValue());
            this.tHistoryS(this.ownedCars.get(i),this.clients.get(g),this.ownedCars.get(i).getValue(),"sold");
            this.carWash(i);
            this.tax(i);
            this.moves +=1;
            this.clients.get(g).setcCash(this.clients.get(g).getcCash() - this.ownedCars.get(i).getValue());
            this.ownedCars.remove(i);
            System.out.println("Car sold to a potential buyer.");

        }
    }
    public void tHistoryS(Cars car,Clients client,Double price,String sb){
        this.historyT.add("Car: "+car.getManufacturer()+" Client: "+client+" Price: "+price+" Action: "+sb);
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