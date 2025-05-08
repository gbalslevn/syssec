package com.adjust.sdk;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AdjustLinkResolution {
    private static volatile ExecutorService executor = null;
    private static final String[] expectedUrlHostSuffixArray = {"adjust.com", "adj.st", "go.link"};
    private static final int maxRecursions = 10;

    /* loaded from: classes.dex */
    public interface AdjustLinkResolutionCallback {
        void resolvedLinkCallback(Uri uri);
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ URL f4124a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdjustLinkResolutionCallback f4125b;

        public a(URL url, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
            this.f4124a = url;
            this.f4125b = adjustLinkResolutionCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdjustLinkResolution.requestAndResolve(this.f4124a, 0, this.f4125b);
        }
    }

    private AdjustLinkResolution() {
    }

    private static URL convertToHttps(URL url) {
        String externalForm;
        if (url == null || (externalForm = url.toExternalForm()) == null || !externalForm.startsWith("http:")) {
            return url;
        }
        try {
            return new URL("https:" + externalForm.substring(5));
        } catch (MalformedURLException unused) {
            return url;
        }
    }

    private static Uri convertToUri(URL url) {
        if (url == null) {
            return null;
        }
        return Uri.parse(url.toString());
    }

    private static boolean isTerminalUrl(String str) {
        return urlMatchesSuffix(str, expectedUrlHostSuffixArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void requestAndResolve(URL url, int i5, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        HttpURLConnection httpURLConnection;
        URL convertToHttps = convertToHttps(url);
        URL url2 = null;
        try {
            httpURLConnection = (HttpURLConnection) convertToHttps.openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                String headerField = httpURLConnection.getHeaderField("Location");
                if (headerField != null) {
                    url2 = new URL(headerField);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
        resolveLink(url2, convertToHttps, i5 + 1, adjustLinkResolutionCallback);
    }

    public static void resolveLink(String str, String[] strArr, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        URL url;
        if (adjustLinkResolutionCallback == null) {
            return;
        }
        if (str == null) {
            adjustLinkResolutionCallback.resolvedLinkCallback(null);
            return;
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null) {
            adjustLinkResolutionCallback.resolvedLinkCallback(null);
            return;
        }
        if (!urlMatchesSuffix(url.getHost(), strArr)) {
            adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri(url));
            return;
        }
        if (executor == null) {
            synchronized (expectedUrlHostSuffixArray) {
                try {
                    if (executor == null) {
                        executor = Executors.newSingleThreadExecutor();
                    }
                } finally {
                }
            }
        }
        executor.execute(new a(url, adjustLinkResolutionCallback));
    }

    private static boolean urlMatchesSuffix(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static void resolveLink(URL url, URL url2, int i5, AdjustLinkResolutionCallback adjustLinkResolutionCallback) {
        Uri convertToUri;
        if (url == null) {
            convertToUri = convertToUri(url2);
        } else {
            if (!isTerminalUrl(url.getHost()) && i5 <= 10) {
                requestAndResolve(url, i5, adjustLinkResolutionCallback);
                return;
            }
            convertToUri = convertToUri(url);
        }
        adjustLinkResolutionCallback.resolvedLinkCallback(convertToUri);
    }
}
