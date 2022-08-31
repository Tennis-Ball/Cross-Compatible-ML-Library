import java.util.ArrayList;

public class ReLUActivation {
    private ArrayList<ArrayList<Double>> inputs = new ArrayList<ArrayList<Double>>();  // is inputs a number??
    private double output;
    private ArrayList<ArrayList<Double>> delta_inputs = new ArrayList<ArrayList<Double>>();

    private Helper func = new Helper();

    public void forward(ArrayList<ArrayList<Double>> inputs) {
        this.inputs = inputs;
        this.output = Math.max(0, inputs);  // how does this work????
    }

    public void backward(ArrayList<ArrayList<Double>> delta_values) {
        this.delta_inputs = func.copy(delta_values);  // copy arraylist??
        self.delta_inputs[self.output <= 0] = 0  // if x<0, delta will be 0 because curve is flat  TODO: uhh...
    }

    public String json() {
        return "ReLU";
    }
}
