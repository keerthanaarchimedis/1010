


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author 91805
 */
@WebServlet(urlPatterns="/fetchAll")
public class fetchall extends HttpServlet{
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        String filter = request.getParameter("filter");
    // JDBC driver name and database URL
        final String DB_URL="jdbc:mysql://localhost:3306/project?allowPublicKeyRetrieval=true&useSSL=false";
       
    // Database credentials(username&password)
       final String USER = "root";
       final String PASS = "keerthana10#";
       
       try {
    // Loading & Registering the JDBC driver
       Class.forName("com.mysql.cj.jdbc.Driver");



    // Establishing a connection between(javaapp&Ds)
       Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);


       String city = request.getParameter("filter");
    // Send & Execute SQL query
       Statement stmt = conn.createStatement();
       String sql = "select * from student ";


   //Gathering the Result set from Ds
      ResultSet rs = stmt.executeQuery(sql);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fetch Data Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border=1 width=100% height=100%>");
        out.println("<tr><th>Name</th><th>Roll_No</th><th>City</th><th>Age</th><tr>");
     // Extract data from result set
        while(rs.next()){
        String name = rs.getString("Name");
        int roll_no = rs.getInt("ROLL_NO");
        String city1 = rs.getString("CITY");
        int age = rs.getInt("AGE");

        out.println("<tr><td>" + name + "</td><td>" + roll_no + "</td><td>"+
        city1 + "</td><td>"+age + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body></html>");



    // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
        } catch(SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
        } catch(Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
        }

        }
    
        }
    
