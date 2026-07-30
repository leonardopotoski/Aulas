import java.awt.Desktop; //FERRAMENTA QUE CONVERSA COM O S.O(SISTEMA OPERACIONAL)
import java.net.URLEncoder; // FERRAMENTA QUE TRANSFORMA LINGUAGEM COMUM EM LINGUAGEM DA INTERNET
import java.net.URI; // TEXTO SIMPLES PARA TEXTO URL
import java.nio.charset.StandardCharsets; //DEIXA O APLICATIVO NA LIGUAGEM UNIVERSAL

public class Aula1Whatsapp {
	public static void main (String [] args ) {
		
		String nome = "Leo";
		String telefone = "41997026695";
		String texto = "Olá Leo, seu pedido chegou!";
		
		try {
			String textoFormatado = URLEncoder.encode(texto, StandardCharsets.UTF_8.name());
		    String linkWhatsapp = "https://wa.me/55" + telefone + "?text=" + textoFormatado;
		    
		    System.out.println("Abrindo o Whatsapp para " + nome + "...");
		    
		    Desktop.getDesktop().browse(new URI (linkWhatsapp));
		} catch(Exception e) {
			System.out.println("Erro ao abrir o link" + e.getMessage());
			
		}
	
	}

}
