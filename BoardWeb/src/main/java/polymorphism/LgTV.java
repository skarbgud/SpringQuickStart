package polymorphism;

public class LgTV implements TV{
//	public void turnOn() {
//		System.out.println("LgTV --- 전원 켠다.");
//	}
//	public void turnOff() {
//		System.out.println("LgTV --- 전원 끈다.");
//	}
//	public void soundUp() {
//		System.out.println("LgTV --- 소리 올린다.");
//	}
//	public void soundDown() {
//		System.out.println("LgTV --- 소리 내린다.");
//	}
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
		System.out.println("LgTV --- 소리 올린다.");
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 소리 내린다.");
	}	
}
