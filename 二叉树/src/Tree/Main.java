package Tree;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 86189
 * @Date 2022/5/14 15:30
 **/
public class Main {
    public static void main(String[] args) {
        MyTree myTree=new MyTree();
        myTree.creatTree();
        myTree.preOrder(myTree.root);   //前序
        System.out.println();
        myTree.inOrder(myTree.root);    //中序
        System.out.println();
        myTree.postOrder(myTree.root);   //后序
        System.out.println();
        System.out.println(myTree.getLeafNodeCount1(myTree.root));
        System.out.println(myTree.getHeight(myTree.root));
        myTree.levelOrder(myTree.root);
    }
}
