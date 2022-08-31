package Java.lib;
import java.util.ArrayList;

public class SigmoidActivation {
    private ArrayList<ArrayList<Double>> inputs = new ArrayList<ArrayList<Double>>();  // is inputs a number??
    private double output;
    private ArrayList<ArrayList<Double>> delta_inputs = new ArrayList<ArrayList<Double>>();

    private Helper func = new Helper();

    public void forward(ArrayList<ArrayList<Double>> inputs) {
        this.inputs = inputs;
        output = func.div(1, func.add(1, func.exp(func.neg(inputs))));
    }

    public void backward(ArrayList<ArrayList<Double>> delta_values) {
        delta_inputs = func.mult(output * (1 - output), delta_values);
    }

    public String json() {
        return "Sigmoid";
    }
}
