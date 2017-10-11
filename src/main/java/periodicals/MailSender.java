package periodicals;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import periodicals.model.config.MailProperties;
import periodicals.model.entity.Letter;

import static periodicals.model.config.MailProperties.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    @Getter
    private static final ExecutorService executor = Executors.newFixedThreadPool(MailProperties.getMailingThreads());
    private static final Logger LOGGER = Logger.getLogger(MailSender.class);
    private static final String SMTP_HOST_NAME = getSmtpHostname();
    private static final int SMTP_PORT = getSmtpPort();
    private static final String USER_NAME = getUserName();
    private static final String PASSWORD = getPassword();

    public static void send(Letter letter) {
        Mail mail = new Mail(letter.getSubject(), letter.getMessage(), letter.getRecipient());
        executor.execute(mail);
    }

    @Setter
    static class Mail implements Runnable {
        String subject;
        String message;
        String recipient;

        Mail(String subject, String message, String recipient) {
            this.subject = subject;
            this.message = message;
            this.recipient = recipient;
        }

        @Override
        public void run() {
            Email email = new SimpleEmail();
            email.setHostName(SMTP_HOST_NAME);
            email.setSmtpPort(SMTP_PORT);
            email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PASSWORD));
            email.setSSLOnConnect(true);
            email.setSubject(subject);
            try {
                email.setFrom(USER_NAME);
                email.setMsg(message);
                email.addTo(recipient);
                email.send();
            } catch (EmailException e) {
                LOGGER.error("Can't send email", e);
            }
        }
    }
}
