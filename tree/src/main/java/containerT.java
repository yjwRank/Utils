import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;

/**
 * Created by yjw on 17-4-10.
 */
public class containerT implements Runnable{
    private String name;
    private Thread t;
    public containerT(String name){
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
            System.out.println("running:"+name);
            Socket client= null;
            try {
                client = new Socket("10.1.10.68",9090);


        JSONObject json=new JSONObject();
        json.put("input","/opt/1.txt");
        json.put("output","/opt/tmp/"+Thread.currentThread().getId()+"container---"+Thread.currentThread().getName());
        json.put("jarfile","/opt/file2.testfile.jarm");
        json.put("resultnum",1);

                DataOutputStream out=new DataOutputStream(client.getOutputStream());
                out.writeUTF(json.toJSONString());
              //  PrintWriter out=new PrintWriter(client.getOutputStream(),true);
               // out.println(json.toString());
                System.out.println("client send:"+json.toString());
              // BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));
               // String answer=input.readLine();
               // System.out.println("accept:"+answer);

               // input.close();

                DataInputStream in=new DataInputStream(client.getInputStream());
                System.out.println(in.readUTF());
                in.close();out.close();
               // ObjectOutputStream outputStream=new ObjectOutputStream(client.getOutputStream());
              //  outputStream.writeObject(json.toJSONString());
    } catch (IOException e) {
        e.printStackTrace();
    }

        }


    public static void main(String[] args){
        long start=System.currentTimeMillis();
        containerT c1=new containerT("1");c1.start();
        containerT c2=new containerT("2");c2.start();
        containerT c3=new containerT("3");c3.start();
        containerT c4=new containerT("4");c4.start();
        System.out.println("total:"+(System.currentTimeMillis()-start));
    }

}
