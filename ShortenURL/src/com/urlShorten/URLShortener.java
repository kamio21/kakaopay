package com.urlShorten;
import java.util.HashMap;
import java.util.Random;
import java.net.URL;
import java.net.URLConnection;


/*
 * URL Shortener
 */
public class URLShortener {
	
	private HashMap<String, String> keyMap; // key-url map
	private HashMap<String, String> valueMap;// url-key 
												
	
	private String domain; // 기본 도메인 값
	private char myChars[]; //1~9 , A~Z , a~z 숫자로 변환해서 담아 넣을 배열
	
	private Random myRand; // 랜덤값 발생 시킬 변수
	private int keyLength; // 8자리
	
	private static URLShortener instance = new URLShortener(8, "localhost");
	
	public static URLShortener getInstance() {
		return instance;
	}
	
	// 1~9 , A~Z , a~z 숫자로 변환해서 담는다
	private URLShortener() {
		keyMap = new HashMap<String, String>();
		valueMap = new HashMap<String, String>();
		myRand = new Random();
		keyLength = 8;
		myChars = new char[62];
		for (int i = 0; i < 62; i++) {
			int j = 0;
			if (i < 10) {
				j = i + 48;
			} else if (i > 9 && i <= 35) {
				j = i + 55;
			} else {
				j = i + 61;
			}
			myChars[i] = (char) j;
		}
		setDomain("localhost");
	}

	public URLShortener(int length, String newDomain) {
		this();
		this.keyLength = length;
		if (!newDomain.isEmpty()) {
			setDomain(newDomain);
		}
	}

	// shortenURL
	// 변환된 주소가 있으면 valueMap에서 반환
	// 변환된 주소가 없으면 key 생성
	public String shortenURL(String longURL) {
		String shortURL = "";
		boolean validationConfirm;
	
			validationConfirm = validateURL(longURL);
			if(validationConfirm) 
			{
				longURL = sanitizeURL(longURL);
				System.out.println(longURL);
				if (valueMap.containsKey(longURL)) {
					shortURL = getDomain() + "/" + valueMap.get(longURL);
				} else {
					shortURL = getDomain() + "/" + getKey(longURL);
				}
				return shortURL;
			}
			else{
				
				return "잘못된주소 입니다.";
			}
	}

	// expandURL
	public String expandURL(String shortURL) {
		String longURL = "";
		String key = shortURL.substring(getDomain().length() + 1);
		longURL = keyMap.get(key);
		return longURL;
	}
	
	//url 검증
    public boolean validateURL(String url) {
        try {
            URL connectionUrl = new URL(url);
            URLConnection conn = connectionUrl.openConnection();
            conn.connect();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	String sanitizeURL(String url) {
		//http 나 https 로 입력하지 않는 url 앞에 http를 앞에 붙여준다.
		if (!url.substring(0, 7).equals("http://") && !url.substring(0, 8).equals("https://")) {
			url = "http://" + url;
		}
		//ex) http://google.com/ 으로 끝난 주소를 http://google.com으로 변환 
		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		
		return url;
	}

	//key를생성해서 keyMap과 valueMap에 각각 넣어준다.
	public String getKey(String longURL) {
		String key;
		key = generateKey();
		keyMap.put(key, longURL);
		valueMap.put(longURL, key);
		return key;
	}

	// key값 생성 (랜덤변수 이용해서 8자리로 생성)
	private String generateKey() {
		String key = "";
		boolean flag = true;
		while (flag) {	
			key = "";
			for (int i = 0; i <= keyLength; i++) {
			
				key += myChars[myRand.nextInt(62)];
			}
			//key값 중복 되는지 확인
			if (!keyMap.containsKey(key)) {
				flag = false;
			}
		}
		return key;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}