package Cars;
import java.util.*;
import Mechanics.*;
import com.company.*;
import Clients.*;
import java.util.Scanner;
public abstract class Cars {
    public Double value;
    public String manufacturer;
    public Integer mileage;
    public String colour;
    public String type;
    public Boolean engine;
    public Boolean suspension;
    public Boolean body;
    public Boolean brakes;
    public Boolean transmission;
    private Double sum = 0.00;
    Scanner sc= new Scanner(System.in);
    public Cars(Double value,String manufacturer,Integer mileage,String colour,String type,Boolean engine,Boolean suspension,Boolean body,Boolean brakes,Boolean transmission){
        this.value = value;
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.colour = colour;
        this.type = type;
        this.engine = engine;
        this.suspension = suspension;
        this.body = body;
        this.brakes = brakes;
        this.transmission = transmission;
    }
    public double getSum(){
        return this.sum;
    }
    public void setSum(double newSum){
        this.sum = newSum;
    }

}
