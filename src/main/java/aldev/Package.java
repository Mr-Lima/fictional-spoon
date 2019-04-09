package aldev;

import java.util.Collection;
import java.util.List;

/**
 * Package pacote para ser enviado
 */
public interface Package<T, R> {

  public T process();

  public R[] split(int parts);

  public List<T> join(Collection<T> T);

}