public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Numero total de billetes vendidos
    private int billetesVendidos;
    // true tiene premio false no tiene premio
    private boolean tipoMaquina;
    // El numero de billetes que dispone la maquina para vender
    private int numeroDeBilletes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean tipo, int billetes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        tipoMaquina = tipo;
        numeroDeBilletes = billetes;
        billetesVendidos = 0;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(numeroDeBilletes > billetesVendidos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        }
        else{
            System.out.println("##################");
            System.out.println("La maquina no acepta dinero numero de billetes acabados");
            System.out.println("##################");
        }
    
    }
        /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if(numeroDeBilletes > billetesVendidos ){
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                if(tipoMaquina == true){
                    System.out.println("#Tiene un descuento del 10%");
                    System.out.println("#El coste del billete ahora sera de " + precioBillete * 0.9 + " euros");
                }
                 System.out.println("##################"); 
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos += 1;
            }
            else{
                System.out.println("##################");
                System.out.println("Falta " + cantidadDeDineroQueFalta + " euros");
                System.out.println("##################");
            }
        }
        else{
            System.out.println("##################");
            System.out.println("Error numero maximo de billetes vendidos");
            System.out.println("##################");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver; 
    } 
    public int vaciarTodaLaMaquina(){
        int dineroAVaciar;
        dineroAVaciar = balanceClienteActual + totalDineroAcumulado;
        if(balanceClienteActual > 0){
            System.out.println("Error no se puede retirar el dinero mientras haya una operacion en curso");
            dineroAVaciar = -1;
        }
        else{
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
            
        }
        return dineroAVaciar;
    }
    public int getNumeroBilletesVendidos(){
        return billetesVendidos;
    }
    public void imprimeNumeroBilletesVendidos(){
        System.out.println("Numero de billetes vendidos " + billetesVendidos);
    }
}
