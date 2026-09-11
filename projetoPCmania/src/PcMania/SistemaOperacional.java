package PcMania;

public class SistemaOperacional {
    private String nome;
    private int tipo;

    public SistemaOperacional(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getTipo() {
        return this.tipo;
    }

}
