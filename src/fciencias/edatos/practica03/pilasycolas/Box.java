package fciencias.edatos.practica03.pilasycolas;


public class Box{
  private class Casilla{
    public boolean wall;
    public boolean visited;
     public Casilla(boolean wall, boolean visited){
       this.wall= wall;
       this.visited=visited;
     }
  }

  /**
	 * Permite saber si una casilla es pared o no.
   */
  public boolean isWall(){
    return wall != false;
  }


  /**
   * Permite saber si una casilla está visitada o no.
   */
  public boolean isVisited(){
    return visited != false;
  }

  /**
  * Visita una casilla.
  */
 public void Visit(){
   if(isVisited()){
      
   }
 }
}
