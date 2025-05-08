package dk.molslinjen.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import dk.molslinjen.core.log.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/core/ShareHelper;", BuildConfig.FLAVOR, "<init>", "()V", "showShareActionFile", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "filePath", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareHelper {
    public static final ShareHelper INSTANCE = new ShareHelper();

    private ShareHelper() {
    }

    public final boolean showShareActionFile(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (filePath == null || filePath.length() == 0) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            Uri uriForFile = FileProvider.getUriForFile(context, "dk.molslinjen.kombardo.provider", new File(filePath));
            intent.addFlags(1);
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.setFlags(268435456);
            context.startActivity(Intent.createChooser(intent, null));
            return true;
        } catch (Exception e5) {
            Logger.INSTANCE.logError(e5);
            return false;
        }
    }
}
