
interface Greet{
    void greet(String s); 
}

public class InterafaceDemo implements  Greet {
        public void greet(String s) {
            System.out.println(s);
        }
    public static void main(String[] args) {
        Greet obj = new InterafaceDemo();
        obj.greet("scsgs");
    }
}