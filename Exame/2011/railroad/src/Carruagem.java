import java.util.Objects;

public class Carruagem {
    private int numLugares;

    public Carruagem(int numLugares) {
        this.numLugares = numLugares;
    }

    public int getNumLugares() {
        return numLugares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carruagem carruagem = (Carruagem) o;
        return numLugares == carruagem.numLugares;
    }
}
