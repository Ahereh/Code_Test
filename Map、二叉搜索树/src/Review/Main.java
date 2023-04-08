package Review;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 86189
 * @Date 2022/7/2 0:24
 **/
public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(3);
        binarySearchTree.insert(44);
        binarySearchTree.insert(11);
        binarySearchTree.remove(11);
        System.out.println("测试");

    }
}
