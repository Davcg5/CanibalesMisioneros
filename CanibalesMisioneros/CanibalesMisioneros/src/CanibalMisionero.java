
import java.util.ArrayList;
import java.util.Arrays;
public class CanibalMisionero {


	public static void generarEstados(Nodo raiz, int[][] estadoSolucion) {

		ArrayList<Nodo> nodosExpandidos = new ArrayList<Nodo>();
		ArrayList<Nodo> nodosVisitados = new ArrayList<Nodo>();
		int misionerosIzquierda;
		int misionerosDerecha;
		int canibalesIzquierda;
		int canibalesDerecha;
		int iteraciones=0;
		//		int posicionMejorHijo=calcularMejorHijo(nodosExpandidos);

		nodosExpandidos.add(raiz);

		while(nodosExpandidos.size()!=0){

			Nodo revisar= nodosExpandidos.remove(0);
			imprimir(revisar.getEstado());
			ArrayList<Nodo> hijos=new ArrayList<Nodo>();
			ArrayList<Nodo> hijosARevisar = new ArrayList<Nodo>();
			nodosVisitados.add(revisar);
			iteraciones++;

			if(verificarSolucion(revisar.getEstado(), estadoSolucion)){
				System.out.println("Ha llegado a la solucion en:"+iteraciones+"iteraciones");

				break;
			}

			misionerosIzquierda = revisar.getEstado()[0][0];
			misionerosDerecha = revisar.getEstado()[1][0];
			canibalesIzquierda = revisar.getEstado()[0][1];
			canibalesDerecha = revisar.getEstado()[1][1];

			boolean lancha = verificarOrilla(revisar.getEstado());

			//true=izquierda
			//false=derecha
			if((misionerosDerecha>=canibalesDerecha || misionerosIzquierda>=canibalesIzquierda)
					){
			if(lancha==true){
				
				if((misionerosDerecha+2)<=3){

					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][0] =  hijo.getEstado()[0][0] - 2;
					hijo.getEstado()[1][0] =  hijo.getEstado()[1][0] + 2;
					hijo.getEstado()[1][2] = 1;
					hijo.getEstado()[0][2] = 0;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v1");
					}
				}

				if((canibalesDerecha+2)<=3){

					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][1] =  hijo.getEstado()[0][1] - 2;
					hijo.getEstado()[1][1] =  hijo.getEstado()[1][1] + 2;
					hijo.getEstado()[1][2] = 1;
					hijo.getEstado()[0][2] = 0;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v2");
					}
				}

