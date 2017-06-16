/**
 * Created by yjw on 17-4-7.
 */
public class Node {
    private Node left;
    private Node right;
    private char c;

    public Node(){
        left=null;
        right=null;
        c=' ';
    }

    public Node leftNode(){
        return left;
    }
    public Node rightNode(){
        return right;
    }
    public Node setC(char c){
        this.c=c;
        return this;
    }

    public void setLeftNode(Node left){
        this.left=left;
    }
    public void setRightNode(Node right){
        this.right=right;
    }

    public char getValue(){
        return c;
    }
}
