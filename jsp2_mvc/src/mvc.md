## 주요 용어

1. MVC
2. 배포 기술자 => Deployment Descriptor
웹 애플리케이션의 배포 설명자는 애플리케이션의 클래스, 리소스, 구성 및 웹 서버가 이를 사용해서 웹 요청을 처리하는 방법을 기술.

https://cloud.google.com/appengine/docs/standard/java/config/webxml?hl=ko
공식 홈페이지 참조.

배포 설명자는 이름이 web.xml인 파일.
배포 설명자는 이름이 web.xml인 파일입니다. 이 파일은 앱의 WAR에서 WEB-INF/ 디렉터리에 위치하며, 루트 요소가 <web-app>인 XML 파일.

웹 어플리케이션이 web.xml 이 작성되어있지 않으면 톰캣에서 작성한 web.xml이 적용됨.

3. 이 프로젝트에서는 서블릿을 1개만 만들어서 프론트 컨트롤러(FrontController) 역할을 합니다.
프론트 컨트롤러는 url과 요청방식(Get 또는 post) 에 따라 처리할 컨트롤러 객체를 생성하여 동작.

4. web.xml
	1) 확장자 없는 url 형식이므로 정적리소스까지 프론트 컨트롤러에서 함.
	2) 정적 리소스처리 없는 jsp 파일 요청하면 404 => error-code 설정
	3) 잘못된 url은 예외 발생시킴.(Front Controller 에서 구현) => exception 설정
