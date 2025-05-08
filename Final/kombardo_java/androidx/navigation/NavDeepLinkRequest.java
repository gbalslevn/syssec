package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0017\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest;", BuildConfig.FLAVOR, "Landroid/net/Uri;", "uri", BuildConfig.FLAVOR, "action", "mimeType", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "(Landroid/content/Intent;)V", "toString", "()Ljava/lang/String;", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Ljava/lang/String;", "getAction", "getMimeType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavDeepLinkRequest {
    private final String action;
    private final String mimeType;
    private final Uri uri;

    public NavDeepLinkRequest(Uri uri, String str, String str2) {
        this.uri = uri;
        this.action = str;
        this.mimeType = str2;
    }

    public String getAction() {
        return this.action;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (getUri() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(getUri()));
        }
        if (getAction() != null) {
            sb.append(" action=");
            sb.append(getAction());
        }
        if (getMimeType() != null) {
            sb.append(" mimetype=");
            sb.append(getMimeType());
        }
        sb.append(" }");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLinkRequest(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        Intrinsics.checkNotNullParameter(intent, "intent");
    }
}
