import org.codehaus.jackson.map.ObjectMapper;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.*;
/**
 * Created by yjw on 17-6-9.
 */
public class JsonToXml {


    public static void main(String[] args) throws FileNotFoundException {

        /**
         * node[{id:1(DS)},{id:2(Analys1)},{id:3(Analys2)},{id:4(Analys3)}]
         *
         * arrows[{from:0,to:1},{from:0,to:2},{from:1,to:3},{from:2,to:3}]
         *
         */

       /* VexNode node1=new VexNode();
        VexNode node2=new VexNode();
        VexNode node3=new VexNode();
        VexNode node0=new VexNode();
        node0.data=0;
        node1.data=1;
        node2.data=2;
        node3.data=3;
        Side side1=new Side();side1.tailVex=0;side1.headVex=1;
        Side side2=new Side();side2.tailVex=0;side2.headVex=2;
        Side side3=new Side();side3.tailVex=1;side3.headVex=3;
        Side side4=new Side();side4.tailVex=2;side4.headVex=3;

        //side1
        node0.firstOut=side1;
        node1.firstIn=side1;

        //side2
        node0.firstOut.tailLink=side2;
        node2.firstIn=side2;

        //side3
        node1.firstOut=side3;
        node3.firstIn=side3;

        //side4
        node2.firstOut=side4;
        node3.firstIn.headLink=side4;



        ArrayList<VexNode> list=new ArrayList<>();
        list.add(node0);
        list.add(node1);
        list.add(node2);
        list.add(node3);


        JsonToXml jsonToXml=new JsonToXml();

        jsonToXml.getNextNodes(node2,list);
        Toplogy toplogy=new Toplogy();
        for(VexNode node:list){
            Map<Integer,Boolean> v=new HashMap<>();
            List<VexNode> Line=new LinkedList<>();
            if(jsonToXml.visit(node,list,v,Line,toplogy)){
                System.out.println("true");
                break;
            }
            for(VexNode l:Line){
                System.out.print(" "+l.data+" ");
            }
            System.out.println("");
        }

        System.out.println("end");*/


        /**
         * node v0 v1 v2 v3
         *
         * arrow [{from:0,to:3},{from:1,to:0},{from:1,to:2},{from:2,to:0},{from:2,to:1}]
         *
         */


       /* VexNode node0=new VexNode();
        VexNode node1=new VexNode();
        VexNode node2=new VexNode();
        VexNode node3=new VexNode();
        node0.data=0;
        node1.data=1;
        node2.data=2;
        node3.data=3;
        Side side1=new Side();side1.tailVex=0;side1.headVex=3;
        Side side2=new Side();side2.tailVex=1;side2.headVex=0;
        Side side3=new Side();side3.tailVex=1;side3.headVex=2;
        Side side4=new Side();side4.tailVex=2;side4.headVex=0;
        Side side5=new Side();side5.tailVex=2;side5.headVex=1;


        //side1
        node0.firstOut=side1;
        node3.firstIn=side1;
        //side2
        node1.firstOut=side2;
        node0.firstIn=side2;
        //side3
        node1.firstOut.tailLink=side3;
        node2.firstIn=side3;
        //side4
        node2.firstOut=side4;
        node0.firstIn.headLink=side4;
        //side5
        node2.firstOut.tailLink=side5;
        node1.firstIn=side5;

        System.out.println(node0.firstIn.headVex+" "+node0.firstIn.tailVex);
        System.out.println(node0.firstOut.headVex+" "+node0.firstOut.tailVex);
        System.out.println(node0.firstIn.headLink.headVex+" "+node0.firstIn.headLink.tailVex);
        System.out.println(node1.firstIn.headVex+" "+node1.firstIn.tailVex);
        System.out.println(node1.firstOut.headVex+" "+node1.firstOut.tailVex);
        System.out.println(node1.firstOut.tailLink.headVex+" "+node1.firstOut.tailLink.tailVex);

        System.out.println(node2.firstIn.headVex+" "+node2.firstIn.tailVex);
        System.out.println(node2.firstOut.headVex+" "+node2.firstOut.tailVex);
        System.out.println(node2.firstOut.tailLink.headVex+" "+node2.firstOut.tailLink.tailVex);

        System.out.println(node3.firstIn.headVex+" "+node3.firstIn.tailVex);
        System.out.println(node3.firstOut==null);

        ArrayList<VexNode> list=new ArrayList<>();
        list.add(node0);
        list.add(node1);
        list.add(node2);
        list.add(node3);

        //huan(node3);
        JsonToXml jsonToXml=new JsonToXml();

       jsonToXml.getNextNodes(node2,list);

        for(VexNode node:list){
            Map<Integer,Boolean> v=new HashMap<>();
            if(jsonToXml.visit(node,list,v)){
                System.out.println("true");
                break;
            }
        }

        System.out.println("end");*/


        String json="{\n" +
                "    \"nodes\": [\n" +
                "        {\n" +
                "            \"id\": \"ds\", \n" +
                "            \"name\": \"ds\", \n" +
                "            \"input\": 0, \n" +
                "            \"output\": 1\n" +
                "        }, \n" +
                "        {\n" +
                "            \"id\": \"a1\", \n" +
                "            \"name\": \"a1\", \n" +
                "            \"input\": 1, \n" +
                "            \"output\": 0\n" +
                "        }\n" +
                "    ], \n" +
                "    \"arrows\": [\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"ds\"\n" +
                "            }, \n" +
                "            \"to\": {\n" +
                "                \"id\": \"a1\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

       /* json="{\n" +
                "    \"nodes\": [\n" +
                "        {\n" +
                "            \"id\": \"ds1\",\n" +
                "            \"name\": \"ds1\",\n" +
                "            \"input\": 0,\n" +
                "            \"output\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"ds2\",\n" +
                "            \"name\": \"ds2\",\n" +
                "            \"input\": 0,\n" +
                "            \"output\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"ds3\",\n" +
                "            \"name\": \"ds3\",\n" +
                "            \"input\": 0,\n" +
                "            \"output\": 2\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"a1\",\n" +
                "            \"name\": \"a1\",\n" +
                "            \"input\": 2,\n" +
                "            \"output\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"a2\",\n" +
                "            \"name\": \"a2\",\n" +
                "            \"input\": 2,\n" +
                "            \"output\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"a3\",\n" +
                "            \"name\": \"a3\",\n" +
                "            \"input\": 1,\n" +
                "            \"output\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"a4\",\n" +
                "            \"name\": \"a4\",\n" +
                "            \"input\": 1,\n" +
                "            \"output\": 2\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"a5\",\n" +
                "            \"name\": \"a5\",\n" +
                "            \"input\": 2,\n" +
                "            \"output\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"a6\",\n" +
                "            \"name\": \"a6\",\n" +
                "            \"input\": 1,\n" +
                "            \"output\": 0\n" +
                "        }\n" +
                "    ],\n" +
                "    \"arrows\": [\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"ds1\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a1\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"ds2\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a1\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"ds3\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a2\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"a1\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a2\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"ds3\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a4\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"a2\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a3\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"a4\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a5\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"a3\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a5\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"from\": {\n" +
                "                \"id\": \"a4\"\n" +
                "            },\n" +
                "            \"to\": {\n" +
                "                \"id\": \"a6\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";*/
      //  System.out.println(json);
        JsonToXml jsonToXml=new JsonToXml();
        jsonToXml.convertJsonToAccrossLink(json);
 //       List<VexNode> nodes=jsonToXml.getNodes();
//        List<VexNode> pre=jsonToXml.getPre(nodes.get(5));
         ArrayList<VexNode> list= (ArrayList<VexNode>) jsonToXml.getNodes();
        for(VexNode node:list){
            Map<Integer,Boolean> v=new HashMap<>();
            if(jsonToXml.visit(node,list,v)){
                System.out.println("true");
                break;
            }
        }
        jsonToXml.run3();
    }


