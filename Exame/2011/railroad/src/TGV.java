public class TGV extends Comboio {
    public TGV(String nome) {
        super(nome);
        servicoABordo = new ServicoPrioritario();
    }

    @Override
    public String toString() {
        String str = "TGV " + nome + ", " + getNumCarruagens() + " ";
        if (getNumCarruagens() == 1) str += "carruagem";
        else str += "carruagens";
        str += ", " + getNumLugares() + " ";
        if (getNumLugares() == 1) str += "lugar";
        else str += "lugares";
        str += ", " + numPassageiros + " ";
        if (numPassageiros == 1) str += "passageiro";
        else str += "passageiros";
        return str;
    }
}
