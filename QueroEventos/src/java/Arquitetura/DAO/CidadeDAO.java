/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquitetura.DAO;

import org.hibernate.Session;
import DTO.Cidade;
import DTO.Estado;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author Daniel
 */
public class CidadeDAO {
 
    
    private Session session;
    
    public List<Cidade> consultaCidadePorEstado(String estadoUf)
    {
        session = HibernateUtil.getInstance();
        Query sqlQuery = session.getNamedQuery("Cidade.ConsultaPorEstado");
        sqlQuery.setString("estadouf", estadoUf);
        List<Cidade> list = sqlQuery.list();
        return list;
    }
    
     public List<Cidade> todosCidades()
    {
        session = HibernateUtil.getInstance();
        List<Cidade> list = session.createQuery("from Cidade").list();
        return list;
    }
}
