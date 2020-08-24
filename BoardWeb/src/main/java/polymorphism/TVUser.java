package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
/*		
		SamsungTV tv = new SamsungTV();
		LgTV tv = new LgTV();
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// TV를 변경하고자 할때, TV 클래스 객체를 생성하는 소스를 수정해야한다.
		// TV를 교체할 때, 클라이언트 소스를 수정하지 않기 위해서 Factory 패턴을 적용
		// Factory 패턴은 클라이언트에서 사용할 객체 생성을 캡슐화하여 TVUser와 TV사이를 느슨한 결합 상태로 만들어 준다.
		
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
*/	
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationContext.xml]
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@7dc5e7b4
// 		첫번째로 applicationContext.xml 파일을 로딩한다는 메세지가 가장 먼저 출력
//		GenericXmlApplicationContext 객체가 생성되어 스프링 컨테이너가 구동됐다는 메세지가 출력
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV)factory.getBean("LgTV");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
//		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
		// => 싱글톤으로 설정해서 클라이언트에서 세번 요청해도 객체는 메모리에 하나만 생성되어 유지된다. <-> prototype (스프링 컨테이너가 해당 빈을 요청할 때 마다 매번 새로운 객체 생성해서 반환)
		
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
	}
}
