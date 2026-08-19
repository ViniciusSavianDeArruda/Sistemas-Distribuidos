import controller.CaixaController;

/**
 * Classe principal da aplicação.
 * Responsável apenas por iniciar o sistema através do CaixaController.
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     */
    public static void main(String[] args) {

        // Cria o Controller responsável pelo processamento
        CaixaController controller = new CaixaController();

        // Inicia a execução do sistema
        controller.executarProcessamento();
    }
}
