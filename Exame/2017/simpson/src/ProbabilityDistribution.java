import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

import static java.lang.Math.*;

public abstract class ProbabilityDistribution implements Function  {
    double mean, stddev, fcnst;
    private static Dictionary<String, ProbabilityDistribution> distributionDictionary = new Hashtable<>();

    public ProbabilityDistribution() {
        mean = 0;
        stddev = 1;
        fcnst = 1 / sqrt(2 * Math.PI);
    }

    public ProbabilityDistribution(double mean, double stddev) throws IllegalArgumentException {
        if (stddev <= 0) {
            throw new IllegalArgumentException();
        }
        this.mean = mean;
        this.stddev = stddev;
        this.fcnst = 1 / (stddev * sqrt(2 * Math.PI));
    }

    public ProbabilityDistribution(String name, double mean, double stddev) throws IllegalArgumentException {
        if (stddev <= 0) {
            throw new IllegalArgumentException();
        }
        this.mean = mean;
        this.stddev = stddev;
        this.fcnst = 1 / (stddev * sqrt(2 * Math.PI));
        distributionDictionary.put(name, this);
    }

    public double getMean() {
        return mean;
    }

    public double getStddev() {
        return stddev;
    }

    public abstract double probabilityDensityFunction(double t);

    public abstract double calcRangeProbability(double a, double b);

    public double calcLeftProbability(double a) {
        return calcRangeProbability(-100, a);
    }

    @Override
    public abstract double evaluate(double x);

    public static ProbabilityDistribution find(String name) {
        return distributionDictionary.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProbabilityDistribution that = (ProbabilityDistribution) o;
        return Double.compare(that.mean, mean) == 0 &&
                Double.compare(that.stddev, stddev) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mean, stddev);
    }
}
