package lk.ijse.dao;

import lk.ijse.dao.Custom.Impl.*;

public class DAOFactory {
        private static DAOFactory daoFactory;
        private DAOFactory(){
        }
        public static DAOFactory getDaoFactory(){
            return (daoFactory==null)?daoFactory
                    =new DAOFactory():daoFactory;
        }

        public enum DAOTypes{
            BUTTERFLY,CUSTOMER,EMPLOYEE,EMPLOYEE_SCHEDULE,ITEM,ORDER,ORDER_DETAIL,PAYMENT,PLACE_ORDER,SALARY,SUPPLIER,VISITOR
        }
        public SuperDAO getDAO(DAOTypes daoTypes){
            switch (daoTypes){
                case BUTTERFLY:
                    return new ButterflyDaoImpl();
                case CUSTOMER:
                    return new CustomerDaoImpl();
                case EMPLOYEE:
                    return new EmployeeDaoImpl();
                case EMPLOYEE_SCHEDULE:
                    return new empScheduleDaoImpl();
                case ITEM:
                    return new ItemDaoImpl();
                case ORDER:
                    return new OrderDaoImpl();
                 case ORDER_DETAIL:
                    return new OrderDetailDaoImpl();
                case PAYMENT:
                    return new paymentDaoImpl();
                case PLACE_ORDER:
                    return new PlaceOrderDaoImpl();
                case SALARY:
                    return new salaryDaoImpl();
                case SUPPLIER:
                    return new supplierDaoImpl();
                case VISITOR:
                    return new visitorDaoImpl();
                default:
                    return null;
            }
        }

    }

