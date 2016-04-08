/*
 PRACTICA 3 SISTEMAS DISTRIBUIDOS 08/04/16
 	JAVIER IGLESIAS SANZ 70896179J
 	ALBERTO VAQUERO PEDRUELO 71025723K

 	========== CLIENTE =============
 */

package code;

import java.net.URI;
import java.util.Scanner;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

//Java 1.8 tomcat 8 API 2.5
//Ruta de acceso: http://localhost:8080/Server_Practica_NTP/main/get_time

public class Cliente extends Thread 
{
	static String []ip;
	public static void main(String []args)
	{
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantas maquinas tienes?: ");
		n = sc.nextInt();
		ip= new String[n];
		
		sc = new Scanner(System.in);
		for (int i = 0; i < ip.length; i++) {
			System.out.println("IP:puerto de maquina"+i+" : ");
			ip[i]= sc.nextLine();
		}
		NTP();
	}
	public static double determinar(double t0,double t1,double t2,double t3,String method)
	{
		double offset = 0.0,delay =0.0;
		switch(method)
		{
			case "o":
				offset = ((t1-t0)+(t2-t3))/2;//offset especifico
				return offset;
			case "d":
				delay = (t1-t0)+(t2-t3);//delay especifico
				return delay;
			default:
				return -1;//algo no ha ido bien
		}
	}
	public static void NTP()
	{
		double []t = new double[4];
		String times;
		double offset, delay;
		//Algoritmo NTP
		for (int i = 0;i<ip.length; i++ ) 
		{
			WebTarget target;
			Client cliente = ClientBuilder.newClient();
			URI url = UriBuilder.fromUri("http://"+ip[i]+"/Server_Practica_NTP").build();
			target = cliente.target(url);
			//para cada maquina
			for (int j = 0; j < 8; j++) 
			{
				t[0] = System.currentTimeMillis();
				times = target.path("main").path("get_time").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
				String trunc[] = times.split("-");
				t[1] = Double.parseDouble(trunc[0]);
				t[2] = Double.parseDouble(trunc[1]);
				//System.out.println("Peticion "+j+"->"+t[1]+"$"+t[2]);
				//System.out.println("Resutlado->"+(t[2]-t[1])+"Ms");
				t[3] = System.currentTimeMillis();
				offset = determinar(t[0],t[1],t[2],t[3],"o");
				delay = determinar(t[0],t[1],t[2],t[3],"d");
				System.out.println("Offset: "+offset+"__"+"Delay: "+delay);
			}
		}
	}
}