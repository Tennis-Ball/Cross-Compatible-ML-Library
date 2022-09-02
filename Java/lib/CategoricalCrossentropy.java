package Java.lib;
import java.util.ArrayList;

public class CategoricalCrossentropy {
    private Helper func = new Helper();

    public ArrayList<ArrayList<Double>> forward(ArrayList<ArrayList<Double>> y_pred, ArrayList<ArrayList<Double>> y_true) {
        int samples = y_pred.size();
        ArrayList<ArrayList<Double>> y_pred_clipped = func.clip(y_pred, 1e-7, 1 - 1e-7);

        // TBC
    }
}
