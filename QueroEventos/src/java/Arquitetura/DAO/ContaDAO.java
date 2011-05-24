/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquitetura.DAO;

import DTO.Conta;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class ContaDAO {
    
    
    private Session session;
    private Transaction tx = null;
    
    public void salvarConta(Conta contaObj)
    {
        session = HibernateUtil.getInstance();
        try{
        tx = session.beginTransaction();
        session.save(contaObj);
        tx.commit();
        }catch(Exception ex)
        {
            ex.printStackTrace();
            tx.rollback();
        }
        finally
        {
            session.close();
        }
    }
}
