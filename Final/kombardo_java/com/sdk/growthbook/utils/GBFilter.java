package com.sdk.growthbook.utils;

import com.sdk.growthbook.utils.RangeSerializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.Bc\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012 \b\u0001\u0010\u0006\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u0002`\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BO\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u0002`\n0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR:\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u0002`\n0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006/"}, d2 = {"Lcom/sdk/growthbook/utils/GBFilter;", BuildConfig.FLAVOR, "seen1", BuildConfig.FLAVOR, "seed", BuildConfig.FLAVOR, "ranges", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBBucketRange;", "attribute", "hashVersion", "fallbackAttribute", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAttribute", "()Ljava/lang/String;", "setAttribute", "(Ljava/lang/String;)V", "getFallbackAttribute", "setFallbackAttribute", "getHashVersion", "()Ljava/lang/Integer;", "setHashVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRanges$annotations", "()V", "getRanges", "()Ljava/util/List;", "setRanges", "(Ljava/util/List;)V", "getSeed", "setSeed", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$GrowthBook_release", "$serializer", "Companion", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class GBFilter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String attribute;
    private String fallbackAttribute;
    private Integer hashVersion;
    private List<Pair<Float, Float>> ranges;
    private String seed;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sdk/growthbook/utils/GBFilter$Companion;", BuildConfig.FLAVOR, "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sdk/growthbook/utils/GBFilter;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GBFilter> serializer() {
            return GBFilter$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ GBFilter(int i5, String str, @Serializable(with = RangeSerializer.GBBucketRangeListSerializer.class) List list, String str2, Integer num, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, GBFilter$$serializer.INSTANCE.getDescriptor());
        }
        this.seed = str;
        this.ranges = list;
        if ((i5 & 4) == 0) {
            this.attribute = null;
        } else {
            this.attribute = str2;
        }
        if ((i5 & 8) == 0) {
            this.hashVersion = null;
        } else {
            this.hashVersion = num;
        }
        if ((i5 & 16) == 0) {
            this.fallbackAttribute = null;
        } else {
            this.fallbackAttribute = str3;
        }
    }

    @Serializable(with = RangeSerializer.GBBucketRangeListSerializer.class)
    public static /* synthetic */ void getRanges$annotations() {
    }

    public static final /* synthetic */ void write$Self$GrowthBook_release(GBFilter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.seed);
        output.encodeSerializableElement(serialDesc, 1, RangeSerializer.GBBucketRangeListSerializer.INSTANCE, self.ranges);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.attribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.attribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hashVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.hashVersion);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.fallbackAttribute == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.fallbackAttribute);
    }

    public final String getAttribute() {
        return this.attribute;
    }

    public final String getFallbackAttribute() {
        return this.fallbackAttribute;
    }

    public final Integer getHashVersion() {
        return this.hashVersion;
    }

    public final List<Pair<Float, Float>> getRanges() {
        return this.ranges;
    }

    public final String getSeed() {
        return this.seed;
    }

    public final void setAttribute(String str) {
        this.attribute = str;
    }

    public final void setFallbackAttribute(String str) {
        this.fallbackAttribute = str;
    }

    public final void setHashVersion(Integer num) {
        this.hashVersion = num;
    }

    public final void setRanges(List<Pair<Float, Float>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.ranges = list;
    }

    public final void setSeed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.seed = str;
    }

    public GBFilter(String seed, List<Pair<Float, Float>> ranges, String str, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(seed, "seed");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        this.seed = seed;
        this.ranges = ranges;
        this.attribute = str;
        this.hashVersion = num;
        this.fallbackAttribute = str2;
    }

    public /* synthetic */ GBFilter(String str, List list, String str2, Integer num, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i5 & 4) != 0 ? null : str2, (i5 & 8) != 0 ? null : num, (i5 & 16) != 0 ? null : str3);
    }
}
