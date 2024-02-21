package kh.mclass.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	private final String IP = "127.0.0.1";
	private final int PORT = 8888;
	private Socket socket; // 받아올 소켓 저장
	private DataInputStream in;
	private DataOutputStream out;
	private String nickname;
	private ClientGUI gui;

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	// 클라이언트가 서버에 접속 기능 메소드
	public void connect(String nickname) {
		this.nickname = nickname;
		try {
			socket = new Socket(IP, PORT); // 서버에 연결성공
			gui.setJtaAppendMsg("서버 접속되었습니다.");
			// 서버와 주고 받을 입,출력 통로 생성
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			// 접속 후 서버에서 닉네임을 인식
			out.writeUTF(nickname); // 접속되자 마자 닉네임 전송함 // flush 없음.

			// 수신 메시지 있는지.. 계속 반복문으로 확인함.
			while (in != null) {
				String msg = in.readUTF();
				gui.setJtaAppendMsg(msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
			gui.setJtaAppendMsg("서버를 찾을 수 없습니다. IP와 Port번호를 확인 후 재시도 해주세요.");
		} catch (Exception e) {
			gui.setJtaAppendMsg("예기치 못한 오류가 발생했습니다. 프로그램 종ㄽ....");
		}
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
