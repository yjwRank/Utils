/**
 * Created by yjw on 17-6-13.
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class ActionNode {
    private String name;
    private Element root;
    private List<String> to;
    public ActionNode(String name,Element root,List<String> to){
        this.name=name;
        this.root=root;
        this.to=to;
    }

    public String getName(){return name;}
    public Element getRootElement(){return root;}
    public List<String> getTo(){return to;}

    public void addAction(){
      /*  Element root=document.addElement("workflow-app")
                .addAttribute("xmlns","uri:oozie:workflow:0.2").addAttribute("name","java-main-wf");*/
        Element action=root.addElement("action")
                .addAttribute("name",name);
        Element java=action.addElement("java");
        Element job_tracker=java.addElement("job-tracker")
                .addText("${jobTracker}");
        Element name_node=java.addElement("name-node")
                .addText("${nameNode}");
        Element configuration=java.addElement("configuration");

        Element configuration_property=configuration.addElement("property");
        Element configuration_property_name=configuration_property.addElement("name")
                .addText("mapred.job.queue.name");
        Element configuration_property_value=configuration_property.addElement("value")
                .addText("${queueName}");

        Element main_class=java.addElement("main-class")
                //.addText("com.k2data.platform.tools.analytics.AnalysisManager");
                .addText("workflowtest");
        Element arg1=java.addElement("arg")
                .addText("${"+name+"_pasdir}");
        Element arg2=java.addElement("arg")
                .addText("${"+name+"_pasjobdir}");
        Element ok=action.addElement("ok")
                .addAttribute("to",to.get(0));
        Element err=action.addElement("error")
                .addAttribute("to",to.get(1));

    }

    public static void main(String[] args) throws IOException {
        List<String> to=new LinkedList<>();
        to.add("next");
        to.add("next2");

        Document document=DocumentHelper.createDocument();
        Element root=document.addElement("workflow-app")
                .addAttribute("xmlns","uri:oozie:workflow:0.2")
                .addAttribute("name","java-main-wf");
        //ActionNode actionNode=new ActionNode("javanode",document,to);
        //actionNode.addAction();
       // ActionNode forknode=new ForkNode("forknode",document,to);
       // forknode.addAction();
        List<ActionNode> actionNodes=new LinkedList<>();
        actionNodes.add(new ActionNode("javanode",root,to));
        actionNodes.add(new ForkNode("forknode",root,to));
        actionNodes.add(new JoinNode("joinnode",root,to));
        for(ActionNode actionNode:actionNodes){
            actionNode.addAction();
        }

        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer;
        writer=new XMLWriter(System.out,format);
        writer.write(document);



    }
}
