import static java.lang.Math.*;

public class NormalDistribution extends ProbabilityDistribution {
    public NormalDistribution() {
    }

    public NormalDistribution(double mean, double stddev) {
        super(mean, stddev);
    }

    public NormalDistribution(String name, double mean, double stddev) throws IllegalArgumentException {
        super(name, mean, stddev);
    }

    @Override
    public double probabilityDensityFunction(double t) {
        return fcnst * Math.exp(-0.5 * pow(t - mean, 2) / pow(stddev, 2));
    }

    @Override
    public double calcRangeProbability(double a, double b) {
        double za = (a - mean) / stddev;
        double zb = (b - mean) / stddev;
        return SimpsonMethod.calcIntegral(this, za, zb, 5e-7) / sqrt(2 * Math.PI);
    }

    @Override
    public double evaluate(double x) {
        return exp(-pow(x, 2) / 2);
    }

    @Override
    public String toString() {
        return "N(" + mean +
                ", " + stddev +
                ')';
    }
}
