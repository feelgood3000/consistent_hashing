package org.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.main.Main;
import org.example.hash.CacheImpl;
import org.example.hash.ICache;
import org.example.hash.Server;
import org.example.math.GetAverageandStandardDevition;

/**
 * A Camel Application
 */
public class MainApp {

	/**
	 * A main() so we can easily run these routing rules in our IDE
	 */
	public static void main(String... args) throws Exception {
		Server server1 = new Server("server1", 300);
		Server server2 = new Server("server2", 300);
		Server server3 = new Server("server3", 300);
		Server server4 = new Server("server4", 300);
		Server server5 = new Server("server5", 300);
		Server server6 = new Server("server6", 300);
		Server server7 = new Server("server7", 300);
		Server server8 = new Server("server8", 300);
		Server server9 = new Server("server9", 300);
		Server server10 = new Server("server10", 300);


		List<Server> servers = new ArrayList<>();
		servers.add(server1);
		servers.add(server2);
		servers.add(server3);
		servers.add(server4);
		servers.add(server5);
		servers.add(server6);
		servers.add(server7);
		servers.add(server8);
		servers.add(server9);
		servers.add(server10);


		ICache cache = new CacheImpl(servers);
		for (int i = 0; i < 1000000; i++) {
			cache.put("test" + i, "mofei" + i);
		}

		long[] arrays = new long[10];
		for (int i = 0; i < servers.size(); i++) {
			arrays[i] = servers.get(i).keys();
		}
		double count = GetAverageandStandardDevition.getStandardDevition(arrays);
		System.out.println("标准差为:" + count);

	}

}

