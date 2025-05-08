package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/facebook/internal/ServerProtocol;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "getDefaultAPIVersion", "()Ljava/lang/String;", BuildConfig.FLAVOR, "getErrorsProxyAuthDisabled", "()Ljava/util/Collection;", "getErrorsUserCanceled", "getErrorConnectionFailure", "getDialogAuthority", "getGamingDialogAuthority", "getInstagramDialogAuthority", "getGraphUrlBase", "getGraphVideoUrlBase", "getFacebookGraphUrlBase", "subdomain", "getGraphUrlBaseForSubdomain", "(Ljava/lang/String;)Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "DIALOG_AUTHORITY_FORMAT", "GAMING_DIALOG_AUTHORITY_FORMAT", "GRAPH_VIDEO_URL_FORMAT", "GRAPH_URL_FORMAT", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ServerProtocol {
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    private static final String GAMING_DIALOG_AUTHORITY_FORMAT = "%s";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    public static final ServerProtocol INSTANCE = new ServerProtocol();
    private static final String TAG = ServerProtocol.class.getName();

    private ServerProtocol() {
    }

    public static final String getDefaultAPIVersion() {
        return "v16.0";
    }

    public static final String getDialogAuthority() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getErrorConnectionFailure() {
        return "CONNECTION_FAILURE";
    }

    public static final Collection<String> getErrorsProxyAuthDisabled() {
        return CollectionsKt.listOf((Object[]) new String[]{"service_disabled", "AndroidAuthKillSwitchException"});
    }

    public static final Collection<String> getErrorsUserCanceled() {
        return CollectionsKt.listOf((Object[]) new String[]{"access_denied", "OAuthAccessDeniedException"});
    }

    public static final String getFacebookGraphUrlBase() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getGamingDialogAuthority() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(GAMING_DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookGamingDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getGraphUrlBase() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getGraphUrlBaseForSubdomain(String subdomain) {
        Intrinsics.checkNotNullParameter(subdomain, "subdomain");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{subdomain}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getGraphVideoUrlBase() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(GRAPH_VIDEO_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getInstagramDialogAuthority() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getInstagramDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
