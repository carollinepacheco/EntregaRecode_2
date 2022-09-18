package Main;

import static java.lang.System.out;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import conexao.Access;
import dao.PacotesDAO;
import model.Pacotes;

public class Menu_pacotes {

	public static void listarPacotes(List<Pacotes> pacote) throws Exception {
	
        for (var p  : pacote ) {
            out.println(
                    "Id: " + p.getId() +
                    "\nNome: " + p.getDestino() +
                    "\nHospedagem: " + p.getHospedagem() +
                    "\nDiárias: " + p.getDiarias() +
                    "\nPreço: " + p.getPreco());
            out.println("---------------------------------");
        }
    }

	public static void cadastrarPacotes(Pacotes pacotes) throws Exception {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Nome do destino: ");
		pacotes.setDestino(input.nextLine());

		System.out.println("Nome da hospedagem: ");
		pacotes.setHospedagem(input.nextLine());

		System.out.println("Informe ás diárias: ");
		pacotes.setDiarias(input.nextLine());

		System.out.println("Preço do Pacote: ");
		pacotes.setPreco(input.nextDouble());
	}

	public static void editarPacotes(Pacotes pacotes) throws ParseException {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Nome do destino: ");
		pacotes.setDestino(input.nextLine());

		System.out.println("Nome da hospedagem: ");
		pacotes.setHospedagem(input.nextLine());

		System.out.println("Informe ás diárias: ");
		pacotes.setDiarias(input.nextLine());

		System.out.println("Preço do Pacote: ");
		pacotes.setPreco(input.nextDouble());
	}

	public static long deletarPacotes(Scanner scanner) {
		System.out.println("Informe o ID da Promocao que deseja editar: ");
		return scanner.nextInt();
	}

	public static int menu(Scanner scanner) {
		System.out.println("\n");
		System.out.println("************************************************************");
		System.out.println("\t\tPACOTES DE VIAGENS");
		System.out.println("************************************************************");
		System.out.println(" 1 Consultar | 2 Cadastrar | 3 Editar | 4 Deletar | 0 Fim");
		System.out.print("Opcao -> ");
		return scanner.nextInt();
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PacotesDAO pacotesDAO = new PacotesDAO(Access.connectionFactory());

		System.out.println("\t\tMENU PRINCIPAL");
		var opcao = menu(scanner);

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				listarPacotes(pacotesDAO.listarPacotes(scanner));
                opcao = menu(scanner);
                break;
			case 2:
				Pacotes pacotes = new Pacotes();
				cadastrarPacotes(pacotes);
				pacotesDAO.cadastrarPacotes(pacotes);
				opcao = menu(scanner);
				break;
			case 3:
				Pacotes pacoteUpdate = new Pacotes();
				pacoteUpdate.setId((int) deletarPacotes(scanner));
				editarPacotes(pacoteUpdate);
				pacotesDAO.editarPacotes(pacoteUpdate);
				opcao = menu(scanner);
				break;
			case 4:
				pacotesDAO.deletarPacotes(deletarPacotes(scanner));
				opcao = menu(scanner);
				break;

			}
		}
	}
}
