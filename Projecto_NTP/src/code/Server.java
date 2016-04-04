package code;
import javax.ws.rs.Path;

//SERVIDOR NO NTP
import org.eclipse.jdt.internal.compiler.parser.Scanner;
@Path("/no_ntp")
public class Server extends Thread{
	Thread th0 = new Server();
	Scanner sc = new Scanner();
	public Server()
	{
		System.out.println("<Iniciando un servidor NO-NTP>");
		th0.start();
	}
	@Path("/get_time")
	public long[] get_time()
	{
		long[] time = new long[2];
		time[0] = System.currentTimeMillis();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		time[1] = System.currentTimeMillis();
		return time;
	}
	public void run()
	{
	
	}
}
