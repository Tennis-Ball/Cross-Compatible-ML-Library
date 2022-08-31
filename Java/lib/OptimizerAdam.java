import java.lang.reflect.Field;
import java.util.ArrayList;

public class OptimizerAdam {
    private double learning_rate;
    private double current_learning_rate;
    private double decay;
    private int iterations;
    private double epsilon;
    private double beta_1;
    private double beta_2;

    private Helper func = new Helper();

    // Temperary constant settings
    public OptimizerAdam(double learning_rate, double decay, double epsilon, double beta_1, double beta_2) {
        this.learning_rate = 0.001;
        this.current_learning_rate = this.learning_rate;
        this.decay = 0.;
        this.iterations = 0;
        this.epsilon = 1e-7;
        this.beta_1 = 0.9;
        this.beta_2 = 0.999;
    }

    public void pre_update_params() {
        if (decay != 0.) {
            current_learning_rate = learning_rate * (1. / (1. + decay * iterations));
        }
    }

    public void update_params(Object layer) {
        if (!hasattr(layer, "weight_cache")) {
            layer.weight_momentums = func.zeros_like(layer.weights);
            layer.weight_cache = func.zeros_like(layer.weights);
            layer.bias_momentums = func.zeros_like(layer.biases);
            layer.bias_cache = func.zeros_like(layer.biases);
        }

        layer.weights_momentums = func.add_mats(func.mult(beta_1, layer.weight_momentums), func.mult((1 - beta_1), layer.delta_weights));
        layer.bias_momentums = func.add_mats(func.mult(beta_1, layer.bias_momentums), func.mult((1 - beta_1), layer.delta_biases));

        ArrayList<ArrayList<Double>> weight_momentums_corrected = func.div(layer.weight_momentums, 1 - Math.pow(beta_1, (iterations + 1)));
        ArrayList<ArrayList<Double>> bias_momentums_corrected = func.div(layer.bias_momentums, 1 - Math.pow(beta_1, (iterations + 1)));

        layer.weight_cache = func.add_mats(func.mult(beta_2, layer.weight_cache), func.mult(1 - beta_2, func.pow(layer.delta_weights, 2)));
        layer.bias_cache = func.add_mats(func.mult(beta_2, layer.bias_cache), func.mult(1 - beta_2, func.pow(layer.delta_biases, 2)));

        ArrayList<ArrayList<Double>> weight_cache_corrected = func.div(layer.weight_cache, 1 - Math.pow(beta_2, self.iterations + 1));
        ArrayList<ArrayList<Double>> bias_cache_corrected = func.div(layer.bias_cache, 1 - Math.pow(beta_2, self.iterations + 1));

        layer.weights = func.add_mats(layer.weights, func.div(func.mult(-current_learning_rate, weight_momentums_corrected), func.add(epsilon, func.sqrt(weight_cache_corrected)))); //??? how to take root and div/mult mats
        layer.biases = func.add_mats(layer.biases, func.div(func.mult(-current_learning_rate, bias_momentums_corrected), func.add(epsilon, func.sqrt(bias_cache_corrected))));
    }

    public void post_update_params() {
        iterations += 1;
    }

    private boolean hasattr(Object obj, String attribute) {
        Class<?> clazz = obj.getClass();
     
        for(Field field : clazz.getDeclaredFields()) {
            if (attribute == field.getName()) {
                return true;
            }
        }

        return false;
     }
}