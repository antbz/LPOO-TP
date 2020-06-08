public class ServicoRegular implements ServicoABordo {
    String descricao = "Servico regular.";

    @Override
    public String getDescricaoServico() {
        return descricao;
    }
}
