/*
This file is part of Labirinto.

Labirinto is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or 
(at your option) any later version.

Labirinto is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Foobar.  If not, see <http://www.gnu.org/licenses/>. 
*/

import java.util.Vector;
import Labirinto.*;

public class ExemploGrafo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Nodo raiz = new Nodo(null, "raiz");
		Vector<Nodo> nivelUm = new Vector<Nodo>();
		Vector<Nodo> nivelDois = new Vector<Nodo>();
		
		nivelUm.add(new Nodo(raiz,"nivel1")); 
		nivelUm.add(new Nodo(raiz,"nivel1")); 
		nivelUm.add(new Nodo(raiz,"nivel1")); 
		
		nivelDois.add(new Nodo(nivelUm.get(0),"nivel2"));
		nivelDois.add(new Nodo(nivelUm.get(0),"nivel2"));
		nivelDois.add(new Nodo(nivelUm.get(2),"nivel2"));
		
		printGrafo (raiz);
	}

	private static void printGrafo(Nodo nodo) {
		// TODO Auto-generated method stub

		for (int c = 0; c < nodo.getProfundidade(); c++)
			System.out.print("\t");
		System.out.println(nodo.getValor());
		if (nodo.getFilho() != null)
			printGrafo(nodo.getFilho());
		if (nodo.getIrmao() != null)
			printGrafo(nodo.getIrmao());
	}
}
