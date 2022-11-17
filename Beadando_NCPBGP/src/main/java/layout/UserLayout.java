package layout;

import java.util.ArrayList;
import org.json.JSONObject;

public class UserLayout {
    public String name;
    public String age;
    public String status;

    public UserLayout() {}

    public UserLayout(String name, String age, String status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public UserLayout(ArrayList<String> tmp) {
        this.name = tmp.get(0);
        this.age = tmp.get(1);
        this.status = tmp.get(2);
    }
    
    
    public JSONObject toJson(){
        JSONObject user = new JSONObject()
        .put("name", this.name)
        .put("age", this.age)
        .put("status", this.status);       
        return user;
    }
}
