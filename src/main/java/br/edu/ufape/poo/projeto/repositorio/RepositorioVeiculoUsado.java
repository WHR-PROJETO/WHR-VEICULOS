package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;

@Repository
public interface RepositorioVeiculoUsado extends JpaRepository<VeiculoUsado, Long> {

	public VeiculoUsado findByChassi(String chassi);

	public VeiculoUsado findById(long id);

	public VeiculoUsado findByPlaca(String placa);

	public VeiculoUsado findByKm(float km);

	public VeiculoUsado findByVendido(boolean vendido);

	public VeiculoUsado findByValorCompraVeiculo(float valorCompraVeiculo);
	
	public List<VeiculoUsado> findByValorVenda(float valorVenda);
	
	public List<VeiculoUsado> findAllByVendido(boolean vendido);

}