    public boolean visit(VexNode node,ArrayList<VexNode> nodes,Map<Integer,Boolean> v,List<VexNode> Line,Toplogy toplogy){
        if(v.get(node.data)==null){
            v.put(node.data,true);
            //get nodes
            Line.add(node);

            toplogy.node=node;

            List<VexNode> nextnodes=getNextNodes(node,nodes);
            for(VexNode nextnode:nextnodes){
                Map<Integer,Boolean> tv=new HashMap<>(v);
                Toplogy ttoplogy=new Toplogy();
                toplogy.next.add(ttoplogy);
                if(visit(nextnode,nodes,tv,Line,ttoplogy)){
                    return true;
                }
            }

            return false;
        }else{
            return true;
        }
    }


    public boolean visit(VexNode node,ArrayList<VexNode> nodes,Map<Integer,Boolean> v){
        if(v.get(node.data)==null){
            v.put(node.data,true);
            //get nodes
            List<VexNode> nextnodes=getNextNodes(node,nodes);
            for(VexNode nextnode:nextnodes){
                Map<Integer,Boolean> tv=new HashMap<>(v);
                if(visit(nextnode,nodes,tv)){
                    return true;
                }
            }

            return false;
        }else{
            return true;
        }
    }

    public List<VexNode> getNextNodes(VexNode node,ArrayList<VexNode> nodes){
        List<VexNode> list=new LinkedList<>();
        if(node.firstOut!=null){
            Side pSide=node.firstOut;
            list.add(nodes.get(pSide.headVex));
            while(pSide.tailLink!=null){
                pSide=pSide.tailLink;
                list.add(nodes.get(pSide.headVex));
            }
        }
        return list;
    }

