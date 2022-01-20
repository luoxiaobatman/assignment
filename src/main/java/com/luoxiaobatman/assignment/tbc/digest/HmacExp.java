package com.luoxiaobatman.assignment.tbc.digest;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacExp extends AbstractSolution<String> implements GenericSolution<String> {
    @Override
    public String doSolve() {
        try {
            Mac hmac = Mac.getInstance("HmacSha256");
            hmac.init(new SecretKeySpec("foobarbaz".getBytes(), "sha256"));
            byte[] bytes = hmac.doFinal("foobarbaz".getBytes());
            String encoded = new String(Base64.getEncoder().encode(bytes));
            return encoded;
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException();
        }
    }
}
