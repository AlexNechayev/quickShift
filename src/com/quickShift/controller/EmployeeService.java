package com.quickShift.controller;

import com.quickShift.model.*;

import javax.swing.*;
import java.sql.*;

public class EmployeeService extends JFrame implements Employee {
    private Connection connection;

    public EmployeeService(){

    }

    @Override
    //Employee constructor that receive Login as argument pull all the Employee data from the DB (SQL QUERY)
    public EmployeeImpl loginEmployee(String username,String password){
        connection = ConnectionManager.getConnection();

        String dbUsername = null;
        String dbPassword = null;
        int dbId;

        try{
            String sql = "SELECT * FROM login_info WHERE username = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            rs.next();
            dbUsername =  rs.getString("username");
            dbPassword =  rs.getString("password");
            if(username.equals(dbUsername) && password.equals(dbPassword)){
                dbId = rs.getInt("id");
                st.execute();
                st.close();
                sql = "SELECT * FROM user_info WHERE id = ?";
                st = connection.prepareStatement(sql);
                st.setInt(1,dbId);
                rs = st.executeQuery();
                rs.next();

                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setId(dbId);
                contactInfo.setFirstName(rs.getString("first_name"));
                contactInfo.setLastName(rs.getString("last_name"));
                contactInfo.setGender(rs.getString("gender"));
                contactInfo.setAddress(rs.getString("address"));
                contactInfo.setPhoneNumber(rs.getString("phone"));
                contactInfo.setEmail(rs.getString("email"));
                contactInfo.setBirthDayDate(rs.getDate("birthday"));

                Login login = new Login();
                login.setId(dbId);
                login.setUsername(dbUsername);
                login.setPassword(dbPassword);

                boolean mangerPosition = rs.getBoolean("MangerPosition");
                String description = rs.getString("description");
                String mangerName = rs.getString("manger_name");
                Date hireDate = rs.getDate("hire_date");
                int departmentNumber = rs.getInt("department_number");

                return new EmployeeImpl(hireDate,mangerName,departmentNumber,description,contactInfo,login,mangerPosition);

            }
        }catch(SQLException ex){
            System.out.println("Unable to login");
        }
        return null;
    }

