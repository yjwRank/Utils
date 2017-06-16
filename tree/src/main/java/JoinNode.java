import org.dom4j.Element;

import java.util.List;

/**
 * Created by yjw on 17-6-13.
 */
public class JoinNode extends ActionNode{

    public JoinNode(String name, Element root, List<String> to) {
        super(name, root, to);
    }

    public void addAction(){
        String name=super.getName();
        Element root=super.getRootElement();
        List<String> to=super.getTo();
        Element join=root.addElement("join")
                .addAttribute("name",name)
                .addAttribute("to",to.get(0));
    }
}
