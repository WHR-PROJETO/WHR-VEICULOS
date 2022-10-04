package br.edu.ufape.poo.factory;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestFactory {

	@Autowired
	private CadastroClienteFisico ccf;

	@Autowired
	private CadastroClienteJuridico ccj;

	@Autowired
	private CadastroFuncionario cff;

	@Autowired
	private CadastroModelo cmo;

	@Autowired
	private CadastroVeiculoNovo cvn;

	@Autowired
	private CadastroVeiculoUsado cvu;

	Faker faker = new Faker(new Locale("pt-BR"));

	@Test
	void saveClienteFisico() throws ClienteFisicoExistenteException, DataForaRangeException, ValorNuloExpection,
			ValorForaRangeException, DataNulaException {

		for (int x = 0; x < 10; x++) {
			
			ccf.save(ClienteFisicoFactory.generate());

		}
		

	}

	@Test
	void saveClienteJuridico() throws ClienteJuridicoExistenteException, ValorNuloExpection, ValorForaRangeException {

		for (int x = 0; x < 10; x++) {
			ccj.save(ClienteJuridicoFactory.generate());
		}
	}

	@Test
	void saveFuncionario() throws DataNulaException, FuncionarioExistenteException, ValorNuloExpection, DataForaRangeException {

		////////////////////////// GERENTES ////////////////////////
		
		for (int x = 0; x < 5; x++) {
		
			cff.save(FuncionarioFactory.generate("Gerente"));
		}

		/////////////////////// VENDEDORES ///////////////////////
		
		for (int x = 0; x < 5; x++) {

			cff.save(FuncionarioFactory.generate("Vendedor"));
		}
	}

	@Test
	void saveModelo() throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException {

		////////////////////////////// AUTOMATICOS ///////////////////////////////

		for (int x = 0; x < 5; x++) {
			cmo.save(ModeloFactory.generate("Automático"));
		}

		/////////////////////////////// MANUAIS ////////////////////////////////

		for (int x = 0; x < 5; x++) {
			cmo.save(ModeloFactory.generate("Manual"));
		}

		/////////////////////////////// SEMI-AUTOMATICO ///////////////////////////

		for (int x = 0; x < 5; x++) {
			cmo.save( ModeloFactory.generate("Semi-Automático"));
		}

	}

	@Test
	void saveVeiculoNovo() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, NomeUnicoException {

		////////////////////////////// AUTOMATICOS ///////////////////////////////

		for (int x = 0; x < 5; x++) {
			VeiculoNovo m = VeiculoNovoFactory.generate("Automático");
			m.setModelo(cmo.save(m.getModelo()));
			cvn.save(m);
		}

		/////////////////////////////// MANUAIS ////////////////////////////////

		for (int x = 0; x < 5; x++) {
			VeiculoNovo m = VeiculoNovoFactory.generate("Manual");
			m.setModelo(cmo.save(m.getModelo()));
			cvn.save(m);
		}

		/////////////////////////////// SEMI-AUTOMATICO ///////////////////////////

		for (int x = 0; x < 5; x++) {
			VeiculoNovo m = VeiculoNovoFactory.generate("Semi-Automático");
			m.setModelo(cmo.save(m.getModelo()));
			cvn.save(m);
		}

	}

	@Test
	void saveVeiculoUsado() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, NomeUnicoException, PlacaExistenteException {

		////////////////////////////// AUTOMATICOS ///////////////////////////////

		for (int x = 0; x < 5; x++) {
			VeiculoUsado m = VeiculoUsadoFactory.generate("Automático");
			m.setModelo(cmo.save(m.getModelo()));
			cvu.save(m);
		}

		/////////////////////////////// MANUAIS ////////////////////////////////

		for (int x = 0; x < 5; x++) {
			VeiculoUsado m = VeiculoUsadoFactory.generate("Manual");
			m.setModelo(cmo.save(m.getModelo()));
			cvu.save(m);
		}

		/////////////////////////////// SEMI-AUTOMATICO ///////////////////////////

		for (int x = 0; x < 5; x++) {
			VeiculoUsado m = VeiculoUsadoFactory.generate("Semi-Automático");
			m.setModelo(cmo.save(m.getModelo()));
			cvu.save(m);
		}

	}

}