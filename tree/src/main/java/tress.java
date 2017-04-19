import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yjw on 17-4-7.
 */
public class tress {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(36000_000);




         Node root=new Node();
        root.setC('A');
        root.setLeftNode(new Node().setC('B'));
        root.leftNode().setLeftNode(new Node().setC('C'));
        root.leftNode().setRightNode(new Node().setC('E'));
        root.leftNode().leftNode().setLeftNode(new Node().setC('D'));

        root.setRightNode(new Node().setC('F'));
        root.rightNode().setRightNode(new Node().setC('G'));
        root.rightNode().rightNode().setLeftNode(new Node().setC('H'));

        System.out.println("******");
        printA(root);//should A B C D E F G H
      /*  String [] command={"docker","run","-v","/home/yjw/workspace/reflect1:/jarfile","mcrtest003_test","/bin/sh","-c","/jarfile/run.sh"};
        ProcessBuilder pb=new ProcessBuilder(command);
        pb.inheritIO();
        Process proc=pb.start();
        InputStream is=proc.getInputStream();
        OutputStream os=proc.getOutputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os));
        writer.write("pwd");
//        writer.flush();
        String line="";
        while((line=reader.readLine())!=null){
            System.out.print(line+"\n");
        }
        proc.waitFor();*/
        containerT c=null;
        imageT m=null;
        int threadcount=Integer.valueOf(args[1]);
        if(args[0].equals("image")){
            /*imageT m1=new imageT("1");m1.start();
            imageT m2=new imageT("2");m2.start();
            imageT m3=new imageT("3");m3.start();
            imageT m4=new imageT("4");m1.start();*/
            for(int i=0;i<threadcount;i++){
                m=new imageT(String.valueOf(i));
                m.start();
            }
        }
        if(args[0].equals("container")){
           /* containerT c1=new containerT("1");c1.start();
            containerT c2=new containerT("2");c2.start();
            containerT c3=new containerT("3");c3.start();
            containerT c4=new containerT("4");c4.start();*/
            for(int i=0;i<threadcount;i++){
                c=new containerT(String.valueOf(i));
                c.start();
            }
        }
    }


    public static void printA(Node root){
        Stack<Node> stack=new Stack<Node>();
        stack.push(root);
        while(stack.size()>0){
            Node ps=stack.pop();
            System.out.print(ps.getValue()+" ");
            if(ps.rightNode()!=null)
                stack.push(ps.rightNode());
            if(ps.leftNode()!=null)
                stack.push(ps.leftNode());
        }
    }

    public static void printB(Node root){

    }
}
