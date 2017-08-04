package com.lazyman.pickupweb.test;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.HexDump;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.HexDumpEncoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/8/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestHttps
{
    @Test
    public void test() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, KeyManagementException, UnrecoverableEntryException
    {

        URL url = new URL("https://192.168.7.139:8443");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null ,new TrustManager[]{new SSLTrustManager()},null);
        connection.setSSLSocketFactory(context.getSocketFactory());
        connection.setHostnameVerifier(new HostnameVerifier()
        {
            @Override
            public boolean verify(String s, SSLSession sslSession)
            {
                return true;
            }
        });
        try
        {
            connection.connect();

            System.out.println(IOUtils.toString(connection.getInputStream(),"UTF-8").substring(1,100));
        }
        finally
        {
            connection.disconnect();
        }
    }

    @Test
    public void testRSA() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException, SignatureException
    {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream("D:\\programe\\apache-tomcat-9.0.0.M21\\conf\\sslstudy.keystore"),"changeit".toCharArray());
        System.out.println("");
        Certificate certificate = keyStore.getCertificate("tomcat");

        HexDumpEncoder encoder = new HexDumpEncoder();
        PublicKey publicKey = certificate.getPublicKey();
        PrivateKey privateKey = (PrivateKey) keyStore.getKey("tomcat", "changeit".toCharArray());
        System.out.println("==================public key=========================");
//        System.out.println(encoder.encode(publicKey.getEncoded()));
        System.out.println("====================private key=======================");
//        System.out.println(encoder.encode(privateKey.getEncoded()));

        CertificateFactory certificateFactory = CertificateFactory.getInstance("x.509","SUN");
        System.out.println(certificateFactory.getProvider().getName());
        Certificate certificateFromFile = certificateFactory.generateCertificate(new FileInputStream("D:\\programe\\apache-tomcat-9.0.0.M21\\conf\\sslstudy.cer"));
        Assert.assertEquals(certificate,certificateFromFile);
        certificate.verify(publicKey);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        String txt = "123456";
        byte[] encrypted = cipher.doFinal(txt.getBytes());
//        System.out.println(encoder.encode(encrypted));
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        Assert.assertEquals(txt,new String(cipher.doFinal(encrypted)));

    }

    @Test
    public void testVerify() throws CertificateException, NoSuchProviderException, FileNotFoundException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("x.509","SUN");
        Certificate certificate = certificateFactory.generateCertificate(new FileInputStream("D:\\ssl\\icloud.cer"));
        Certificate certificateSigner = certificateFactory.generateCertificate(new FileInputStream("D:\\ssl\\signforicloud.cer"));
        certificate.verify(certificateSigner.getPublicKey());
    }

    public static class SSLTrustManager implements TrustManager, X509TrustManager
    {
        public java.security.cert.X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException
        {
            return;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException
        {
            return;
        }
    }
}
