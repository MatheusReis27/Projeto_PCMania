package PcMania;

public class Computador {
    private String marca;
    private float preco;

    private MemoriaUSB memoriaUSB;
    private SistemaOperacional sistemaOperacional;
    private HardwareBasico[] hardwaresBasicos;

    public Computador(String marca, float preco, String nomeSO, int tipoSO) {
        this.marca = marca;
        this.preco = preco;
        this.hardwaresBasicos = new HardwareBasico[3];
        this.sistemaOperacional = new SistemaOperacional(nomeSO, tipoSO);
    }

    public void mostraPCConfigs() {
        System.out.println("Computador " + this.marca);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Sistema operacional do computador: " + this.sistemaOperacional.getNome() + " (" + this.sistemaOperacional.getTipo() + " bits)");
        System.out.println("Os hardwares básicos são: ");

        for (int i = 0; i < this.hardwaresBasicos.length; i++) {
            if (this.hardwaresBasicos[i] != null) {
                System.out.println(" " + this.hardwaresBasicos[i].getNome() + " (" + this.hardwaresBasicos[i].getCapacidade() + ")");
            }
        }

        if (this.memoriaUSB != null) {
            System.out.println("Tem: " + this.memoriaUSB.getNome() + " de " + this.memoriaUSB.getCapacidade() + "GB");
        }
    }

    public float getPreco() {
        return this.preco;
    }

    public void addMemoriaUSB(MemoriaUSB memUSB) {
        this.memoriaUSB = memUSB;
    }

    public void addHardwareBasico(HardwareBasico hb) {
        for (int i = 0; i < this.hardwaresBasicos.length; i++) {
            if (this.hardwaresBasicos[i] == null) {
                this.hardwaresBasicos[i] = hb;
                break;
            }
        }
    }
}