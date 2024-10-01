package Football_manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        boolean exit = false;


        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Equipo> equipos = new ArrayList<>();

        generarEquipos(equipos, personas);


        Entrenador entrenador2 = new Entrenador("Juan", "de Dios", LocalDate.of(2001,9,21), 4, 2000,
                5, false, null);
        personas.add(entrenador2);

        do {
            opcion = menu(opcion);
            exit = switchMenu(opcion, equipos, personas);
        } while (!exit);
    }


    private static void generarEquipos(ArrayList equipos, ArrayList personas) {
        ArrayList<Jugador> jugadores_equipo = new ArrayList<>();

        // Con equipo
        Jugador jugador01 = new Jugador("Javier", "Castillo", LocalDate.of(2004,10,19), 10, 2004,
                5, "POR",5);

        Jugador jugador02 = new Jugador("Eric", "Pahino", LocalDate.of(2006,5,6), 2, 2006,
                8, "DEF",5);

        Jugador jugador03 = new Jugador("Juan", "de Dios", LocalDate.of(2001,2,10), 2, 2006,
                10, "MIG",5);

        Jugador jugador04 = new Jugador("Alex", "Garcia", LocalDate.of(2006,4,20), 2, 2006,
                10, "DAV",5);

        jugadores_equipo.add(jugador01);
        jugadores_equipo.add(jugador02);
        jugadores_equipo.add(jugador03);
        jugadores_equipo.add(jugador04);

        Equipo equipo01 = new Equipo("eq1", 1999, "Gibraltar",
                "Si", null, null, jugadores_equipo);
        equipos.add(equipo01);

        Equipo equipo02 = new Equipo("eq2", 1999, "Ibiza",
                "Si", null, null, jugadores_equipo);
        equipos.add(equipo02);

        // Sin equipo
        Jugador jugador05 = new Jugador("Luis", "Garcia", LocalDate.of(2000,1,20), 5, 2000,
                7, "POR",5);

        Jugador jugador06;
        jugador06 = new Jugador("Pol", "Rodriguez", LocalDate.of(2002,9,2), 2, 2006,
                8, "DEF",5);

        Jugador jugador07 = new Jugador("Lev", "Lopez", LocalDate.of(2007,10,21), 2, 2006,
                10, "MIG",5);

        Jugador jugador08 = new Jugador("Hugo", "Torres", LocalDate.of(1999,8,22), 2, 2006,
                10, "DAV",5);

        Entrenador entrenador01 = new Entrenador("Jean", "Felix", LocalDate.of(2000,5,10), 5,
                2000, 5, true, null);

        Entrenador entrenador02 = new Entrenador("Carlos", "Luis", LocalDate.of(1998,8,10), 5,
                2000, 5, true, null);

        personas.add(jugador05);
        personas.add(jugador06);
        personas.add(jugador07);
        personas.add(jugador08);
        personas.add(entrenador01);
        personas.add(entrenador02);
    }


    private static boolean teamManagerSwitch(int opcion_Manager, String nombre_equipo, ArrayList<Equipo> equipos, Equipo equipo_seleccionado, ArrayList<Persona> personas) {
        boolean exit = false;
        switch (opcion_Manager) {
            case 0:
                System.out.println("Saliendo del menu...");
                exit = true;
                break;

            case 1:
                darBajaEquipo(equipos);
                break;

            case 2:
                modificarPresidente(equipo_seleccionado);
                break;

            case 3:
                destituirEntrenador(personas, equipo_seleccionado);
                break;

            case 4:
                ficharEntrenadoryJugador(equipos,personas,equipo_seleccionado);
                break;

            case 5:
                transferirJugador(equipos, equipo_seleccionado);
                break;
        }
        return exit;
    }

    private static void transferirJugador(ArrayList<Equipo> equipos, Equipo equipo_seleccionado) {
        String nombreEquipo;
        boolean equipoEncontrado = false;
        String nombreJugador;
        int posicionEquipo = 0;
        Jugador jugador = null;
        ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
        Equipo equipoParaModificar = null;

        System.out.println("Introduce el nombre del equipo destino que quieres transferir el jugador");
        nombreEquipo = Teclat.llegirString();
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombreEquipo().equals(nombreEquipo)) {
                posicionEquipo = i;
            }
        }
        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                equipoParaModificar = equipo;
                equipoEncontrado = true;
            }
        }

        if (equipoEncontrado) {
            System.out.println("Jugadores del equipo " + equipo_seleccionado.getJugadores() + ":");
            System.out.println("Elige el jugador que quiere fichar");
            nombreJugador = Teclat.llegirString();
            for (int i = 0; i < equipo_seleccionado.getJugadores().size(); i++) {
                if (nombreJugador == equipo_seleccionado.getJugadores().get(i).getNombre()) {
                    jugador.equals(equipo_seleccionado.getJugadores().get(i).getNombre());
                    jugadoresEquipo.equals(equipo_seleccionado.getJugadores().get(i).getNombre());
                    jugadoresEquipo.remove(equipo_seleccionado.getJugadores().get(i).getNombre());
                    if (jugador.esTransferible()) {
                        jugador.transferirAEquipo(equipo_seleccionado, nombreJugador, equipoParaModificar);
                        System.out.println(equipo_seleccionado);
                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("El equipo no esta, se te devolvera al menu");
            System.out.println();
        }
    }

    private static void ficharEntrenadoryJugador(ArrayList<Equipo> equipos, ArrayList<Persona> personas, Equipo equipo_seleccionado) {
        int respuesta;
        boolean salir = false;

        System.out.println("Que quieres fichar? \n" +
                "1.- Entrenador \n" +
                "2.- Jugador");
        respuesta = Teclat.llegirInt();

        do {
            if (respuesta != 1 || respuesta != 2) {
                System.out.println("Introduce una de las 2 opciones \n" +
                        "1.- Entrenador \n" +
                        "2.- Jugador");
                respuesta = Teclat.llegirInt();
                salir = true;
            }
        } while (!salir);

        if (respuesta == 1) {
            ficharEntrenador(equipos, personas,equipo_seleccionado);
        }
        if (respuesta == 2) {
            ficharJugador(equipos, personas, equipo_seleccionado);
        }
    }

    private static void ficharJugador(ArrayList<Equipo> equipos, ArrayList<Persona> personas, Equipo equipo_seleccionado) {
        String nombreEquipo;
        boolean equipoEncontrado = false;
        boolean salir = false;
        boolean comprobar;
        String respuesta;
        int posicionEquipo = 0;
        int numi = 0;

        System.out.println("Introduce el nombre del equipo");
        nombreEquipo = Teclat.llegirString();
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombreEquipo().equals(nombreEquipo)) {
                posicionEquipo = i;
            }
        }
        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                equipo_seleccionado = equipo;
                equipoEncontrado = true;
            }
        }

        if (!equipoEncontrado) {
            System.out.println("El equipo no esta, se te devolvera al menu");
            System.out.println();
        }

        System.out.println("Jugadores disponibles:");
        for (Persona persona : personas) {
            if (persona instanceof Jugador) {
                Jugador jugador = (Jugador) persona;
                System.out.println(jugador.getNombre() + " " + jugador.getApellido());
            }
        }

        System.out.println("Que jugador quieres fichar?");
        respuesta = Teclat.llegirString();
        comprobar = false;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) != null || personas.get(i).getNombre().equals(respuesta)) {
                System.out.println("Se ha encontrado la persona");
                equipos.get(posicionEquipo).jugadores.add((Jugador) personas.get(i));
                numi = i;
                salir = true;
                comprobar = true;
            }
        }
        if (comprobar){
            personas.remove(personas.get(numi));
        }
        if (!salir) {
            System.out.println("No se ha podido encontrar una persona con el nombre " + respuesta);
        }
    }

    private static void ficharEntrenador(ArrayList<Equipo> equipos, ArrayList<Persona> personas, Equipo equipo_seleccionado) {
        String nombreEquipo;
        boolean equipoEncontrado = false;
        boolean salir = false;
        boolean comprobar;
        String respuesta;
        int posicionEquipo = 0;
        int numi = 0;

        System.out.println("Introduce el nombre del equipo");
        nombreEquipo = Teclat.llegirString();

        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombreEquipo().equals(nombreEquipo)) {
                posicionEquipo = i;
                equipoEncontrado = true;
                break;
            }
        }

        if (!equipoEncontrado) {
            System.out.println("El equipo no está disponible, se te devolverá al menú");
            return;
        }

        System.out.println("Entrenadores disponibles:");
        for (Persona persona : personas) {
            if (persona instanceof Entrenador) {
                Entrenador entrenador = (Entrenador) persona;
                System.out.println(entrenador.getNombre() + " " + entrenador.getApellido());
            }
        }

        System.out.println("¿Qué entrenador quieres fichar?");
        respuesta = Teclat.llegirString();

        comprobar = false;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Entrenador) {
                Entrenador entrenador = (Entrenador) personas.get(i);
                if (entrenador.getNombre().equals(respuesta)) {

                    if (entrenador.getEquipoActual() != null) {
                        System.out.println("El entrenador " + entrenador.getNombre() + " ya está en el equipo ");
                        comprobar = true;
                        break;
                    } else {
                        equipos.get(posicionEquipo).entrenador = entrenador;
                        entrenador.setEquipoActual(nombreEquipo);
                        numi = i;
                        salir = true;
                        comprobar = true;
                    }
                }
            }
        }

        if (comprobar) {
            personas.remove(personas.get(numi));
        }

        if (!salir) {
            System.out.println("No se ha podido encontrar un entrenador con el nombre " + respuesta);
        }
    }

    private static void destituirEntrenador(ArrayList<Persona> personas, Equipo equipo_seleccionado) {
        char respuesta;
        boolean salir = false;

        System.out.println("Estas seguro que quieres destituir al entrenador? \n" +
                "y = si, n = no");
        respuesta = Teclat.llegirChar();

        do {
            if (respuesta != 'y' || respuesta != 'n') {
                System.out.println("Solo se permite responder con 'y' o 'n', 'y = si' y 'n = no'");
                respuesta = Teclat.llegirChar();
                salir = true;
            }
        } while (!salir);

        if (respuesta == 'y') {
            personas.add(equipo_seleccionado.getEntrenador());
            equipo_seleccionado.setEntrenador(null);
        }
    }

    private static void modificarPresidente(Equipo equipo_seleccionado) {
        String nuevo_nombre_presi;
        boolean salir = false;

        System.out.println("Introduce el nuevo nombre del presidente: ");
        nuevo_nombre_presi = Teclat.llegirString();

        if (equipo_seleccionado.getNombrePresidente() == null || equipo_seleccionado.getNombrePresidente().isEmpty()) {
            System.out.println("El equipo no tiene presidente, pero se le asignara el presidente que has agregado");
            equipo_seleccionado.setNombrePresidente(nuevo_nombre_presi);
        } else {
            do {
                if (equipo_seleccionado.getNombrePresidente().equalsIgnoreCase(nuevo_nombre_presi)) {
                    System.out.println("Este nombre esta siendo utilizado \n" +
                            "Introduce otro:");
                    nuevo_nombre_presi = Teclat.llegirString();
                }
                equipo_seleccionado.setNombrePresidente(nuevo_nombre_presi);
                salir = true;
            } while (!salir);
        }
        System.out.println(equipo_seleccionado.getNombrePresidente());
    }

    private static void darBajaEquipo(ArrayList<Equipo> equipos) {
        String nombre_equipo;
        boolean equipo_encontrado = false;

        int i = 0;

        System.out.println("Introduce el nombre del equipo que quieres ver los datos");
        nombre_equipo = Teclat.llegirString();

        do {
            if (equipos.get(i).getNombreEquipo().equals(nombre_equipo)) {
                equipos.remove(i);
                equipo_encontrado = true;
            }
            i++;
        } while (i <= equipos.size() && !equipo_encontrado);
    }

    private static int teamManager() {
        int opcion_Manager;

        System.out.println();
        System.out.println("Team Manager \n" +
                "0- Salir \n" +
                "1- Dar baja equipo \n" +
                "2- Modificar presidente \n" +
                "3- Destituir a entrenador \n" +
                "4- Fichar jugador o entrenador \n" +
                "5- Transferir jugador \n" +
                "Elige una de las opciones:");

        opcion_Manager = Teclat.llegirInt();
        return opcion_Manager;
    }

    private static boolean switchMenu(int opcion, ArrayList<Equipo> equipos, ArrayList<Persona> personas) {
        boolean exit = false;
        switch (opcion) {
            case 0:
                exit = salirPrograma();
                break;

            case 1:
                gestionarEquipo(equipos, exit, personas);
                break;

            case 2:
                darAltaEquipo(equipos);
                break;

            case 3:
                darAltaJugadorEntrenador(personas);
                break;

            case 4:
                consultarDatosEquipos(equipos);
                break;

            case 5:
                consultarDatosJugador(equipos);
                break;

            case 6:
                disputarNuevaLiga(equipos);
                break;

            case 7:
                sesionEntrenamiento(personas);
                break;
        }
        return exit;
    }

    private static void sesionEntrenamiento(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            if (persona instanceof Jugador) {
                ((Jugador) persona).entrenamiento();
                System.out.println("Posicion del jugador \n" +
                        "1.- Portero \n" +
                        "2.- Defensa \n" +
                        "3.- Centro campista \n" +
                        "4.- Delantero");
                int respuesta = Teclat.llegirInt();
                ((Jugador) persona).cambiarPosicion(respuesta);
            } else if (persona instanceof Entrenador) {
                ((Entrenador) persona).entrenamiento();
                ((Entrenador) persona).incrementarDinero();
            }
        }
    }

    private static void disputarNuevaLiga(ArrayList<Equipo> equipos) {
        String nombreLiga;
        int numeroEquiposLiga;
        boolean salir = false;
        Equipo equipoSeleccionado = null;
        String nombreEquipo;
        ArrayList<Equipo> equiposLiga = new ArrayList<>();


        System.out.println("Creacion de nueva Liga: \n" +
                "Nombre de Liga:");
        nombreLiga = Teclat.llegirString();

        System.out.println("Numero de equipos que participaran en la Liga " + nombreLiga);
        numeroEquiposLiga = Teclat.llegirInt();

        do {
            if (numeroEquiposLiga <= 1) {
                System.out.println("Se necesitan 2 equipos o mas para jugar una liga");
                numeroEquiposLiga = Teclat.llegirInt();
            }
            salir = true;
        } while (!salir);

        Liga liga = new Liga(nombreLiga, numeroEquiposLiga, equiposLiga);

        salir = false;
        for (int i = 0; i < numeroEquiposLiga; i++) {
                System.out.println("Introduce el nombre del equipo " + (i + 1) + " para la liga");
            do {
                nombreEquipo = Teclat.llegirString();

                for (Equipo equipo : equipos) {
                    if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                        liga.meterEquipoLiga(equipo);
                        salir = true;
                    }
                }
                if (!salir){
                    System.out.println("Equipo no encontrado, porfavor vuelve a introducirlo");
                }
            }while(!salir);
        }
        System.out.println(liga);
        liga.jugarPartidos();
    }

    private static void consultarDatosJugador(ArrayList<Equipo> equipos) {
        String respuesta_usuario;
        boolean equipo_encontrado = false;
        String nombre_jugador;
        int dorsal_jugador;
        boolean salir = false;
        int i = 0;
        Equipo equipo_jugador = null;
        ArrayList<Jugador> jugadores_equipo;

        System.out.println("De que equipo es el jugador que quieres consultar?");
        respuesta_usuario = Teclat.llegirString();

        do {
            if (equipos.get(i).getNombreEquipo().equals(respuesta_usuario)) {
                System.out.println(equipos.get(i).mosrarAtributos());
                equipo_encontrado = true;
                equipo_jugador = equipos.get(i);
            }
            i++;

        } while (i <= equipos.size() && !equipo_encontrado);

        jugadores_equipo = equipo_jugador.getJugadores();

        System.out.println(jugadores_equipo);

        if (equipo_encontrado == false) {
            System.out.println("No se ha podido encontar un equipo con ese nombre");
        }

        if (equipo_encontrado == true) {
            System.out.println("Ingresa el nombre del jugador:");
            nombre_jugador = Teclat.llegirString();

            System.out.println("Ingresa el dorsal del jugador:");
            dorsal_jugador = Teclat.llegirInt();

            do {
                if (dorsal_jugador < 0 || dorsal_jugador > 100) {
                    System.out.println("Selecciona un numero para el dorsal del jugador entre el 0-100");
                    dorsal_jugador = Teclat.llegirInt();
                } else {

                    salir = true;
                }
            } while (!salir);

            for (Jugador jugador : jugadores_equipo) {
                if (jugador.getNombre().equalsIgnoreCase(nombre_jugador) && jugador.getDorsal() == dorsal_jugador) {
                    System.out.println("Jugador encontrado: " + jugador);
                }
            }

        }
    }

    private static void consultarDatosEquipos(ArrayList<Equipo> equipos) {
        String nombre_equipo;
        boolean equipo_encontrado = false;

        int i = 0;

        System.out.println("Introduce el nombre del equipo que quieres ver los datos");
        nombre_equipo = Teclat.llegirString();

        do {
            if (equipos.get(i).getNombreEquipo().equals(nombre_equipo)) {
                System.out.println(equipos.get(i).mosrarAtributos());
                equipo_encontrado = true;
            }
            i++;
        } while (i <= equipos.size() && !equipo_encontrado);
    }

    private static void darAltaJugadorEntrenador(ArrayList<Persona> personas) {
        int opcion;
        String nombre;
        String apellido;
        int nivelMotivacion;
        int sueldoAnual;
        boolean salir = false;
        int dorsal;
        int posicion;
        String jugPosicion;
        int torneos_ganados;
        char respuesta_entrenador;
        boolean seleccionador = false;


        System.out.println("A quien quieres dar de alta: \n" +
                "1.- Jugador \n" +
                "2.- Entrenador");
        opcion = Teclat.llegirInt();

        if (opcion == 1) {
            System.out.println("Nombre del jugador");
            nombre = Teclat.llegirString();

            System.out.println("Apellido del jugador");
            apellido = Teclat.llegirString();

            System.out.println("Fecha de nacimiento (dd/mm/yyyy)");
            String fechaString = Teclat.llegirString();
            LocalDate fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Escribe el numero del dorsal que quieras para el jugador");
            dorsal = Teclat.llegirInt();

            do {
                if (dorsal < 0 || dorsal > 100) {
                    System.out.println("Selecciona un numero para el dorsal del jugador entre el 0-100");
                    dorsal = Teclat.llegirInt();
                } else {
                    salir = true;
                }
            } while (!salir);

            System.out.println("Posicion del jugador \n" +
                    "1.- Portero \n" +
                    "2.- Defensa \n" +
                    "3.- Centro campista \n" +
                    "4.- Delantero");
            posicion = Teclat.llegirInt();

            do {
                if (posicion < 1 || posicion > 4) {
                    System.out.println("Selecciona una de las opciones");
                    posicion = Teclat.llegirInt();
                } else {
                    salir = true;
                }
            } while (!salir);

            jugPosicion = Jugador.posiciones[posicion - 1];

            nivelMotivacion = 5;

            Random random = new Random();
            int calidad = random.nextInt(71) + 30;

            System.out.println("Cuanto sueldo cobrará tu jugador anualmente? \n" +
                    "Que este entre las siguientes cifras: 90.000- 500.000");
            sueldoAnual = Teclat.llegirInt();

            do {
                if (sueldoAnual < 90.000 || sueldoAnual > 500.000) {
                    System.out.println("Introduce un numero entre los siguientes: 90.000- 500.000");
                    sueldoAnual = Teclat.llegirInt();
                } else {
                    salir = true;
                }
            } while (!salir);

            Jugador jugador = new Jugador(nombre, apellido, fecha,
                    nivelMotivacion, sueldoAnual, dorsal, jugPosicion, calidad);
            personas.add(jugador);
        }


        if (opcion == 2) {
            System.out.println("Nombre del entrenador");
            nombre = Teclat.llegirString();

            System.out.println("Apellido del entrenador");
            apellido = Teclat.llegirString();

            System.out.println("Fecha de nacimiento (dd/mm/yyyy)");
            String fechaString = Teclat.llegirString();
            LocalDate fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            nivelMotivacion = 5;

            System.out.println("Cuanto sueldo cobrará tu entrenador anualmente? \n" +
                    "Que este entre las siguientes cifras: 28.000- 300.000");
            sueldoAnual = Teclat.llegirInt();

            do {
                if (sueldoAnual < 26.000 || sueldoAnual > 300.000) {
                    System.out.println("Introduce un numero entre los siguientes: 28.000- 300.000");
                    sueldoAnual = Teclat.llegirInt();
                } else {
                    salir = true;
                }
            } while (!salir);

            System.out.println("Cuantos torneos ha ganado tu entrenador?");
            torneos_ganados = Teclat.llegirInt();

            do {
                if (torneos_ganados < 0) {
                    System.out.println("No se permiten numeros negativos");
                    torneos_ganados = Teclat.llegirInt();
                } else {
                    salir = true;
                }
            } while (!salir);

            System.out.println("Tu entrenador a sido seleccionado nacional? (y/n)");
            respuesta_entrenador = Teclat.llegirChar();

            do {
                if (respuesta_entrenador == 'y' || respuesta_entrenador == 'n') {
                    System.out.println("respuesta registrada");
                    seleccionador = true;
                } else {
                    System.out.println("Introduce una respuesta valida (y/n)");
                    respuesta_entrenador = Teclat.llegirChar();
                }
            } while (!salir);

            Entrenador entrenador = new Entrenador(nombre, apellido, fecha,
                    nivelMotivacion, sueldoAnual, torneos_ganados, seleccionador,null);
            personas.add(entrenador);
        }

    }

    private static void darAltaEquipo(ArrayList<Equipo> equipos) {
        String nombreEquipo;
        int anyoFundacion;
        String nombreCiudad;
        boolean salir = false;
        String nombreEstadio;
        String nombrePresidente;
        ArrayList<Jugador> jugadores_equipo = new ArrayList<>();

        System.out.println("Dar de alta equipo");
        System.out.println("Introduce los siguientes datos: \n" +
                "Nombre del equipo: ");
        nombreEquipo = Teclat.llegirString();

        //collection para no repetir nombre de equipos
        HashSet<String> nombreEquipos = new HashSet<>();
        for (Equipo equipo : equipos) {
            nombreEquipos.add(equipo.getNombreEquipo().toLowerCase());
        }
        if (nombreEquipos.contains(nombreEquipo)) {
            System.out.println("El equipo ya está registrado. Introduce un nombre diferente.");
            darAltaEquipo(equipos);
            return;
        }

        System.out.println("Año de fundacion del equipo:");
        anyoFundacion = Teclat.llegirInt();

        do {
            if (anyoFundacion < 1900) {
                System.out.println("Pon una fecha entre 1900 y 2024");
                anyoFundacion = Teclat.llegirInt();
            } else {
                salir = true;
            }
        } while (!salir);

        System.out.println("Nombre de la ciudad doned se fundo el equipo:");
        nombreCiudad = Teclat.llegirString();
        System.out.println("Tienes un estadio? (si/no)");
        nombreEstadio = Teclat.llegirString();

        if (nombreEstadio.equals("si")) {
            System.out.println("Introduce el nombre del estadio");
            nombreEstadio = Teclat.llegirString();
        } else {
            System.out.println("No tienes estadio");
            nombreEstadio = null;
        }

        System.out.println("Tiene tu club un presidente? (si/no)");
        nombrePresidente = Teclat.llegirString();

        if (nombrePresidente.equals("si")) {
            System.out.println("Introduce el nombre del Presidente:");
            nombrePresidente = Teclat.llegirString();
        } else {
            System.out.println("No tienes presidente");
            nombrePresidente = null;
        }

        Equipo equipo1 = new Equipo(nombreEquipo, anyoFundacion, nombreCiudad, nombreEstadio, nombrePresidente, null, jugadores_equipo);
        equipos.add(equipo1);
        System.out.println(equipo1);
    }


    private static void gestionarEquipo(ArrayList<Equipo> equipos, boolean exit, ArrayList<Persona> personas) {
        String nombre_equipo;
        boolean equipoEncontrado = false;
        int opcion_manager;
        Equipo equipo_seleccionado = null;

        System.out.println("Escribe el nombre del equipo que quieras gestionar");
        nombre_equipo = Teclat.llegirString();

        for (Equipo equipo : equipos) {
            if (equipo.getNombreEquipo().equals(nombre_equipo)) {
                equipo_seleccionado = equipo;
                equipoEncontrado = true;
                System.out.println("Equipo encontrado: " + nombre_equipo);
            }
        }

        if (!equipoEncontrado) {
            System.out.println("El equipo no esta, se te devolvera al menu");
            System.out.println();
        } else {
            do {
                opcion_manager = teamManager();
                exit = teamManagerSwitch(opcion_manager, nombre_equipo, equipos, equipo_seleccionado, personas);
            } while (!exit);
        }
    }

    private static boolean salirPrograma() {
        System.out.println("Saliendo del programa");
        return true;
    }

    private static int menu(int opcion) {
        boolean exit = false;
        System.out.println("Bienvenido al Football Manager \n" +
                "1- Gestionar equipo \n" +
                "2- Dar alta equipo \n" +
                "3- Dar alta jugador o entrenador \n" +
                "4- Consultar datos equipo \n" +
                "5- Consultar datos jugador \n" +
                "6- Disputar nueva liga \n" +
                "7- Realizar sesion de entrenamiento \n" +
                "0- Salir");
        System.out.println("Elige una opcion valida entre 0 - 7");
        opcion = Teclat.llegirInt();

        do {
            if (opcion < 0 || opcion > 7) {
                System.out.println("No has seleccionado una opcion correcta, \n" +
                        "selecciona un numero entre 0 y 7!");
                opcion = Teclat.llegirInt();
            } else {
                System.out.println("Has elegido la opcion: " + opcion);
                exit = true;
            }
        } while (!exit);
        return opcion;
    }
}