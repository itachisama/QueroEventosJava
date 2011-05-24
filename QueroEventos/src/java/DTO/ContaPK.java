/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Daniel
 */
@Embeddable
public class ContaPK implements Serializable{
    

  @OneToOne  
  @JoinColumn(name="USU_ID", referencedColumnName="USU_ID")  
  private Usuario usurario;
  
 
  @Column(name="CNT_TXT_LOGIN", columnDefinition="String")
  private String login;
  
   


    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the usurario
     */
    public Usuario getUsurario() {
        return usurario;
    }

    /**
     * @param usurario the usurario to set
     */
    public void setUsurario(Usuario usurario) {
        this.usurario = usurario;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaPK other = (ContaPK) obj;
        if (this.usurario != other.usurario && (this.usurario == null || !this.usurario.equals(other.usurario))) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.usurario != null ? this.usurario.hashCode() : 0);
        hash = 17 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }

}
