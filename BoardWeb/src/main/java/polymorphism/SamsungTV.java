package polymorphism;

public class SamsungTV implements TV{
	public void initMethod() {
		System.out.println("객체 초기화 작업 관리...");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	// 생성자를 통해 스프링 컨테이너로부터 SamsungTV 객체가 언제 생성되는지 확인
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV --- 소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV --- 소리 내린다.");
	}	
}
