public class GateNot extends LogicGate {
    public GateNot(LogicVariable output, LogicVariable input) throws CollisionException, CycleException {
        super(output, input);
        super.symbol = "NOT";
        output.setValue(!input.getValue());
        output.setFormula("NOT(" + input.getFormula() + ")");
    }

    @Override
    public boolean update() {
        return !getInputs()[0].getValue();
    }
}
