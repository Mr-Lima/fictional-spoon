package aldev;

/**
 * Package pacote para ser enviado
 */
public interface Package<T, R> {

  public R process();

  public Object[] split(int parts);
}