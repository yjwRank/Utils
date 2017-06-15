import java.util.Stack;

/**
 * Created by yjw on 17-4-19.
 */
public class test {
    public static void main(String[] args) {
        Node root=new Node();
        root.setC('A');
        root.setLeftNode(new Node().setC('B'));
        root.leftNode().setLeftNode(new Node().setC('C'));
        root.leftNode().setRightNode(new Node().setC('E'));
        root.leftNode().leftNode().setLeftNode(new Node().setC('D'));

        root.setRightNode(new Node().setC('F'));
        root.rightNode().setRightNode(new Node().setC('G'));
        root.rightNode().rightNode().setLeftNode(new Node().setC('H'));

        printA(root);
        System.out.println();
        printB(root);
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
        Stack<Node> stack=new Stack<>();
        Node ps=root;
        while(ps!=null || !stack.empty()){
            if(ps == null){
                ps=stack.pop();
                System.out.print(ps.getValue()+" ");
                ps=ps.rightNode();
            }else{
                stack.push(ps);
                ps=ps.leftNode();
            }
        }

    }

    public static void printC(Node root){

    }
}
