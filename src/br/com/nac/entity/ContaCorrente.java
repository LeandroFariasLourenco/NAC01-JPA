package br.com.nac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_CONTA_CORRENTE")
@SequenceGenerator(name = "conta_corrente", sequenceName = "SQ_TB_CONTA_CORRENTE", allocationSize = 1)
public class ContaCorrente {

	@Id
	@Column(name="cd_conta")
	@GeneratedValue(generator = "conta_corrente", strategy = GenerationType.SEQUENCE)
	int codigo;
	
	@Column(name="nr_conta", nullable = false , length = 5)
	int numero;
	
	@Column(name="ds_senha", nullable = false, length = 6)
	int senha;
}
