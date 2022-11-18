import java.util.List;

public interface Questionario extends Sorteavel<Pergunta>, Repository<Pergunta> {
   List<Pergunta> getPerguntas();

}
