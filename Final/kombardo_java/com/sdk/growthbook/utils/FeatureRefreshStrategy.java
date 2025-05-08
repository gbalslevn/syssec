package com.sdk.growthbook.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/utils/FeatureRefreshStrategy;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "STALE_WHILE_REVALIDATE", "SERVER_SENT_EVENTS", "SERVER_SENT_REMOTE_FEATURE_EVAL", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureRefreshStrategy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureRefreshStrategy[] $VALUES;
    public static final FeatureRefreshStrategy STALE_WHILE_REVALIDATE = new FeatureRefreshStrategy("STALE_WHILE_REVALIDATE", 0);
    public static final FeatureRefreshStrategy SERVER_SENT_EVENTS = new FeatureRefreshStrategy("SERVER_SENT_EVENTS", 1);
    public static final FeatureRefreshStrategy SERVER_SENT_REMOTE_FEATURE_EVAL = new FeatureRefreshStrategy("SERVER_SENT_REMOTE_FEATURE_EVAL", 2);

    private static final /* synthetic */ FeatureRefreshStrategy[] $values() {
        return new FeatureRefreshStrategy[]{STALE_WHILE_REVALIDATE, SERVER_SENT_EVENTS, SERVER_SENT_REMOTE_FEATURE_EVAL};
    }

    static {
        FeatureRefreshStrategy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FeatureRefreshStrategy(String str, int i5) {
    }

    public static EnumEntries<FeatureRefreshStrategy> getEntries() {
        return $ENTRIES;
    }

    public static FeatureRefreshStrategy valueOf(String str) {
        return (FeatureRefreshStrategy) Enum.valueOf(FeatureRefreshStrategy.class, str);
    }

    public static FeatureRefreshStrategy[] values() {
        return (FeatureRefreshStrategy[]) $VALUES.clone();
    }
}
