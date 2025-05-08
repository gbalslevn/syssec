package com.sdk.growthbook.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sdk/growthbook/model/GBFeatureSource;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "unknownFeature", "defaultValue", "force", "experiment", "cyclicPrerequisite", "prerequisite", "override", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBFeatureSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GBFeatureSource[] $VALUES;
    public static final GBFeatureSource unknownFeature = new GBFeatureSource("unknownFeature", 0);
    public static final GBFeatureSource defaultValue = new GBFeatureSource("defaultValue", 1);
    public static final GBFeatureSource force = new GBFeatureSource("force", 2);
    public static final GBFeatureSource experiment = new GBFeatureSource("experiment", 3);
    public static final GBFeatureSource cyclicPrerequisite = new GBFeatureSource("cyclicPrerequisite", 4);
    public static final GBFeatureSource prerequisite = new GBFeatureSource("prerequisite", 5);
    public static final GBFeatureSource override = new GBFeatureSource("override", 6);

    private static final /* synthetic */ GBFeatureSource[] $values() {
        return new GBFeatureSource[]{unknownFeature, defaultValue, force, experiment, cyclicPrerequisite, prerequisite, override};
    }

    static {
        GBFeatureSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private GBFeatureSource(String str, int i5) {
    }

    public static EnumEntries<GBFeatureSource> getEntries() {
        return $ENTRIES;
    }

    public static GBFeatureSource valueOf(String str) {
        return (GBFeatureSource) Enum.valueOf(GBFeatureSource.class, str);
    }

    public static GBFeatureSource[] values() {
        return (GBFeatureSource[]) $VALUES.clone();
    }
}
