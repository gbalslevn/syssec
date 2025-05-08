package com.sdk.growthbook.features;

import com.sdk.growthbook.utils.FeatureRefreshStrategy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/sdk/growthbook/features/FeatureURLBuilder;", BuildConfig.FLAVOR, "()V", "buildUrl", BuildConfig.FLAVOR, "baseUrl", "apiKey", "featureRefreshStrategy", "Lcom/sdk/growthbook/utils/FeatureRefreshStrategy;", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureURLBuilder {
    private static final String EVENTS_PATH = "sub";
    private static final String FEATURE_PATH = "api/features";
    private static final String REMOTE_FEATURE_PATH = "api/eval";

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeatureRefreshStrategy.values().length];
            try {
                iArr[FeatureRefreshStrategy.STALE_WHILE_REVALIDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureRefreshStrategy.SERVER_SENT_EVENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureRefreshStrategy.SERVER_SENT_REMOTE_FEATURE_EVAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ String buildUrl$default(FeatureURLBuilder featureURLBuilder, String str, String str2, FeatureRefreshStrategy featureRefreshStrategy, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            featureRefreshStrategy = FeatureRefreshStrategy.STALE_WHILE_REVALIDATE;
        }
        return featureURLBuilder.buildUrl(str, str2, featureRefreshStrategy);
    }

    public final String buildUrl(String baseUrl, String apiKey, FeatureRefreshStrategy featureRefreshStrategy) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(featureRefreshStrategy, "featureRefreshStrategy");
        int i5 = WhenMappings.$EnumSwitchMapping$0[featureRefreshStrategy.ordinal()];
        if (i5 == 1) {
            str = FEATURE_PATH;
        } else if (i5 == 2) {
            str = EVENTS_PATH;
        } else {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = REMOTE_FEATURE_PATH;
        }
        if (StringsKt.endsWith$default((CharSequence) baseUrl, '/', false, 2, (Object) null)) {
            str2 = baseUrl + str;
        } else {
            str2 = baseUrl + '/' + str;
        }
        return str2 + '/' + apiKey;
    }
}
