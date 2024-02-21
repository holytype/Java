package kh.mclass.chat.client;

import javax.swing.JOptionPane;

public class ClientRun {
	public static void main(String[] args) {
		// 사용자 GUI를 구동하기 위한 메소드
		String nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		System.out.println(nickName);
		// cancel ==> null, 아무것도 입력안하고 OK ==> ""
// NullPointerException		if(  !nickName.equals("") 	&& 	nickName != null ) {
		if (nickName == null || nickName.equals("")) {
			System.out.println("닉네임 없이는 채팅 입장이 불가합니다.");
		}

		if (nickName != null && !nickName.equals("")) {
			new ClientGUI(nickName);
		} else {
			System.out.println("닉네임 없이는 채팅 입장이 불가합니다.");
		}

	}
}
