package lk.ijse.cmjd.fx.dao;

import lk.ijse.cmjd.fx.dao.custom.CustomerDAO;
import lk.ijse.cmjd.fx.dao.custom.impl.*;
import lk.ijse.cmjd.fx.entity.Banquet;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,BANQUET,ORDER_DETAIL,QUERY,CLEAN;
    }

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case BANQUET:
                return new BanquetDAOImpl();
            case CLEAN:
                return new CleanDAOImpl();
            default:
                return null;
        }
    }


}
