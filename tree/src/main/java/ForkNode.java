import org.dom4j.Document;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
/**
 * Created by yjw on 17-6-13.
 */
public class ForkNode extends ActionNode {
    public ForkNode(String name, Element root, List<String> to) {
        super(name, root, to);
    }


    public void addAction(){
        String name=super.getName();
        Element root=super.getRootElement();
        List<String> to=super.getTo();
        Element fork=root.addElement("fork")
                .addAttribute("name",name);
        for(String start:to){
            Element path=fork.addElement("path")
                    .addAttribute("start",start);
        }
    }
}
