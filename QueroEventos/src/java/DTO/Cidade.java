/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


/**
 *
 * @author Daniel
 */
@Entity
@Table(name="tb_cidade")
@SuppressWarnings("serial")
@NamedQueries({
    @NamedQuery(name="Cidade.ConsultaPorEstado", query="SELECT c FROM Cidade c where c.estado.uf = :estadouf")
})
public class Cidade implements Serializable{
    
    @Id
    @Column(name="CID_ID")
    private int id;
    
    @OneToOne
    @JoinColumn(name="EST_UF",nullable=false)
    private Estado estado;
    
    @Column(name="CID_TXT_NOME")
    private String nome;

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
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
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
    
    
}
