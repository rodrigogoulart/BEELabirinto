/*This file is part of Labirinto.

Labirinto is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or 
(at your option) any later version.

Labirinto is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Foobar.  If not, see <http://www.gnu.org/licenses/>. */

package Labirinto;

import java.util.Random;
import java.util.Vector;
import java.lang.Math;

/**
 * Classe que implementa o labirinto (problema) com funcionalidades de busca e
 * fornecimento de informações. As posições ocupadas, entrada e saída são 
 * posicionadas aleatóriamente.
 */
public class Labirinto{
	
	private int dimX;
	private int dimY;
	private int labirinto[][];
	// 0 = vazio
	// 1 = ocupado
	// 2 = entrada
	// 3 = saída
	private int txObstaculos;
	private Posicao atual;
	private Posicao saida;

	/**
	 * Construtor da classe.
	 *
	 * @param dimX Dimensão do labirinto em X.
	 * @param dimY Dimensão do labirinto em Y.
	 * @param txO Taxa percentual de ocupação do labirinto, pois as posições 
	 * ocupadas, entrada e saída são posicionadas aleatóriamente.
	 */
	public Labirinto(int dimX, int dimY, int txO, boolean d){
		this.dimX = dimX;
		this.dimY = dimY;
		labirinto = new int[dimX][dimY];
		txObstaculos = txO;

		Random gerador = new Random();

		for (int x = 0; x < dimX; x++)
			for (int y = 0; y < dimY; y++){
				if (gerador.nextInt(100) < txObstaculos)
					labirinto[x][y] = 1;
			}

		atual = new Posicao(gerador.nextInt(dimX), gerador.nextInt(dimY));
		labirinto[atual.getX()][atual.getY()] = 2;
		saida   = new Posicao(gerador.nextInt(dimX), gerador.nextInt(dimY));
		labirinto[saida.getX()][saida.getY()] = 3;
	}

	/**
	 * Fornece a posição de partida no labirinto
	 *
	 * @return Retorna uma posição X,Y
	 */
	public Posicao getPosicaoAtual(){
		return atual;
	}

	/**
	 * Fornece a posição de saído no labirinto
	 *
	 * @return Retorna uma posição X,Y
	 */
	public Posicao getPosicaoSaida(){
		return saida;
	}

	/**
	 * Fornece um vetor de posições disponíveis no entorno de uma dada posição.
	 *
	 * @param p Posição a partir da qual serão identificadas as livres em seu 
	 * redor.
	 * @return Vetor de posições livres para se movimentar.
	 */
	public Vector<Posicao> getExpansao(Posicao p){
		int x = p.getX();
		int y = p.getY();

		Vector<Posicao> expansao = new Vector<Posicao>();

		if (x > 0 && labirinto[x-1][y] != 1)
			expansao.add(new Posicao(x-1,y));
		if (x < dimX-1  && labirinto[x+1][y] != 1)
			expansao.add(new Posicao(x+1,y));
		if (y > 0  && labirinto[x][y-1] != 1)
			expansao.add(new Posicao(x,y-1));
		if (y < dimY-1  && labirinto[x][y+1] != 1)
			expansao.add(new Posicao(x,y+1));

		return expansao;
	}

	/**
	 * Fornece a informação de uma dada posição (entrada, saída, etc).
	 *
	 * @param p Posição a ser analisada.
	 * @return Valor numérico que indica a ocupação da posição.
	 */
	public int getValorPosicao(Posicao p){
		return labirinto[p.getX()][p.getY()];
	}

	/**
	 * Imprime o labirinto marcando as posições fornecidas
	 *
	 * @param caminho Vetor de posições que devem ser marcadas na impressão do 
	 * labirinto.
	 */
	public void print(Posicao[] caminho){
		
		/* Imprime o Labirinto com o caminho */
		System.out.print("      |");
		for (int c = 0; c < dimY; c++)
			System.out.printf("%4d|", c);
		System.out.printf("\n      |");
		for (int c = 0; c < dimY; c++)
			System.out.printf("----|");
		System.out.println();
		for (int x = 0; x < dimX; x++){
			System.out.printf("%6d|", x);
			for (int y = 0; y < dimY; y++){
				if (labirinto[x][y] != 0 ) {
					if (labirinto[x][y] == 1)
						System.out.printf("++++|");
					if (labirinto[x][y] == 2)
						System.out.printf("  E |");
					if (labirinto[x][y] == 3)
						System.out.printf("  S |");
				}
				else {
					boolean solucao = false;		       
					if ( caminho != null){
						for (int pc=0; pc<caminho.length; pc++)
							if (caminho[pc].comparaCom(x,y)){
								solucao = true;
							}
					}
					if (solucao)
						System.out.print("  x |");
					else
						System.out.print("    |");
				}
			}
			System.out.printf("\n      |");
			for (int c = 0; c < dimY; c++)
				System.out.printf("----|");
			System.out.println();
		}
		
		if (caminho != null) {
			/* Imprime o caminho*/
			for (int c = caminho.length - 1; c >= 0; c--) {
				System.out.print(" -> " + caminho[c].toString());
			}
			System.out.println();
		}
	}


	/**
	 * Fornece a distância em linha reta a partir do cálculo da hipotenusa 
	 * entre duas posições do labirinto.
	 *
	 * @param a Posição A.
	 * @param b Posição B.
	 */
	public double getDLR(Posicao a, Posicao b){
		int catB = Math.abs(a.getX() - b.getX()); // Cateto B
		int catC = Math.abs(a.getY() - b.getY()); // Cateto B
		double DLR = Math.sqrt((catB * catB) + (catC * catC));
		return DLR;
	}

	/**
	 * Fornece a dimensão do labirinto em X
	 */
	public int getDimX(){
		return dimX;
	}

	/**
	 * Fornece a dimensão do labirinto em Y
	 */
	public int getDimY(){
		return dimY;
	}
}