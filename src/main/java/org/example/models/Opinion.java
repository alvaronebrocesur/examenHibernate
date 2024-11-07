package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "usuario", nullable = false, length = 64)
    private String usuario;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public void setPuntuacion(Integer puntuacion) {
       if (puntuacion > 0 && puntuacion < 10) {
           this.puntuacion = puntuacion;
       }else System.out.println("Puntuacion erronea, introduzca otra");
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", puntuacion=" + puntuacion +
                ", pelicula=" + pelicula.getTitulo() +
                '}';
    }
}