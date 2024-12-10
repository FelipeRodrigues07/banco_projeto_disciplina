package apresentacao;

import java.util.ArrayList;
import java.util.Iterator;

import model.Conta;
import model.ContaNormal;
import database.AcessoADado;
import model.ContaDebEspecial;

public class Banco {
    private ArrayList<Conta> contas;

    // Construtor de Banco
    Banco() {
        contas = contas();
    }

    private ArrayList<Conta> contas() {
        if (contas == null) {
            contas = new ArrayList<>();
        }
        return contas;
    }

    private void CriaConta(Conta c) {
        contas.add(c);
    }

    private void RemoveConta(String numero) {
        Iterator<Conta> iterator = contas.iterator();
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c.getNumero().equals(numero)) {
                iterator.remove();
            }
        }
    }

    private void CreditaConta(String numero, double valor) {
        Iterator<Conta> iterator = contas.iterator();
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c.getNumero().equals(numero)) {
                c.creditar(valor);
            }
        }
    }

    private void DebitaConta(String numero, double valor) {
        Iterator<Conta> iterator = contas.iterator();
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c.getNumero().equals(numero)) {
                c.debitar(valor);
            }
        }
    }

    private void TransfereConta(String numero_conta_origem, String numero_conta_destino, double valor) {
        DebitaConta(numero_conta_origem, valor);
        CreditaConta(numero_conta_destino, valor);
    }

    private void ListaContas() {
        Iterator<Conta> iterator = contas.iterator();
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            System.out.printf("Conta %s  %s\n", c.getNumero(), c.getSaldo());
        }
    }

    public static void main(String args[]) {
        Banco banco = new Banco();
        AcessoADado a = new AcessoADado();

        Conta c1 = new ContaNormal();
        c1.setNumero("1654-3");
        c1.setSaldo(500);
        banco.CriaConta(c1);

        Conta c2 = new ContaDebEspecial();
        c2.setNumero("4067-6");
        c2.setSaldo(2500);
        banco.CriaConta(c2);

        banco.ListaContas();
        banco.CreditaConta("1654-3", 1000);
        banco.ListaContas();
        banco.TransfereConta("1654-3", "4067-6", 500);
        banco.ListaContas();
    }
}
