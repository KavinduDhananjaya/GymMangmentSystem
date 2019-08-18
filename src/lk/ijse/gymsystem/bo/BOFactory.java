package lk.ijse.gymsystem.bo;

import lk.ijse.gymsystem.bo.custom.impl.*;

public class BOFactory {


    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }

        return boFactory;

    }

    public enum BOTyepes {
        CUSTOMER, PAYMENT, ACCESSORIES, MEASURMENT, INSTRUCTOR, ATTENDANCE, SCHEDULE, QUERY;
    }

    public SuperBO getBO(BOTyepes types) {
        switch (types) {

            case CUSTOMER:
                return new CustomerBOImpl();

            case PAYMENT:
                return new PaymentBOImpl();

            case ACCESSORIES:
                return new AccessoriesBOImpl();

            case MEASURMENT:
                return new MeasurmentBOImpl();

            case INSTRUCTOR:
                return new InscructorsBOImpl();

            case ATTENDANCE:
                return new AttendanceBOImpl();

            case SCHEDULE:
                return new ScheduleBOImpl();
            case QUERY:
                return new QueryBOImpl();


            default:
                return null;
        }
    }
}
