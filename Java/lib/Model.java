package Java.lib;

import java.util.ArrayList;

public class Model {
    private ArrayList<ArrayList<String>> layers;
    private String loss_function;
    private String optimizer;

    public void add(String layer, String activation) {
        layers.add({layer, activation});
    }

    public void set_loss(String loss_function) {
        this.loss_function = loss_function;
    }

    public void set_optimizer(String optimizer) {
        this.optimizer = optimizer;
    }

    public ? loss(ArrayList<Double> true_y) {
        return loss_function.calculate(layers.get(layers.size() - 1).get(1).output, true_y);
    }

    public ArrayList<ArrayList<Double>> forward(ArrayList<ArrayList<Double>> inputs) {
        for (ArrayList<String> layer : layers) {
            layer.get(0).forward(inputs);
            layer.get(1).forward(layer.get(0).output);
            inputs = layer.get(1).output;
        }

        return inputs;
    }

    public ArrayList<ArrayList<Double>> backward(ArrayList<ArrayList<Double>> true_y) {
        loss_function.backward(layers.get(layers.size() - 1).get(1).output, true_y);
        ArrayList<ArrayList<Double>> delta_inputs = loss_function.delta_inputs;
        for (int layer=layers.size()-1; layer>=0; layer--) {
            layers.get(layer).get(1).backward(delta_inputs);
            layers.get(layer).get(0).backward(layers.get(layer).get(1).delta_inputs);
            delta_inputs = layers.get(layer).get(0).delta_inputs;
        }

        return delta_inputs;
    }

    public void optimize() {
        optimizer.pre_update_params();
        for (ArrayList<String> layer : layers) {
            optimizer.update_params(layer.get(0));
        }

        optimizer.post_update_params();
    }
}
