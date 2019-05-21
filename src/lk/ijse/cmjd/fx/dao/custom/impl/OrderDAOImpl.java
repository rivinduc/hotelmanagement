package lk.ijse.cmjd.fx.dao.custom.impl;

import lk.ijse.cmjd.fx.dao.custom.OrderDAO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.entity.Customer;
import lk.ijse.cmjd.fx.entity.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {


    @Override
    public Order find(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Orders WHERE id=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Order(
                    rst.getString("id"),
                    rst.getString("customerId"),
                    rst.getString("itemCode"),
                    rst.getString("qtyOnHand"),
                    rst.getDate("date1"),
                    rst.getString("customerName"),
                    rst.getString("discription"),
                    rst.getString("unitePrice"),
                    rst.getString("qty"),
                    rst.getString("total")
            );
        }
        return null;
    }

    @Override
    public List<Order> findAll() throws Exception {
        ArrayList<Order> alOrders = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Orders");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String id = rst.getString(1);
            String customerId = rst.getString(2);
            String itemCode = rst.getString(3);
            String qtyOnHand =rst.getString(4);
            Date date1 = rst.getDate(5);
            String customerName =rst.getString(6);
            String discription =rst.getString(7);
            String unitePrice =rst.getString(8);
            String qty =rst.getString(9);
            String total =rst.getString(10);
            Order order = new Order(
                    id,
                    customerId,
                    itemCode,
                    qtyOnHand,
                    date1,
                    customerName,
                    discription,
                    unitePrice,
                    qty,
                    total
            );
            alOrders.add(order);
        }
        return alOrders;
    }

    @Override
    public boolean save(Order order) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Orders VALUES (?,?,?,?,?,?,?,?,?,?)");
        pstm.setObject(1, order.getId());
        pstm.setObject(2, order.getCustomerId());
        pstm.setObject(3, order.getItemCode());
        pstm.setObject(4, order.getQtyOnHand());
        pstm.setObject(5, order.getDate1());
        pstm.setObject(6,order.getCustomerName());
        pstm.setObject(7,order.getDiscription());
        pstm.setObject(8, order.getUnitePrice());
        pstm.setObject(9, order.getQty());
        pstm.setObject(10, order.getTotal());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Order order) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Orders SET customerId=?, " +
                "itemCode=? ,qtyOnHand=?,date1=?,customerName=?," +
                "discription=?,unitePrice=?,qty=?,total=? WHERE id=?");
        pstm.setObject(10, order.getId());
        pstm.setObject(1, order.getCustomerId());
        pstm.setObject(2, order.getItemCode());
        pstm.setObject(3, order.getQtyOnHand());
        pstm.setObject(4, order.getDate1());
        pstm.setObject(5, order.getCustomerName());
        pstm.setObject(6, order.getDiscription());
        pstm.setObject(7, order.getUnitePrice());
        pstm.setObject(8, order.getQty());
        pstm.setObject(9, order.getTotal());
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Orders WHERE id=?");
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
