import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yjw on 17-4-7.
 */
public class tress {
    public static void main(String[] args){
        String pasdir=args[0];
        String pasjobdir=args[1];
        File dir=new File(System.getProperty("user.dir"));
        System.out.println(dir.getAbsolutePath());
        System.out.println("pasdir:"+pasdir+" pasjobdir:"+pasjobdir);
        File[] files=dir.listFiles();
        System.out.println("-----------------get list------------------------------"+files.length);
        Queue<File> q=new LinkedList<>();
        q.add(dir);
        while(q.size()>0){
            File tmp=q.poll();
            if(tmp.isDirectory()){
                File[] fs=tmp.listFiles();
                for(File f:fs){
                    q.add(f);
                }
            }else{
                System.out.println(tmp.getAbsolutePath());
            }
        }
        System.out.println("-------------------------------1------------------------------");
        try {
            FileInputStream in=new FileInputStream(pasdir);
            int c=0;
            while((c=in.read())!=-1){
                System.out.println(c);
            }

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------2------------------------------");
        try {
            FileInputStream in2=new FileInputStream(pasjobdir);
            int c1=0;
            while((c1=in2.read())!=-1){
                System.out.println(c1);
            }

            in2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main1(String[] args) throws IOException, InterruptedException {
        System.out.println(36000_000);

        Object isBoring=null;
        boolean isB=isBoring!=null&&Boolean.valueOf(String.valueOf(isBoring));
        System.out.println(isB);


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