    public boolean convertJsonToAccrossLink(String json){

        ObjectMapper objectMapper=new ObjectMapper();
        try {
            Map<String,Object> mapper=objectMapper.readValue(json,Map.class);
            System.out.println(mapper);

            nodes=new ArrayList<>();
            Map<String,Integer> nodeslocMap=new HashMap<>();
            List<Map<String,Object>> nodesInfo= (List<Map<String, Object>>) mapper.get("nodes");
            List<Map<String,Object>> arrowsInfo= (List<Map<String, Object>>) mapper.get("arrows");
            //init nodes
            int id=0;
            for(Map<String,Object> nodeInfo:nodesInfo){
                nodeslocMap.put(String.valueOf(nodeInfo.get("id")),id);
                VexNode node=new VexNode();
                node.data=id;
                node.input=Integer.valueOf(String.valueOf(nodeInfo.get("input")));
                node.output=Integer.valueOf(String.valueOf(nodeInfo.get("output")));
                node.name=String.valueOf(nodeInfo.get("name"));
                nodes.add(node);
                id++;
            }
            System.out.println(nodeslocMap.toString());

            //make across link
            for(Map<String,Object> arrowInfo:arrowsInfo){
                Map<String,String> from= (Map<String, String>) arrowInfo.get("from");
                Map<String,String> to= (Map<String, String>) arrowInfo.get("to");
                String fromId=from.get("id");
                String toId=to.get("id");
                //get from node
                VexNode fromNode=nodes.get(nodeslocMap.get(fromId));
                //get to node
                VexNode toNode=nodes.get(nodeslocMap.get(toId));
                Side side=new Side();
                side.tailVex=fromNode.data;
                side.headVex=toNode.data;
                //process from node firstOut tailLink
                if(fromNode.firstOut==null){
                    fromNode.firstOut=side;
                }else{
                    Side psSide=fromNode.firstOut;
                    while(psSide.tailLink!=null){
                        psSide=psSide.tailLink;
                    }
                    psSide.tailLink=side;
                }
                //process to node firstInt headLink
                if(toNode.firstIn==null){
                    toNode.firstIn=side;
                }else{
                    Side psSide=toNode.firstIn;
                    while(psSide.headLink!=null){
                        psSide=psSide.headLink;
                    }
                    psSide.headLink=side;
                }
            }

            System.out.println("finish build across linker");

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }



        getStartEndNode();
        getAllStartNodes();
        getAllEndNodes();
        return true;
    }

    private boolean add(VexNode node){
        return judge.contains(node);
    }

    public void run(){
        VexNode ps=nodes.get(startLoc);
        Queue<VexNode> q=new LinkedList<>();
        q.add(ps);
        Queue<String> message=new LinkedList<>();
        while(q.size()>0){
            //get ps node
            VexNode p=q.poll();
            //get next nodes
            List<VexNode> nextNodes=getNext(p);
            if(p.input==0){
                System.out.println("begin");
            }

            if (p.input>1){
                System.out.println("join");
            }
            System.out.println(p.name);
            if(nextNodes.size()>1){
                for(VexNode n:nextNodes){
                    if(!add(n)) {
                        q.add(n);
                        judge.add(n);
                    }
                }
                System.out.println("fork "+nextNodes.size());
            }
            if(nextNodes.size()==1){
                if(!add(nextNodes.get(0))) {
                    q.add(nextNodes.get(0));
                    judge.add(nextNodes.get(0));
                }
            }

        }
    }

