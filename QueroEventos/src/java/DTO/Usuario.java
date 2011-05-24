/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Daniel
 */

@Table(name="tb_usuario")
@SuppressWarnings("serial")
@Embeddable public class Usuario implements Serializable{
    
    
    @Column(name="USU_ID")
    private int id;
    
    @OneToOne
    @JoinColumn(name="CID_ID",nullable=false)
    private Cidade cidade;
    
    @Column(name="USU_TXT_NOME")    
    private String nome;
    
    @Column(name="USU_TXT_EMAIL")    
    private String email;
    
    @Column(name="USU_TXT_WEB_PAGE") 
    private String webpage;
    
    @Column(name="USU_DT_NASCIMENTO") 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name="USU_FLG_SEXO") 
    private char sexo;
    
    @Column(name="USU_DT_CADASTRO") 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @Column(name="USU_FLG_TWITTER") 
    private boolean  flgTwitter;
    
    @Column(name="USU_FLG_FACEBOOK") 
    private boolean flgFacebook;
    
    @Column(name="USU_IMG_ARQUIVO") 
    private byte[] fotoArquivo;
    
    @Column(name="USU_IMG_TIPO") 
    private String fotoTipo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the webpage
     */
    public String getWebpage() {
        return webpage;
    }

    /**
     * @param webpage the webpage to set
     */
    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the flgTwitter
     */
    public boolean getFlgTwitter() {
        return flgTwitter;
    }

    /**
     * @param flgTwitter the flgTwitter to set
     */
    public void setFlgTwitter(boolean flgTwitter) {
        this.flgTwitter = flgTwitter;
    }

    /**
     * @return the flgFacebook
     */
    public boolean getFlgFacebook() {
        return flgFacebook;
    }

    /**
     * @param flgFacebook the flgFacebook to set
     */
    public void setFlgFacebook(boolean flgFacebook) {
        this.flgFacebook = flgFacebook;
    }

    /**
     * @return the fotoArquivo
     */
    public byte[] getFotoArquivo() {
        return fotoArquivo;
    }

    /**
     * @param fotoArquivo the fotoArquivo to set
     */
    public void setFotoArquivo(byte[] fotoArquivo) {
        this.fotoArquivo = fotoArquivo;
    }

    /**
     * @return the fotoTipo
     */
    public String getFotoTipo() {
        return fotoTipo;
    }

    /**
     * @param fotoTipo the fotoTipo to set
     */
    public void setFotoTipo(String fotoTipo) {
        this.fotoTipo = fotoTipo;
    }
    
}
