package com.quickShift.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmployeeImpl implements Employee {
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

    //Employee constructor that receive Login as argument pull all the Employee data from the DB (SQL QUERY)
    public EmployeeImpl(Login login){
        Connection con = ConnectionManager.getConnection();
        this.login = new Login();
        this.contactInfo = new ContactInfo();
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
            if(username.equals(login.getUsername()) && password.equals(login.getPassword())){
                System.out.println("Valid");
                this.login.setId(rs.getInt("id"));
                this.login.setUsername(username);
                this.login.setPassword(password);
                sql = "SELECT * from user_info WHERE id = ?";
                 st = con.prepareStatement(sql);
                st.setString(1,String.valueOf(this.login.getId()));
                rs = st.executeQuery();
                rs.next();
                this.contactInfo.setId(rs.getInt("id"));
                this.contactInfo.setFirstName(rs.getString("first_name"));
                this.contactInfo.setLastName(rs.getString("last_name"));
                this.contactInfo.setGender(rs.getString("gender"));
                this.contactInfo.setAddress(rs.getString("address"));
                this.contactInfo.setPhoneNumber(rs.getString("phone"));
                this.contactInfo.setEmail(rs.getString("email"));
                this.contactInfo.setBirthDayDate(rs.getDate("birthday"));
                this.setHireDate(rs.getDate("hire_date"));
                this.setDepartmentNumber(rs.getInt("department_number"));
                this.setMangerName(rs.getString("manger_name"));
                this.setDescription(rs.getString("description"));
            }
        }catch(SQLException e){
            System.out.println("Unable to retrieve data from DB");
        }

    }

    //Adding a new employee which takes all the variables and insert it to the DB (SQL QUERY)
    public void insertNewEmployee(){
        Connection con = ConnectionManager.getConnection();

        int id = this.login.getId();
        String username = this.login.getUsername();
        String password = this.login.getPassword();

        String firstName = this.contactInfo.getFirstName();
        String lastName = this.contactInfo.getLastName();
        String gender = this.contactInfo.getGender();
        String address = this.contactInfo.getAddress();
        String phone = this.contactInfo.getPhoneNumber();
        String email = this.contactInfo.getEmail();
        java.sql.Date birthDay = convertUtilToSql(this.contactInfo.getBirthDayDate());
        java.sql.Date hireDate = convertUtilToSql(this.getHireDate());
        int departmentNumber = this.departmentNumber;
        String mangerName = this.mangerName;
        String description = this.description;

        try{
            String query = "INSERT INTO user_info(id,first_name,last_name,gender,address,phone,email,birthday,hire_date,department_number,manger_name,description) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepStmt = con.prepareStatement(query);

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
            prepStmt.executeUpdate();
            prepStmt.close();

            query = "INSERT INTO login_info (id,username,password) VALUES (?,?,?)";
            prepStmt = con.prepareStatement(query);

            prepStmt.setInt(1,id);
            prepStmt.setString(2,username);
            prepStmt.setString(3,password);
            prepStmt.executeUpdate();
            prepStmt.close();

            if(this.mangerPosition){
                query = "INSERT INTO manger_info (id) VALUES (?)";
                prepStmt = con.prepareStatement(query);

                prepStmt.setInt(1,id);
                prepStmt.executeUpdate();
                prepStmt.close();
            }


        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
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


    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        return new java.sql.Date(uDate.getTime());
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