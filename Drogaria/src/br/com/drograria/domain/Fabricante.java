package br.com.drograria.domain;

public class Fabricante {
	
	private Long codigo;
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDecricao() {
		return descricao;
	}

	public void setDescricao(String decricao) {
		this.descricao = decricao;
	}
	
	@Override
	public String toString() {
		String saida = codigo + " - " + descricao;
		return saida;
	}

}
