package com.example.service;

import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class UserPwHashClass {
	public String getSHA256(String inputtxt) {
		String shaString = "";
		
		try {
			// getInstance �ȿ��� algorithm�� ������ �ȴ�.
			// sha256��  sha512����� �ַ� ����Ѵ�.
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(inputtxt.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			shaString = sb.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			shaString = null;
		}
		
		return shaString;
	}
}
