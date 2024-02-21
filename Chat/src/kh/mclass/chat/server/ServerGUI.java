package kh.mclass.chat.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class ServerGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 3216336723360170144L;

	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분

	// view - controller필드 생성
	private ServerBackground back = new ServerBackground(); // 채팅을 담당할 백그라운드(뒷 작업 영역) 선언

	public ServerGUI() {
		// 생성자 = 초기값지정. JFrame 기본화면 구성
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 글자 폰트, 크기 변경
		jta.setBackground(new Color(230, 255, 230));
		add(jta, BorderLayout.CENTER);
		jtf.addActionListener(this); // jtf에서 enter key 치면 actionPerformed()호출되게 등록함
		add(jtf, BorderLayout.SOUTH);

		setBounds(200, 100, 400, 600);
		setTitle("서버부분");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		back.setGui(this); // 현재 창을 back에게 전달하고 back 에서 setJtaAppendMsg 호출할수 있도록 함.
		back.setting();// GUI 실행 시 서버도 같이 동작 시킨다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 문자 입력 창에 글을 입력 시 구동할 이벤트 설정
		String msg = "운영자 : " + jtf.getText() + "\n";
		System.out.print(msg);
		jta.append(msg); // 채팅 창에 추가
		jtf.setText(""); // 입력 후 내용 초기화
		back.sendMessage(msg, "운영자");
	}

	public void setJtaAppendMsg(String msg) {
		jta.append(msg); // 채팅 창에 추가
	}

}
