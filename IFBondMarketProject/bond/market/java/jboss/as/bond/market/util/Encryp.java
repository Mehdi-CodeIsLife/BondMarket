package jboss.as.bond.market.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encryp {
	
	public  String encode(String str) {
	    BASE64Encoder encoder = new BASE64Encoder();
	    str = new String(encoder.encodeBuffer(str.getBytes()));
	    return str;
	}

	public  String decode(String str) {

	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
	        str = new String(decoder.decodeBuffer(str));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }       
	    return str;
	}
	
}
