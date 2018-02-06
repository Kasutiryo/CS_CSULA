package Homework_10;

public class myClass {
	private boolean On;
	private int channel;
	private int volume;
	
	
	
	
	public myClass() {
		
	}
	
	private void turnOn() {
		this.On = true;
		this.channel = 3;
		this.volume = 10;
	}

	public void turnON() {
		
		turnOn();
		
	}
	private int changeChannel(int channel) {
		
		if(On && this.channel != channel) {
			this.channel = channel;
		}
		
		return this.channel;
	}
	
	public void changeCH(int CH) {
		changeChannel(CH);
	}
	
	private int changeVolume(int volume) {
		
		if(On) {
			this.volume = volume;
		}
		
		return this.volume;
	}
	
	public void changeVOL(int VOL) {
		changeVolume(VOL);
	}
	
	public int getChannel() {
		
		return channel;
	}

	public int getVolume() {
		
		return volume;
	}
}
