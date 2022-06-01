package co.empresa.test.util;


import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.empresa.test.modelo.Mensaje;

public class EmailConexion {
	
public static Boolean enviarCorreo(Mensaje m) {
        
        try{

            // Propiedades de la conexión
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");// puerto de salida, de
            // entrada 110
            p.setProperty("mail.smtp.user", "brayanperutty1@gmail.com");
            p.setProperty("mail.smtp.auth", "true");
            //props.put("mail.transport.protocol.", "smtp");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(p);
            // Construimos el mensaje

      
            
            String mensaje = m.getMensaje();
            String asunto = m.getAsunto();
            String destinatario = m.getEmail();
            
            // se compone el mensaje (Asunto, cuerpo del mensaje y direccion origen)
            
            MimeMessage message = new MimeMessage(session);
            	
            message.setFrom(new InternetAddress("brayanperutty1@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);

            // Lo enviamos.
            Transport t  = session.getTransport("smtp");
            
            t.connect("brayanperutty1@gmail.com", "5120Perutty_!");

            try{
                t.sendMessage(message, message.getAllRecipients());
                
            }catch(MessagingException e){
                
                System.out.println(e.toString());
                System.out.println("Error ");
                return(false);
                
            }
            
            // Cierre de la conexion
            t.close();
            return(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return(false);
            
        }
        
    }

}
