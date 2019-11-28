package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author santiago.scantamburlo
 */
public class TestInmobiliariaIIbis {

    //Este algoritmo se encarga de predefinir al arreglo y llama a un menu con las opciones disponibles
    public static void main(String[] args) {
        //Declaracion e inicializacion de variables
        Scanner pufu = new Scanner(System.in);
        Propiedad[] arreglo;
        boolean continuar = true;
        boolean ordenado = false;
        int indice = 10;
        int opcion, cantPropiedades, props;

        cantPropiedades = cargarLongitudMaxima();

        arreglo = new Propiedad[cantPropiedades];
        arreglo = predefinirArreglo(arreglo); //Llamo al modulo que va a predefinir las primeras 10 posiciones del arreglo

        while (continuar != false) {
            menu(); //Llamo al modulo que va a imprimir las opciones disponibles
            opcion = pufu.nextInt();

            //Lee la opcion ingresada y efectua la accion correspondiente
            switch (opcion) {
                case 1:
                    props = definirCantPropiedades(indice, arreglo);
                    arreglo = cargarDatos(indice, arreglo, props);
                    indice = indice + props;
                    ordenado = false;
                    break;
                case 2:
                    listarDatos(arreglo, indice);
                    break;
                case 3:
                    verificarCasa(arreglo, indice);
                    break;
                case 4:
                    verificarDepto(arreglo, indice);
                    break;
                case 5:
                    ordenarXPrecio(arreglo, indice);
                    listarDatos(arreglo, indice);
                    ordenado = true;
                    break;
                case 6:
                    contarPropiedades(arreglo, indice);
                    break;
                case 7:
                    buscarMayor(arreglo, indice);
                    break;
                case 8:
                    buscarCasa(arreglo, ordenado);
                    break;
                case 9:
                    heapSort(arreglo, indice);
                    listarDatos(arreglo, indice);
                    break;
                case 0:
                    continuar = false;
                    break;
                default: //En caso de no haberse ingresado una opcion valida repite el llamado del menu
                    System.out.println("Ingrese una opcion valida");
            }
        }
    }

    //Solicita al usuario la longitud maxima del arreglo y verifica que esa longitud sea mayor a diez
    public static int cargarLongitudMaxima() {
        Scanner pufu = new Scanner(System.in);
        int propsACargar = 0;
        boolean cantValida = false;

        while (cantValida != true) {
            System.out.println("Ingrese la cantidad total de propiedades");
            propsACargar = pufu.nextInt();

            if (propsACargar > 10) {
                cantValida = true;
            }
        }
        return propsACargar;
    }

    //Este modulo predefine las primeras diez posiciones del arreglo
    public static Propiedad[] predefinirArreglo(Propiedad[] arr) {
        arr[0] = new Propiedad(00000, 'c', "San Martin", 3, 'v', 200, true, 150000);
        arr[1] = new Propiedad(11111, 'd', "Libertad", 4, 'a', 80, false, 16000);
        arr[2] = new Propiedad(22222, 'x', "Santa Fe", 2, 't', 74, true, 1300);
        arr[3] = new Propiedad(33333, 'x', "Avenida Olascoaga", 5, 'a', 96, true, 19500);
        arr[4] = new Propiedad(44444, 'd', "Santa Rosa", 7, 'v', 156, true, 1250000);
        arr[5] = new Propiedad(55555, 'c', "Tierra del Fuego", 5, 'a', 79, false, 32000);
        arr[6] = new Propiedad(66666, 'x', "Saturnino Torres", 6, 'a', 103, false, 25320);
        arr[7] = new Propiedad(77777, 'x', "Bahia Blanca", 4, 't', 125, true, 1250);
        arr[8] = new Propiedad(88888, 'd', "Elordi", 3, 'v', 86, true, 57890);
        arr[9] = new Propiedad(99999, 'c', "San Martin", 1, 't', 12, false, 1350);

        return arr;
    }

