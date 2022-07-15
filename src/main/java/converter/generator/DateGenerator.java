package converter.generator;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


public class DateGenerator {

    private Date start;
    private Date end;


    public DateGenerator(Date start, Date end) {
        this.end = end; this.start = start;
       
    }

  

    public Date getTime() {
        return new Date(ThreadLocalRandom.current().nextLong(start.getTime(), end.getTime()));
    }

}
