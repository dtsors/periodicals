package periodicals;

import org.mindrot.jbcrypt.BCrypt;

import java.util.UUID;

public class HashUtil {
    private HashUtil() {
    }

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPass(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public static String getRandomUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
