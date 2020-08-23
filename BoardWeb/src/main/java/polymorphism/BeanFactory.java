package polymorphism;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("Samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")){
			return new LgTV();
		}
		return null;
	}
	
	// BeanFactory 클래스의 getBean() 메소드는 매개변수로 받은 beanName에 해당하는 객체를 리턴한다.
}
