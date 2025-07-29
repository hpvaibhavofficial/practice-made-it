interface Fi{
    void DcTv(String s);

    default void Flash(){
        System.out.println("Run Barry Run.");
    }

    static void CrossOver(){
        System.out.println("I am THE Green Arrow.");
    }

}

public class FunctionalInterface{
    static  Fi obj = (s) -> System.out.println("I belong to DC TV...  "+s);
    public static void main(String[] args) {
        obj.DcTv("Vaibhav");
        obj.Flash();
        Fi.CrossOver();
    }
}
