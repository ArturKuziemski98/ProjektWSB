package Cars;
import com.company.*;
import Mechanics.*;

public class DeliveryTruck extends Cars {
    private Integer load;
    public DeliveryTruck(Double value,String manufacturer,Integer mileage,String colour,String type,Integer load){
        super(value,manufacturer,mileage,colour,type);
        this.load = load;
    }


}
