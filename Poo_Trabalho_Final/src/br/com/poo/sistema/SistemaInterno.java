package br.com.poo.sistema;
import java.io.IOException;

/*import java.util.Map;
import javax.swing.JOptionPane;
import br.com.poo.cargos.Cliente;
import br.com.poo.cargos.Funcionario;
import br.com.poo.cargos.Gerente;
import br.com.poo.cargos.Pessoa;*/

public class SistemaInterno {
	public static void main(String[] args) throws IOException {

		LeituraEscrita.leitor("banco.txt");

		HomePage homePage = new HomePage();

		homePage.login();

	}
}
