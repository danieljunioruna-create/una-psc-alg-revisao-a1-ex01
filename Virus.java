
import java.util.Scanner;

public class Virus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        // Perguntas e pesos
        String[] perguntas = {
            "Cartão de vacina está no dia?",
            "Teve sintomas recentemente?",
            "Teve contato com pessoas gripadas?",
            "Retornou de viagem ao exterior?"
        };

        int[] pesos = {10, 30, 30, 30};

        String[] respostas = new String[4];

        // Loop para cada pergunta
        for (int i = 0; i < perguntas.length; i++) {
            int tentativas = 0;
            while (tentativas < 3) {
                System.out.print(perguntas[i] + " (SIM/NAO): ");
                String resposta = scanner.nextLine().trim().toUpperCase();

                if (resposta.equals("SIM") || resposta.equals("NAO")) {
                    respostas[i] = resposta;
                    break;
                } else {
                    tentativas++;
                    System.out.println("Resposta inválida. Tente novamente pelo amor de DEUS.");
                }
            }

            if (tentativas == 3) {
                System.out.println("\nNão foi possível realizar o diagnóstico.\nProcure ajuda médica sua anta .");
                return;
            }
        }

        // Cálculo do risco
        int risco = 0;
        if (respostas[0].equals("NAO")) risco += pesos[0];
        if (respostas[1].equals("SIM")) risco += pesos[1];
        if (respostas[2].equals("SIM")) risco += pesos[2];
        if (respostas[3].equals("SIM")) risco += pesos[3];

        // Orientação
        String orientacao;
        if (risco <= 30) {
            orientacao = respostas[3].equals("SIM") ? "Observação por 15 dias." : "Sob observação, procure médico se tiver sintomas.";
        } else if (risco <= 60) {
            orientacao = "Risco moderado: lockdown 20 dias.";
        } else if (risco < 90) {
            orientacao = "Alto risco: lockdown 99 dias.";
        } else {
            orientacao = "Crítico: lockdown 123456789 dias.";
        }

        // Impressão do relatório
        System.out.println("\n--- RELATÓRIO ---");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Vacina: " + respostas[0]);
        System.out.println("Sintomas: " + respostas[1]);
        System.out.println("Contato: " + respostas[2]);
        System.out.println("Viagem: " + respostas[3]);
        System.out.println("Risco: " + risco + "%");
        System.out.println("Orientação: " + orientacao);
    }
}
