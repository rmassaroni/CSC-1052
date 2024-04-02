
public class TestRadio {
	public static void main(String[] args) {
		FMRadio radio1 = new FMRadio();
		FMRadio radio2 = new FMRadio(50);
		
		System.out.println(radio1);
		radio1.turnOn();
		System.out.println(radio1);
		for(int i = 0; i < 5; i++) {
			radio1.increaseVolume();
		}
		System.out.println(radio1.getVolume());
		for(int i = 0; i < 5; i++) {
			radio1.increaseFrequency();
		}
		System.out.println(radio1.getFrequency());
		System.out.println(radio1);
		radio1.turnOff();
		System.out.println(radio1);
		
		System.out.println(radio2);
		radio2.turnOn();
		System.out.println(radio2);
		for(int i = 0; i < 5; i++) {
			radio2.increaseVolume();
		}
		System.out.println(radio2.getVolume());
		for(int i = 0; i < 5; i++) {
			radio2.increaseFrequency();
		}
		System.out.println(radio2.getFrequency());
		System.out.println(radio2);
		radio2.turnOff();
		System.out.println(radio2);
	}
}
