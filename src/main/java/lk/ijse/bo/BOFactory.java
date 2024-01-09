package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=
                new BOFactory():boFactory;

    }
    public enum BOTypes{ BUTTERFLY,CUSTOMER,EMPLOYEE,EMPLOYEE_SCHEDULE,ITEM,ORDER,ORDER_DETAIL,PAYMENT,PLACE_ORDER,SALARY,SUPPLIER,VISITOR }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case BUTTERFLY:
                return new ButterflyBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case EMPLOYEE_SCHEDULE:
                return new EmpScheduleBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case ORDER_DETAIL:
                return new OrderDetailBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case VISITOR:
                return new VisitoBOImpl();
            default:
                return null;
        }
    }

}
