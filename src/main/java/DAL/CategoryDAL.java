/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;



import DTO.Category;
import DTO.Customers;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Admin
 */
public class CategoryDAL {
    private static SessionFactory factory;
    public void listCategory(){
    Session session =  factory.openSession();
    Transaction tx =null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Customers AS c WHERE c.Fullname LIKE :name";
            List category = session.createQuery(hql)
                .setParameter("name","%" + "John" + "%" ).list();
            for(Iterator iterator = category.iterator(); iterator.hasNext();){
                Customers cate = (Customers) iterator.next();
                System.out.println("CatagoryID: "+ cate.getCustomerID());
                System.out.println("Name: "+ cate.getFullname());
                System.out.println("Description: "+ cate.getAddress());
            }
            tx.commit();
        }catch(HibernateError e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
}
    public static void main(String[] args) {
        
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
            System.err.println("Failed to create sessionFactory object."+ ex);
            throw new ExceptionInInitializerError(ex);
        }
        CategoryDAL category = new CategoryDAL();
        category.listCategory();
    }
}
