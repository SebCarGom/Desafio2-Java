package operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Formacion Java
 * 
 * @author Sebas
 *
 */
public class Pinball {

	private String playerName;
	private double euros;
	private int coins;
	private int tickets;
	private int coinsPerPlay;

	/* Premio maximo que se puede ganar en el pinball */
	private int maxTicketsPerPlay;
	private boolean playerCreated;
	private List<String> toysOwned = new ArrayList<>();

	/**
	 * Constructor de la clase Pinball
	 * 
	 * @param coinssPerPlay
	 * @param maxTicketsPerPlay
	 */
	public Pinball(int coinsPerPlay, int maxTicketsPerPlay) {
		this.coinsPerPlay = coinsPerPlay;
		this.maxTicketsPerPlay = maxTicketsPerPlay;

	}

	/**
	 * Metodo principal de la clase Pinball para poder poder empezar a Jugar. Para
	 * que este metodo funcione correctamente se condiciona a que es necesario un
	 * Jugador y suficientes monedas.
	 * 
	 */
	public void launchBall() {
		if (!playerCreated) {
			System.out.println("Por favor crea un jugador para poder empezar a jugar.\n");

		} else if (coins < coinsPerPlay) {
			System.out.println("No tienes suficientes monedas para poder jugar.\n");

		} else {

			int points = (int) (Math.random() * (999 + 1));
			coins -= coinsPerPlay;
			if (points == 999) {
				System.out.println("Enhorabuena! Has conseguido la máxima puntuación.\n Puntuación: " + points + "p\n");
				tickets += maxTicketsPerPlay;

			} else if (points >= 600) {
				System.out.println("Enhorabuena! Has conseguido una buena puntuación.\n Puntuación: " + points + "p\n");
				tickets += maxTicketsPerPlay / 2;

			} else if (points >= 300) {
				System.out.println(
						"Tu puntuación no ha sido mala pero puede mejorarse, ¿quieres intentarlo de nuevo?\n Puntuación: "
								+ points + "p\n");
				tickets += maxTicketsPerPlay / 3;

			} else {
				System.out
						.println("Tu puntuación no ha sido de las mejores, ¿quieres intentarlo de nuevo?\n Puntuación: "
								+ points + "p\n");
			}
		}
	}

	/**
	 * Creacion del jugador para poder inicalizar el metodo launchBall().
	 * 
	 * @param playerName
	 * @param euros
	 * @param coins
	 * @param tickets
	 */
	public void createPlayer(String playerName, double euros, int coins, int tickets) {
		this.playerName = playerName;
		this.euros = euros;
		this.coins = coins;
		this.tickets = tickets;
		playerCreated = true;

	}

	/**
	 * 
	 * @param coins
	 */
	public void exchangeCoins(int coins) {
		if (coins > this.coins || !playerCreated) {
			System.out
					.println("Ha ocurrido un error\nCompruebe si tiene suficientes monedas o hay un jugador creado.\n");

		} else {
			this.coins -= coins;
			euros += coins / 4;

		}

	}

	/**
	 * 
	 * @param euros
	 */
	public void exchangeEuros(int euros) {
		if (euros > this.euros || !playerCreated) {
			System.out.println("Ha ocurrido un error\nCompruebe si tiene suficiente dinero o hay un jugador creado.\n");

		} else {
			this.euros -= euros;
			coins += euros * 4;

		}

	}

	/**
	 * Se intercambian los tickets por premios mediante un menu que interactua con
	 * el usuario
	 * 
	 */
	public void exchangeTickets() {
		if (playerCreated && tickets > 0) {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("--- PREMIOS ----");
				showMenu();
				int i = 1;
				while (i != 0) {
					System.out.println("\nPor favor elija una OPCION:");
					showMenu();
					i = sc.nextInt();
					chooseToy(i);

				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error - Cerrando el programa.");

			}

		} else {
			System.out
					.println("Ha ocurrido un error\nCompruebe si tiene suficientes tickets o hay un jugador creado.\n");

		}
	}

	/**
	 * Se muestra el menu de los objetos.
	 * 
	 */
	private void showMenu() {
		System.out.println("OPCION 0 - ABANDONAR Menu Premios");
		System.out.println("OPCION 1 - Oso de peluche - Precio: 700 tickets");
		System.out.println("OPCION 2 - Yoyo - Precio: 300 tickets");
		System.out.println("OPCION 3 - Gorra - Precio: 500 tickets");

	}

	/**
	 * Dependiendo del parametro de entrada se ejecuta una accion del switch. Si la
	 * opcion es valida se realiza una comprobacion mediante una condicion para
	 * poder seguir ejecutando el metodo.
	 * 
	 * @param i
	 */
	private void chooseToy(int i) {
		switch (i) {
		case 0:
			System.out.println("ABANDONANDO MENU\n");
			break;

		case 1:
			if (tickets >= 700) {
				toysOwned.add("Oso de Peluche");
				tickets -= 700;

			} else {
				System.out.println("No tienes suficientes tickets.");

			}
			break;

		case 2:
			if (tickets >= 300) {
				toysOwned.add("Yoyo");
				tickets -= 300;

			} else {
				System.out.println("No tienes suficientes tickets.");

			}
			break;

		case 3:
			if (tickets >= 500) {
				toysOwned.add("Gorra");
				tickets -= 500;

			} else {
				System.out.println("No tienes suficientes tickets.");

			}
			break;

		default:
			System.out.println("OPCION Incorrecta. Por favor escoja una OPCION válida.");

		}

	}

	/**
	 * 
	 * @return toys
	 */
	public List<String> getToysOwned() {
		return toysOwned;

	}

	/**
	 * 
	 * @return tickets
	 */
	public int getTickets() {
		return tickets;

	}

	/**
	 * 
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;

	}

	/**
	 * 
	 * @return euros
	 */
	public double getEuros() {
		return euros;

	}

	/**
	 * 
	 * @return coins
	 */
	public int getCoins() {
		return coins;

	}

	/**
	 * 
	 * @return coinsPerPlay
	 */
	public int getCoinsPerPlay() {
		return coinsPerPlay;

	}

	/**
	 * 
	 * @return maxTicketsPerPlay
	 */
	public int getMaxTicketsPerPlay() {
		return maxTicketsPerPlay;

	}

}
