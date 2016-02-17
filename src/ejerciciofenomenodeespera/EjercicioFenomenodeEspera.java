/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciofenomenodeespera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author RICARDO
 */
public class EjercicioFenomenodeEspera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 0;
        float uEx;
        float uUn;
        Double horaLlegada = 8.00;
        Double tiempoentreLl = 0.0;
        Double tiempoServ;
        Double tiempoCola;
        Double tiempoSistema;
        Double tiempoSalida;
        Double aux = null;
        DecimalFormat formato = new DecimalFormat("0.00");

        System.out.println("Ingrese número de clientes-> ");
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(entrada.readLine());

        } catch (IOException e) {
        }

        System.out.println("Cliente\tT.entre llegadas\tT. Llegada\tT. Servicio\tT. Cola\t\tT. Sistema\tSalida");

        for (int i = 0; i < n; i++) {
            uEx = (float) Math.random();
            uUn = (float) Math.random();
            tiempoentreLl = ((-1 * ((Math.log(1 - uEx)) / 0.04)));
//            System.out.println(""+tiempoentreLl);
            tiempoServ = 1.0 * (17 + ((25 - 17) * uUn));

            if (i == 0) {

                System.out.println("1\t\t" + 0 + "\t\t8,00\t\t" + formato.format(tiempoServ) + "\t\t0\t\t" + formato.format(tiempoServ) + "\t\t" + formato.format(tiempoServ));
                aux = tiempoServ;

            } else {

                if (aux > tiempoentreLl) {
                    tiempoSistema = aux - (tiempoentreLl/100) + tiempoServ;
                    aux = tiempoSistema;
                } else {

                    tiempoSistema = tiempoServ;
                }
                horaLlegada = horaLlegada + (tiempoentreLl/100);
                tiempoCola = tiempoSistema - tiempoServ;
                tiempoSalida = (tiempoentreLl/100) + tiempoSistema;
                System.out.println("" + (i + 1) + "\t\t" + formato.format(tiempoentreLl)
                        + "\t\t" + formato.format(horaLlegada) + "\t\t" + formato.format(tiempoServ) + "\t\t" + formato.format(tiempoCola) + "\t\t" + formato.format(tiempoSistema) + "\t\t" + formato.format(tiempoSalida));
            }
        }
    }

}
