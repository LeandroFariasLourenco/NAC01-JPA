package br.com.nac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SERVICOS")
@SequenceGenerator(name = "servicos", sequenceName = "SQ_TB_SERVICOS", allocationSize = 1)
public class Servicos {
	
	@Id
	@GeneratedValue(generator="servicos", strategy = GenerationType.SEQUENCE)
	@Column(name="cd_servicos")
	int codigo;
	
	@Column(name="nm_servico", nullable = false, length = 50)
	String nome;
	
	@Column(name="vd_servico", nullable=false, length = 6)
	float valor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
