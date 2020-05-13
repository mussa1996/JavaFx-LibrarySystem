
package Library.controller;


import Library.model.Book;
import LibraryUtil.HibernateUtil;
import Library.model.Bookcategory;
import Library.model.Checkin;
import Library.model.Checkout;
import Library.model.Client;
import Library.model.Login;
import Library.model.Signup;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DataAccessDao {
    public static void addBook(Book book){
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(book);
            tx.commit();
        }catch(Exception asd)
        {
            System.out.println(asd.getMessage()); 
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
         session.close();
        }
        
        
    }
    public static void addClient(Client client){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(client);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
            session.close();
        }
    } 
     public static void addBookCategory(Bookcategory category){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(category);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
            session.close();
        }
    }
      public static void addCheckin(Checkin checkin){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(checkin);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
            session.close();
        }
    } 
      public static void addCheckout(Checkout checkout){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(checkout);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
            session.close();
        }
    } 
       public static void addSignin(Login signin){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(signin);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
            session.close();
        }
    }
        public static void addSign(Signup sign){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try
        {
            tx=session.beginTransaction();
            session.save(sign);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }finally
        {
            session.close();
        }
    } 
        public String testSignin (String username){
          String password=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              List cr =session.createCriteria(Signup.class).add(Restrictions.eq("username", username)).setProjection(Projections.property("password")).list();
              
              
              tx.commit();
              for (Object sig :cr ) {
                  password=sig.toString();
              }
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
              
          }
        return password;
        }
      public static List<Book> listBook(){
          List<Book> book=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              Criteria cr=session.createCriteria(Book.class);
//              cr.add(Restrictions.eq("bookid", id));
              book=cr.list();
              tx.commit();
              
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
          }
        return book;
      }
      public static List<Client> listClient(){
          List<Client> client=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              Criteria cr=session.createCriteria(Client.class);
//              cr.add(Restrictions.eq("regno", id));
             
              client=cr.list();
              tx.commit();
              
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
          }
        return client;
      }
      public static List<Bookcategory> listCategory(){
          List<Bookcategory> category=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              Criteria cr=session.createCriteria(Bookcategory.class);
//              cr.add(Restrictions.eq("categoryid", id));
              category=cr.list();
              tx.commit();
              
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
          }
        return category;
      }
      public static List<Checkin> listcheckin(){
          List<Checkin> checkin=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              Criteria cr=session.createCriteria(Checkin.class);
//              cr.add(Restrictions.eq("status", name));
              checkin=cr.list();
              tx.commit();
              
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
          }
        return checkin;
      }
      public static List<Checkout> listcheckout(){
          List<Checkout> checkout=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              Criteria cr=session.createCriteria(Checkout.class);
//              cr.add(Restrictions.eq("status", name));
              checkout=cr.list();
              tx.commit();
              
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
          }
        return checkout;
      }
      public static void updateBook(Book book){

        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.update(book);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }
}
      public static void updateClient(Client client){

        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.update(client);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }
}
      
       public static void deleteBook(String id){

        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Book st=new Book(id);
            session.delete(st);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally{
            session.close();
        }

    }
        public static void deleteClient( String id){

        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Client st=new Client(id);
            session.delete(st);
            tx.commit();
        }catch(Exception asd){
            System.out.println(asd.getMessage());
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally{
            session.close();
        }

    }
         public static List<Client> searchClient(String id){
          List<Client> cl=null;
          Session session=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=null;
          try
          {
              tx=session.beginTransaction();
              Criteria cr=session.createCriteria(Client.class);
             cr.add(Restrictions.eq("regno", id));
              cl=cr.list();
              tx.commit();
              
          }catch(Exception asd)
          {
              System.out.println(asd.getMessage());
              if(tx!=null){
                  tx.rollback();
              }
          }
          finally{
              session.close();
          }
        return cl;
      }
         public static String operationNumber(String date){
             Session session=HibernateUtil.getSessionFactory().openSession();
             Object su=session.createCriteria(Checkout.class).setProjection(Projections.count("ponumber")).uniqueResult();
             session.close();
             return "OP"+su+date;
         }
         public  List<Client> searchClientId(String id){
             Session session=HibernateUtil.getSessionFactory().openSession();
             Transaction tx=session.beginTransaction();
             List<Client> cli=(List<Client>)session.createCriteria(Client.class).add(Restrictions.eq("regno", id)).list();
             tx.commit();
             session.close();
             return cli;
         }
         public  List<Book> searchBookId(String id){
             Session session=HibernateUtil.getSessionFactory().openSession();
             Transaction tx=session.beginTransaction();
             List<Book> bo=(List<Book>)session.createCriteria(Book.class).add(Restrictions.eq("bookid", id)).list();
             tx.commit();
             session.close();
             return bo;
         }
        
         
}
