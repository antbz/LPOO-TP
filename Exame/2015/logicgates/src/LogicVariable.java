import java.util.Objects;

public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calculatedBy = null;
    private String formula;

    public LogicVariable(String name) {
        this.name = name;
        this.value = false;
        this.formula = name;
    }

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.formula = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        if (calculatedBy != null) {
            value = calculatedBy.update();
        }
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicVariable that = (LogicVariable) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
