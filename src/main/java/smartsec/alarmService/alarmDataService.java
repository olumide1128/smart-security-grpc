package smartsec.alarmService;

public class alarmDataService {
	
	public alarmDataService() {}
	
	public static String activateAlarmSound() {
		
        String audioFilePath = "sound/siren.wav";
        soundAlarm player = new soundAlarm();
        player.play(audioFilePath);
		
		return "Alarm Sounded!!";
	}
}
