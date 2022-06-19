package ch3;

public class Stu02 {
	boolean isPowerOn;		// 전원
	int channel;			// 채널
	int volume;				// 볼륨
	
	// 상수
	final int MAX_VOLUME = 100;		// 최대 볼륨 		
	final int MIN_VOLUME = 0;		// 최소 볼륨
	final int MAX_CHANNEL = 100;	// 마지막 채널
	final int MIN_CHANNEL = 1;		// 처음 채널

	
	void turnOnOff() {
		// (1) isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
		if(this.isPowerOn) {		// true라면 false로
			this.isPowerOn = false;
		}else {
			this.isPowerOn = true;
		}
		
	// 다른 답안 : isPowerOn = !isPowerOn;
		
	}
	void volumeDown() {
		// (3) volume의 값이 max_volume보다 작을 때만 값을 1 증가시킨다.
		if(volume < MAX_VOLUME) {
			volume++;
		}
	}
	
	void channelUp() {
		// (4) channel의 값을 1증가시킨다.
		// 만일 channel이 max_channel이면, channel의 값을 min_channel로 바꾼다.
		if(channel == MAX_CHANNEL) {	// 만약 마지막 채널이라면
			channel = MIN_CHANNEL;		// 처음 채널로
		}else {
			channel++;		// 만약 마지막 채널이 아니라면 channel을 ++해라
		}
		
	}
	void channelDown() {
		// (4) channel의 값을 1 감소시킨다.
		// 만일 channel이 min_channel이면, channel의 값을 max_channel로 바꾼다.
		if(channel == MIN_CHANNEL) {	// 만약 처음 채널이라면
			channel = MAX_CHANNEL;		// 마지막 채널로
		}else {
			channel--;		// 만약 마지막 채널이 아니라면 channel을 --해라
		}

	}
	
	public static void main(String[] args) {
		/*
		 * [6-21] tv클래스를 주어진 로직대로 완성하시오. 완성한 후에 실행해서 주어진 실행결과와 일치하는지 확인하라
		 * [참고] 코드를 단순히 하기 위해서 유효성 검사는 로직에서 제외했음
		 */
		
		 
		
	}

}
