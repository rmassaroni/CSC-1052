
public class FMRadio {
	final static int MINIMUM_VOLUME = 0;
	final static int MAXIMUM_VOLUME = 100;
	final static double MINIMUM_FREQUENCY = 88;
	final static double MAXIMUM_FREQUENCY = 108;
	final static double INCREMENT = 0.1;
	
	
	private boolean on;
	private int volume;
	private double frequency;
	
	public FMRadio() {
		on = false;
		setVolume(MINIMUM_VOLUME);
		setFrequency(MINIMUM_FREQUENCY);
	}
	
	public FMRadio(int volume) {
		on = false;
		setVolume(volume);
		setFrequency(MINIMUM_FREQUENCY);
	}
	
	public void turnOn() {
		on = true;
	}
	
	public void turnOff() {
		on = false;
	}
	
	public void increaseVolume() {
		if(on && volume < MAXIMUM_VOLUME) {
			volume++;
		}
	}
	
	public void decreaseVolume() {
		if(on && volume > MINIMUM_VOLUME) {
			volume--;
		}
	}
	
	public void setVolume(int volume) {
		if(volume >= MINIMUM_VOLUME && volume <= MAXIMUM_VOLUME) {
			this.volume = volume;
		}
	}
	
	public String getVolume() {
		return Integer.toString(volume);
	}
	
	public void increaseFrequency() {
		if(on && frequency < MAXIMUM_FREQUENCY - INCREMENT) {
			frequency += INCREMENT;
		}
	}
	
	public void decreaseFrequency() {
		if(on && frequency > MINIMUM_FREQUENCY + INCREMENT) {
			frequency -= INCREMENT;
		}
	}
	
	public void setFrequency(double frequency) {
		if(frequency >= MINIMUM_FREQUENCY && frequency <= MAXIMUM_FREQUENCY) {
			this.frequency = frequency;
		}
	}
	
	public String getFrequency() {
		return Double.toString(frequency);
	}
	
	public String toString() {
		return "On: " + on + ". Volume: " + getVolume() + ". Frequency: " + getFrequency();
	}
}
