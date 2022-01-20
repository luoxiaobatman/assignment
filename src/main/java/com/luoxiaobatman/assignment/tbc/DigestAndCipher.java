package com.luoxiaobatman.assignment.tbc;


import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class DigestAndCipher {
    public static class MyAES implements Solution {

        @Override
        public Answer solve() {
            try {
                Cipher cipher = Cipher.getInstance("AES");
//                cipher.init(Cipher.ENCRYPT_MODE, );
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static class MyRSA implements Solution {

        @Override
        public Answer solve() {
            return null;
        }
    }

}
