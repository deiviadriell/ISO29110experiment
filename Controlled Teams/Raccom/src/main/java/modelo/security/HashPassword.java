package modelo.security;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class HashPassword {
    private SHA3.Digest256 funcionHash;
    private static final Random RANDOM = new SecureRandom();
    public HashPassword(){
        funcionHash = new SHA3.Digest256();
    }

    public String valorHash(String entrada){
        return Hex.toHexString(funcionHash.digest(entrada.getBytes()));
    }

    public static String getSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
