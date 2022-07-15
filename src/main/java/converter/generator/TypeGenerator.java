package converter.generator;

public class TypeGenerator {

  

    public String get_vehicle() {
        int val = (int) ((Math.random() * (4 - 1)) + 1);
        switch (val) {
            case 1:
            return "Автобус";
                
            case 2:
            return "Легковая";
               
            case 3:
            return "Грузовик";
    
            default: return "Легковая";
               
        }
    }

}
