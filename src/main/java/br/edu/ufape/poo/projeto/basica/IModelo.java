package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.cadastro.exceptions.CilindradasForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PassageirosForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PotenciaForaRangeException;

public interface IModelo {
	public boolean checarPassageiros(int quantidade) throws PassageirosForaRangeException;

	public boolean checarAno(int ano) throws DataForaRangeException;

	public boolean chegarPotencia(int potencia) throws PotenciaForaRangeException;

	public boolean chegarCilindradas(int cilindradas) throws CilindradasForaRangeException;
}