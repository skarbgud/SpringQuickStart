package polymorphism;

public class TVUser {
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// TV를 변경하고자 할때, TV 클래스 객체를 생성하는 소스를 수정해야한다.
		// TV를 교체할 때, 클라이언트 소스를 수정하지 않기 위해서 Factory 패턴을 적용
		// Factory 패턴은 클라이언트에서 사용할 객체 생성을 캡슐화하여 TVUser와 TV사이를 느슨한 결합 상태로 만들어 준다.
		
//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.turnOff();
//		tv.soundUp();
//		tv.soundDown();
	}
}