    public void run1(){
       VexNode ps=nodes.get(startLoc);
        getAllForkNode();
        getAllJoinNode();
       Queue<VexNode> q=new LinkedList<>();
        q.add(ps);
        List<ActionNode> actionNodes=new LinkedList<>();
        Document document=DocumentHelper.createDocument();

        Element root1=document.addElement("workflow-app","uri:oozie:workflow:0.2")
               .addAttribute("name","java-main-wf");

        while(q.size()>0){
            VexNode p=q.poll();
            List<VexNode> nextNodes=getNext(p);
            StringBuffer next=new StringBuffer();
            List<String> to=new LinkedList<>();
            for(VexNode nexenode:nextNodes){
                if(isJoinNode(nexenode)) {
                    next.append(nexenode.name+" join"+" ");
                    to.add(nexenode.name+"_join");
                }else{
                    next.append(nexenode.name+" ");
                    to.add(nexenode.name);
                }
                if(!add(nexenode)) {
                    q.add(nexenode);
                    judge.add(nexenode);
                }
            }
            //System.out.println("name:"+p.name+" to:"+next.toString());
            if(isForkNode(p)) {
                System.out.println("name:" + p.name + " to:" + p.name + " fork");
                System.out.println("name:" + p.name + " fork" + " to:" + next.toString());
                List<String> tmpList=new LinkedList<>();
                tmpList.add(p.name+"_fork");
                tmpList.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,tmpList));
                actionNodes.add(new ForkNode(p.name+"_fork",root1,to));
            }else if(isJoinNode(p)){
                System.out.println("name:"+p.name+" join"+" to:"+ p.name);
                System.out.println("name:"+p.name+" to:"+next.toString());
                List<String> tmpList=new LinkedList<>();
                tmpList.add(p.name);tmpList.add("fail");
                actionNodes.add(new JoinNode(p.name+"_join",root1,tmpList));
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
            }else if(p.output==0){
                System.out.println("name:"+p.name+" to: end");
                to.add("end");
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
                actionNodes.add(new EndAction("end",root1,to));
                actionNodes.add(new KillAction("fail",root1,to));
            }else if(p.input==0){
                System.out.println("name: start to:"+p.name);
                System.out.println("name:"+p.name+" to:"+next.toString());
                List<String> tmpList=new LinkedList<>();
                tmpList.add(p.name);
                actionNodes.add(new StartAction(p.name,root1,tmpList));
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
            }
            else{
                System.out.println("name:"+p.name+" to:"+next.toString());
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
            }


        }

        for(ActionNode actionNode:actionNodes){
            actionNode.addAction();
        }

        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer;
        try {
            writer=new XMLWriter(System.out,format);
            writer.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run2(){
        VexNode ps=nodes.get(startLoc);
        if(startNode.size()>1)
            ps=nodes.get(startNode.get(0));
        getAllForkNode();
        getAllJoinNode();
        Queue<VexNode> q=new LinkedList<>();
        q.add(ps);
        List<ActionNode> actionNodes=new LinkedList<>();
        Document document=DocumentHelper.createDocument();

        Element root1=document.addElement("workflow-app","uri:oozie:workflow:0.2")
                .addAttribute("name","java-main-wf");
        boolean judegeAddStart=false;

       /* if(startNode.size()>1){
            List<String> tmpList=new LinkedList<>();
            tmpList.add("fork");
            actionNodes.add(new StartAction("root",root1,tmpList));
            tmpList.clear();
            for(Integer i:startNode){
                tmpList.add(nodes.get(i).name);
            }
            actionNodes.add(new ForkNode("fork",root1,tmpList));
        }
        judegeAddStart=true;*/


        while(q.size()>0){
            VexNode p=q.poll();
            List<VexNode> nextNodes=getNext(p);
            StringBuffer next=new StringBuffer();
            List<String> to=new LinkedList<>();
            for(VexNode nexenode:nextNodes){
                if(isJoinNode(nexenode)) {
                    next.append(nexenode.name+" join"+" ");
                    to.add(nexenode.name+"_join");
                }else{
                    next.append(nexenode.name+" ");
                    to.add(nexenode.name);
                }
                if(!add(nexenode)) {
                    q.add(nexenode);
                    judge.add(nexenode);
                }
            }
            System.out.println("name:"+p.name+" to:"+next.toString());
            if(isForkNode(p)){
                if(p.input==0){

                    //make start node
                    if(!judegeAddStart){

                        if(startNode.size()==1){
                            List<String> tmpList=new LinkedList<>();
                            tmpList.add(p.name);
                            actionNodes.add(new StartAction(p.name,root1,tmpList));
                        }else if(startNode.size()>1){
                            List<String> tmpList=new LinkedList<>();
                            tmpList.add("fork");
                            actionNodes.add(new StartAction(p.name,root1,tmpList));
                            tmpList.clear();
                            for(Integer i:startNode){
                                tmpList.add(nodes.get(i).name);
                            }
                            actionNodes.add(new ForkNode("fork",root1,tmpList));
                        }
                        judegeAddStart=true;
                    }
                }else {
                    List<String> tmpList = new LinkedList<>();
                    tmpList.add(p.name + "_fork");
                    tmpList.add("fail");
                    actionNodes.add(new ActionNode(p.name, root1, tmpList));
                    actionNodes.add(new ForkNode(p.name + "_fork", root1, to));
                }
            }else if(isJoinNode(p)){
                if(p.output==0){
                    List<String> tmpList=new LinkedList<>();
                    tmpList.add(p.name);
                    tmpList.add("fail");
                    actionNodes.add(new JoinNode(p.name+"_join",root1,tmpList));
                    tmpList.clear();
                    tmpList.add("end");
                    tmpList.add("fail");
                    actionNodes.add(new ActionNode(p.name,root1,tmpList));
                    actionNodes.add(new KillAction("fail",root1,tmpList));
                    actionNodes.add(new EndAction("end",root1,tmpList));
                }else {
                    List<String> tmpList = new LinkedList<>();
                    tmpList.add(p.name);
                    tmpList.add("fail");
                    actionNodes.add(new JoinNode(p.name + "_join", root1, tmpList));
                    to.add("fail");
                    actionNodes.add(new ActionNode(p.name, root1, to));
                }
            }else if(p.output==0) {
                System.out.println("name:"+p.name+" to: end");
                to.add("end");
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
                actionNodes.add(new KillAction("fail",root1,to));
                actionNodes.add(new EndAction("end",root1,to));
            }else if(p.input==0){
                System.out.println("name: start to:"+p.name);
                System.out.println("name:"+p.name+" to:"+next.toString());
                List<String> tmpList = new LinkedList<>();
                tmpList.add(p.name);
                actionNodes.add(new StartAction(p.name, root1, tmpList));
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
            }else{
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root1,to));
            }
        }

        for(ActionNode actionNode:actionNodes){
            actionNode.addAction();
        }

        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer;
        try {
            writer=new XMLWriter(System.out,format);
            writer.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run3() throws FileNotFoundException {
        VexNode ps=nodes.get(startLoc);
        getAllForkNode();
        getAllJoinNode();
        Queue<VexNode> q=new LinkedList<>();
        List<ActionNode> actionNodes=new LinkedList<>();
        Document document=DocumentHelper.createDocument();
        Element root=document.addElement("workflow-app","uri:oozie:workflow:0.2")
                .addAttribute("name","java-main-wf");
        List<String> startNodeToLists=new LinkedList<>();
        if(startNode.size()>1){
            for(Integer start:startNode){
                VexNode node=nodes.get(start);
                q.add(node);
                startNodeToLists.add(node.name);
            }
            List<String> tmpList=new LinkedList<>();
            tmpList.add("fork");
            actionNodes.add(new StartAction("",root,tmpList));
            actionNodes.add(new ForkNode("fork",root,startNodeToLists));
        }else{
            q.add(ps);
            List<String> tmpList=new LinkedList<>();
            tmpList.add(ps.name);
            actionNodes.add(new StartAction(ps.name,root,tmpList));
        }

        while(q.size()>0){
            VexNode p=q.poll();
            if(p.name.equals("a4"))
                System.out.println("a4");
            List<VexNode> nextNodes=getNext(p);
            List<String> to=new LinkedList<>();
            for(VexNode nexenode:nextNodes){
                if(isJoinNode(nexenode)){
                    to.add(nexenode.name+"_join");
                }else{
                    to.add(nexenode.name);
                }
                if(!add(nexenode)){
                    q.add(nexenode);
                    judge.add(nexenode);
                }

            }

            if(isForkNode(p)){
                List<String> tmpList=new LinkedList<>();
                tmpList.add(p.name+"_fork");
                tmpList.add("fail");
                actionNodes.add(new ActionNode(p.name,root,tmpList));
                actionNodes.add(new ForkNode(p.name+"_fork",root,to));
            }else if(isJoinNode(p)&&!(p.output==0)){
                List<String> tmpList=new LinkedList<>();
                tmpList.add(p.name);
                tmpList.add("fail");
                actionNodes.add(new JoinNode(p.name+"_join",root,tmpList));
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root,to));
            }else if(p.output==0){
                ;
            }else{
                to.add("fail");
                actionNodes.add(new ActionNode(p.name,root,to));
            }

        }


        if(endNode.size()==1){
            List<String> tmpList=new LinkedList<>();
            VexNode end=nodes.get(endNode.get(0));
            tmpList.add("end");
            tmpList.add("fail");
            actionNodes.add(new ActionNode(end.name,root,tmpList));
            actionNodes.add(new KillAction("fail",root,tmpList));
            actionNodes.add(new EndAction("end",root,tmpList));
        }else if(endNode.size()>1){
            List<String> tmpList1=new LinkedList<>();
            tmpList1.add("join");
            tmpList1.add("fail");
            for(Integer endloc:endNode){
                VexNode endnode=nodes.get(endloc);
                if(endnode.input>1){
                    List<String> t=new LinkedList<>();
                    t.add("join");
                    actionNodes.add(new JoinNode(endnode.name+"_join",root,t));
                }
                actionNodes.add(new ActionNode(endnode.name,root,tmpList1));

            }
            List<String> tmpList=new LinkedList<>();
            tmpList.add("end");
            tmpList.add("fail");
            actionNodes.add(new JoinNode("join",root,tmpList));
            actionNodes.add(new KillAction("fail",root,tmpList));
            actionNodes.add(new EndAction("end",root,tmpList));
        }



        for(ActionNode actionNode:actionNodes){
            actionNode.addAction();
        }

        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer;
        OutputStream outputStream=new FileOutputStream("workflow.xml");
        try {
            writer=new XMLWriter(outputStream,format);
            writer.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public boolean isForkNode(VexNode node){
        if(forknode.get(node.name)!=null)
            return true;
        else
            return false;
    }

    public boolean isJoinNode(VexNode node){
        if(joinNode.get(node.name)!=null)
            return true;
        else
            return false;
    }

    public List<VexNode> getAllJoinNode(){
        List<VexNode> joinnodes=new LinkedList<>();
        for(VexNode node:nodes){
            if(node.input>1){
                joinnodes.add(node);
                joinNode.put(node.name,true);
            }
        }
        return joinnodes;
    }

    public List<VexNode> getAllForkNode(){
        List<VexNode> forknodes=new LinkedList<>();
        for(VexNode node:nodes){
            if(node.output>1){
                forknodes.add(node);
                forknode.put(node.name,true);
            }
        }
        return forknodes;
    }

    public Queue<String> q=new LinkedList<>();

    public List<VexNode> getNext(VexNode node){
        List<VexNode> ns=new LinkedList<>();
        if(node.firstOut!=null){
            Side side=node.firstOut;

            while(side!=null){
                ns.add(nodes.get(side.headVex));
                side=side.tailLink;
            }
        }
        return ns;
    }

    public List<VexNode> getPre(VexNode node){
        List<VexNode> ns=new LinkedList<>();
        if(node.firstIn!=null){
            Side side=node.firstIn;
            while(side!=null){
                ns.add(nodes.get(side.tailVex));
                side=side.headLink;
            }
        }
        return ns;
    }

    public void getStartEndNode(){
        if(nodes!=null&&nodes.size()>0){
            for(int i=0;i<nodes.size();i++){
                VexNode node=nodes.get(i);
                if(node.input==0){
                    startLoc=i;
                }
                if(node.output==0){
                    endLoc=i;
                }
            }
        }else{
            System.out.println("nodes is null or size zero");
        }
    }

    public void getAllStartNodes(){
        for(int i=0;i<nodes.size();i++){
            VexNode node=nodes.get(i);
            if(node.input==0){
                startNode.add(i);
            }
        }
    }

    public void getAllEndNodes(){
        for(int i=0;i<nodes.size();i++){
            VexNode node=nodes.get(i);
            if(node.output==0){
                endNode.add(i);
            }
        }
    }


    public List<VexNode> getNodes(){return nodes;}
    public int getStartLoc(){return startLoc;}
    public int getEndLoc(){return endLoc;}

    private List<Integer> startNode=new LinkedList<>();
    private List<Integer> endNode=new LinkedList<>();
    private int startLoc;
    private int endLoc;
    private Map<String,Boolean> forknode=new HashMap<>();
    private Map<String,Boolean> joinNode=new HashMap<>();
    private List<VexNode> nodes=new ArrayList<>();
    private Set<VexNode> judge=new HashSet<>();
}

