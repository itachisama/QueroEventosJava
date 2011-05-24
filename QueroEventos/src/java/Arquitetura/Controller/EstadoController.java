/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquitetura.Controller;

import Arquitetura.DAO.CidadeDAO;
import Arquitetura.DAO.ContaDAO;
import Arquitetura.DAO.EstadoDAO;
import DTO.Cidade;
import DTO.Conta;
import DTO.Estado;
import DTO.Perfil;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Daniel
 */
public class EstadoController {
    
    private List<SelectItem> estadoListCombo;
    private List<SelectItem> cidadeListCombo;  
    private String nome="Daniel";
    private SelectItem itemList;
    private String estadoUf;
    private int cidadeId;
    private Conta conta = new Conta();
    private List<Estado> estadoList= new ArrayList<Estado>();
    private List<Cidade> cidadeList = new ArrayList<Cidade>();
    
    public EstadoController()
    {
        try {
            this.getTodos();
            //this.getCidades();
        } catch (Exception ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getTodos() throws Exception{
    
        EstadoDAO dao= new EstadoDAO();
        setEstadoList(dao.todosEstados());
       /* if(estadoList !=null && estadoList.size()>0)
                {
                   
                   setEstadoListCombo(new ArrayList<SelectItem>());
                   for(Estado estado: estadoList)
                   {
                       itemList = new SelectItem(estado.getUf(),estado.getNome());
                       getEstadoListCombo().add(itemList);
                   }
                }    
         * 
         */
   }
    
   public void AtualizarCidadeEstado() 
   {
       try{
            CidadeDAO dao= new CidadeDAO();            
            setCidadeList(dao.consultaCidadePorEstado(getEstadoUf()));
//           if(cidadeList !=null && cidadeList.size()>0)
//                {
//                   
//                   setCidadeListCombo(new ArrayList<SelectItem>());
//                   for(Cidade cidade: cidadeList)
//                   {
//                       itemList=new SelectItem(cidade.getId(),cidade.getNome());
//                       getCidadeListCombo().add(itemList);
//                   }
//                }      
       }catch(Exception ex)
       {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void getCidades() {
    try{
        CidadeDAO dao= new CidadeDAO();
        List<Cidade> cidadeList= dao.todosCidades();
        if(cidadeList !=null && cidadeList.size()>0)
                {
                   
                   setCidadeListCombo(new ArrayList<SelectItem>());
                   for(Cidade cidade: cidadeList)
                   {
                       itemList=new SelectItem(cidade.getId(),cidade.getNome());
                       getCidadeListCombo().add(itemList);
                   }
                }     
    }catch(Exception ex)
    {
        Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   
   public void salvar()
   {
       ContaDAO dao = new ContaDAO();
       conta.getContapk().getUsurario().setDataCadastro(new Date());
       conta.setPerfil(new Perfil());
       conta.getPerfil().setId(1);
       conta.getContapk().getUsurario().setCidade(new Cidade());
       conta.getContapk().getUsurario().getCidade().setId(cidadeId);
       dao.salvarConta(conta);
       
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
     * @return the estadoListCombo
     */
    public List<SelectItem> getEstadoListCombo() {
        return estadoListCombo;
    }

    /**
     * @param estadoListCombo the estadoListCombo to set
     */
    public void setEstadoListCombo(List<SelectItem> estadoListCombo) {
        this.estadoListCombo = estadoListCombo;
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
     * @return the cidadeId
     */
    public int getCidadeId() {
        return cidadeId;
    }

    /**
     * @param cidadeId the cidadeId to set
     */
    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
    }

    /**
     * @return the estadoUf
     */
    public String getEstadoUf() {
        return estadoUf;
    }

    /**
     * @param estadoUf the estadoUf to set
     */
    public void setEstadoUf(String estadoUf) {
        this.estadoUf = estadoUf;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    /**
     * @return the estadoList
     */
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    /**
     * @param estadoList the estadoList to set
     */
    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    /**
     * @return the cidadeList
     */
    public List<Cidade> getCidadeList() {
        return cidadeList;
    }

    /**
     * @param cidadeList the cidadeList to set
     */
    public void setCidadeList(List<Cidade> cidadeList) {
        this.cidadeList = cidadeList;
    }
    
}
