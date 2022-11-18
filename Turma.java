import java.util.List;

public interface Turma extends Sorteavel<Aprendiz>, Repository<Aprendiz> {
   List<Aprendiz> getAprendizes();
}
