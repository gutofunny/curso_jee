package com.algaworks.financeiro.service;

import java.io.Serializable;
import java.util.Date;

import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.repository.Lancamentos;

public class CadastroLancamentos implements Serializable {
	private static final long serialVersionUID = 1L;

	private Lancamentos lancamentos;

	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws NegocioException {
		if(lancamento.getDataPagamento() != null && 
				lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException(
					"Data de Pagamento não pode ser uma data futura!");
		}
			this.lancamentos.adicionar(lancamento);
	}
}
