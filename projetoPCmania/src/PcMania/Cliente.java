package PcMania;

public class Cliente {
    private String nome;
    private String cpf;

    private Computador[] computadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];
    }

    //adiciona pc no array
    public void adicionarCompra(Computador pc) {
        for (int i = 0; i < this.computadores.length; i++) {
            //verifica se ta vazia
            if (this.computadores[i] == null) {
                this.computadores[i] = pc;
                break;
            }
        }
    }

    public float calcularTotalCompra() {
        float total = 0;

        for (int i = 0; i < this.computadores.length; i++) {
            //nao deixa ler algo vazio
            if (this.computadores[i] != null) {
                //usa o getter do pc atual
                total += this.computadores[i].getPreco();
            }
        }

        return total;
    }

    //getters para o final na main
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return this.computadores;
    }
}
