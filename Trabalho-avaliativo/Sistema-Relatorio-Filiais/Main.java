import controller.FilialController;

/**
 * Classe principal da aplicação.
 * Responsável apenas por iniciar o sistema.
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     */
    public static void main(String[] args) {

        // Cria o Controller
        FilialController controller = new FilialController();

        // Inicia o processamento
        controller.executarProcessamento();
    }
}
