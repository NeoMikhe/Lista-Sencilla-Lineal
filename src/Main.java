import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
		Lista miLista = new Lista(); 

		int pos = 0;

        String menu = " ";
		String[] optionsMenu = {"Crear lista", "Recorrer lista", "Tamano de la lista",
		 "Insertar en el inicio", "Insertar en el final", "Insertar en posicion",
		 "Borrar ultimo", "Borrar primero", "Borrar en posicion", "Buscar", "Salir"};
		
		while(menu != "Salir") {
            menu = (String) JOptionPane.showInputDialog(null, "Elige una opcion del menu",
			        "Menu", JOptionPane.QUESTION_MESSAGE, null, optionsMenu, optionsMenu[0]);
			
			if(menu == null)
				menu = "Salir";
			
			switch(menu) {
			
			case "Crear lista":
				miLista.crearLista();
				break;
			
			case "Recorrer lista":
				miLista.recorrerLista();
				break;
				
			case "Tamano de la lista":
				JOptionPane.showMessageDialog(null, "El tamano de la lista es: "+miLista.tamanoLista());
				break;

			case "Insertar en el inicio":
				miLista.insertarAlInicio();
				break;
				
			case "Insertar en el final":
				miLista.insertarAlFinal();
				break;
				
			case "Insertar en posicion":
			    pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar posicion para insertar dato: "));
				miLista.insertarEnPosicion(pos);
				break;

			case "Borrar ultimo":
				miLista.borrarUltimo();
				break;

				case "Borrar primero":
				miLista.borraPrimero();
				break;

			case "Borrar en posicion":
				pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar posicion para borrar nodo: "));
				miLista.borrarCualquier(pos);
				break;

				case "Buscar":
				int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar valor a buscar: "));
				Nodo n = miLista.buscar(valor);
				if(n != null){
					JOptionPane.showMessageDialog(null, "Dato: "+n.getDato()+" Siguiente es:"+n.getSig());
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro");
				}
				/*pos = miLista.buscar(valor);
				if(pos != -1)
					JOptionPane.showMessageDialog(null, "El valor buscado: "+valor+" posicion donde se encontro: "+pos);*/
				break;
				
			case "Salir": // Mensaje despedida
				System.out.println("Decidiste salir del programa, hasta pronto!.");
				break;
			}
        }
    }
}
