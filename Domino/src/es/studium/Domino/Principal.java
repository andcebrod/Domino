package es.studium.Domino;

public class Principal {
	public static void main(String[] args) {
		MenuPrincipal MPrincipal = new MenuPrincipal();
		Modelo Mod = new Modelo();
		new Controlador(MPrincipal, Mod);
	}
}
