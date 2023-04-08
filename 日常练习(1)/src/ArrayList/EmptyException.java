package ArrayList;

/**
 * @ClassName EmptyException
 * @Description TODO
 * @Author 86189
 * @Date 2022/5/2 15:17
 **/
public class EmptyException extends RuntimeException{
    public EmptyException() {
    }
    public EmptyException(String data) {
        super(data);
    }
}
