
import java.util.ArrayList;

public class Nodo {
	int estado[][];
	ArrayList hijos = new ArrayList();
	
	public Nodo(int [][] estado){
		this.estado=estado;
		hijos=null;
	}

	public int[][] getEstado() {
		return estado;
	}

	public void setEstado(int[][] estado) {
		this.estado = estado;
	}

	public ArrayList getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList hijos) {
		this.hijos = hijos;
	}
	
	
	

}

