package converter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;


public class Request {
    private static Connection connection;

    public Request(Connection connection) {
        Request.connection = connection;
    }




    public ResultSet select(String query, Timestamp time) {
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setTimestamp(0, time);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            // TODO send to logger
            e.printStackTrace();
        }
        return null;
    }


    public String insert(String query) {
        try (//LocalDate localDate = LocalDate.now();
        PreparedStatement st = connection.prepareStatement(query)) {
            //st.setObject(1, localDate);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public boolean simple_query(String query) {
        boolean status = false;
        try (Statement st = connection.createStatement()) {
            st.execute(query);
            st.close(); 
            status = true;   
        } catch (SQLException e) {
            // TODO send to logger
            e.printStackTrace();
        }
        return status;
    }

}