				if((misionerosDerecha+1)<=3){
					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][0] =  hijo.getEstado()[0][0] - 1;
					hijo.getEstado()[1][0] =  hijo.getEstado()[1][0] + 1;
					hijo.getEstado()[1][2] = 1;
					hijo.getEstado()[0][2] = 0;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v3");
					}

				}

				if((canibalesDerecha+1)<=3){
					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][1] =  hijo.getEstado()[0][1] - 1;
					hijo.getEstado()[1][1] =  hijo.getEstado()[1][1] + 1;
					hijo.getEstado()[1][2] = 1;
					hijo.getEstado()[0][2] = 0;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v4");
					}

				}

				if(((misionerosDerecha + 1)<=3) && ((canibalesDerecha + 1)<=3)){
					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][0] =  hijo.getEstado()[0][0] - 1;
					hijo.getEstado()[1][0] =  hijo.getEstado()[1][0] + 1;
					hijo.getEstado()[0][1] =  hijo.getEstado()[0][1] - 1;
					hijo.getEstado()[1][1] =  hijo.getEstado()[1][1] + 1;
					hijo.getEstado()[1][2] = 1;
					hijo.getEstado()[0][2] = 0;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v5");
					}

				}

			}else{

				if((misionerosIzquierda+2)<=3){

					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[1][0] =  hijo.getEstado()[1][0] - 2;
					hijo.getEstado()[0][0] =  hijo.getEstado()[0][0] + 2;
					hijo.getEstado()[1][2] = 0;
					hijo.getEstado()[0][2] = 1;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v6");
					}
				}


				if((canibalesIzquierda+2)<=3){

					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[1][1] =  hijo.getEstado()[1][1] - 2;
					hijo.getEstado()[0][1] =  hijo.getEstado()[0][1] + 2;
					hijo.getEstado()[1][2] = 0;
					hijo.getEstado()[0][2] = 1;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v7");
					}

				}

				if(misionerosIzquierda -misionerosDerecha==1 &&((misionerosIzquierda+1)<=3)){
					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][0] =  hijo.getEstado()[0][0] + 1;
					hijo.getEstado()[1][0] =  hijo.getEstado()[1][0] - 1;
					hijo.getEstado()[1][2] = 0;
					hijo.getEstado()[0][2] = 1;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v8");
					}
				}

				if((canibalesIzquierda + 1)<=3 ){
					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][1] =  hijo.getEstado()[0][1] + 1;
					hijo.getEstado()[1][1] =  hijo.getEstado()[1][1] - 1;
					hijo.getEstado()[1][2] = 0;
					hijo.getEstado()[0][2] = 1;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v9");
					}
				}

				if(((misionerosIzquierda + 1)<=3) && ((canibalesIzquierda+ 1)<=3)){
					Nodo hijo = new Nodo (clonar(revisar.getEstado()));
					hijo.getEstado()[0][0] =  hijo.getEstado()[0][0] + 1;
					hijo.getEstado()[1][0] =  hijo.getEstado()[1][0] - 1;
					hijo.getEstado()[0][1] =  hijo.getEstado()[0][1] + 1;
					hijo.getEstado()[1][1] =  hijo.getEstado()[1][1] - 1;
					hijo.getEstado()[1][2] = 0;
					hijo.getEstado()[0][2] = 1;
					if(!estaVisitado(nodosVisitados, hijo)){
						hijosARevisar.add(hijo);
						hijos.add(hijo);
						System.out.println("v10");
					}
				}

			}
			}
			//nodosExpandidos.addAll(hijosARevisar);
			nodosExpandidos.add(calcularMejorHijo(hijosARevisar));
			revisar.setHijos(hijos);
		}
	}

	private static Nodo calcularMejorHijo(ArrayList<Nodo> hijosARevisar) { 
		Nodo mejorEstado = null;
		double aux = -1;
	
		for(int i = 0; i<hijosARevisar.size();i++){
			Nodo posibleHijo = hijosARevisar.get(i);
		double	valorHeuristico = calcularValorHeuristico(posibleHijo.getEstado());
			
			if(valorHeuristico>=aux){
				aux = valorHeuristico;
				mejorEstado = posibleHijo;
				
				}
			
		}
		return mejorEstado;
	}

	private static int calcularValorHeuristico(int[][] posibleHijo) {

		int valorHeuristico = 0;
		int misioneroIzquierda, misioneroDerecha, canibalIzquierda, canibalDerecha;

		if((posibleHijo[0][0] >= posibleHijo[0][1])&&posibleHijo[0][0] >= posibleHijo[0][1]){
			misioneroIzquierda = posibleHijo[0][0];
			misioneroDerecha = posibleHijo[1][0];
			canibalIzquierda = posibleHijo[0][1];
			canibalDerecha = posibleHijo[1][1];

			boolean ladoLancha = verificarOrilla(posibleHijo);

			if(ladoLancha==true){
				valorHeuristico=2*(misioneroIzquierda * canibalIzquierda)-0;
			}else{
				valorHeuristico=2*(misioneroDerecha * canibalDerecha)-1;
			}
		}

		return valorHeuristico;
	}


	private static boolean verificarSolucion(int[][] estado, int[][] estadoSolucion) {
		int contador=0;
		for(int i = 0; i<estado.length; i++){
			for(int j = 0; j< estado[0].length; j++){
				if(estado[i][j]==estadoSolucion[i][j]){
					contador++;
				}
			}
		}

		if(contador==6){
			return true;
		}else{
			return false;

		}


	}

	private static boolean estaVisitado(ArrayList<Nodo> visitados, Nodo posibleHijo) {
		for(Nodo visitado:visitados){
			if (Arrays.deepEquals(visitado.getEstado(),posibleHijo.getEstado())){
				return true;
			}

		}
		return false;

	}

	private static boolean verificarOrilla(int[][] estado) {
		if(estado[0][2]==1){
			return true;
		}else{
			return false;
		}

	}

	private static int[][] clonar(int[][] estado) {
		int [][] clon=new int [estado.length][estado[0].length];
		for (int i = 0; i < estado.length; i++) {
			for (int j = 0; j < estado.length; j++) {
				clon [i][j]=estado[i][j];
			}
		}


		return clon;
	}

	public static void imprimir(int[][] array){

		for(int i = 0; i<array.length; i++){
			for(int j = 0; j<array[0].length; j++){
				System.out.print(array[i][j]+"  ");


			}
			System.out.println("");
		}

	}


}


