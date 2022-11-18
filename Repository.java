import java.util.List;

interface Repository<T> {
   List<T> findAll();
}
