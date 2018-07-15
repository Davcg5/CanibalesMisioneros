
public class Aplicacion {
	public static void main (String[] args){
		
		
		int [][] estadoInicial = {{3,3,1},{0,0,0}};
		
		int [][] estadoSolucion = {{0,0,0},{3,3,1}};
		
		CanibalMisionero CB= new CanibalMisionero();
		Nodo raiz = new Nodo(estadoInicial);
		CanibalMisionero.generarEstados(raiz, estadoSolucion);
		
	}
}
