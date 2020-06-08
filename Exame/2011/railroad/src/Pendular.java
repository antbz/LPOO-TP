public class Pendular extends Comboio {
    public Pendular(String nome) {
        super(nome);
        servicoABordo = new ServicoSemEnjoos();
    }

    @Override
    public String toString() {
        String str = "Pendular " + nome + ", " + getNumCarruagens() + " ";
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
