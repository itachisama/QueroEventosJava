/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquitetura.Controller;

import Arquitetura.DAO.CidadeDAO;
import DTO.Cidade;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Daniel
 */

public class CidadeController {

    private List<SelectItem> cidadeListCombo;   
    private SelectItem itemList;
    private int marcado;
    /** Creates a new instance of CidadeController */
    public CidadeController() {
        try {
            this.getTodos();
        } catch (Exception ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     public void getTodos() throws Exception{
    
        CidadeDAO dao= new CidadeDAO();
        List<Cidade> cidadeList= dao.todosCidades();
        if(cidadeList !=null && cidadeList.size()>0)
                {
                   System.out.println("Quantidade de cidades: "+cidadeList.size());
                   setCidadeListCombo(new ArrayList<SelectItem>());
                   for(Cidade cidade: cidadeList)
                   {
                       itemList=new SelectItem(cidade.getId(),cidade.getNome());
                       getCidadeListCombo().add(itemList);
                   }
                }       
   }

    /**
     * @return the cidadeListCombo
     */
    public List<SelectItem> getCidadeListCombo() {
        return cidadeListCombo;
    }

    /**
     * @param cidadeListCombo the cidadeListCombo to set
     */
    public void setCidadeListCombo(List<SelectItem> cidadeListCombo) {
        this.cidadeListCombo = cidadeListCombo;
    }

    /**
     * @return the itemList
     */
    public SelectItem getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(SelectItem itemList) {
        this.itemList = itemList;
    }

    /**
     * @return the marcado
     */
    public int getMarcado() {
        return marcado;
    }

    /**
     * @param marcado the marcado to set
     */
    public void setMarcado(int marcado) {
        this.marcado = marcado;
    }
}
