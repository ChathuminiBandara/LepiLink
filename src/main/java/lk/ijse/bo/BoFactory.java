package lk.ijse.bo;

import lk.ijse.bo.Custom.Impl.CustomerBOImpl;
import lk.ijse.bo.Custom.Impl.ItemBOImpl;
import lk.ijse.bo.Custom.Impl.PlaceOrderBOImpl;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){

    }
    public static BoFactory getBoFactory(){
        return (boFactory==null)?boFactory=
                new BoFactory():boFactory;

    }
    public enum BOTypes{
        CUSTOMER,ITEM,PLACE_ORDER
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
