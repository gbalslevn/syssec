package com.google.firebase.perf.util;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class URLWrapper {
    private final URL url;

    public URLWrapper(URL url) {
        this.url = url;
    }

    public URLConnection openConnection() {
        return this.url.openConnection();
    }

    public String toString() {
        return this.url.toString();
    }
}
