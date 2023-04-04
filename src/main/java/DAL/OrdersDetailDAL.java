/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;



import DTO.Customers;
import DTO.OrderDetail;
import DTO.Orders;
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
public class OrdersDetailDAL {
    private static SessionFactory factory;
    public void listCategory(){
    Session session =  factory.openSession();
    Transaction tx =null;
        try{
            tx = session.beginTransaction();
            List order = session.createQuery("from Orders").list();
            for(Iterator iterator = order.iterator(); iterator.hasNext();){
                Orders od = (Orders) iterator.next();
                System.out.println("OrderID : "+ od.getOrderID());
                System.out.println("CustomerID : "+ od.getCustomer().getCustomerID());
                System.out.println("Name : "+ od.getCustomer().getFullname());
//                System.out.println("Date: "+ od.getOrders().getDate());
//                System.out.println("Total : "+ od.getOrders().getTotal());
//                System.out.println("Note: "+ od.getOrders().getNote());
//                System.out.println("Quantity: "+ od.getQuantity());
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
        OrdersDetailDAL odDAL = new OrdersDetailDAL();
        odDAL.listCategory();
    }
}
