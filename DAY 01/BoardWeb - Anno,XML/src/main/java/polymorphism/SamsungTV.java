package polymorphism;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 관리...");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	// 생성자를 통해 스프링 컨테이너로부터 SamsungTV 객체가 언제 생성되는지 확인
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	/*  
		스프링 컨테이너는 XML 설정 파일에 등록된 클래스를 찾아서 객체 생성할 때 기본적으로 매개변수가 없는 기본 생성자를 호출한다.
		하지만 컨테이너가 기본 생성자 말고 매개변수를 가지는 다른 생성자를 호출하도록 설정할 수 있는데, 이 기능을 이용하여 생성자 인젝션을 처리한다.
		생성자 인젝션을 사용하면 생성자의 매개변수로 의존관계에 있는 객체의 주소 정보를 전달할 수 있다.
	*/
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 켠다. (가격 : "+price+")");
	}
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	public void volumeUp() {
//		speaker = new SonySpeaker();
//		System.out.println("SamsungTV --- 소리 올린다.");
		speaker.volumeUp();
	}
	public void volumeDown() {
//		speaker = new SonySpeaker();
//		System.out.println("SamsungTV --- 소리 내린다.");
		speaker.volumeDown();
	}	
}
