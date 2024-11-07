package org.example;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        /* Ej 1
        Pelicula p = new Pelicula();
        p.setId(6);
        p.setTitulo("Madagascar");
        DataService.addPellicula(p);
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println();
         */

        /* Ej 2
        DataService.getOpinionByUser("user1@example.com");
         */

        /* Ej 3
        Session session = HibernateUtil.getSessionFactory().openSession();
        Opinion o = new Opinion();
        o.setId(8);
        o.setDescripcion("Me flipo");
        o.setUsuario("alvaro@gmail.com");
        o.setPuntuacion(9);
        o.setPelicula(session.get(Pelicula.class, 6));
        DataService.addOpinion(o);
        System.out.println(session.get(Opinion.class, 8));
         */

        /* Ej 4
        DataService.getPeliculasBajaPuntuacion();
         */
    }
}