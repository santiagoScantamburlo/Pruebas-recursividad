package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author santiago.scantamburlo
 */
public class TestInmobiliariaII {

    //Este algoritmo se encarga de predefinir al arreglo y llama a un menu con las opciones disponibles
    public static void main(String[] args) {
        //Declaracion e inicializacion de variables
        Scanner pufu = new Scanner(System.in);
        Propiedad[] arreglo;
        boolean continuar = true;
        int indice = 10;
        int opcion, props;

        arreglo = new Propiedad[indice];
        arreglo = predefinirArreglo(arreglo); //Llamo al modulo que va a predefinir las primeras 10 posiciones del arreglo

        while (continuar != false) {
            menu(); //Llamo al modulo que va a imprimir las opciones disponibles
            opcion = pufu.nextInt();

            //Lee la opcion ingresada y efectua la accion correspondiente
            switch (opcion) {
                case 1:
                    props = definirCantPropiedades();
                    for (int i = 0; i < props; i++) {
                        indice++;
                        arreglo = cargarDatos(indice, arreglo);
                    }
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
                case 0:
                    continuar = false;
                    break;
                default: //En caso de no haberse ingresado una opcion valida repite el llamado del menu
                    System.out.println("Ingrese una opcion valida");
            }
        }
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
        System.out.println("0: Finalizar");
    }

    //Este modulo solicita que se ingrese la cantidad de propiedades a cargar, verificando que no supere la longitud total del arreglo
    public static int definirCantPropiedades() {
        Scanner pufu = new Scanner(System.in);
        int propsACargar;

        System.out.println("Ingrese la cantidad de propiedades a cargar");
        propsACargar = pufu.nextInt();

        return propsACargar;
    }

    //Este modulo se encarga de la carga de los datos de las propiedades llamando modulos que van a retornar cada valor, y despues se asignan a una variable del tipo
    public static Propiedad[] cargarDatos(int i, Propiedad[] a) {
        boolean esValido = false;
        Propiedad p;
        Propiedad[] arr = new Propiedad[i];
        int codigo = 0, cantAmbientes, superficie, precio, k;
        String direccion;
        char tipo, operacion;
        boolean disponibilidad;
        
        k = a.length;
        
        for (int j = 0; j < k; j++) {
            arr[j] = a[j];
        }

            //Repite hasta que el codigo ingresado sea valido
            while (esValido != true) {
                codigo = cargarCodigo();
                esValido = verificarCodigo(arr, codigo, i);//Llama al modulo que verifica la validez del codigo
            }
            tipo = cargarTipo();
            direccion = cargarDireccion();
            cantAmbientes = cargarAmbientes();
            operacion = cargarOperacion();
            superficie = cargarSuperficie();
            disponibilidad = cargarDisponibilidad();
            precio = cargarPrecio();

            p = new Propiedad(codigo, tipo, direccion, cantAmbientes, operacion, superficie, disponibilidad, precio);
            arr[i] = p;
        return a;
    }

    //Este modulo se encarga de verificar la validez del codigo ingresado anteriormente
    public static boolean verificarCodigo(Propiedad[] a, int cod, int i) {

        Propiedad p = new Propiedad(cod);
        boolean retorno = true;
        int j = 0;
        while (!(a[j].equals(p)) && j < i - 1) { //Hago uso del metodo equals para comparar los codigos de las Propiedades
            j++;
        }
        if (a[j].equals(p)) {
            retorno = false;
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
}
