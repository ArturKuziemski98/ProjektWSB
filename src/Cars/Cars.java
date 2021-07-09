package Cars;
import java.util.Scanner;
public abstract class Cars {
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    private Double value;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String manufacturer;
    private Integer mileage;
    private String colour;
    private String type;

    public Boolean getEngine() {
        return engine;
    }

    public void setEngine(Boolean engine) {
        this.engine = engine;
    }

    private Boolean engine;

    public Boolean getSuspension() {
        return suspension;
    }

    public void setSuspension(Boolean suspension) {
        this.suspension = suspension;
    }

    private Boolean suspension;

    public Boolean getBody() {
        return body;
    }

    public void setBody(Boolean body) {
        this.body = body;
    }

    private Boolean body;

    public Boolean getBrakes() {
        return brakes;
    }

    public void setBrakes(Boolean brakes) {
        this.brakes = brakes;
    }

    private Boolean brakes;

    public Boolean getTransmission() {
        return transmission;
    }

    public void setTransmission(Boolean transmission) {
        this.transmission = transmission;
    }

    private Boolean transmission;
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
