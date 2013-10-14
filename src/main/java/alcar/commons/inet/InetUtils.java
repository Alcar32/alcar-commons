package alcar.commons.inet;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;

public class InetUtils {

	private InetUtils() {
	}
	
	/**
	 * 
	 * @param hostAdresses
	 * @return
	 */
	public static Inet4Address getIP4AsNeeded(Collection<InetAddress> hostAdresses){

		Inet4Address returnAddr = null; 

		Inet4Address globalAddr = null;
		Inet4Address siteLocalAddr = null;
		Inet4Address loopBackAddr = null;

		for (InetAddress inetAddress : hostAdresses) {
			if(inetAddress instanceof Inet4Address){
				Inet4Address inet4addr = (Inet4Address) inetAddress;
				if(isGlobalIP4(inet4addr)){
					globalAddr = inet4addr;
				}else if(inet4addr.isSiteLocalAddress()){
					siteLocalAddr = inet4addr;
				}else if(inet4addr.isLoopbackAddress()){
					loopBackAddr = inet4addr;
				}
			}
		}

		if(globalAddr != null){
			returnAddr = globalAddr;
		}else if(siteLocalAddr != null){
			returnAddr = siteLocalAddr;
		}else if(loopBackAddr != null){
			returnAddr = loopBackAddr;
		}
		return returnAddr;
	}

	/**
	 * This method verify that a given {@code InetAddress} is a global,
	 * ip4-style and a unicast address.
	 * 
	 * @param inet The {@code InetAddress} that is to be verified.
	 * @return true: if the {@code InetAddress} is global, ip4 and unicast.
	 * 		false: else.
	 */
	private static boolean isGlobalIP4(InetAddress inet){
		return ( (!inet.isAnyLocalAddress())		&& 
				(!inet.isLinkLocalAddress())		&&
				(!inet.isLoopbackAddress())			&&
				(!inet.isMulticastAddress()) 		&&
				(inet instanceof Inet4Address) );
	}
}
