package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u0018\u00002\u00020\u0001B«\u0001\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u0005\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR \u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b!\u0010\"\u001a\u0004\b \u0010\u001cR \u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010#\u0012\u0004\b%\u0010\"\u001a\u0004\b$\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b'\u0010\u001cR\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b)\u0010\u001cR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b*\u0010\u001cR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010+\u0012\u0004\b.\u0010\"\u001a\u0004\b,\u0010-R \u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u0012\u0004\b0\u0010\"\u001a\u0004\b/\u0010\u001cR \u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u001a\u0012\u0004\b2\u0010\"\u001a\u0004\b1\u0010\u001cR(\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0015\u00103\u0012\u0004\b8\u0010\"\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lkotlinx/serialization/json/JsonConfiguration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "encodeDefaults", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", BuildConfig.FLAVOR, "prettyPrintIndent", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "Lkotlinx/serialization/json/JsonNamingStrategy;", "namingStrategy", "decodeEnumsCaseInsensitive", "allowTrailingComma", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "classDiscriminatorMode", "<init>", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZLkotlinx/serialization/json/JsonNamingStrategy;ZZLkotlinx/serialization/json/ClassDiscriminatorMode;)V", "toString", "()Ljava/lang/String;", "Z", "getEncodeDefaults", "()Z", "getIgnoreUnknownKeys", "getAllowStructuredMapKeys", "getPrettyPrint", "getExplicitNulls", "getExplicitNulls$annotations", "()V", "Ljava/lang/String;", "getPrettyPrintIndent", "getPrettyPrintIndent$annotations", "getCoerceInputValues", "getUseArrayPolymorphism", "getClassDiscriminator", "getAllowSpecialFloatingPointValues", "getUseAlternativeNames", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy$annotations", "getDecodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive$annotations", "getAllowTrailingComma", "getAllowTrailingComma$annotations", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getClassDiscriminatorMode$annotations", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonConfiguration {
    private final boolean allowSpecialFloatingPointValues;
    private final boolean allowStructuredMapKeys;
    private final boolean allowTrailingComma;
    private final String classDiscriminator;
    private ClassDiscriminatorMode classDiscriminatorMode;
    private final boolean coerceInputValues;
    private final boolean decodeEnumsCaseInsensitive;
    private final boolean encodeDefaults;
    private final boolean explicitNulls;
    private final boolean ignoreUnknownKeys;
    private final boolean isLenient;
    private final JsonNamingStrategy namingStrategy;
    private final boolean prettyPrint;
    private final String prettyPrintIndent;
    private final boolean useAlternativeNames;
    private final boolean useArrayPolymorphism;

    public JsonConfiguration(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String prettyPrintIndent, boolean z11, boolean z12, String classDiscriminator, boolean z13, boolean z14, JsonNamingStrategy jsonNamingStrategy, boolean z15, boolean z16, ClassDiscriminatorMode classDiscriminatorMode) {
        Intrinsics.checkNotNullParameter(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(classDiscriminator, "classDiscriminator");
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "classDiscriminatorMode");
        this.encodeDefaults = z5;
        this.ignoreUnknownKeys = z6;
        this.isLenient = z7;
        this.allowStructuredMapKeys = z8;
        this.prettyPrint = z9;
        this.explicitNulls = z10;
        this.prettyPrintIndent = prettyPrintIndent;
        this.coerceInputValues = z11;
        this.useArrayPolymorphism = z12;
        this.classDiscriminator = classDiscriminator;
        this.allowSpecialFloatingPointValues = z13;
        this.useAlternativeNames = z14;
        this.decodeEnumsCaseInsensitive = z15;
        this.allowTrailingComma = z16;
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public final boolean getAllowSpecialFloatingPointValues() {
        return this.allowSpecialFloatingPointValues;
    }

    public final boolean getAllowStructuredMapKeys() {
        return this.allowStructuredMapKeys;
    }

    public final boolean getAllowTrailingComma() {
        return this.allowTrailingComma;
    }

    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    public final ClassDiscriminatorMode getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getCoerceInputValues() {
        return this.coerceInputValues;
    }

    public final boolean getDecodeEnumsCaseInsensitive() {
        return this.decodeEnumsCaseInsensitive;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final boolean getExplicitNulls() {
        return this.explicitNulls;
    }

    public final boolean getIgnoreUnknownKeys() {
        return this.ignoreUnknownKeys;
    }

    public final JsonNamingStrategy getNamingStrategy() {
        return null;
    }

    public final boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    public final boolean getUseAlternativeNames() {
        return this.useAlternativeNames;
    }

    public final boolean getUseArrayPolymorphism() {
        return this.useArrayPolymorphism;
    }

    /* renamed from: isLenient, reason: from getter */
    public final boolean getIsLenient() {
        return this.isLenient;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.encodeDefaults + ", ignoreUnknownKeys=" + this.ignoreUnknownKeys + ", isLenient=" + this.isLenient + ", allowStructuredMapKeys=" + this.allowStructuredMapKeys + ", prettyPrint=" + this.prettyPrint + ", explicitNulls=" + this.explicitNulls + ", prettyPrintIndent='" + this.prettyPrintIndent + "', coerceInputValues=" + this.coerceInputValues + ", useArrayPolymorphism=" + this.useArrayPolymorphism + ", classDiscriminator='" + this.classDiscriminator + "', allowSpecialFloatingPointValues=" + this.allowSpecialFloatingPointValues + ", useAlternativeNames=" + this.useAlternativeNames + ", namingStrategy=" + ((Object) null) + ", decodeEnumsCaseInsensitive=" + this.decodeEnumsCaseInsensitive + ", allowTrailingComma=" + this.allowTrailingComma + ", classDiscriminatorMode=" + this.classDiscriminatorMode + ')';
    }

    public /* synthetic */ JsonConfiguration(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str, boolean z11, boolean z12, String str2, boolean z13, boolean z14, JsonNamingStrategy jsonNamingStrategy, boolean z15, boolean z16, ClassDiscriminatorMode classDiscriminatorMode, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6, (i5 & 4) != 0 ? false : z7, (i5 & 8) != 0 ? false : z8, (i5 & 16) != 0 ? false : z9, (i5 & 32) != 0 ? true : z10, (i5 & 64) != 0 ? "    " : str, (i5 & 128) != 0 ? false : z11, (i5 & 256) != 0 ? false : z12, (i5 & 512) != 0 ? "type" : str2, (i5 & 1024) != 0 ? false : z13, (i5 & 2048) == 0 ? z14 : true, (i5 & 4096) != 0 ? null : jsonNamingStrategy, (i5 & 8192) != 0 ? false : z15, (i5 & 16384) != 0 ? false : z16, (i5 & 32768) != 0 ? ClassDiscriminatorMode.POLYMORPHIC : classDiscriminatorMode);
    }
}
