package converter;

import java.sql.Timestamp;

public class Row {
    private Integer id;
    private Integer id_cam;
    private String type;
    private Integer line;
    private Timestamp at_update;


    public Row(Integer id_cam, String type, Integer line) {
        this.id_cam = id_cam;
        this.type = type;
        this.line = line;
    }

    public Row getRow(){
        return this;
    }

    public Integer getCam(){
        return this.id_cam;
    }

    public String getType(){
        return this.type;
    }

    public Integer getLine(){
        return this.line;
    }

}
