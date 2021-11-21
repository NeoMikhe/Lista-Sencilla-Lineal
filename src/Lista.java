import javax.swing.JOptionPane;

public class Lista {
    Nodo head;

	public Lista() {
		head = null;
	}
	
	public void crearLista() {
		Nodo q = new Nodo();
		//Código para crear la lista
		String [] leer = { "Si", "No"};
		int op;
		do{
			Nodo p = new Nodo();
			int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Leer dato: "));
			p.setDato(n);
			p.setSig(null);

			if (head == null)
				head = p;
			else
				q.setSig(p);
			q = p;
			op = JOptionPane.showOptionDialog (null, "Leer otro dato?", "Selecciona una opcion", 
												JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, leer, leer[0]);
		}while(op != 1);
	}
	
	public void recorrerLista() {
		Nodo p = new Nodo();
		int cont = 1;
		//Código para recorrer la lista
		if (head != null){
			p = head;
			System.out.println("<=                                     =>");
			while(p != null){
				System.out.println("Posicion del nodo: "+cont+", Dato de nodo: "+p.getDato());
				p = p.getSig();
				cont++;
			}
		}
		else
			System.out.println("Lista vacia...");
	}
	
	public int tamanoLista() {
		Nodo p = new Nodo();
		int tam = 0;
		//Codigo para obtener el tamaño
		if (head != null){
			p = head;
			tam = 1;
			while(p.getSig() != null){
				tam++;
				p = p.getSig();
			}
		} else {
			System.out.println("Lista vacia...");
		}
		return tam;
	}

	public void insertarAlInicio(){
		//Código para insertar al inicio
		Nodo p = new Nodo();
		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar dato al inicio: "));
		p.setDato(n);
		p.setSig(head);
		head = p;
	}

	public void insertarAlFinal(){
		Nodo q = new Nodo();
		//Código para insertar al final
		Nodo p = new Nodo();
		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar dato al final: "));
		p.setDato(n);
		p.setSig(null);
		if(head != null){
			q = head;
			while(q.getSig()  != null){
				q = q.getSig();
			}
			q.setSig(p);
		} else{
			head = p;
		}
	}

	public void insertarEnPosicion(int pos){
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int c;
		//Código para insertar en cualquier posicion
		p = head;
		c = 0;
		while(p != null){
			p = p.getSig();
			c++;
		}
		if(pos > 0 && pos <= c+1){
			p = new Nodo();
			int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar dato: "));
			p.setDato(n);
			if(pos == 1){
				p.setSig(head);
				head = p;
			} else {
				q = head;
				for(int i = 1; i < pos-1; i++)
					q = q.getSig();
				p.setSig(q.getSig());
				q.setSig(p);
			}
		} else {
			System.out.println("Posicion incorrecta");
		}
	}

	public void borrarUltimo(){
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		if(head != null){
			p = head;
			while(p.getSig() != null){
				q = p;
				p = p.getSig();
			}
			if(p != head)
				q.setSig(null);
			else
				head = null;
		} else{
			System.out.println("Lista vacia");	
		}
	}

	public void borraPrimero(){
		if(head != null)
			head = head.getSig();
		else
		System.out.println("Lista vacia");	
	}

	public void borrarCualquier(int pos){
		Nodo p = new Nodo();
		Nodo q = new Nodo();
		int c = 0;
		if(head != null){
			p = head;
			c = 1;
			while(c != pos && p != null){
				q = p;
				p = p.getSig();
				c++;
			}
			if(c == pos && p != null){
				if(p == head)
					head = head.getSig();
				else
					q.setSig(p.getSig());
			} else{
				System.out.println("Posicion invalida");
			}
		} else{
			System.out.println("Lista vacia");
		}
	}

	public Nodo buscar(int valor){
		Nodo p = new Nodo();
		boolean existe;
		//int pos = 0;
		if (head != null){
			existe = false;
			p = head;
			while(p != null && existe == false){
				if (p.getDato() == valor)
					existe = true;
				p = p.getSig();
				//pos++;
			}
			if(existe == true){
				System.out.println("Se encontro el elemento");
				return p;
			}else{
				System.out.println("No se encontro el elemento");
				return null;
			}
		} else{
			System.out.println("Lista vacia");
			//pos = -1;
		}
		return null;
	}

}
