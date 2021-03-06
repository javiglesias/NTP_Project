/*
 PRACTICA 3 SISTEMAS DISTRIBUIDOS 08/04/16
 	JAVIER IGLESIAS SANZ 70896179J
 	ALBERTO VAQUERO PEDRUELO 71025723K

 	========== SERVIDOR =============
 */
package Server_Practica_NTP;

import java.net.URI;
//Java 1.8 tomcat 8 API 2.5
//Ruta de acceso: http://localhost:8080/Server_Practica_NTP/main/get_time
import java.util.Random;
import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

@Path("/main")
public class ServerNTP extends Thread
{
	@GET
	@Path("/get_time")
	public String get_time()
	{
		double []time = new double[2];
		Random rng = new Random();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Maquina arrancada.");
		//System.out.println("Introduzca la IP y PUERTO del servidor NTP(IP:PUERTO): ");
		//IP = sc.nextLine();
		//System.out.println("Pulse una tecla para continuar.");
		//sc.nextLine();
		time[0] = System.currentTimeMillis();//INICIALIZAMOS EL TIME
		try {
			Thread.sleep((long)(100+rng.nextDouble()*(1000-100)));//HACEMOS QUE DUERMA ENTRE 1 Y 10s
		} catch (InterruptedException e) {
			System.out.println("ERROR 1");
		}
		time[1] = System.currentTimeMillis();//TERMINAMOS LA MEDICION DE TIEMPO
		//System.out.println(time[1]-time[0]+" Ms");
		return time[0]+"-"+time[1];
	}
}
//Java 1.8 tomcat 8 API 2.5
//Ruta de acceso: http://localhost:8080/ServidorNTP/server/pedi