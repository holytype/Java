package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image introBackground;

	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
	}

	//Jframe 상속받았을 때 가장 첫번째로 화면을 그려주는 메소드.

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 	//프로그램 화면 크기만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // 생성한 이미지에 소스를 그려냄.
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);// 생성한 소스를 넣어서 그림.
		this.repaint(); // 다시 페인트 함수 재귀. 즉 매 순간마다 프로그램이 정지 되는 순간까지 반복.
	}
}
