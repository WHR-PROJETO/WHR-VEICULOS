package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemPessoaFisica;

@Service
public class CadastroOrdemPessoaFisica {
	
	@Autowired
	private RepositorioOrdemPessoaFisica repositorioOrdemPessoaFisica;

	public OrdemVendaPessoaFisica save(OrdemVendaPessoaFisica entity) {
		return repositorioOrdemPessoaFisica.save(entity);
	}
	
	public void delete(OrdemVendaPessoaFisica entity) {
		repositorioOrdemPessoaFisica.delete(entity);
	}

	public List<OrdemVendaPessoaFisica> findAll() {
		return repositorioOrdemPessoaFisica.findAll();
	}
	
	public List<OrdemVendaPessoaFisica> findByCodVenda(String codVenda) {
		return repositorioOrdemPessoaFisica.findByCodVenda(codVenda);
	}
	
	public List<OrdemVendaPessoaFisica> findByPago(boolean pago) {
		return repositorioOrdemPessoaFisica.findByPago(pago);
	}
	
	
	
}