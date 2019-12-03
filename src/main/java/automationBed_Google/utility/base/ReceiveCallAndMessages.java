package automationBed_Google.utility.base;


//Install the Java helper library from twilio.com/docs/java/install
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Hangup;
import com.twilio.type.PhoneNumber;

import automationBed_Google.utility.ReportManager.AdvanceReporting;
import automationBed_Google.utility.constants.Constants;

public class ReceiveCallAndMessages {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC60f8355ed51e17e40d0512daab196918";
	public static final String AUTH_TOKEN = "7afc58495fd6fbf598accebe887e3441";

	public static String receiveCall(String MTNumber) throws URISyntaxException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);


		//new PhoneNumber("toNumber"), new PhoneNumber("fromNumber")
		Call call = Call.creator(new PhoneNumber("+1"+MTNumber), new PhoneNumber("+16474908123"),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();


		return call.getSid();
		//	 System.out.println(sid);
		//	 if(sid.contains("CA"))
		//		 System.out.println("Call/VoiceMail Recevied");
	}

	/*
	 * public static String receiveMessage(String MTNumber) {
	 * Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	 * System.out.println("In receiveMsg"+MTNumber); Message message =
	 * Message.creator(new PhoneNumber("+1"+MTNumber), new
	 * PhoneNumber("+16474908123"), "This is a Test Message")
	 * .setStatusCallback(URI.create("http://postb.in/qo0UnEHY")) .create();
	 * 
	 * return message.getSid();
	 * 
	 * }
	 * 
	 * public static String receiveMessage(String MTNumber, String messageText ) {
	 * Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	 * System.out.println("In receiveMsg"+MTNumber); Message message =
	 * Message.creator(new PhoneNumber("+1"+MTNumber), new
	 * PhoneNumber("+16474908123"), messageText)
	 * .setStatusCallback(URI.create("http://postb.in/qo0UnEHY")) .create();
	 * 
	 * return message.getSid();
	 * 
	 * }
	 */

	public static void hangUpTwilioCall() throws URISyntaxException, Exception {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		System.out.println("In hangup call");
		Hangup hangup = new Hangup.Builder().build();
		VoiceResponse response = new VoiceResponse.Builder().hangup(hangup).build();
		try {
			System.out.println(response.toString());
		} catch (TwiMLException e) {
			e.printStackTrace();
		}

	}


	public static void receiveMissedCall(String udid, String phoneNum) throws IOException, InterruptedException {
		Process process;
		try {
			process = Runtime.getRuntime().exec(
					"curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
							+ udid + "/shell -d \" am start -a android.intent.action.CALL -d tel:\""+phoneNum);
			process.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void endCall(String MO_udid) throws IOException, InterruptedException {
		Process process;
		try {
			process = Runtime.getRuntime().exec(
					"curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
							+ MO_udid + "/shell -d \" input keyevent KEYCODE_ENDCALL\"");
			process.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void receiveMesage (String MO_udid, String MT_phoneNum) throws
	 * IOException, InterruptedException { createBatFile(MO_udid, MT_phoneNum);
	 * Process process; try { process =
	 * Runtime.getRuntime().exec("sendMessage.bat"); process.waitFor();
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * public static void createBatFile(String MO_udid, String MT_phoneNum) throws
	 * IOException {
	 * 
	 * String echo = "@echo off"; String curl1 =
	 * "curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
	 * + MO_udid +
	 * "/shell -d \"am start -a android.intent.action.SENDTO -d sms:\""+MT_phoneNum;
	 * String curl2
	 * ="curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
	 * + MO_udid + "/shell -d \"input text  'Hello This is test SMS'\""; String
	 * curl3
	 * ="curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
	 * + MO_udid + "/shell -d \"input keyevent 61\""; String curl4
	 * ="curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
	 * + MO_udid + "/shell -d \"input keyevent 66\""; String curl5
	 * ="curl -s -H \"Authorization: Bearer 9cc2bb7a5511427ca418e652cb493407\" -X POST https://api-dev.headspin.io/v0/adb/"
	 * + MO_udid + "/shell -d \"input keyevent 4\"";
	 * 
	 * String timeout = "timout 15"; String exit = "exit";
	 * 
	 * BufferedWriter writer = new BufferedWriter(new
	 * FileWriter("sendMessage.bat")); writer.write(echo + "\n"); writer.write(curl1
	 * + "\n"); writer.write(curl2 + "\n"); writer.write(curl3 + "\n");
	 * writer.write(curl3 + "\n"); writer.write(curl4 + "\n"); writer.write(curl5 +
	 * "\n"); writer.write(timeout + "\n"); writer.write(exit); writer.close(); }
	 */

	/*
	 * public static void makeCall(String phoneNumber) throws URISyntaxException,
	 * Exception {
	 * 
	 * final String ACCOUNT_SID = "AC60f8355ed51e17e40d0512daab196918"; final String
	 * AUTH_TOKEN = "7afc58495fd6fbf598accebe887e3441"; Twilio.init(ACCOUNT_SID,
	 * AUTH_TOKEN); System.out.println(phoneNumber); //new PhoneNumber("ToNumber"),
	 * new PhoneNumber("FromNumber") Call call = Call.creator(new
	 * PhoneNumber(phoneNumber), new PhoneNumber(Constants.phoneNumber), new
	 * URI("http://demo.twilio.com/docs/voice.xml")).create(); Thread.sleep(15000);
	 * String sid = call.getSid(); System.out.println(sid); if(sid.contains("CA"))
	 * System.out.println("Call is placed"); AdvanceReporting.addLogs("info",
	 * "Call is placed"); }
	 */
	
	/*
	 * public static void makeMissedCall(String phoneNumber) throws
	 * URISyntaxException, Exception {
	 * 
	 * final String ACCOUNT_SID = "AC60f8355ed51e17e40d0512daab196918"; final String
	 * AUTH_TOKEN = "7afc58495fd6fbf598accebe887e3441"; Twilio.init(ACCOUNT_SID,
	 * AUTH_TOKEN); System.out.println(phoneNumber); //new PhoneNumber("ToNumber"),
	 * new PhoneNumber("FromNumber") Call call = Call.creator(new
	 * PhoneNumber(phoneNumber), new PhoneNumber(Constants.phoneNumber), new
	 * URI("http://demo.twilio.com/docs/voice.xml")).create(); Thread.sleep(15000);
	 * String sid = call.getSid(); System.out.println(sid); if(sid.contains("CA"))
	 * System.out.println("Call is placed"); AdvanceReporting.addLogs("info",
	 * "Missed Call is placed");
	 * Call.updater(sid).setStatus(Call.UpdateStatus.COMPLETED).update(); }
	 */
	
	/* Sending four auto messages through twillo */
	/*
	 * public static void receiveThreeMessages(String data) throws Exception {
	 * Thread.sleep(3000); for(int i=0; i<=Constants.numOfMsgs; i++) {
	 * ReceiveCallAndMessages.receiveMessage(data); Thread.sleep(5000); }
	 * 
	 * AdvanceReporting.addLogs("pass", "Multiple messages sent");
	 * 
	 * }
	 */

}


