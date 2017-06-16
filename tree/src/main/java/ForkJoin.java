import java.util.LinkedList;
import java.util.List;

/**
 * Created by yjw on 17-6-12.
 */
public class ForkJoin extends Action{

    private List<String> path=new LinkedList<>();

    public ForkJoin(String name, String to) {
        super(name, to);
    }
    public ForkJoin(String name,String to,List<String> path){
        super(name,to);
        this.path=path;
    }
    public void setPath(List<String> path){
        this.path=path;
    }
    public List<String> getPath(){
        return path;
    }
}
