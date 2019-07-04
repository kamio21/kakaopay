package com.urlShorten;
import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class URLShortenTest {
	
    @Test
    //주소를 입력하면 값을 잘 반환하는지 
    public void executeTest() throws Exception{

    	URLShortener u = new URLShortener(8, "localhost");
    	
    	String oriUrl = "http://www.google.com";
    	String shortenUrl = u.shortenURL(oriUrl);
    	
    	assertNotNull("실행결과 null", shortenUrl);
    	
    }
    @Test
    //원래 주소와 줄인 주소가 같은지 비교
    public void equalsTest() throws Exception{

    	URLShortener u = new URLShortener(8, "localhost");
    	
    	String oriUrl = "http://www.google.com";
    	String shortenUrl = u.shortenURL(oriUrl);
    	String expandUrl = u.expandURL(shortenUrl);
    	
    	assertEquals(oriUrl, expandUrl);
    		
    }
    @Test
    //유효한 url 입력했는지 확인!
    public void validateTest() throws Exception{

    	URLShortener u = new URLShortener(8, "localhost");
   
    	assertTrue(u.validateURL("http://google.com"));
    	assertFalse(u.validateURL("http://google.kakaopay"));
	
    }
}
