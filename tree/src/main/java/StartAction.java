import org.dom4j.Element;

import java.util.List;

/**
 * Created by yjw on 17-6-13.
 */
public class StartAction extends ActionNode {
    public StartAction(String name, Element root, List<String> to) {
        super(name, root, to);
    }

    public void addAction(){
        List<String> to=super.getTo();
        Element root=super.getRootElement();
        root.addElement("start").addAttribute("to",to.get(0));
    }
}
