
public interface Barrier {
	 /**
	   * Bloque jusqu’à ce que tous les threads soient devant la barrière
	 * @throws InterruptedException 
	   */
	  public void await() throws InterruptedException ;

}
