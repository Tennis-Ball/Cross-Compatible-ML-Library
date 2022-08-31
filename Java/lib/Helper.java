package Java.lib;

import java.util.ArrayList;

public class Helper {
    // Matrix multiplication, results into output matrix which should be initialized with 0s
    public void dot_product(ArrayList<ArrayList<Double>> matrixA, ArrayList<ArrayList<Double>> matrixB, ArrayList<ArrayList<Double>> output) {
        double product;
        for (int i=0; i<matrixA.size(); i++) {  // A rows
            for (int j=0; j<matrixB.get(0).size(); j++) {  // B columns
                for (int k=0; k<matrixA.get(0).size(); k++) {  // A columns
                    product = matrixA.get(i).get(k) * matrixB.get(k).get(j);  // multiply
                    product += output.get(i).get(j);  // add
                    output.get(i).set(j, product);  // set
                }
            }
        }
    }

    public ArrayList<ArrayList<Double>> zeros_like(ArrayList<ArrayList<Double>> inMat) {
        ArrayList<ArrayList<Double>> outMat = new ArrayList<ArrayList<Double>>();

        for (int i = 0; i < inMat.size(); i++) {
            outMat.add(new ArrayList<Double>());

            for (int j = 0; j < inMat.get(0).size(); j++) {
                outMat.get(i).add(0.00000);
            }
        }

        return outMat;
    }

    public ArrayList<ArrayList<Double>> mult(double val, ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(val * matrix.get(row).get(col));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> div(ArrayList<ArrayList<Double>> matrix, double val) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(matrix.get(row).get(col) / val);
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> div(double val, ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(val / matrix.get(row).get(col));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> pow(ArrayList<ArrayList<Double>> matrix, double val) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(Math.pow(matrix.get(row).get(col), val));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> add(double val, ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(val + matrix.get(row).get(col));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> sqrt(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(Math.sqrt(matrix.get(row).get(col)));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> exp(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();
        double E = 2.71828;

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(Math.pow(E, matrix.get(row).get(col)));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> neg(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();
        double E = 2.71828;

        for (int row=0; row<matrix.size(); row++) {
            output.add(new ArrayList<Double>());
            
            for (int col=0; col<matrix.get(0).size(); col++) {
                output.get(row).add(-matrix.get(row).get(col));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> add_mats(ArrayList<ArrayList<Double>> matA, ArrayList<ArrayList<Double>> matB) {
        ArrayList<ArrayList<Double>> output = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<matA.size(); row++) {
            output.add(new ArrayList<Double>());
            for (int col=0; col<matA.get(0).size(); col++) {
                output.get(row).add(matA.get(row).get(col) + matB.get(row).get(col));
            }
        }

        return output;
    }

    public ArrayList<ArrayList<Double>> copy(ArrayList<ArrayList<Double>> mat) {
        ArrayList<ArrayList<Double>> copy = new ArrayList<ArrayList<Double>>();

        for (int row=0; row<mat.size(); row++) {
            copy.add(new Arraylist<Double>());

            for (int col=0; col<mat.get(0).size(); col++) {
                copy.get(row).add(mat.get(row).get(col));
            }
        }

        return copy;
    }
}
