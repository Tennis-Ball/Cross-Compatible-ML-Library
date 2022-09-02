package Java.lib;
import java.util.ArrayList;

public class Loss {
    private Helper func = new Helper();
    
    public double calculate(ArrayList<ArrayList<Double>> output, ArrayList<ArrayList<Double>> y) {
        // check param types
        ArrayList<ArrayList<Double>> sample_losses = this.forward(output, y); // called in CatCross, apparently...
        double data_loss = func.mean(sample_losses); // IDK ANY OF THE TYPES AYAHH
        return data_loss;
    }
}
