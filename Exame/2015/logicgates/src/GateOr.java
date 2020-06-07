public class GateOr extends LogicGate {
    public GateOr(LogicVariable output, LogicVariable input1, LogicVariable input2) throws CollisionException, CycleException {
        super(output, input1, input2);
        super.symbol = "OR";
        output.setValue(input1.getValue() || input2.getValue());
        output.setFormula("OR(" + input1.getFormula() + "," + input2.getFormula() + ")");
    }

    @Override
    public boolean update() {
        return getInputs()[0].getValue() || getInputs()[1].getValue();
    }
}
