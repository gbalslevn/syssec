package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentManager;", BuildConfig.FLAVOR, "()V", "start", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InstrumentManager {
    public static final InstrumentManager INSTANCE = new InstrumentManager();

    private InstrumentManager() {
    }

    public static final void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() { // from class: p0.b
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z5) {
                    InstrumentManager.m2871start$lambda0(z5);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: p0.c
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z5) {
                    InstrumentManager.m2872start$lambda1(z5);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.AnrReport, new FeatureManager.Callback() { // from class: p0.d
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z5) {
                    InstrumentManager.m2873start$lambda2(z5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: start$lambda-0, reason: not valid java name */
    public static final void m2871start$lambda0(boolean z5) {
        if (z5) {
            CrashHandler.INSTANCE.enable();
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                ExceptionAnalyzer.enable();
                CrashShieldHandler.enable();
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                ThreadCheckHandler.enable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: start$lambda-1, reason: not valid java name */
    public static final void m2872start$lambda1(boolean z5) {
        if (z5) {
            ErrorReportHandler.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: start$lambda-2, reason: not valid java name */
    public static final void m2873start$lambda2(boolean z5) {
        if (z5) {
            ANRHandler.enable();
        }
    }
}
