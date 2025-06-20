import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new ProfesionalMedico(salaCirugia, "Dra. Sánchez"));
        executor.submit(new ProfesionalMedico(salaCirugia, "Dr. Gómez"));
        executor.submit(new ProfesionalMedico(salaCirugia, "Enfermera Ruiz"));
        executor.submit(new ProfesionalMedico(salaCirugia, "Dr. López"));
        executor.submit(new ProfesionalMedico(salaCirugia, "Dra. Torres"));

        executor.shutdown();
    }
}
