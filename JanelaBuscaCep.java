import java.util.Scanner;
import java.net.URL;
import java.awt.event.*;
import javax.swing.*;

public class JanelaBuscaCep {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Consulta de CEP simples");
		janela.setSize(400,300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);
		
		JLabel rotuloCep= new JLabel("Digite o CEP: ");
		rotuloCep.setBounds(20,20,100,25);
		janela.add(rotuloCep);
		
		JTextField campoCep = new JTextField();
		campoCep.setBounds(120,20,150,25);
		janela.add(campoCep);
		
		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(120,60,150,30);
		janela.add(botaoConsultar);
		
		JTextArea areaResultado = new JTextArea();
		areaResultado.setBounds(20,110,340,130);
		areaResultado.setEditable(false);
		janela.add(areaResultado);
		
		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = campoCep.getText();

                       try {
                    	   String urlString = "https://viacep.com.br/ws/" + cep + "/json/"; //arquivos que saem ou voltam nas interações em java	
                    	   URL url = new URL  (urlString);
                    	   Scanner leitorApi = new Scanner(url.openStream());
                    	   
                    	   StringBuilder resultado = new StringBuilder();
                    	   while(leitorApi.hasNextLine()) {
                    		   resultado.append(leitorApi.nextLine ()).append("\n");
                    	   } leitorApi.close();
                    	   
                    	   areaResultado.setText(resultado.toString());
                       } catch (Exception ex) {
                    	   areaResultado.setText("Erro ao consultar");
                       }
                           

		}
		});
		janela.setVisible(true);

	}

}
