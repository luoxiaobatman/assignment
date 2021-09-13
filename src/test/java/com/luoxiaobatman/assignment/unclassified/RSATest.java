package com.luoxiaobatman.assignment.unclassified;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class RSATest {
    @Test
    public void testRSA() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            String secretMessage = "secret";
            byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
            String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

            Assertions.assertEquals(secretMessage, decryptedMessage);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            Assertions.assertEquals(1, 2);
//            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            Assertions.assertEquals(1, 2);
//            e.printStackTrace();
        } catch (BadPaddingException e) {
            Assertions.assertEquals(1, 2);
//            e.printStackTrace();
        }
    }
}
