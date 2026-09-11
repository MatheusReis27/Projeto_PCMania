package PcMania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //cria o cliente
        Cliente cliente = new Cliente("João da Silva", "123.456.789-00");

        //inicializa com um valor inteiro q n vai inteferir nos cases
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n- MENU PC MANIA -");
            System.out.println("1 - Adicionar PC Promoção 1");
            System.out.println("2- Adicionar PC Promoção 2");
            System.out.println("3 - Adicionar PC Promoção 3");
            System.out.println("0 - Finalizar Compra");
            System.out.print("Escolha sua opção: ");

            opcao = entrada.nextInt();

            if (opcao == 0) {
                System.out.println("Finalizando carrinho...");
                break;
            }

            switch (opcao) {
                case 1:
                    //instanciando o pc1
                    Computador pc1 = new Computador("Positivo", 3300.00f, "Linux Ubuntu", 32);
                    pc1.addHardwareBasico(new HardwareBasico("Pentium Core i3", 2200));
                    pc1.addHardwareBasico(new HardwareBasico("Memória RAM", 8));
                    pc1.addHardwareBasico(new HardwareBasico("HD", 500));
                    //instanciando memoria
                    MemoriaUSB penDrive1 = new MemoriaUSB("Pen-drive", 16);
                    //agregacao da memoria no pc
                    pc1.addMemoriaUSB(penDrive1);
                    //adiciona
                    cliente.adicionarCompra(pc1);
                    System.out.println("PC Promoção 1 adicionado ao carrinho!");
                    break;

                case 2:
                    Computador pc2 = new Computador("Acer", 8800.00f, "Windows 8", 64);
                    pc2.addHardwareBasico(new HardwareBasico("Pentium Core i5", 3370));
                    pc2.addHardwareBasico(new HardwareBasico("Memória RAM", 16));
                    pc2.addHardwareBasico(new HardwareBasico("HD", 1000));
                    MemoriaUSB penDrive2 = new MemoriaUSB("Pen-drive", 32);
                    pc2.addMemoriaUSB(penDrive2);
                    cliente.adicionarCompra(pc2);
                    System.out.println("PC Promoção 2 adicionado ao carrinho!");
                    break;

                case 3:
                    Computador pc3 = new Computador("Vaio", 4800.00f, "Windows 10", 64);
                    pc3.addHardwareBasico(new HardwareBasico("Pentium Core i7", 4500));
                    pc3.addHardwareBasico(new HardwareBasico("Memória RAM", 32));
                    pc3.addHardwareBasico(new HardwareBasico("HD", 2000));
                    MemoriaUSB hdExterno = new MemoriaUSB("HD Externo", 1000);
                    pc3.addMemoriaUSB(hdExterno);
                    cliente.adicionarCompra(pc3);
                    System.out.println("PC Promoção 3 adicionado ao carrinho!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        entrada.close();

        //relatório final
        System.out.println("- RECIBO DA COMPRA -");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        //config de cada PC comprado
        System.out.println("Itens comprados:");
        for (int i = 0; i < cliente.getComputadores().length; i++) {
            if (cliente.getComputadores()[i] != null) {
                cliente.getComputadores()[i].mostraPCConfigs();
                System.out.println("-----------------------------------");
            }
        }

        //manda a lista PCs para o método processar
        ProcessarPedido.processar(cliente.getComputadores());

        System.out.println("Total a pagar: R$ " + cliente.calcularTotalCompra());
    }
}