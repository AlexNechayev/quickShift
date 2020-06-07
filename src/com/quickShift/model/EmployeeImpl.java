package com.quickShift.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmployeeImpl {
    private Login login;
    private Date hireDate;
    private String mangerName;
    private int departmentNumber;
    private String description;
    private ContactInfo contactInfo;
    private Boolean mangerPosition;

    public EmployeeImpl(Date hireDate, String mangerName, int departmentNumber, String description, ContactInfo contactInfo, Login login, boolean mangerPosition)
    {
        this.login = login;
        this.hireDate = hireDate;
        this.mangerName = mangerName;
        this.departmentNumber = departmentNumber;
        this.description = description;
        this.contactInfo = contactInfo;
        this.mangerPosition = mangerPosition;
    }

    public boolean isManger(){
        Connection con = ConnectionManager.getConnection();
        int id = this.contactInfo.getId();
        int checkedId = -1;

        try{
            String sql = "SELECT * FROM manger_info WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            rs.next();

            checkedId = rs.getInt("id");
            if(checkedId == this.contactInfo.getId()) return true;


        }catch(SQLException e){
            System.out.println("Unable to retrieve data from DB");
            return false;
        }
        return true;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Login getLogin(){return login;}

    public void setLogin(Login login){this.login = login;}

    public void updateClient() {
        Connection con = ConnectionManager.getConnection();

        String username = this.login.getUsername();
        String password = this.login.getPassword();

        try {
            String query = "UPDATE login_info SET username = ?, password = ? WHERE username = ?";
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1,username);
            prepStmt.setString(2,password);
            prepStmt.setString(3,username);
            prepStmt.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    //Check if the given username and password is in the database (SQL QUERY)
    public boolean checkIfValid(){
        Connection con = ConnectionManager.getConnection();

        String username = null;
        String password = null;

        try{
            String sql = "SELECT * FROM login_info WHERE username = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,login.getUsername());
            ResultSet rs = st.executeQuery();
            rs.next();
            username =  rs.getString("username");
            password =  rs.getString("password");
            return (username.equals(this.login.getUsername()) && password.equals(this.login.getPassword()));


        }catch(SQLException e){
            System.out.println("Unable to login");
        }

        return false;
    }


    ////////////////////////////////////////////     Getters and Setters     ///////////////////////////////////////////
    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getMangerName() {
        return mangerName;
    }
    public void setMangerName(String mangerName) {
        this.mangerName = mangerName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }
    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMangerPosition() {
        return mangerPosition;
    }
    public void setMangerPosition(Boolean mangerPosition) {
        this.mangerPosition = mangerPosition;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Employee{" +
                "hireDate=" + hireDate +
                ", mangerName='" + mangerName + '\'' +
                ", departmentNumber=" + departmentNumber +
                ", description='" + description + '\'' +
                ", contact Info=" + contactInfo.toString() +
                '}';
    }
}