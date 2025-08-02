import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        String cliente = "Alexandre Cavalcante";
        String tipoDeConta = "Corrente";
        double saldo = 2500.00;
        int opcao = 0;

        String menu = """
                
                *** Operações Disponíveis ***
                1- Consultar Saldo
                2- Realizar Transferência (Saque)
                3- Receber Valor (Depósito)
                4- Sair
                ****************************
                Digite a opção desejada:\s""";

        System.out.println("***********************");
        System.out.printf("Bem vindo ao SkyBank, %s.%n", cliente);
        System.out.printf("Conta: %s%n", tipoDeConta);
        System.out.println("***********************");

        Scanner scanner = new Scanner(System.in);

        while (opcao != 4) {
            System.out.print(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("%nSeu saldo atual é: R$%.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor a ser transferido: R$");
                    double valorTransferencia = scanner.nextDouble();

                    if (valorTransferencia > saldo) {
                        System.out.println("\nOperação não realizada. Saldo insuficiente.");
                    } else if (valorTransferencia <= 0) {
                        System.out.println("\nOperação não realizada. O valor deve ser positivo.");
                    } else {
                        saldo -= valorTransferencia;
                        System.out.printf("%nTransferência realizada! Seu novo saldo é: R$%.2f%n", saldo);
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor a ser recebido: R$");
                    double valorRecebido = scanner.nextDouble();

                    if (valorRecebido <= 0) {
                        System.out.println("\nOperação não realizada. O valor deve ser positivo.");
                    } else {
                        saldo += valorRecebido;
                        System.out.printf("%nValor recebido! Seu novo saldo é: R$%.2f%n", saldo);
                    }
                    break;

                case 4:

                    break;

                default:
                    System.out.println("\nOpção inválida! Por favor, selecione uma opção de 1 a 4.");
                    break;
            }
        }

        System.out.println("\nObrigado por usar o SkyBank. Sessão encerrada.");
        scanner.close();
    }
}