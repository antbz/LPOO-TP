public abstract class LogicGate {
    private LogicVariable output;
    private LogicVariable[] inputs;
    protected String symbol;

    public LogicGate(LogicVariable output, LogicVariable input) throws CollisionException, CycleException {
        if (output.getCalculatedBy() != null) {
            throw new CollisionException();
        }
        if (input.getCalculatedBy() != null && input.getCalculatedBy().getInputs()[0].equals(output)) {
            throw new CycleException();
        }
        this.output = output;
        inputs = new LogicVariable[]{input};
        output.setCalculatedBy(this);
    }

    public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2) throws CollisionException, CycleException {
        if (output.getCalculatedBy() != null) {
            throw new CollisionException();
        }
        if (input1.getCalculatedBy() != null &&
            (input1.getCalculatedBy().getInputs()[0].equals(output) ||
            input1.getCalculatedBy().getInputs()[1].equals(output)) ||
            input2.getCalculatedBy() != null &&
            (input2.getCalculatedBy().getInputs()[0].equals(output) ||
            input2.getCalculatedBy().getInputs()[1].equals(output))) {
            throw new CycleException();
        }
        this.output = output;
        this.inputs = new LogicVariable[]{input1, input2};
        output.setCalculatedBy(this);
    }

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs() {
        return inputs;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getFormula() {
        return output.getFormula();
    }

    public abstract boolean update();
}
