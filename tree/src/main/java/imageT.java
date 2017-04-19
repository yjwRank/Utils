import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;

/**
 * Created by yjw on 17-4-10.
 */
public class imageT implements Runnable{

    private String name;
    private Thread t;
    public imageT(String name){
        this.name=name;
    }

    public void start(){
        if(t==null){
            t=new Thread(this,name);
            t.start();
        }
    }
    @Override
    public void run() {
        String [] command={"docker","run","-v","/home/yjw/workspace/reflect1:/jarfile","mcrtest003_test","/bin/sh","-c","/jarfile/run.sh "+name+"---"+Thread.currentThread().getName()};
        ProcessBuilder pb=new ProcessBuilder(command);
        pb.inheritIO();
        Process proc= null;
        try {
            proc = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is=proc.getInputStream();
        OutputStream os=proc.getOutputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os));
        try {
            writer.write("pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        writer.flush();
        String line="";
        try {
            while((line=reader.readLine())!=null){
                System.out.print(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name:"+this.name+" thread:"+Thread.currentThread().getName());
        System.out.println();
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args){
        imageT m1=new imageT("1");m1.start();
        imageT m2=new imageT("2");m2.start();
        imageT m3=new imageT("3");m3.start();
        imageT m4=new imageT("4");m1.start();
    }
}
