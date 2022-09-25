package br.edu.ufape.poo.projeto.cadastro;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.cadastro.exceptions.VendaSemLucroException;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemPessoaJuridica;

@Service
@Transactional
public class CadastroOrdemPessoaJuridica {

	@Autowired
	private RepositorioOrdemPessoaJuridica repositorioOrdemPessoaJuridica;

	public OrdemVendaPessoaJuridica save(OrdemVendaPessoaJuridica entity)
			throws ValorNuloExpection, ValorForaRangeException, DataForaRangeException, VendaSemLucroException {
		if (Objects.isNull(entity.getPago()) || Objects.isNull(entity.getNovo())
				|| Objects.isNull(entity.getVendaConcluida()) || entity.getFormaPagamento().isEmpty()
				|| Objects.isNull(entity.getValor()) || Objects.isNull(entity.getVendedor())
				|| Objects.isNull(entity.getVeiculo()) || Objects.isNull(entity.getVeiculo().getModelo())
				|| entity.getDataOperacao().before(new Date())) {
			throw new ValorNuloExpection("Erro ao cadastrar, informações inválidas");
		} else {
			if (Objects.isNull(entity.getDataOperacao())) {
				throw new DataForaRangeException("Erro ao cadastrar, data inválida");
			} else {

				return repositorioOrdemPessoaJuridica.save(entity);
			}
		}
	}

	public void delete(OrdemVendaPessoaJuridica entity) {
		repositorioOrdemPessoaJuridica.delete(entity);
	}

	public void deleteById(long id) {
		repositorioOrdemPessoaJuridica.deleteById(id);
	}

	public OrdemVendaPessoaJuridica update(OrdemVendaPessoaJuridica entity) {
		return repositorioOrdemPessoaJuridica.save(entity);
	}

	public OrdemVendaPessoaJuridica findById(long id) {
		return repositorioOrdemPessoaJuridica.findById(id);
	}

	public List<OrdemVendaPessoaJuridica> findAll() {
		return repositorioOrdemPessoaJuridica.findAll();
	}

	public List<OrdemVendaPessoaJuridica> findByPago(boolean pago) {
		return repositorioOrdemPessoaJuridica.findByPago(pago);
	}

}