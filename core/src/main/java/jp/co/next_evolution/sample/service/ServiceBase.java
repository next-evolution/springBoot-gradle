package jp.co.next_evolution.sample.service;

import jp.co.next_evolution.sample.common.CommonConst;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class ServiceBase {

    protected String getAesCryptString(final String value) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CommonConst.CIPHER_CRYPT_KEY.getBytes(), CommonConst.CIPHER_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CommonConst.CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(value.getBytes());
        return new String(Base64.getEncoder().encode(result));
    }
}