    //Este modulo imprime las opciones disponibles
    public static void menu() {
        System.out.println("Ingrese una opcion a realizar");
        System.out.println("1: Cargar datos");
        System.out.println("2: Listar datos");
        System.out.println("3: Verificar casa");
        System.out.println("4: Verificar departamento");
        System.out.println("5: Ordenar las propiedades por precio");
        System.out.println("6: Contar la cantidad de propiedades disponibles con una cantidad de ambientes determinada");
        System.out.println("7: Encontrar la casa en alquiler con la mayor superficie");
        System.out.println("8: Verificar la existencia de una casa con un precio dado");
        System.out.println("9: Ordenar las propiedades por superficie");
        System.out.println("0: Finalizar");
    }

    //Este modulo solicita que se ingrese la cantidad de propiedades a cargar, verificando que no supere la longitud total del arreglo
    public static int definirCantPropiedades(int i, Propiedad[] arreglo) {
        Scanner pufu = new Scanner(System.in);
        int propsACargar = 0;
        boolean cantValida = false;

        //Verifico que la cantidad de propiedades ingresada no supere la cantidad total de posiciones del arreglo y se repite hasta que se ingrese un valor valido
        while (cantValida != true) {
            System.out.println("¿Cuantas propiedades va a cargar?");
            propsACargar = pufu.nextInt();

            if (propsACargar + i <= arreglo.length) {
                cantValida = true;
            }
        }

        return propsACargar;
    }

    //Este modulo se encarga de la carga de los datos de las propiedades llamando modulos que van a retornar cada valor, y despues se asignan a una variable del tipo
    public static Propiedad[] cargarDatos(int i, Propiedad[] a, int propiedades) {
        boolean esValido = false;
        Propiedad p;
        int codigo = 0, cantAmbientes, superficie, precio, k;
        String direccion;
        char tipo, operacion;
        boolean disponibilidad;

        k = i;
        for (int j = i; j < i + propiedades; j++) {

            //Repite hasta que el codigo ingresado sea valido
            while (esValido != true) {
                codigo = cargarCodigo();
                esValido = verificarCodigo(a, codigo, k);//Llama al modulo que verifica la validez del codigo
            }
            tipo = cargarTipo();
            direccion = cargarDireccion();
            cantAmbientes = cargarAmbientes();
            operacion = cargarOperacion();
            superficie = cargarSuperficie();
            disponibilidad = cargarDisponibilidad();
            precio = cargarPrecio();

            p = new Propiedad(codigo, tipo, direccion, cantAmbientes, operacion, superficie, disponibilidad, precio);
            a[j] = p; //Asigno la propiedad cargada
            esValido = false;
            k++;
        }
        return a;
    }

    //Este modulo se encarga de verificar la validez del codigo ingresado anteriormente
    public static boolean verificarCodigo(Propiedad[] a, int cod, int i) {

        Propiedad p = new Propiedad(cod);
        boolean retorno;
        int j = 0;
        while (!(a[j].equals(p)) && j < i - 1) { //Hago uso del metodo equals para comparar los codigos de las Propiedades
            j++;
        }
        if (a[j].equals(p)) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }

    //Este modulo se encarga de solicitar que se ingrese un codigo para luego verificarlo
    public static int cargarCodigo() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        int codigo = 0;
        char opcion;

