package br.com.nac.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.nac.enums.Status;

@Entity
@Table(name="T_SERVICOS_CONTRATADOS")
@SequenceGenerator( name="servicos_contratados", sequenceName = "SQ_T_SERVICOS_CONTRATADOS", allocationSize = 1)
public class ServicosContratados {

	@Id
	@GeneratedValue(generator="servicos_contratados", strategy = GenerationType.SEQUENCE)
	@Column(name="cd_servico_contratado")
	int codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_contratacao", nullable = false)
	Calendar contratacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_status", nullable = false)
	Status stautus;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getContratacao() {
		return contratacao;
	}

	public void setContratacao(Calendar contratacao) {
		this.contratacao = contratacao;
	}

	public Status getStautus() {
		return stautus;
	}

	public void setStautus(Status stautus) {
		this.stautus = stautus;
	}
}
