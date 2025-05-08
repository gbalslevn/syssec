package com.facebook;

import com.facebook.FacebookException;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Random;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0016\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\nB\u0013\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/facebook/FacebookException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", BuildConfig.FLAVOR, "message", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "throwable", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "toString", "()Ljava/lang/String;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class FacebookException extends RuntimeException {
    public static final long serialVersionUID = 1;

    public FacebookException() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final void m2773_init_$lambda0(String str, boolean z5) {
        if (z5) {
            try {
                ErrorReportHandler.save(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        String message = getMessage();
        return message == null ? BuildConfig.FLAVOR : message;
    }

    public FacebookException(final String str) {
        super(str);
        Random random = new Random();
        if (str == null || !FacebookSdk.isInitialized() || random.nextInt(100) <= 50) {
            return;
        }
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: d0.c
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                FacebookException.m2773_init_$lambda0(str, z5);
            }
        });
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }
}
