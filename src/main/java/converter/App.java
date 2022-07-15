package converter;

//import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import converter.generator.DateGenerator;
import converter.generator.IntegerGenerator;
import converter.generator.TypeGenerator;
import converter.psql.Postgres;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        Postgres pg = new Postgres();
        if(pg.raw_query("CREATE TABLE IF NOT EXISTS public.history(id BIGINT GENERATED ALWAYS AS IDENTITY, id_cam INTEGER NOT NULL, type TEXT, line INTEGER NOT NULL, at_update TIMESTAMP WITHOUT TIME ZONE NOT NULL)")){
            System.out.println("Status OK");
        } else {
            System.out.println("Status FALSE");
        }


        //Date date = new Date();
        
        //Timestamp timestamp = new Timestamp(date.getTime());
        Calendar cal = Calendar.getInstance();
        Date current = cal.getTime();
        cal.add(Calendar.YEAR, -1); // to get previous year add -1
        
        DateGenerator dateGenerator = new DateGenerator(cal.getTime(), current);
        IntegerGenerator intGenerator_cam = new IntegerGenerator();
        TypeGenerator typeGenerator_type = new TypeGenerator();
        IntegerGenerator intGenerator_line = new IntegerGenerator();
        

        for(Long i = (long) 0 ; i < 50000000 ; i++){
            pg.insert("INSERT INTO public.history (id_cam, type, line, at_update) VALUES ("+intGenerator_cam.get_id_cam()+",'"+typeGenerator_type.get_vehicle()+"',"+intGenerator_line.get_line()+",'"+dateGenerator.getTime()+"')");
        }
    


        /* create constant table for converted data */
        if(pg.raw_query("CREATE TABLE IF NOT EXISTS public.test(id BIGINT GENERATED ALWAYS AS IDENTITY, id_cam INTEGER NOT NULL, car INTEGER, bus INTEGER, truck INTEGER, line INTEGER NOT NULL, at_update TIMESTAMP WITHOUT TIME ZONE NOT NULL)")){
            System.out.println("Status OK");
        } else {
            System.out.println("Status FALSE");
        }
        




        //ResultSet r = pg.select("SELECT * FROM mytable WHERE at_update > ?", Timestamp.valueOf("2022-07-13 12:00"));
        
    
        
        

       
    }
}
