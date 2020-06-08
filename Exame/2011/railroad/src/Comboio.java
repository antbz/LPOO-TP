import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comboio {
    protected String nome;
    List<Carruagem> carruagens = new ArrayList<>();
    int numPassageiros = 0;
    protected ServicoABordo servicoABordo = new ServicoRegular();

    public Comboio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addCarruagem(Carruagem carruagem) {
        carruagens.add(carruagem);
    }

    public Carruagem getCarruagemByOrder(int i) {
        return carruagens.get(i);
    }

    public int getNumCarruagens() {
        return carruagens.size();
    }

    public int getNumLugares() {
        int lugares = 0;
        for (Carruagem c : carruagens)
            lugares += c.getNumLugares();
        return lugares;
    }

    public void removeAllCarruagens(int cap) {
        carruagens.removeIf(carruagem -> (carruagem.getNumLugares() == cap));
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public int getLugaresLivres() {
        return getNumLugares() - numPassageiros;
    }

    public void addPassageiros(int num) throws PassengerCapacityExceeded {
        if (num > getLugaresLivres()) throw new PassengerCapacityExceeded();
        numPassageiros += num;
    }

    public void removePassageiros() {
        numPassageiros = 0;
    }

    public void removePassageiros(int num) {
        numPassageiros -= num;
        if (numPassageiros < 0) numPassageiros = 0;
    }

    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }

    public String getDescricaoServico() {
        return servicoABordo.getDescricaoServico();
    }

    @Override
    public String toString() {
        String str = "Comboio " + nome + ", " + getNumCarruagens() + " ";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comboio comboio = (Comboio) o;
        return carruagens.equals(comboio.carruagens);
    }
}
