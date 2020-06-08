import java.util.Dictionary;
import java.util.Hashtable;

public class CombinatorialCircuit {
    Dictionary<String, LogicVariable> variables = new Hashtable<>();

    public boolean addVariable(LogicVariable variable) {
        if (variables.get(variable.getName()) == null) {
            variables.put(variable.getName(), variable);
            return true;
        }
        return false;
    }

    public LogicVariable getVariableByName(String name) {
        return variables.get(name);
    }
}
