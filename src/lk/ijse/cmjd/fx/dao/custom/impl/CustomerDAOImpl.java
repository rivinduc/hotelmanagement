package lk.ijse.cmjd.fx.dao.custom.impl;

import lk.ijse.cmjd.fx.dao.custom.CustomerDAO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.entity.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer find(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getString("days"),
                    rst.getDate("Date2"),
                    rst.getDate("Date1"),
                    rst.getString("rn"),
                    rst.getString("daysi"),
                    rst.getString("f1"),
                    rst.getString("f3"),
                    rst.getString("f2"),
                    rst.getString("label31")
            );
        }
        return null;
    }

    public List<Customer> findAll() throws Exception {
        ArrayList<Customer> alCustomerS = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String email =rst.getString(4);
            String days =rst.getString(5);
            Date Date2 = rst.getDate(6);
            Date Date1 = rst.getDate(7);
            String rn =rst.getString(8);
            String daysi =rst.getString(9);
            String f1 =rst.getString(10);
            String f3 =rst.getString(11);
            String f2 =rst.getString(12);
           String label31 = rst.getString(13);
            Customer customer = new Customer(
                    id,
                    name,
                    address,
                    email,
                    days,
                    Date2,
                    Date1,
                    rn,
                    daysi,
                    f1,
                    f3,
                    f2,
                    label31
            );
            alCustomerS.add(customer);
        }
        return alCustomerS;
    }

    public boolean save(Customer customer) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pstm.setObject(1, customer.getId());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, customer.getEmail());
        pstm.setObject(5, customer.getDays());
        pstm.setObject(6,customer.getDate2());
        pstm.setObject(7,customer.getDate1());
        pstm.setObject(8, customer.getRn());
        pstm.setObject(9, customer.getDaysi());
        pstm.setObject(10, customer.getF1());
        pstm.setObject(11,customer.getF3());
        pstm.setObject(12,customer.getF2());
        pstm.setObject(13,customer.getLabel31());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Customer customer) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement
                ("UPDATE Customer SET name=?," +
                " address=? ,email=? , days = ?," +
                "date2 =? ,date1=? ,rn=? ,daysi=? ," +
                "f1 =? ,f3= ? , f2 = ? ,label31= ?" +
                " WHERE id=?");
        pstm.setObject(13, customer.getId());
        pstm.setObject(1, customer.getName());
        pstm.setObject(2, customer.getAddress());
        pstm.setObject(3, customer.getEmail());
        pstm.setObject(4, customer.getDays());
        pstm.setObject(5,customer.getDate2());
        pstm.setObject(6,customer.getDate1());
        pstm.setObject(7, customer.getRn());
        pstm.setObject(8,customer.getDaysi());
        pstm.setObject(9,customer.getF1());
        pstm.setObject(10,customer.getF3());
        pstm.setObject(11,customer.getF2());
        pstm.setObject(12,customer.getLabel31());

        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String customerId) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setObject(1, customerId);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }

}
