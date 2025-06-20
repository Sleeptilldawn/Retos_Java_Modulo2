import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Introducción a Java", "Mario", 15));
        materiales.add(new Video("POO en Java", "Carlos", 20));
        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));
        materiales.add(new Ejercicio("Variables y tipos", "Luis"));
        materiales.add(new Ejercicio("Condicionales", "Mario"));

        System.out.println("            *Materiales del curso:* ");
        GestorMateriales.mostrarMateriales(materiales);

        // Extraer solo videos para sumar duración
        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        GestorMateriales.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        GestorMateriales.marcarEjerciciosRevisados(materiales);

        // Filtrar por autor "Mario"
        GestorMateriales.filtrarPorAutor(materiales, m -> m.autor.equals("Mario"));
    }
}