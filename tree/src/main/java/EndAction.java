import org.dom4j.Element;

import java.util.List;

/**
 * Created by yjw on 17-6-13.
 */
public class EndAction extends ActionNode{
    public EndAction(String name, Element root, List<String> to) {
        super(name, root, to);
    }

    public void addAction(){
        String name=super.getName();
        Element root=super.getRootElement();
        root.addElement("end").addAttribute("name",name);
    }
}
