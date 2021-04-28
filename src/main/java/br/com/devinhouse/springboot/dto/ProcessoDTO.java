package br.com.devinhouse.springboot.dto;

import java.io.Serializable;

//import javax.xml.bind.annotation.XmlRootElement;
//
//@XmlRootElement(name = "processo")
public class ProcessoDTO implements Serializable {
	
	private static final long serialVersionUID = 7887343820631112092L;
	
	private Integer id;
	private Integer cdAssunto;
	private Integer cdInteressado;
	private String descricao;
	private String descricaoAssunto;
	private String nmInteressado;
	private String nuAnoProcesso;
	private Integer nuProcesso;
	private String sgOrgaoProcesso;
	private String chaveProcesso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCdAssunto() {
		return cdAssunto;
	}
	public void setCdAssunto(Integer cdAssunto) {
		this.cdAssunto = cdAssunto;
	}
	
	public Integer getCdInteressado() {
		return cdInteressado;
	}
	public void setCdInteressado(Integer cdInteressado) {
		this.cdInteressado = cdInteressado;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricaoAssunto() {
		return descricaoAssunto;
	}
	public void setDescricaoAssunto(String descricaoAssunto) {
		this.descricaoAssunto = descricaoAssunto;
	}
	
	public String getNmInteressado() {
		return nmInteressado;
	}
	public void setNmInteressado(String nmInteressado) {
		this.nmInteressado = nmInteressado;
	}
	
	public String getNuAnoProcesso() {
		return nuAnoProcesso;
	}
	public void setNuAnoProcesso(String nuAnoProcesso) {
		this.nuAnoProcesso = nuAnoProcesso;
	}
	
	public Integer getNuProcesso() {
		return nuProcesso;
	}
	public void setNuProcesso(Integer nuProcesso) {
		this.nuProcesso = nuProcesso;
	}
	
	public String getSgOrgaoProcesso() {
		return sgOrgaoProcesso;
	}
	public void setSgOrgaoProcesso(String sgOrgaoProcesso) {
		this.sgOrgaoProcesso = sgOrgaoProcesso;
	}
	
	public String getChaveProcesso() {
		return chaveProcesso;
	}
	public void setChaveProcesso(String chaveProcesso) {
		this.chaveProcesso = chaveProcesso;
	}
	
}
