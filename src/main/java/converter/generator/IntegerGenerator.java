package converter.generator;

public class IntegerGenerator {

  
    public int get_id_cam() {
         return (int) ((Math.random() * (546 - 1)) + 1);
    }

    public int get_line() {
        return (int) ((Math.random() * (6 - 1)) + 1);
    }

}
