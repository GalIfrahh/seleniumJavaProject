package ProjectUtils;

import java.sql.*;


public class MySqlConnection {



    public Connection get_connection(){

        Connection connection=null;


            try{

                    Class.forName("com.mysql.jdbc.Driver");


                    connection=DriverManager.getConnection("jdbc:mysql://localhost:xxxxxx/RedLionAutomation","xxxxxxx","xxxxxxx");


            }catch (Exception e) {


                    System.out.println(e);
            }


        return connection;
    }




    public void select(Connection connection, String query, String colomn_label) {

        try {

            Statement stmt = connection.createStatement();


            ResultSet rs = stmt.executeQuery(query);


            while(rs.next()){

                String desire_value  = rs.getString(colomn_label);


                System.out.println(colomn_label + "\n");
            }

        } catch (SQLException e){

            System.out.println(e.getMessage());

        }

    }




    public void insert(Connection connection, String query){

        try {

            Statement stmt = connection.createStatement();


            stmt.executeUpdate(query);


        } catch (SQLException e){

            System.out.println(e.getMessage());

        }
    }
}
