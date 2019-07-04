# 소개
URL 을 입력받아 짧게 줄여주고, Shortening 된 URL 을 입력하면 원래 URL 로 리다이렉트하는 URL 개발하기!

# 문제해결 
- URL을 입력받으면 62진법[0-9a-zA-Z]을 이용하여 랜덤하게 String 변수로 만들어서 8번 반복하여 8자리로 key값 생성한다.
- key-map에 랜덤발생한 key 값과 원래 주소를 저장하고 value-map에는 반대로 원래주소와 key값을 저장한다.
- URL을 입력받으면 처음에 value-map에서 이미 입력한 값이 있는지 확인하고 없으면 키값을 발생시킨다.

key-map

key	     | value             |
------------ | -------------     |
157u972lM    | http://google.com |


value-map

key          | value          |
------------ | -------------  | 
http://google.com | 157u972lM |


# 실행 방법
- 서버 구동 <br>
  kakaopay\server\apache-tomcat-7.0.73\bin\startup.bat <br>
- 페이지 실행<br>
  주소창에 http://localhost/index.jsp  <br>
  원본link에 URL을 넣고 shorten 버튼을 클릭한다. <br>
  변경link에 반환된 URL을 goWebsite 버튼을 클릭하여 화면이 잘 뜨나 확인한다.  <br>
# Project folder structure
<pre><code>
ShortenURL
    ├─src
    │  └─com
    │      └─urlShorten
    │              URLShortener.java
    │              UrlShortenMakeServlet.java
    │              UrlShortenServlet.java
    │              URLShortenTest.java
    │
    └─webapps
        │  index.jsp
        │
        └─WEB-INF
            │  web.xml
            │
            └─classes
                └─com
                    └─urlShorten
                            URLShortener.class
                            UrlShortenMakeServlet.class
                            UrlShortenServlet.class
                            URLShortenTest.class            
</pre></code>        
