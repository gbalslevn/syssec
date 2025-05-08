package com.google.accompanist.web;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/google/accompanist/web/WebContent;", BuildConfig.FLAVOR, "<init>", "()V", "NavigatorOnly", "Url", "Lcom/google/accompanist/web/WebContent$NavigatorOnly;", "Lcom/google/accompanist/web/WebContent$Url;", "web_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WebContent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/accompanist/web/WebContent$NavigatorOnly;", "Lcom/google/accompanist/web/WebContent;", "()V", "web_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class NavigatorOnly extends WebContent {
        public static final NavigatorOnly INSTANCE = new NavigatorOnly();

        private NavigatorOnly() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/accompanist/web/WebContent$Url;", "Lcom/google/accompanist/web/WebContent;", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "additionalHttpHeaders", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "Ljava/util/Map;", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "web_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class Url extends WebContent {
        private final Map<String, String> additionalHttpHeaders;
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(String url, Map<String, String> additionalHttpHeaders) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
            this.url = url;
            this.additionalHttpHeaders = additionalHttpHeaders;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Url)) {
                return false;
            }
            Url url = (Url) other;
            return Intrinsics.areEqual(this.url, url.url) && Intrinsics.areEqual(this.additionalHttpHeaders, url.additionalHttpHeaders);
        }

        public final Map<String, String> getAdditionalHttpHeaders() {
            return this.additionalHttpHeaders;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.additionalHttpHeaders.hashCode();
        }

        public String toString() {
            return "Url(url=" + this.url + ", additionalHttpHeaders=" + this.additionalHttpHeaders + ')';
        }
    }

    public /* synthetic */ WebContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WebContent() {
    }
}
