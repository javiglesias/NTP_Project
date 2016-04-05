//SERVIDOR NTP

public class Server_NTP extends Thread
{
	static String ip1,ip2;
	static WebTarget target;

	Scanner sc = new Scanner(System.in);
	
	public Server_NTP()
	{
		Thread th0 = new Server_NTP();
		th0.setName("Server_NTP");
		System.out.println("introduzca la ip de pc1 y puerto:");
		ip1 = sc.nextLine();
		System.out.println("introduzca la ip de pc2 y puerto:");
		ip2 = sc.nextLine();	

	}
	public void run()
	{
		Client cliente = ClientBuilder.newClient();
		URI url1 = UriBuilder.fromUri("http://"+ip1+"/no_ntp");
		URI url2 = UriBuilder.fromUri("http://"+ip2+"/no_ntp");
	}
	
}