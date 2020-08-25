package polymorphism;

public class LgTV implements TV{
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("===> LgTV(1) 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 전원 켠다.");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 전원 끈다.");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
//		System.out.println("LgTV --- 소리 올린다.");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
//		System.out.println("LgTV --- 소리 내린다.");
		speaker.volumeDown();
	}	
}
