package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;

public interface IFuncionario {
	public boolean checarSalario(float salario) throws ValorNegativoException;
}