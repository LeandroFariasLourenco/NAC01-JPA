package br.com.nac.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_CONTA_CORRENTE")
@SequenceGenerator(name = "conta_corrente", sequenceName = "SQ_TB_CONTA_CORRENTE", allocationSize = 1)
public class ContaCorrente {
	
	public ContaCorrente(int numero, int senha) {
		super();
		this.numero = numero;
		this.senha = senha;
	}

	public ContaCorrente() {
		
	}
	
	@Id
	@Column(name="cd_conta")
	@GeneratedValue(generator = "conta_corrente", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nr_conta", nullable = false , length = 5)
	private int numero;
	
	@Column(name="ds_senha", nullable = false, length = 6)
	private int senha;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_cliente", nullable = false)
	private Cliente cliente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_agencia", nullable = false)
	private Agencia agencia;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_SERVICOS_CONTRATADOS",
			joinColumns = @JoinColumn(name = "cd_conta_corrente"),
			inverseJoinColumns = @JoinColumn(name = "cd_servico"))
	private List<Servico> servicos;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}
