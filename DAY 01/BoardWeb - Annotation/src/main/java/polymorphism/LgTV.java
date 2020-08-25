package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	//@Autowired
	//@Qualifier("apple") // Qualifier 어노테이션을 사용하므로써 의존성 주입될 객체의 아이디나 이름을 지정
	
	// @Autowired는 변수의 타입을 기준으로 객체를 검색하여 의존성 주입을 처리하지만, @Resource는 객체의 이름을 이용하여 의존성 주입을 처리 
	@Resource(name="apple")	// apple 이라는 이름으로 메모리에 생성된 AppleSpeaker 객체를 speaker 변수에 할당 하는 설정이다. 같은 기능 @Inject
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
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
