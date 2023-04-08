/**
 * @ClassName Test
 * @Description TODO
 * @Author 86189
 * @Date 2022/5/7 9:25
 **/
class Person{
    public String name;
    public Person(String name) {
        this.name = name;
    }
    public static class Student{
        public int age;
        public Student(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    '}';
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Person person=new Person("小明");
        Person.Student student=new Person.Student(46);
    }
}
