package org.example;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chandini", "kritter", "kritter");
            Statement stmt = con.createStatement();
            stmt.execute("update Employee set empId=1 where empId=4");
            // int check=stmt.executeUpdate("insert into Employee values(1,'krishna','radha')");
            ResultSet otp=stmt.executeQuery("select * from Employee");
            while(otp.next()){
                System.out.println(otp.getInt("empId")+" "+
                        otp.getString("LastName")+" "+otp.getString("FirstName"));
            }
            PreparedStatement pS=con.prepareStatement("insert into Salary values (?,?,?)");
            pS.setInt(1,10000);
            pS.setString(2,"e001");
            pS.setInt(3,1);
            //pS.executeUpdate();
            ResultSet rS1=stmt.executeQuery("select * from Salary");

            while(rS1.next()){
                System.out.println(rS1.getInt("salary")+" "+
                        rS1.getString("payId")+" "+rS1.getInt("empId"));
            }
            con.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}