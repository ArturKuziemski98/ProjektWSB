package Cars;

public class DeliveryTruck extends Cars {
    private Integer load;
    public DeliveryTruck(Double value,String manufacturer,Integer mileage,String colour,String type,Integer load,Boolean engine,Boolean suspension,Boolean body,Boolean brakes,Boolean transmission){
        super(value,manufacturer,mileage,colour,type,engine,suspension,body,brakes,transmission);
        this.load = load;
    }


}
