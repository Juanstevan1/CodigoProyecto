import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Methods {
    Scanner scan = new Scanner(System.in);
    ArrayList<App> apps = new ArrayList<App>();
    ArrayList<Machine> machines = new ArrayList<Machine>();

    public void startOn(){
        System.out.println("--------------------------");
        System.out.println("Bienvenido a GREENIMPACT");
        System.out.println("--------------------------");
        boolean control = true;
        while(true){
             System.out.println("1. Registrarse");
             System.out.println("2. Inicia sesión");
             System.out.println("3. depositar reciclaje");
             System.out.println("4. Finzalizar programa");
             int option = scan.nextInt();
             switch (option){
                 case 1:
                     this.register();
                     break;
                 case 2:
                     this.logIn();
                     break;
                 case 3:
                     this.joinMachine();
                     break;
                 case 4:
                     control = false;
                     break;

             }
             if(!control){break;}
         }
    } // metodo principal

    public void register(){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        System.out.println("------------------");
        System.out.println("Registra tu cuenta");
        System.out.println("------------------");
        System.out.println("");
        System.out.println("Nombre");
        String name = scan.next();
        scan.nextLine();
        System.out.println("");
        String email;
        while(true){
            System.out.println("Correo");
            email = scan.next();
            Matcher mather = pattern.matcher(email);
            if (mather.find() == true) {
                System.out.println("El email ingresado es válido.");
                break;
            } else {
                System.out.println("El email ingresado es inválido, intentalo otra vez");
            }
        }
        System.out.println("");
        System.out.println("Contraseña");
        String password = scan.next();
        System.out.println("");
        System.out.println("Nombre Usuario");
        String nameUs = scan.next();
        System.out.println("");
        System.out.println("Numero celular");
        long number = scan.nextLong();
        String qr = this.codigoQr();
        int point = 0;
        System.out.println("Codigo qr: " + qr);
        App user = new App (qr,point, name, password, email,number, nameUs );
        apps.add(user);
    } // Metodo 1

    public void logIn(){
        System.out.println("--------------");
        System.out.println("Inicia seccion");
        System.out.println("--------------");
        boolean control = false;
        int indice = 0;
        while(true){
            System.out.println("");
            System.out.println("Usuario");
            String user = scan.next();
            System.out.println("");
            System.out.println("Contraseña");
            String password = scan.next();
            for(int i = 0; i< apps.size(); i++){
                if(Objects.equals(user, apps.get(i).getUserName()) && Objects.equals(password, apps.get(i).getPassword())){
                    indice = i;
                    control = true;

                    break;
                }
                else{
                    control = false;
                }
            }
            if(control == true){
                break;
            }
            else{
                System.out.println("El usuario o la contraseñan es incorrecta");
            }
        }
        System.out.println("Perfil de" + apps.get(indice).getUserName());
        System.out.println("");
        System.out.println("------");
        System.out.println("Nombre");
        System.out.println(apps.get(indice).getName());
        System.out.println("------");
        System.out.println("");
        System.out.println("------------------");
        System.out.println("Correo electronico");
        System.out.println(apps.get(indice).getMail());
        System.out.println("------------------");
        System.out.println("");
        System.out.println("---------");
        System.out.println("Codigo qr");
        System.out.println(apps.get(indice).getCode());
        System.out.println("---------");
        System.out.println("");
        System.out.println("------");
        System.out.println("numero");
        System.out.println(apps.get(indice).getNumber());
        System.out.println("------");
        System.out.println("");
        System.out.println("------");
        System.out.println("Puntos");
        System.out.println(apps.get(indice).getTpoints());
        System.out.println("------");
        System.out.println("");
        System.out.println("--------------");
        System.out.println("Menu");
        System.out.println("--------------");
        System.out.println("");
        while(true){
            System.out.println("1. Ingresar tienda");
            System.out.println("2. ingresar foro");
            System.out.println("3. salir ");
            int answer = scan.nextInt();
            boolean control2 = true;
            switch (answer){
                case 1:
                    this.shopp(indice);
                    break;
                case 2:
                    this.forum(indice);
                    break;
                case 3:
                    control2 = false;
                default:
                    System.out.println("Ingresa una opcion correspondiente");
                    break;
            }
            if(control2 == false){break;}
        }

    } // metodo 2

    public void joinMachine(){
        System.out.println("Maquina para depositar el reciclaje");
        System.out.println("");
        boolean control = false;
        int indice = 0;
        System.out.println("Ingresa tu qr");
        while(true){
            String code = scan.next();
            for(int i = 0; i < apps.size(); i++){
                if(Objects.equals(code, apps.get(i).getCode())){
                    indice = i;
                  control = true;
                  break;
                }

            }
            if(control == false){
                System.out.println("No se ha encontrado cuenta, ingresa otro qr");
            }
            else{
                break;
            }
        }
        System.out.println("");
        while(true){
            boolean cont = false;
            System.out.println("1 - Ingresar botellas (2 puntos)\r\n"
                    + "2 - Ingresar pilas (1 punto)\r\n"
                    + "3 - Ingresar vidrio, (1kg de vidrio = 2 punto)\r\n"
                    + "4 - Terminar proceso.\r\n");
            int choose = scan.nextInt();

            switch (choose){
                case 1:
                    System.out.println("¿Cuántas botellas quiere ingresar?");
                    int cantBottles = scan.nextInt();
                    int point = cantBottles*2;
                    int actuallP = apps.get(indice).getTpoints();
                    int total = point + actuallP;
                    apps.get(indice).setTpoints(total);
                   // System.out.println(apps.get(indice).getTpoints());
                   // System.out.println(indice);
                    break;

                case 2:
                    System.out.println("¿Cuántas pilas quiere ingresar?");
                    int cantPilas = scan.nextInt();
                    int start2 = apps.get(indice).getTpoints();
                    apps.get(indice).setTpoints(cantPilas+start2);
                    break;

                case 3:
                    System.out.println("¿Cuantos kg de vidrio quiere ingresar?");
                    int cantVidrio = scan.nextInt();
                    int point3 = (cantVidrio*2);
                    int start3 = apps.get(indice).getTpoints();
                    apps.get(indice).setTpoints(point3+start3);
                    break;

                case 4:
                    cont = true;
                    break;

                default:
                    System.out.println("Ingresa una oporeacion coorecta");
                    break;

            }
            if (cont == true){
                break;
            }

        }

    } // metodo 3

    public void shopp(int a){
        System.out.println("----------------------");
        System.out.println("Bienvenido a la tienda");
        System.out.println("----------------------");

        if(apps.get(a).getTpoints() < 30){
            System.out.println("No tienes puntos suficientes para comenzar a canjear ");
            System.out.println("¡Consigue más!");
        }
        else{
            System.out.println("----------------------");
            System.out.println("Productos para canjear");
            System.out.println("Puntos actuales: "+ apps.get(a).getTpoints());
            System.out.println("----------------------");
            System.out.println("");
            boolean control = true;
            while(true){
                System.out.println("""
                    1. Cupon 20% de descuento en Arturo Calle (60 puntos)
                    2. 1 boleta para CineColombia (100 puntos)
                    3. 1 pollo entero en KFC (250 puntos)
                    4. Donar a la caridad (libre)
                    5. Cerrar tienda""");
                System.out.println("Puntos actuales: "+ apps.get(a).getTpoints());
                int answer = scan.nextInt();
                switch (answer){
                    case 1:
                        if (apps.get(a).getTpoints() >= 60){
                            System.out.println("Recibes un cupon 20% de descuento en Arturo Calle ");
                            apps.get(a).setTpoints((apps.get(a).getTpoints()-60));
                        }
                        else{
                            System.out.println("No tienes puntos suficientes para redimir el cupon");
                        }
                        break;
                    case 2:
                        if (apps.get(a).getTpoints() >= 100){
                            System.out.println("Recibes una boleta para CineColombia ");
                            apps.get(a).setTpoints((apps.get(a).getTpoints()-100));
                        }
                        else{
                            System.out.println("No tienes puntos suficientes para redimir el cupon");
                        }
                        break;
                    case 3:
                        if (apps.get(a).getTpoints() >= 250){
                            System.out.println(" Recibes un pollo entero en KFC");
                            apps.get(a).setTpoints((apps.get(a).getTpoints()-250));
                        }
                        else{
                            System.out.println("No tienes puntos suficientes para comprar el pollo");
                        }
                        break;
                    case 4:
                        System.out.println("¿Cuántos puntos quieres donar?");
                        int pointD = scan.nextInt();
                        if(apps.get(a).getTpoints() < 31){
                            System.out.println("Debes que tener más de 30 puntos para donar");
                        }
                        else{
                            System.out.println("Has donado: " + pointD + " puntos.");
                            apps.get(a).setTpoints((apps.get(a).getTpoints()-pointD));
                        }
                        break;
                    case 5:
                        control = false;
                        break;

                    default:
                        System.out.println("Pronto agregaremos más opciones, selecciona una opcion valida");
                        break;
                }
                if(!control){
                    break;
                }

            }
        }
    } //Metodo tienda

    public void forum(int a){
        System.out.println("------------------");
        System.out.println("Bienvenido al Foro");
        System.out.println("------------------");
        System.out.println("");
        while (true){
            System.out.println("""
                    1. Hacer una publicacion
                    2. Salir del foro""");
            boolean control = true;
            int answer = scan.nextInt();
            switch (answer){
                case 1:
                    System.out.println("");
                    System.out.println("Ingresa el titulo de tu publicacion");
                    String tit = scan.nextLine();
                    scan.next(); 
                    System.out.println("");
                    System.out.println("Ingresa el cometido de tu publicacion");
                    String cometido = scan.next();
                    scan.nextLine(); 
                    System.out.println("");
                    System.out.println("¿Publicar? 1. Sí - 2. No");
                    int respu = scan.nextInt();
                    if(respu == 1){
                        System.out.println(tit);
                        System.out.println(cometido);
                    }
                    break;

                case 2:
                    control = false;
                    break;
            }
            if(!control){break;}

        }
    } // Metodo foro

    public String codigoQr() {
        int i = 15;
        String theAlphaNumericS;
        StringBuilder builder;

        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        //create the StringBuffer
        builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {

            // generate numeric
            int myindex
                    = (int)(theAlphaNumericS.length()
                    * Math.random());

            // add the characters
            builder.append(theAlphaNumericS
                    .charAt(myindex));
        }
        return builder.toString();
    } // Metodo qr

}
