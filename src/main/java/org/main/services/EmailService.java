package org.main.services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

public class EmailService {
        public void enviarCorreoConAdjunto(String destinatario, File adjunto) throws Exception {

            String remitente = "listaautoordenada@gmail.com";
            String password = "otzx jcjq sywm qicw"; // no la normal

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remitente, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            message.setSubject("Lista de la compra");

            // Cuerpo del mensaje
            MimeBodyPart texto = new MimeBodyPart();
            texto.setText("Adjunto tienes la lista de la compra ordenada.");

            // Adjunto
            MimeBodyPart adjuntoPart = new MimeBodyPart();
            adjuntoPart.attachFile(adjunto);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(texto);
            multipart.addBodyPart(adjuntoPart);

            message.setContent(multipart);

            Transport.send(message);
        }

}
