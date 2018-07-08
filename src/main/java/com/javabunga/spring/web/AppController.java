package com.javabunga.spring.web;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    private Connection getConnection() throws SQLException {
        String hostName = "ran-db.database.windows.net";
        String dbName = "IvoryDB";
        String user = "rants";
        String password = "tsurRan01";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);

        Connection connection = DriverManager.getConnection(url);
        return connection;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/allData")
    public List<Customer> getAllData() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Customers";
        ResultSet resultSet = statement.executeQuery(query);
        List<Customer> customers = new ArrayList<Customer>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCode(resultSet.getInt(1));
            customer.setEname(resultSet.getString(3));
            customer.setHname(resultSet.getString(2));
            customer.setCity(resultSet.getString(4));
            customer.setStreet(resultSet.getString(5));
            customer.setHomeNumber(resultSet.getString(6));
            customer.setPhone(resultSet.getString(7));
            customer.setActivity_status_code(resultSet.getInt(8));
            customer.setTimestamp(resultSet.getTimestamp(9));
            customers.add(customer);
        }
        return customers;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/register")
    public void register(@RequestBody Customer customer) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?,?,1,?)");

        stmt.setString(1, customer.getHname());
        stmt.setString(2, customer.getEname());
        stmt.setString(3, customer.getCity());
        stmt.setString(4, customer.getStreet());
        stmt.setString(5, customer.getHomeNumber());
        stmt.setString(6, customer.getPhone());
        stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
        stmt.executeUpdate();
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/edit")
    public void update (@RequestBody Customer customer) throws SQLException
    {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("UPDATE Customers Set Name_Heb=?, Name_Eng=?, City=?, Street=?, Home_Number=?, Phone=?, Timestamp=? Where Code=?  ");

        stmt.setString(1, customer.getHname());
        stmt.setString(2, customer.getEname());
        stmt.setString(3, customer.getCity());
        stmt.setString(4, customer.getStreet());
        stmt.setString(5, customer.getHomeNumber());
        stmt.setString(6, customer.getPhone());
        stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
        stmt.setInt(8,customer.getCode());
        stmt.executeUpdate();
    }
}
