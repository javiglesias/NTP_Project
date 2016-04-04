package code;
import java.util.Random;
import java.util.Scanner;

import javax.ws.rs.Path;

//SERVIDOR NO NTP
@Path("/no_ntp")
public class Server extends Thread{
	Thread th0 = new Server();
	Scanner sc;
	public Server()
	{
		sc = new Scanner(System.in);
		System.out.println("<Iniciando un servidor NO-NTP>");
		System.out.println("Nombre de la maquina?: ");
		th0.setName(sc.nextLine());
		th0.start();
	}
	@Path("/get_time")
	public void run()
	{
		long[] time = new long[2];
		Random rng = new Random();
		System.out.println(this.getName()+" arrancada.");
		System.out.println("Pulse una tecla para continuar.");
		sc.nextLine();
		time[0] = System.currentTimeMillis();//INICIALIZAMOS EL TIME
		try {
			Thread.sleep(rng.nextInt(10000-1000)+1);//HACEMOS QUE DUERMA ENTRE 1 Y 10s
		} catch (InterruptedException e) {
			System.out.println("ERROR 1");
		}
		time[1] = System.currentTimeMillis();//TERMINAMOS LA MEDICION DE TIEMPO
		//LLAMAMOS AL SERVIDOR NTP PASANDOLE LOS TIEMPOS COMO PARAMETRO
	}
}
