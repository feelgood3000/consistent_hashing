package org.example.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

	public static long hash(String nodeName, int number) {
		byte[] digest = md5(nodeName);
		long hash = (((long) (digest[3 + number * 4] & 0xFF) << 24)
				| ((long) (digest[2 + number * 4] & 0xFF) << 16)
				| ((long) (digest[1 + number * 4] & 0xFF) << 8)
				| (digest[number * 4] & 0xFF))
				& 0xFFFFFFFFL;
		return hash;
	}

	public static byte[] md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(str.getBytes("UTF-8"));
			return md.digest();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
