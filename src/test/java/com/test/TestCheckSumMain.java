package com.test;

import java.security.NoSuchAlgorithmException;

import com.bigdata.test.CheckSumBuilder;

public class TestCheckSumMain {
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		String check = CheckSumBuilder.getCheckSum("123456", "111111", "777777");
		System.out.println(check);
		java.security.MessageDigest algb=java.security.MessageDigest.getInstance("sha1");
	    algb.update("123456111111777777".getBytes());
	    String check2 = getFormattedText(algb.digest());
	    System.out.println(check2);
	    
	    if(algb.isEqual(check.getBytes(), check2.getBytes() )){
	    	System.out.println("相等");
	    }else{
	    	System.out.println("不相等");
	    }
	}
	
	private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
	
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
}
