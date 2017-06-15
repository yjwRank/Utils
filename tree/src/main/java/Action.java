/**
 * Created by yjw on 17-6-12.
 */
public class Action {
    private String name;
    private String to;

    public Action(String name,String to){
        this.name=name;
        this.to=to;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setTo(String to){
        this.to=to;
    }
    public String getName(){
        return name;
    }
    public String getTo(){
        return to;
    }
}
