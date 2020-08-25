package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV)factory.getBean("tv");
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
