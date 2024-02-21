package kh.mclass.chat.client;

import java.awt.*;
import javax.swing.*;

import kh.mclass.chat.server.ServerBackground;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 8225164367035267687L;
	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
	private String nickname;

	// view - controller필드 생성
	private ClientBackground back = new ClientBackground(); // 채팅을 담당할 백그라운드(뒷 작업 영역) 선언

	public ClientGUI(String nickname) {
		this.nickname = nickname;
		// 생성자 = 초기값지정. JFrame 기본화면 구성
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 글자 폰트, 크기 변경
		jta.setBackground(new Color(230, 255, 230));
		add(jta, BorderLayout.CENTER);
		jtf.addActionListener(this); // jtf에서 enter key 치면 actionPerformed()호출되게 등록함
		add(jtf, BorderLayout.SOUTH);

		setBounds(200, 100, 400, 600);
		setTitle("클라이언트부분");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

//		The method setGui(ServerGUI) in the type ClientBackground is not applicable for the arguments (ClientGUI)
		back.setGui(this);
		back.connect(nickname);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ? synchronized
		// 문자 입력 창에 글을 입력 시 구동할 이벤트 설정
		String msg = nickname + " : " + jtf.getText() + "\n";
		System.out.print(msg);
		// jta.append(msg); // 채팅 창에 추가
		jtf.setText(""); // 입력 후 내용 초기화
		back.sendMessage(msg);
	}

	public void setJtaAppendMsg(String msg) {
		jta.append(msg); // 채팅 창에 추가

	}
}
