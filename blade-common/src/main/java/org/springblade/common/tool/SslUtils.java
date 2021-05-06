/**
 * Copyright (C), 2015-2021
 * FileName: SslUtils
 * Author:   呵呵哒
 * Date:     2021/4/25 14:04
 * Description:
 */
package org.springblade.common.tool;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @创建人 hyp
 * @创建时间 2021/4/25
 * @描述
 */
public class SslUtils {private static void trustAllHttpsCertificates() throws Exception {
	TrustManager[] trustAllCerts = new TrustManager[1];
	TrustManager tm = new miTM();
	trustAllCerts[0] = tm;
	SSLContext sc = SSLContext.getInstance("SSL");
	sc.init(null, trustAllCerts, null);
	HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
}

	static class miTM implements TrustManager,X509TrustManager {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(X509Certificate[] certs) {
			return true;
		}
		@Override
		public void checkServerTrusted(X509Certificate[] certs, String authType)
			throws CertificateException {
			return;
		}

		@Override
		public void checkClientTrusted(X509Certificate[] certs, String authType)
			throws CertificateException {
			return;
		}
	}

	/**
	 * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用
	 * @throws Exception
	 */
	public static void ignoreSsl() throws Exception{
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
				return true;
			}
		};
		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

}
