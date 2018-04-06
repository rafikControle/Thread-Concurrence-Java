public interface Barrier {
  /**
   * Bloque jusqu’à ce que tous les threads soient devant la barrière
   */
  public void await(int id);
  
}