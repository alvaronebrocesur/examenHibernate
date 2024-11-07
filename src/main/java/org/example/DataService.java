package org.example;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    /**
     * Metodo para guardar peliculas en la base de datos
     * @param p Pelicula a guardar
     */
    public static void addPellicula(Pelicula p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(p);
        transaction.commit();
        session.close();
    }

    /**
     * Metodo para obtener todas las opiniones que ha escrito un usuario
     * @param user correo del usuario del que se desea obtener las opiniones
     * @return Lista con las opiniones de los usuarios
     */
    public static List<Opinion> getOpinionByUser(String user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Opinion WHERE usuario = :user");
        query.setParameter("user", user);
        List<Opinion> lista = query.list();
        List<Opinion> ret = new ArrayList<>();
        for (Opinion opinion : lista) {
            ret.add(opinion);
        }
        session.close();
        return ret;
    }

    /**
     * Metodo para guardar opiniones en la base de datos
     * @param o Opinion a guardar
     */
    public static void addOpinion(Opinion o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        o.getPelicula().addOpinion(o);
        session.persist(o);
        transaction.commit();
        session.close();
    }

    /**
     * Metodo para listar todas las peliculas que tengan alguna puntuacion igual o inferior a 3
     * @return Lista con los titulos de las peliculas
     */
    public static List<String> getPeliculasBajaPuntuacion() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select pelicula from Opinion where puntuacion <= 3");
        List<Pelicula> lista = query.list();
        List<String> ret = new ArrayList<>();
        for (Pelicula pelicula : lista) {
            ret.add(pelicula.getTitulo());
        }
        session.close();
        return ret;
    }
}
