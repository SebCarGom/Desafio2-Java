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

		// Creacion variables StringBuilder
		StringBuilder strCoins = new StringBuilder();
		StringBuilder strMoney = new StringBuilder();
		StringBuilder strTickets = new StringBuilder();
		StringBuilder strToys = new StringBuilder();
		StringBuilder strCoinsPerPlay = new StringBuilder();
		StringBuilder strMaxTicketsReward = new StringBuilder();

		// Asignación a variables StringBuilder
		strCoins.append(pinball1.getPlayerName()).append(" tiene ").append(pinball1.getCoins()).append(" monedas.");
		strMoney.append(pinball1.getPlayerName()).append(" tiene ").append(pinball1.getEuros()).append(" euros.");
		strTickets.append(pinball1.getPlayerName()).append(" tiene ").append(pinball1.getTickets()).append(" tickets.");
		strToys.append("Lista de premios: ").append(pinball1.getToysOwned());
		strCoinsPerPlay.append("Cada partida cuesta ").append(pinball1.getCoinsPerPlay()).append(" monedas.");
		strMaxTicketsReward.append("El premio máximo del Pinball es de ").append(pinball1.getMaxTicketsPerPlay())
				.append(" tickets.");

		// Se muestran las propiedades del Pinball y del Jugador.
		System.out.println(strCoinsPerPlay);
		System.out.println(strMaxTicketsReward);
		System.out.println(strCoins);
		System.out.println(strTickets);
		System.out.println(strMoney);
		System.out.println(strToys);

		// Se ejecuta el metodo LaunchBall 20 veces.
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBall();
		pinball1.launchBallFiveTimes();
		pinball1.launchBallTenTimes();

		// Se intercambian las monedas restantes del jugador por euros.
		pinball1.exchangeCoins(10);

		// Se intercambian 10 euros por monedas.
		pinball1.exchangeEuros(4);

		// Reasignación a variables StringBuilder.
		strCoins.setLength(0);
		strMoney.setLength(0);
		strTickets.setLength(0);

		strCoins.append(pinball1.getPlayerName()).append(" tiene ").append(pinball1.getCoins()).append(" monedas.");
		strMoney.append(pinball1.getPlayerName()).append(" tiene ").append(pinball1.getEuros()).append(" euros.");
		strTickets.append(pinball1.getPlayerName()).append(" tiene ").append(pinball1.getTickets()).append(" tickets.");

		// Se muestran las propiedades del Jugador.
		System.out.println(strTickets);
		System.out.println(strMoney);
		System.out.println(strCoins);

		// Se le da al jugador la opcion de comprar premios.
		pinball1.exchangeTickets();

		// Reasignación a variable strToys.
		strToys.setLength(0);
		strToys.append("Lista de premios: ").append(pinball1.getToysOwned());

		// Se imprimen los premios del jugador.
		System.out.println(strToys);

		// Se comprueba si pinball1 pertenece a la clase Pinball
		if (pinball1 instanceof Pinball) {
			System.out.println("pinball1 pertence a la clase Pinball");
		} else {
			System.out.println("pinball1 no pertence a la clase Pinball");
		}
	}

}
