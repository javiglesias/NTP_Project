package code;
import java.util.Random;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//SERVIDOR NO NTP
@Path("/nontp")
public class Server extends Thread{
	@GET
	@Path("/getit")
	@Produces(MediaType.TEXT_PLAIN)
	public String get_time()
	{
		return "carcaj";
	}
}
