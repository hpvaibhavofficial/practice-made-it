// interface Greet {
//     void greet(String s);  // abstract method
// }

// public class InterafaceDemo implements Greet {
//     // Outer class method override
//     public void greet(String s) {
//         System.out.println("Your string is : " + s);
//     }

//     // Static Inner Class implementing the same interface
//     static class InnerDemo implements Greet {
//         public void greet(String s) {
//             System.out.println("String is (From inner class): " + s);
//         }
//     }

//     public static void main(String[] args) {
//         Greet obj = new InterafaceDemo();     // ✅ Interface reference to outer class object
//         InterafaceDemo objj = new InterafaceDemo();  // ✅ Direct outer class object

//         obj.greet("Normal");            // ✅ Works via interface
//         objj.greet("vaibhav");         // ✅ Works via class reference

//         InnerDemo obb = new InnerDemo();  // ✅ Inner class object
//         obb.greet("HELLO I AM inner class object");

//         Greet obbj = new InnerDemo();     // ✅ Polymorphism with interface
//         obbj.greet("i am interface name  =  new Innerclass()");

//         Greet g1 = (s) -> System.out.println("Your string is : "+s);
//         g1.greet("FROM lambda expression.");

        
//     }
// }


interface DailyDiaries{
    void ReadDiary();
    static void DrinkThenRead(){
        System.out.println("I am drinking water.Now i'll read after it.");
    }
    default void makeabookmark(){
        System.out.println("Bookmark Added.");
    }
    //void ReadDiaryLouder();
}

class Diary implements DailyDiaries{
    
    public void ReadDiary(){
        System.out.println("HI i am reading diary.");
    }

    static void DrinkThenRead(){
        System.out.println("I am drink and read of class. But i am not overridden i am a separate method which is acceessiblee via cclass only.");
    }

    public void makeabookmark(){
        System.out.println("I am overriden method of Diary class.");
    }


}

public class InterafaceDemo{
    public static void main(String[] args) {
        DailyDiaries obj = new Diary();
        obj.ReadDiary();
        obj.makeabookmark();
        DailyDiaries.DrinkThenRead();
        Diary.DrinkThenRead();
        
        DailyDiaries ob = new DailyDiaries(){
            public void ReadDiary(){
               System.out.println("Reading diary from anonymous class.");
            }
        };
        ob.makeabookmark();
        }
} 

