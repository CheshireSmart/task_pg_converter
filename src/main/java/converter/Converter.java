package converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Converter {


    private void convert_to_hash_map(ResultSet result){

        HashMap<Integer,ArrayList<Row>> array = new HashMap<>();
        ArrayList<Row> list;
        try {
            while (result.next()) {

                if(array.get(result.getInt(2)) != null){
                    array.get(result.getInt(2)).add(new Row(result.getInt(2),result.getString(3), result.getInt(4)));
                } else {
                    list = new ArrayList<>();
                    list.add(new Row(result.getInt(2),result.getString(3), result.getInt(4)));
                    array.put(result.getInt(2), list);
                }   
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