    @Override
    //Adding a new employee which takes all the variables and insert it to the DB (SQL QUERY)
    public void addEmployee(EmployeeImpl e) {
        connection = ConnectionManager.getConnection();

        int id = e.getLogin().getId();
        String username = e.getLogin().getUsername();
        String password = e.getLogin().getPassword();

        String firstName = e.getContactInfo().getFirstName();
        String lastName = e.getContactInfo().getLastName();
        String gender = e.getContactInfo().getGender();
        String address = e.getContactInfo().getAddress();
        String phone = e.getContactInfo().getPhoneNumber();
        String email = e.getContactInfo().getEmail();
        java.sql.Date birthDay = convertUtilToSql(e.getContactInfo().getBirthDayDate());
        java.sql.Date hireDate = convertUtilToSql(e.getHireDate());
        int departmentNumber = e.getDepartmentNumber();
        String mangerName = e.getMangerName();
        String description = e.getDescription();
        boolean mangerPosition = e.getMangerPosition();

        try{
            String query = "INSERT INTO user_info(id,first_name,last_name,gender,address,phone,email,birthday,hire_date,department_number,manger_name,description,mangerPosition) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepStmt = connection.prepareStatement(query);

            prepStmt.setInt(1,id);
            prepStmt.setString(2,firstName);
            prepStmt.setString(3,lastName);
            prepStmt.setString(4,gender);
            prepStmt.setString(5,address);
            prepStmt.setString(6,phone);
            prepStmt.setString(7,email);
            prepStmt.setDate(8,birthDay);
            prepStmt.setDate(9,hireDate);
            prepStmt.setInt(10,departmentNumber);
            prepStmt.setString(11,mangerName);
            prepStmt.setString(12,description);
            if(mangerPosition) prepStmt.setBoolean(13,true);
            else prepStmt.setBoolean(13,false);
            prepStmt.executeUpdate();
            prepStmt.close();

            query = "INSERT INTO login_info (id,username,password) VALUES (?,?,?)";
            prepStmt = connection.prepareStatement(query);

            prepStmt.setInt(1,id);
            prepStmt.setString(2,username);
            prepStmt.setString(3,password);
            prepStmt.executeUpdate();
            prepStmt.close();


        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(EmployeeImpl e) {
        Connection con = ConnectionManager.getConnection();

        try {
            String query = "UPDATE login_info SET username = ?, password = ? WHERE id = ?";
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1,e.getLogin().getUsername());
            prepStmt.setString(2,e.getLogin().getPassword());
            prepStmt.setInt(3,e.getLogin().getId());
            prepStmt.execute();
            prepStmt.close();

            query = "UPDATE user_info SET first_name = ?, last_name = ?, gender = ?, address = ?, phone = ?, email = ?, birthday = ?, hire_date = ?, department_number = ?, manger_name = ?, description = ?, mangerPosition = ? WHERE id = ?";
            prepStmt = con.prepareStatement(query);
            prepStmt.setString(1,e.getContactInfo().getFirstName());
            prepStmt.setString(2,e.getContactInfo().getLastName());
            prepStmt.setString(3,e.getContactInfo().getGender());
            prepStmt.setString(4,e.getContactInfo().getAddress());
            prepStmt.setString(5,e.getContactInfo().getPhoneNumber());
            prepStmt.setString(6,e.getContactInfo().getEmail());
            prepStmt.setDate(7,convertUtilToSql(e.getContactInfo().getBirthDayDate()));
            prepStmt.setDate(8,convertUtilToSql(e.getHireDate()));
            prepStmt.setInt(9,e.getDepartmentNumber());
            prepStmt.setString(10,e.getMangerName());
            prepStmt.setString(11,e.getDescription());
            prepStmt.setBoolean(12,e.getMangerPosition());
            prepStmt.setInt(13,e.getLogin().getId());
            prepStmt.execute();
            prepStmt.close();


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(EmployeeImpl e) {
        connection = ConnectionManager.getConnection();

        int id = e.getContactInfo().getId();

        try{
            String query = "DELETE FROM user_info WHERE id = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1,id);
            prepStmt.executeUpdate();
            prepStmt.close();

            query = "DELETE FROM login_info WHERE id = ?";
            prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1,id);
            prepStmt.executeUpdate();
            prepStmt.close();

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(String username) {
        connection = ConnectionManager.getConnection();

        int id;

        try{
            String query = "SELECT * FROM login_info WHERE username = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1,username);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            id =  rs.getInt("id");
            prepStmt.execute();
            prepStmt.close();

            query = "DELETE FROM user_info WHERE id = ?";
            prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1,id);
            prepStmt.execute();
            prepStmt.close();

            query = "DELETE FROM login_info WHERE id = ?";
            prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1,id);
            prepStmt.execute();
            prepStmt.close();

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
    }

    @Override
    public boolean isUsernameAvailable(String givenUsername) {
        connection = ConnectionManager.getConnection();
        String username = null;
        try{
            String query = "SELECT * FROM login_info WHERE username = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1,givenUsername);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            username = rs.getString("username");
            prepStmt.execute();
            prepStmt.close();

            if(username != null) return false;

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isEmailAvailable(String givenEmail) {
        connection = ConnectionManager.getConnection();
        String email = null;
        try{
            String query = "SELECT * FROM user_info WHERE email = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1,givenEmail);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            email = rs.getString("email");
            prepStmt.execute();
            prepStmt.close();

            if(email != null) return false;

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isPhoneAvailable(String givenPhone) {
        connection = ConnectionManager.getConnection();
        String phone = null;
        try{
            String query = "SELECT * FROM user_info WHERE phone = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1,givenPhone);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            phone = rs.getString("email");
            prepStmt.execute();
            prepStmt.close();

            if(phone != null) return false;

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return true;
    }

    public JComboBox<String> employeeList(){
        JComboBox<String> employeeListCBox = new JComboBox<String>();
        connection = ConnectionManager.getConnection();


        try{
            String query = "SELECT * FROM user_info";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt = connection.prepareStatement(query);

            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()) {
                employeeListCBox.addItem(rs.getString("first_name"));
            }
            prepStmt.execute();
            prepStmt.close();

            return employeeListCBox;

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }

        return null;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        return new java.sql.Date(uDate.getTime());
    }
}
