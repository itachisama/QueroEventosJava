/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquitetura.DAO;

import DTO.Estado;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Daniel
 */
public class EstadoDAO {
    
    private Session session;
    
    public List<Estado> todosEstados()
    {
        session = HibernateUtil.getInstance();
        List<Estado> list = session.createQuery("from Estado").list();
        return list;
    }
}