        while (continuar != false) {
            System.out.println("Ingrese el codigo");
            codigo = pufu.nextInt();
            System.out.println("¿El codigo ingresado es correcto? s/n");
            opcion = pufu.next().charAt(0);
            switch (opcion) {
                case 's':
                    continuar = false;
                    break;
                case 'n':
                    continuar = true;
                    break;
                default:
                    continuar = true;
            }
        }
        return codigo;
    }

    //Solicita el ingreso del tipo de Propiedad, verificando que sea un tipo valido
    public static char cargarTipo() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        char tipo = 0;

        while (continuar != false) {
            System.out.println("Ingrese el tipo");
            tipo = pufu.next().charAt(0);
            if (tipo == 'c' || tipo == 'd' || tipo == 'x') {
                continuar = false;
            }
        }
        return tipo;
    }

    //Solicita el ingreso de la direccion y pregunta si fue ingresada correctamente
    public static String cargarDireccion() {
        Scanner pufu = new Scanner(System.in);
        String direccion = "";
        boolean continuar = true;
        char opcion;

        while (continuar != false) {
            System.out.println("Ingrese la direccion");
            direccion = pufu.next();
            System.out.println("¿La direccion es correcta? s/n");
            opcion = pufu.next().charAt(0);

            switch (opcion) {
                case 's':
                    continuar = false;
                    break;
                case 'n':
                    continuar = true;
                    break;
                default:
                    continuar = true;
            }
        }
        return direccion;
    }

    //Solicita la cantidad de ambientes y pregunta si fue ingresada correctamente
    public static int cargarAmbientes() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        int cantAmbientes = 0;
        char opcion;

        while (continuar != false) {
            System.out.println("Ingrese la cantidad de ambientes");
            cantAmbientes = pufu.nextInt();
            System.out.println("¿La cantidad de ambientes es correcta? s/n");
            opcion = pufu.next().charAt(0);

            switch (opcion) {
                case 's':
                    continuar = false;
                    break;
                case 'n':
                    continuar = true;
                    break;
                default:
                    continuar = true;
            }
        }
        return cantAmbientes;
    }

    //Solicita la operacion de la Propiedad, verificando que sea una operacion valida
    public static char cargarOperacion() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        char operacion = 0;

        while (continuar != false) {
            System.out.println("Ingrese la operacion v/a/t");
            operacion = pufu.next().charAt(0);
            if (operacion == 'v' || operacion == 'a' || operacion == 't') {
                continuar = false;
            }
        }
        return operacion;
    }

    //Solicita la superficie y pregunta si fue ingresada correctamente
    public static int cargarSuperficie() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        char opcion;
        int superficie = 0;

        while (continuar != false) {
            System.out.println("Ingrese la superficie");
            superficie = pufu.nextInt();
            System.out.println("¿La superficie es correcta? s/n");
            opcion = pufu.next().charAt(0);

            switch (opcion) {
                case 's':
                    continuar = false;
                    break;
                case 'n':
                    continuar = true;
                    break;
                default:
                    continuar = true;
            }
        }
        return superficie;
    }

    //Solicita la disponibilidad de la Propiedad, verificando que sea una opcion valida
    public static boolean cargarDisponibilidad() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        char disp;
        boolean disponibilidad = false;
        while (continuar != false) {
            System.out.println("Ingrese la disponibilidad d/o");
            disp = pufu.next().charAt(0);
            switch (disp) {
                case 'd':
                    disponibilidad = true;
                    continuar = false;
                    break;
                case 'o':
                    disponibilidad = false;
                    continuar = false;
                    break;
                default:
                    continuar = true;
                    break;
            }
        }
        return disponibilidad;
    }

    //Solicita el precio de la Propiedad y pregunta si fue ingresado correctamente
    public static int cargarPrecio() {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        char opcion;
        int precio = 0;

        while (continuar != false) {
            System.out.println("Ingrese el precio");
            precio = pufu.nextInt();
            System.out.println("¿El precio es correcto? s/n");
            opcion = pufu.next().charAt(0);

            switch (opcion) {
                case 's':
                    continuar = false;
                    break;
                case 'n':
                    continuar = true;
                    break;
                default:
                    continuar = true;
            }
        }
        return precio;
    }

    //Este modulo recorre el arreglo e imprime los datos de cada Propiedad por medio del metodo toString()
    public static void listarDatos(Propiedad[] arreglo, int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(arreglo[j].toString());
        }
    }

    //Este modulo recorre el arreglo buscando todas las Propiedades que sean casas a la venta con una superficie superior a 100 y esten disponibles
    public static void verificarCasa(Propiedad[] arreglo, int i) {
        char tipo, op;
        int sup, contador = 0;
        boolean disp;

        for (int j = 0; j < i; j++) {
            tipo = arreglo[j].getTipo();
            op = arreglo[j].getOperacion();
            sup = arreglo[j].getSuperficie();
            disp = arreglo[j].getDisponibilidad();
            if (tipo == 'c' && op == 'v' && sup > 100 && disp) {
                System.out.println(arreglo[j].toString());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay propiedades que cumplan con las caracteristicas buscadas");
        }
    }

    //Este modulo recorre el arreglo buscando todas las Propiedades que sean departamentos en alquiler de un solo ambiente por menos de $20.000
    public static void verificarDepto(Propiedad[] arreglo, int i) {
        char tipo, op;
        int cantAmbientes, precio, contador = 0;

        for (int j = 0; j < i; j++) {
            tipo = arreglo[j].getTipo();
            op = arreglo[j].getOperacion();
            cantAmbientes = arreglo[j].getCantAmbientes();
            precio = arreglo[j].getPrecio();
            if (tipo == 'd' && op == 'a' && cantAmbientes == 1 && precio < 20000) {
                System.out.println(arreglo[j].toString());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay propiedades que cumplan con las caracteristicas buscadas");
        }
    }

    //Este modulo recibe el arreglo de propiedades y muestra un menu con los metodos de ordenamiento disponibles
    public static void ordenarXPrecio(Propiedad[] arreglo, int n) {
        Scanner pufu = new Scanner(System.in);
        int opcion;

        System.out.println("Ingrese el tipo de ordenamiento que desea utilizar");
        System.out.println("1: Burbuja Mejorado");
        System.out.println("2: Seleccion");
        System.out.println("3: Insercion");
        opcion = pufu.nextInt();

        switch (opcion) {
            case 1:
                burbujaMejorado(arreglo, n);
                break;
            case 2:
                seleccion(arreglo, n);
                break;
            case 3:
                insercion(arreglo, n);
                break;
        }
    }

    public static void burbujaMejorado(Propiedad[] a, int n) {
        int i = 0;
        boolean sinCambio = false;
        Propiedad p;

        while (i < n && !sinCambio) {
            sinCambio = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].getPrecio() > a[j + 1].getPrecio()) {
                    p = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = p;
                    sinCambio = false;
                }
            }
            i++;
        }
    }

    public static void seleccion(Propiedad[] a, int n) {
        int i, j, min;
        Propiedad p;

        for (i = 0; i < n - 1; i++) {
            min = i;

            for (j = i + 1; j < n; j++) {
                if (a[j].getPrecio() < a[min].getPrecio()) {
                    min = j;
                }
            }
            p = a[i];
            a[i] = a[min];
            a[min] = p;
        }

    }

    public static void insercion(Propiedad[] a, int n) {
        int j;
        Propiedad p;

        for (int i = 1; i < n; i++) {
            p = a[i];
            j = i;
            while (j > 0 && p.getPrecio() < a[j - 1].getPrecio()) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = p;
        }
    }

    //Solicito que se ingrese la cantidad de ambientes buscado y llamo al metodo recursivo
    public static void contarPropiedades(Propiedad[] arreglo, int i) {
        Scanner pufu = new Scanner(System.in);
        int cantPropiedades, cantAmbientes;

        System.out.println("Ingrese la cantidad de ambientes que desea buscar");
        cantAmbientes = pufu.nextInt();

        cantPropiedades = contar(arreglo, i - 1, cantAmbientes);
        System.out.println("Hay " + cantPropiedades + " propiedades con " + cantAmbientes + " ambientes");
    }

    //Recorro el arreglo recursivamente y aumento en 1 el retorno cada vez que la cantidad de ambientes es igual a la ingresada
    public static int contar(Propiedad[] arreglo, int n, int buscado) {
        int retorno = 0;

        if (n == 0) {
            if (arreglo[n].getCantAmbientes() == buscado && arreglo[n].getDisponibilidad()) {
                retorno = 1;
            }
        } else {
            if (arreglo[n].getCantAmbientes() == buscado && arreglo[n].getDisponibilidad()) {
                retorno = 1 + contar(arreglo, n - 1, buscado);
            } else {
                retorno = contar(arreglo, n - 1, buscado);
            }
        }
        return retorno;
    }

    public static void buscarMayor(Propiedad[] arreglo, int indice) {
        int pos;

        pos = posicionMayor(arreglo, indice - 1);

        if (pos != -1) {
            System.out.println(arreglo[pos].toString());
        } else {
            System.out.println("No existe una propiedad de esas caracteristicas");
        }
    }

    //Buscamos la casa disponible en alquiler con mas superficie
    public static int posicionMayor(Propiedad[] arreglo, int indice) {
        int pos = -1;
        char tipo, operacion;
        boolean disponibilidad;
        int superficie;

        tipo = arreglo[indice].getTipo();
        operacion = arreglo[indice].getOperacion();
        disponibilidad = arreglo[indice].getDisponibilidad();
        superficie = arreglo[indice].getSuperficie();

        if (indice == 0) { //Caso base cuando la posicion sea cero
            if (disponibilidad && tipo == 'c' && operacion == 'a') { //Verifica qie sea una casa disponible en alquiler y retorna la posicion actual. De no serlo retorna -1
                pos = indice;
            }
        } else {
            pos = posicionMayor(arreglo, indice - 1); //Hace el paso recursivo hasta llegar a la primer posicion y empieza a verificar
            if (pos == -1) { //Verifica que el retorno sea una casa disponible en alquiler
                if (disponibilidad && tipo == 'c' && operacion == 'a') { //De no serlo verifica que la propiedad de la posicion actual lo sea
                    pos = indice;
                }
            } else {
                if (disponibilidad && tipo == 'c' && operacion == 'a') { //Si la propiedad en la posicion retornada es valida, verifica que la de la posicion actual tambien lo sea
                    if (arreglo[pos].getSuperficie() < superficie) {
                        pos = indice;
                    }
                }
            }
        }
        return pos;
    }

    //En este modulo se realiza la busqueda de una propiedad con un precio ingresado
    public static void buscarCasa(Propiedad[] arreglo, boolean ordenado) {
        Scanner pufu = new Scanner(System.in);
        int precioBuscado, pos;
        if (ordenado) { //Verifico que el arreglo haya sido ordenado previamente, y a continuar realizo la busqueda
            System.out.println("Ingrese el precio de la casa que busca");
            precioBuscado = pufu.nextInt();
            pos = busquedaBinaria(arreglo, precioBuscado);

            if (pos == -1) {//Verifico que la posicion sea diferente a -1 para imprimir la propiedad con el precio ingresado
                System.out.println("El precio ingresado no pertenece a ninguna propiedad");
            } else {
                System.out.println(arreglo[pos].toString());
            }
        } else { //Si no esta ordenado imprime el cartel y vuelve al menu de opciones
            System.out.println("El arreglo no esta ordenado");
            System.out.println("");
        }
    }

    //Realizo la busqueda binaria una vez se verifica que esta ordenado y se solicita el precio
    public static int busquedaBinaria(Propiedad[] arreglo, int precioBuscado) {
        int inicio, fin, pos, medio;

        inicio = 0;
        fin = arreglo.length - 1;
        pos = -1;

        while (inicio <= fin) {
            medio = (inicio + fin) / 2;
            if (precioBuscado == arreglo[medio].getPrecio()) {
                pos = medio;
                inicio = fin + 1;
            } else if (precioBuscado < arreglo[medio].getPrecio()) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return pos;
    }

    public static void heapSort(Propiedad[] a, int n) {
        Propiedad temp;
        for (int i = n / 2; i >= 0; i--) {
            hacerMonticulo(a, i, n - 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            hacerMonticulo(a, 0, i - 1);
        }
    }

    public static void hacerMonticulo(Propiedad[] a, int i, int fin) {
        int izq = 2 * i + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            if (a[izq].getSuperficie() > a[der].getSuperficie()) {
                may = izq;
            } else {
                may = der;
            }
        }
        if (a[i].getSuperficie() < a[may].getSuperficie()) {
            Propiedad tmp = a[i];
            a[i] = a[may];
            a[may] = tmp;
            hacerMonticulo(a, may, fin);
        }
    }
}
