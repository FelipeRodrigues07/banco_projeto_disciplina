package database;

public class AcessoADado {

    public String cadastrar_conta(String numero, float saldo) {
        // Implementar a lógica de cadastro no banco de dados
        return "Conta " + numero + " cadastrada com saldo " + saldo;
    }

    public String cadastrar_conta_normal(String numero) {
        // Implementar lógica para cadastro de conta normal
        return "Conta normal " + numero + " cadastrada.";
    }
}
