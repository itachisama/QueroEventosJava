/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */

@Entity
@Table(name="tb_perfil")
@SuppressWarnings("serial")
public class Perfil implements Serializable{
    
    @Id
    @Column(name="PRF_ID")
    private int id;
    
    @Column(name="PRF_TXT_NOME")    
    private String nomePerfil;

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
     * @return the nomePerfil
     */
    public String getNomePerfil() {
        return nomePerfil;
    }

    /**
     * @param nomePerfil the nomePerfil to set
     */
    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
    
}
