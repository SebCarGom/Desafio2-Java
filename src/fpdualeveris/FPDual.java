package fpdualeveris;

import operators.Pinball;

/**
 * Formacion Java
 * 
 * @author Sebas
 *
 */
public class FPDual {

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		operatorsChallenge();

	}

	/**
	 * Metodo de la clase FPDual.
	 */
	public static void operatorsChallenge() {

		// Creacion del Objeto Pinball y creacion del Jugador para poder ejecutar el
		// metodo launchBall().
		Pinball pinball1 = new Pinball(2, 700);
		pinball1.createPlayer("Antonio", 100, 50, 0);

		// Se muestran las propiedades del Pinball y del Jugador.
		System.out.println("Cada partida cuesta " + pinball1.getCoinsPerPlay() + " monedas.");
		System.out.println("El premio máximo del Pinball es de " + pinball1.getMaxTicketsPerPlay() + " tickets.");
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getCoins() + " monedas.");
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getTickets() + " tickets.");
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getEuros() + " euros.\n");

		// Se ejecuta el metodo LaunchBall 5 veces.
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBall();

		// Se muestran las monedas que tiene el Jugador.
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getCoins() + " monedas.\n");

		// Se intercambian las monedas restantes del jugador por euros.
		pinball1.exchangeCoins(40);

		// Se muestran las propiedades del Jugador.
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getTickets() + " tickets.");
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getEuros() + " euros.");
		System.out.println(pinball1.getPlayerName() + " tiene " + pinball1.getCoins() + " monedas.\n");

		// Se imprimen los premios que tiene el jugador y se le da la opcion de
		// comprarlos.
		System.out.println("Lista de premios: " + pinball1.getToysOwned());
		pinball1.exchangeTickets();
		System.out.println("Lista de premios: " + pinball1.getToysOwned() + "\n");

		// Se comprueba si pinball1 pertenece a la clase Pinball
		System.out.println(pinball1 instanceof Pinball);
	}

}
