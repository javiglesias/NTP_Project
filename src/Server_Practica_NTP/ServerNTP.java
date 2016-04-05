package Server_Practica_NTP;

import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//Java 1.8 tomcat 8 API 2.5
//Ruta de acceso: http://localhost:8080/Server_Practica_NTP/server/mostrar
@Path("/server")
public class ServerNTP {
	@GET
	@Path("/mostrar")
	public String mostrar()
	{
		/*
		 * Client cliente = ClientBuilder.newClient();
		URI url1 = UriBuilder.fromUri("http://"+ip1+"/no_ntp");
		URI url2 = UriBuilder.fromUri("http://"+ip2+"/no_ntp");
		 * */
		return("mostra");
	}
	@GET
	@Path("/pedir")
	public void pedir()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca la ip de pc1 y puerto:");
		String ip1 = sc.nextLine();
		System.out.println("introduzca la ip de pc2 y puerto:");
		String ip2 = sc.nextLine();
	}
}
