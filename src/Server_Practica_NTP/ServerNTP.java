package Server_Practica_NTP;

import java.net.URI;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

//Java 1.8 tomcat 8 API 2.5
//Ruta de acceso: http://localhost:8080/Server_Practica_NTP/server/pedir
@Path("/server")
public class ServerNTP {
	static String ip1="",ip2="";
	//static String IP = "";
	/*@GET
	@Path("/cargar")
	public void cargar(String IP)
	{
		WebTarget target;
		Client cliente = ClientBuilder.newClient();
		URI url = UriBuilder.fromUri("http://"+IP+"/Practica_NTP/main").build();
		target = cliente.target(url);
		
	}*/
	@GET
	@Path("/pedir")
	public void pedir()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca la ip de pc1 y puerto:");
		ip1 = sc.nextLine();
		System.out.println("introduzca la ip de pc2 y puerto:");
		ip2 = sc.nextLine();
	}
}
