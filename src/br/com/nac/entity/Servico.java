package br.com.nac.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SERVICO")
@SequenceGenerator(name = "servicos", sequenceName = "SQ_TB_SERVICOS", allocationSize = 1)
public class Servico {
	public Servico() {
		
	}
	
	public Servico(String nome, float valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	@Id
	@GeneratedValue(generator="servicos", strategy = GenerationType.SEQUENCE)
	@Column(name="cd_servicos")
	private int codigo;
	
	@Column(name="nm_servico", nullable = false, length = 50)
	private String nome;
	
	@Column(name="vl_servico", nullable=false, length = 6)
	private float valor;
	
	@ManyToMany(mappedBy="servicos")
	private List<ContaCorrente> contas;
	
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

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public void setContas(List<ContaCorrente> contas) {
		this.contas = contas;
	}

}
