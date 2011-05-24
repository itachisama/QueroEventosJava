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
@Table(name="tb_estado")
@SuppressWarnings("serial")
public class Estado implements Serializable{
    
    private String uf;
    private String nome;

    public Estado()    
    { }
    
    public Estado(String pUf, String pNome)
    {
        this.uf = pUf;
        this.nome= pNome;
    }    
    
   
    /**
     * @return the nome
     */
    @Column(name="EST_TXT_NOME")
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
     * @return the uf
     */
    @Id
    @Column(name="EST_UF")
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
}
