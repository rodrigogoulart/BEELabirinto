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

import java.util.Iterator;
import java.util.Vector;
import Labirinto.*;

public class ExemploLabirinto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Labirinto labirinto;
		boolean debug = false;
		
		// Cria um laborinto 10x10 com 30% de obstáculos
		labirinto = new Labirinto(10, 10, 30, debug);
		
		// Imprimime o labirinto
		labirinto.print(null);
		
		// Cria uma posição hipotética p(2,3) 
		Posicao p = new Posicao(2,3);
		
		// Imprime a posição
		System.out.println(p.toString());
		// Imprime a posição de entrada do labirinto
		System.out.println(labirinto.getPosicaoAtual());
		p = labirinto.getPosicaoAtual();
		
		// Imprimir uma coleção de posições possíves a partir de uma posição
		Vector<Posicao> expansao = labirinto.getExpansao(p);
		Iterator<Posicao> expansaoIt = expansao.iterator();
		while (expansaoIt.hasNext()) {
			p = (Posicao) expansaoIt.next();
			System.out.print(p.toString());
		}
		
		/* Imprimir a distância em linha reta do ponto de entrada para o ponto
		 *  saída
		 */	
		Posicao e = labirinto.getPosicaoAtual();
		Posicao s = labirinto.getPosicaoSaida();
		System.out.println("\n Distância(entrada->saida)" + labirinto.getDLR(e, s));
	}

}
