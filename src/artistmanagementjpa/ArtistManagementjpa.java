package artistmanagementjpa;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArtistManagementjpa {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        createArtist();
//        findArtistById();
//        removeArtistById();
//updateName();
getAllArtist();


        /*     EntityManager em = emf.createEntityManager();

//        Artist a = new Artist("Mickel jackson:");
// it is begin to start transactipon with databae
        em.getTransaction().begin();
//      Artist a = em.find(Artist.class,1);
//      a.setName("chinmayee");

        em.remove(em.find(Artist.class, 1));

//        em.persist(a);
        //finsih after executing
        em.getTransaction().commit();
//          Artist a2 = em.find(Artist.class,1);
//        System.out.println(a2);*/
    }

    public static void createArtist() {
        EntityManager em = emf.createEntityManager();
        System.out.println(" What is the name of the Artist:");
        String name = sc.nextLine();
        Artist a = new Artist(name);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public static Artist findArtistById() {
        EntityManager em = emf.createEntityManager();
        System.out.println(" What is the id:");
        int id = sc.nextInt();
        sc.nextLine();

        Artist a = em.find(Artist.class, id);
        System.out.println(a);
//        every time we have to close entity manager close.
        em.close();
        return a;

    }

    public static void removeArtistById() {
        EntityManager em = emf.createEntityManager();
        System.out.println(" What is the id:");
        int id = sc.nextInt();
        sc.nextLine();
//        em.remove(em.find(Artist.class, id));
//or we can write alternative way

        Artist a = em.find(Artist.class, id);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        em.close();

    }
    
    public static void updateName()
    {
        EntityManager em = emf.createEntityManager();
        System.out.println("What is the id of the user you want to update:");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("What uis the new name :");
        String  name  = sc.nextLine();
        
       Artist a = em.find(Artist.class, id);
       a.setName(name);
       
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        
     
       
    }
    
    public static  List<Artist> getAllArtist()
    {
          EntityManager em = emf.createEntityManager();
    List<Artist> artists = em.createNativeQuery("select* from Artist",Artist.class).getResultList();
    
        for (Artist artist : artists) {
            System.out.println(artist);
            
        }
        return artists;
    }
}
