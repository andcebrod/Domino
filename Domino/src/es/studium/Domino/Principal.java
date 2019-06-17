package es.studium.Domino;

public class Principal {
	public static void main(String[] args) {
		MenuPrincipal MPrincipal = new MenuPrincipal();
		Modelo Mo = new Modelo();
		new ControladorMenuPrincipal(MPrincipal, Mo);
		
	}
}
