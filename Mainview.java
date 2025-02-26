import java.util.Date;
import java.util.Scanner;

class Visao {
    private Controladora controladora;

    public Visao() {
        this.controladora = new Controladora();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Gerenciar Usuários");
            System.out.println("3. Gerenciar Veículos");
            System.out.println("4. Gerenciar Clientes");
            System.out.println("5. Gerenciar Aluguéis");
            System.out.println("6. Gerar Relatórios");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 0) break;
            switch (opcao) {
                case 1:
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    if (controladora.autenticarUsuario(login, senha)) {
                        System.out.println("Login bem-sucedido!");
                    }
                    break;
                case 5:
                    System.out.print("ID Veículo: ");
                    int idVeiculo = scanner.nextInt();
                    System.out.print("ID Cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    // Usando data fixa para simplificar
                    Date dataRet = new Date();
                    Date dataPrev = new Date();
                    controladora.gerenciarAlugueis(idVeiculo, idCliente, dataRet, dataPrev, null, "cadastrar");
                    break;
                case 6:
                    System.out.print("Tipo (veiculosPorData/receitaMensal): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Parâmetro (data ou MM/AAAA): ");
                    String param = scanner.nextLine();
                    if ("veiculosPorData".equals(tipo)) {
                        System.out.println(controladora.gerarRelatorios(tipo, new Date()));
                    } else {
                        System.out.println(controladora.gerarRelatorios(tipo, param));
                    }
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Visao visao = new Visao();
        visao.exibirMenu();
    }
}