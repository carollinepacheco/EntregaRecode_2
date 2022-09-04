package Main;

import static java.lang.System.out;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import conexao.Access;
import dao.PromocaoDAO;
import model.Promocao;

public class Menu_promocao {

	public static void listarPromocao(List<Promocao> promo) throws Exception {
	
        for (var p  : promo ) {
            out.println(
                    "Id: " + p.getId() +
                    "\nNoome da Promocao: " + p.getNomePromocao() +
                    "\nTipo da Promocao: " + p.getTipoPromocao() +
                    "\nDesconto: " + p.getDesconto() +
                    "\nId do Pacote de Viagens: " + p.getFk_pacoteViagens_id());
            out.println("---------------------------------");
        }
    }

	public static void cadastrarPromocao(Promocao promocao) throws Exception {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Nome da Promoção: ");
		promocao.setNomePromocao(input.nextLine());

		System.out.println("Tipo da Promoção: ");
		promocao.setTipoPromocao(input.nextLine());

		System.out.println("Informe o percentual de desconto: ");
		promocao.setDesconto(input.nextDouble());

		System.out.println("Informe o ID do Pacote de Viagens: ");
		promocao.setFk_pacoteViagens_id(input.nextInt());
	}

	public static void editarPromocao(Promocao promocao) throws ParseException {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Nome da Promoção: ");
		promocao.setNomePromocao(input.nextLine());

		System.out.println("Tipo da Promoção: ");
		promocao.setTipoPromocao(input.nextLine());

		System.out.println("Informe o percentual de desconto: ");
		promocao.setDesconto(input.nextDouble());

		System.out.println("Informe o ID do Pacote de Viagens: ");
		promocao.setFk_pacoteViagens_id(input.nextInt());
	}

	public static long deletarPromocao(Scanner scanner) {
		System.out.println("Informe o ID da Promocao que deseja editar: ");
		return scanner.nextInt();
	}

	public static int menu(Scanner scanner) {
		
		System.out.println("\t\tPROMOÇÕES");
		System.out.println("************************************************************");
		System.out.println(" 1 Consultar | 2 Cadastrar | 3 Editar | 4 Deletar | 0 Fim");
		System.out.print("Opcao -> ");
		return scanner.nextInt();
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PromocaoDAO promocaoDAO = new PromocaoDAO(Access.connectionFactory());

		System.out.println("\t\tMENU PRINCIPAL");
		System.out.println("************************************************************");
		var opcao = menu(scanner);

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				listarPromocao(promocaoDAO.listarPromocao(scanner));
                opcao = menu(scanner);
                break;
			case 2:
				Promocao p = new Promocao();
				cadastrarPromocao(p);
				promocaoDAO.cadastrarPromocao(p);
				opcao = menu(scanner);
				break;
			case 3:
				Promocao pUpdate = new Promocao();
				pUpdate.setId((int) deletarPromocao(scanner));
				editarPromocao(pUpdate);
				promocaoDAO.editarPromocao(pUpdate);
				opcao = menu(scanner);
				break;
			case 4:
				promocaoDAO.deletarPromocao(deletarPromocao(scanner));
				opcao = menu(scanner);
				break;

			}
		}
	}
}
