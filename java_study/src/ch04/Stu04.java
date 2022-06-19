package ch04;


class MyTv2{
	/*
	 * [7-10] My Tv2클래스의 멤버 변수 isPowerON, channel, volume을 클래스 외부에서 접근할 수 없도록 
	 * 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter와 setter 메서드를 추가하라
	 * 
	 */
	
	private boolean isPowerOn;
	private int channel;
	private int volume; 
	private int prevChannel;	// 이전 채널 값 저장변수
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	//(1)
	public boolean getIsPowerOn() {
		return this.isPowerOn;
	}
	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	
	public int getChannel() {
		return this.channel;
	}
	public void setChannel(int channel) {
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
			return;
		}
		this.prevChannel = this.channel;	// 현재 채널 저장
		this.channel = channel;
	}
	
	public int getVolume() {
		return this.volume;
	}
	public void setVolume(int volume) {
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) {
			return;
		}
		this.volume= volume;
	}
	
	/*
	 * [7-11] 문제 7-10에서 작성한 MyTv2 클래스에 이전 채널(previous channel)로 이동하는
	 * 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.
	 * 힌트) 이전 채널의 값을 저장할 멤버변수를 정의하라
	 * 
	 * 메서드명 : gotoPrevChannel
	 * 기능 : 현재 채널을 이전 채널로 변경한다.
	 * 반환타입, 매개변수 : 없음
	 */
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
	}
	
	/*
	 * [7-14] Stu01으로 가면 있음
	 * [7-15],[7-16] 아이패드에 정리
	 */
	
}


public class Stu04 {
	public static void main(String[] args) {
		
		
		
	}

}
