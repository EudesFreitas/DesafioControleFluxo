import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NovoProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Novo Processo Seletivo");

        analisarCandidato(1300.0);
        analisarCandidato(2500.0);
        analisarCandidato(2100.0);

        System.out.println("\n-- Seleção de novos candidatos --");
        selecaoCandidatos();

        System.out.println("\n-- Imprimir Novos Selecionados --");
        imprimirSelecionados();

        String[] candidatos = {"Fernanda", "Paulo", "Juliana", "Rafael", "Mariana", "André", "Camila", "Renato", "Viviane", "Thiago"};
        for (String candidato : candidatos) {
            entrarEmContato(candidato);
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO IMEDIATAMENTE");
        }else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM URGÊNCIA");
        }else {
            System.out.println("AGUARDAR MELHORES OPÇÕES");
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"Fernanda", "Paulo", "Juliana", "Rafael", "Mariana", "André", "Camila", "Renato", "Viviane", "Thiago"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " - valor: " + salarioPretendido);

            if(salarioBase >= salarioPretendido) {
                System.out.println(candidato + " selecionado para a vaga!");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2600);
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"Fernanda", "Paulo", "Juliana", "Rafael", "Mariana", "André", "Camila", "Renato", "Viviane", "Thiago"};
        System.out.println("Lista de candidatos selecionados:");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("Candidato número " + (i+1) + ": " + candidatos[i]);
        }
    }

    static boolean atender() {
        return new Random().nextInt(4) == 1;
    }

    static void entrarEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando) {
                System.out.println("Tentativa " + tentativasRealizadas + " de contato com " + candidato + " falhou.");
                tentativasRealizadas++;
            }else {
                System.out.println("Contato realizado com sucesso com " + candidato + " na tentativa " + tentativasRealizadas + "!");
            }
        } while(continuaTentando && tentativasRealizadas < 3);

        if(!atendeu) {
            System.out.println("NÃO conseguimos contato com " + candidato + " após " + tentativasRealizadas + " tentativas.");
        }
    }
}

