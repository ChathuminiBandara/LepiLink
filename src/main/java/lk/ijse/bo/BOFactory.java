package lk.ijse.bo;

public class BOFactory {


        private static BOFactory bOFactory;
        private BOFactory(){

        }
        public static BOFactory getBoFactory(){
            return (bOFactory==null)?bOFactory=
                    new BOFactory():bOFactory;

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
