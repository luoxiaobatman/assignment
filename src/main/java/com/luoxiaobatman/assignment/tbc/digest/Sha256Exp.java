package com.luoxiaobatman.assignment.tbc.digest;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Sha256Exp extends AbstractSolution<String> implements GenericSolution<String> {
    @Override
    public String doSolve() {
        String message = "foobar";
        try {
            MessageDigest md5MessageDigest = MessageDigest.getInstance("sha256");
            byte[] summary = md5MessageDigest.digest(message.getBytes());
            String encoded = new String(Base64.getEncoder().encode(summary));
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
