package dinomanager;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailSenderService {
	
	private Properties properties; //Clase en donde pondremos toda la configuración del sistema de emails.
	
 
	private Session session;
	
	EmailSenderService (String path) throws IOException {
		this.properties=new Properties();
		loadConfig(path);
	}
	
	private void loadConfig (String path) throws IOException {
		InputStream is = new FileInputStream(path);
		this.properties.load(is);
	}
	
	private void checkConfig() {
		
		String[] keys = {
				"mail.smtp.host",
				"mail.smtp.port",
				"mail.smtp.user",
				"mail.smtp.password",
				"mail.smtp.starttls.enable",
				"mail.smtp.auth",
		};
		
		for (int i=0; i< keys.length; i++) {
			if(this.properties.get(keys[i])==null) {
				throw new InvalidParameterException("No existe la clave "+ keys[i]); //Para comprobar si las properties son correctas
			}
		}
		
		
	}
	
	public void sendEmail(String subject, String message, String email) throws MessagingException {
		
		MimeMessage container = new MimeMessage(session);
		container.setFrom(new InternetAddress((String) this.properties.get("mail.smtp.user")));
		container.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		container.setSubject(subject);
		container.setText(message);
		Transport t = session.getTransport("smtp");
		t.connect((String) this.properties.get("mail.smtp.user"), (String) this.properties.get("mail.smtp.password"));
		t.sendMessage(container, container.getAllRecipients());
		
	}
 
	
}
 
