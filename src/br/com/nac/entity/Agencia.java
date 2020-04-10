package br.com.nac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_AGENCIA")
@SequenceGenerator(name="agencia", sequenceName = "SQ_TB_AGENCIA", allocationSize = 1)
public class Agencia {

	@Id
	@GeneratedValue(generator = "agencia", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_agencia")
	int codigo;
	
	@Column(name="nr_agencia", nullable=false, length = 3)
	int numero;
	
	@Column(name = "ds_endereco", nullable = false, length = 60)
	String endereco;
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}
