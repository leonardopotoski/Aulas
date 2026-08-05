import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class APP {

	public static void main(String[] args) {
		JFrame janela = new JFrame("FREE FIRE - LOGIN");
		janela.setSize(300,240);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15 ));
		janela.setLocationRelativeTo(null);
		
		janela.getContentPane().setBackground(new Color(18, 18, 20));
		
		Font fonteInputs = new Font("Impact", Font.PLAIN, 14);
		Font fonteBotao = new Font("Impact", Font.PLAIN, 16);
		
		Color laranjaGamer = new Color(255, 102, 0);
		Color amareloLobby = new Color(255, 187, 0);
		Color fundoCampo = new Color(30, 30, 35);
		
		Cursor cursorLaranja = criarCursorSetinhaLaranja(laranjaGamer);
		janela.setCursor(cursorLaranja);
		
		JTextField email = new JTextField(18);
		email.setPreferredSize(new Dimension(240, 40));
		email.setFont(fonteInputs);
		email.setBackground(fundoCampo);
		email.setForeground(Color.WHITE);
		email.setCaretColor(laranjaGamer);
		email.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder( new Color(60, 60, 65), 2),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)
		));
		
		JPasswordField senha = new JPasswordField(18);
		senha.setPreferredSize(new Dimension(240, 40));
		senha.setFont(fonteInputs);
		senha.setBackground(fundoCampo);
		senha.setForeground(Color.WHITE);
		senha.setCaretColor(laranjaGamer);
		senha.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder( new Color(60, 60, 65), 2),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)
		));
		
		JButton btn = new JButton("ENTRAR NO JOGO");
		btn.setPreferredSize(new Dimension(240, 40));
		btn.setFont(fonteBotao);
		btn.setBackground(amareloLobby);
		btn.setForeground(Color.BLACK);
		btn.setFocusPainted(false);
		btn.setBorder(BorderFactory.createLineBorder(laranjaGamer, 2));
		
		btn.addMouseListener( new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(laranjaGamer);
				btn.setForeground(Color.WHITE);
				btn.setBorder(BorderFactory.createLineBorder(amareloLobby, 2));
			}
			
			public void mouseExited(MouseEvent e) {
				btn.setBackground(amareloLobby);
				btn.setForeground(Color.BLACK);
				btn.setBorder(BorderFactory.createLineBorder(laranjaGamer, 2));
			}
		});
		
		janela.add(email);
		janela.add(senha);
		janela.add(btn);
		
		janela.setVisible(true);

	}

	private static Cursor criarCursorSetinhaLaranja(Color corLaranja) {
		int tamanho = 25;
		BufferedImage imagemCursor = new BufferedImage(tamanho, tamanho, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = imagemCursor.createGraphics();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		Polygon setinha = new Polygon();
		setinha.addPoint(0, 0);
		setinha.addPoint(0, 18);
		setinha.addPoint(5, 13);
		setinha.addPoint(9, 20);
		setinha.addPoint(12, 18);
		setinha.addPoint(8, 12);
		setinha.addPoint(14, 12);
		
		g2d.setColor(corLaranja);
		g2d.fill(setinha);
		
		g2d.setColor(Color.BLACK);
		g2d.draw(setinha);
		
		g2d.dispose();
		
		
		
		
		return Toolkit.getDefaultToolkit().createCustomCursor(
				imagemCursor, new Point(0, 0), "CursorLaranja"
				);
	}

}
