import java.util.ArrayList;

public class experimentation {
    public static void test(ArrayList<Integer> x) {
        ArrayList<Integer> y = x;
        y.add(42);

        System.out.println(x.toString());
        System.out.println(y.toString());
    }
    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(42);
        
        test(x);
    }
}
