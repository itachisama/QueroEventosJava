/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name="tb_conta")
@SuppressWarnings("serial")
public class Conta implements Serializable{
    
    @EmbeddedId 
    private ContaPK contapk;
    
    @OneToOne
    @JoinColumn(name="PRF_ID",nullable=false)
    private Perfil perfil = new Perfil();
    
    @Column(name="CNT_TXT_SENHA")    
    private String senha;

   
    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the contapk
     */
    public ContaPK getContapk() {
        return contapk;
    }

    /**
     * @param contapk the contapk to set
     */
    public void setContapk(ContaPK contapk) {
        this.contapk = contapk;
    }
}
