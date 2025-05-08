package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class InstrHttpsURLConnection extends HttpsURLConnection {
    private final InstrURLConnectionBase delegate;
    private final HttpsURLConnection httpsURLConnection;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrHttpsURLConnection(HttpsURLConnection httpsURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpsURLConnection.getURL());
        this.httpsURLConnection = httpsURLConnection;
        this.delegate = new InstrURLConnectionBase(httpsURLConnection, timer, networkRequestMetricBuilder);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.delegate.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() {
        this.delegate.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.delegate.disconnect();
    }

    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.httpsURLConnection.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() {
        return this.delegate.getContent();
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.delegate.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.delegate.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i5) {
        return this.delegate.getHeaderField(i5);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j5) {
        return this.delegate.getHeaderFieldDate(str, j5);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i5) {
        return this.delegate.getHeaderFieldInt(str, i5);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i5) {
        return this.delegate.getHeaderFieldKey(i5);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j5) {
        return this.delegate.getHeaderFieldLong(str, j5);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.httpsURLConnection.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        return this.delegate.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.httpsURLConnection.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        return this.httpsURLConnection.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        return this.delegate.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() {
        return this.httpsURLConnection.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() {
        return this.delegate.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.delegate.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        return this.delegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        return this.delegate.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.httpsURLConnection.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() {
        return this.httpsURLConnection.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.delegate.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z5) {
        this.delegate.setAllowUserInteraction(z5);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i5) {
        this.delegate.setChunkedStreamingMode(i5);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i5) {
        this.delegate.setConnectTimeout(i5);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z5) {
        this.delegate.setDefaultUseCaches(z5);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z5) {
        this.delegate.setDoInput(z5);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z5) {
        this.delegate.setDoOutput(z5);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i5) {
        this.delegate.setFixedLengthStreamingMode(i5);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.httpsURLConnection.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j5) {
        this.delegate.setIfModifiedSince(j5);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z5) {
        this.delegate.setInstanceFollowRedirects(z5);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i5) {
        this.delegate.setReadTimeout(i5);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) {
        this.delegate.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.delegate.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z5) {
        this.delegate.setUseCaches(z5);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) {
        return this.delegate.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.delegate.getHeaderField(str);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j5) {
        this.delegate.setFixedLengthStreamingMode(j5);
    }
}
