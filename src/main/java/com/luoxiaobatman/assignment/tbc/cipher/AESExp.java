package com.luoxiaobatman.assignment.tbc.cipher;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * 变种
 *
 */
@AllArgsConstructor
public class AESExp extends AbstractSolution<String> implements GenericSolution<String> {
    @Override
    public String doSolve() {
        try {
            SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] bytes = cipher.doFinal("foobarbaz".getBytes());
            String encoded = new String(Base64.getEncoder().encode(bytes));
            return encoded;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class Spec {
        private String variant;
        private String keyGen;
    }


    private SecretKey fromPassword(String password, String salt) {
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacShar256")
                .generateSecret(pbeKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
