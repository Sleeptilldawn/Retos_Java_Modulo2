public class ProfesionalMedico implements Runnable {
    private final RecursoMedico recurso;
    private final String nombre;

    public ProfesionalMedico(RecursoMedico recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        recurso.usar(nombre);
    }
}
