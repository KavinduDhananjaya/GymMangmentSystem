package lk.ijse.gymsystem.dao;

import lk.ijse.gymsystem.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes {
        CUSTOMER,PAYMENT,ACCESSORIES,MEASURMENT,INSTRUCTOR,ATTENDANCE,SCHEDULE,QUERYDAO;
    }

    public  SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case ACCESSORIES:
                return new AccessoriesDAOImpl();
            case MEASURMENT:
                return new MeasurmentDAOImpl();
            case INSTRUCTOR:
                return new InstructorsDAOImpl();
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case SCHEDULE:
                return new ScheduleDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();










            default:
                return null;
        }
    }

}
