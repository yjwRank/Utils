import org.dom4j.Element;

import java.util.List;

/**
 * Created by yjw on 17-6-13.
 */
public class KillAction extends ActionNode {
    public KillAction(String name, Element root, List<String> to) {
        super(name, root, to);
    }

    public void addAction(){
        String name=super.getName();
        Element root=super.getRootElement();
        Element kill=root.addElement("kill")
                .addAttribute("name",name);
        kill.addElement("message")
                .addText("Java failed, error message[${wf:errorMessage(wf:lastErrorNode())}]");
    }
}
