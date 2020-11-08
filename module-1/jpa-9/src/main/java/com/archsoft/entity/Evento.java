package com.archsoft.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB009_EVENTOS")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1891027876136434217L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "gen_evento_9")
	@Column(name="ID_EVENTO", nullable=false)
    private Long id;

    @Column(name="NOME", nullable=false, length=45)
    private String nome;
    
    @Column(name="LOCAL", nullable=false, length=45)
    private String local;

    @Column(name="DATA_INICIO", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date periodoInicio;
    
    @Column(name="DATA_FIM", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date periodoFim;
    
    @Column(name="DATA_OFICIO", nullable=true)
    @Temporal(TemporalType.DATE)
    private Date dataOficio;
    
    @Column(name="NUMERO_OFICIO", nullable=true)
    private String numeroOficio;

    @Lob
    @Basic(fetch=FetchType.EAGER)
    @Column(name="OBJETIVO", nullable=false)
    private String objetivo;
    
    @Lob 
    @Basic(fetch=FetchType.EAGER)
    @Column(name="JUSTIFICATIVA", nullable=true)
    private String justificativa;
    
    @ManyToMany(
		fetch=FetchType.LAZY, 
		cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinTable(
		name="EVENTO_MODALIDADE",
		joinColumns=@JoinColumn(name="ID_EVENTO"), 
		inverseJoinColumns=@JoinColumn(name="ID_MODALIDADE")
	)
	private List<Modalidade> modalidades = new ArrayList<Modalidade>();
    
    @Column(name="REQUER_INSCRICAO", nullable=false)
    private boolean requerInscricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFim() {
		return periodoFim;
	}

	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}

	public Date getDataOficio() {
		return dataOficio;
	}

	public void setDataOficio(Date dataOficio) {
		this.dataOficio = dataOficio;
	}

	public String getNumeroOficio() {
		return numeroOficio;
	}

	public void setNumeroOficio(String numeroOficio) {
		this.numeroOficio = numeroOficio;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}

	public boolean isRequerInscricao() {
		return requerInscricao;
	}

	public void setRequerInscricao(boolean requerInscricao) {
		this.requerInscricao = requerInscricao;
	}

	@Override
	public String toString() {
		return "Evento{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				'}';
	}
}
