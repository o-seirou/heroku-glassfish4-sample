package jp.co.flect;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class TransponderResource {
	@GET
	@Produces("text/plain")
	public String sayHello() {
		return getHost().getName();
	}

	@GET
	@Produces({"application/xml", "application/json"})
	public Host respond() {
		return getHost();
	}

	private Host getHost() {
		try {
			return new Host(InetAddress.getLocalHost().getHostName(), InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			return new Host("unknown", "0.0.0.0");
		}
	}
}
