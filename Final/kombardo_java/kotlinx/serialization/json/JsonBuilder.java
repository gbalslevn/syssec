package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.SerializersModule;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R(\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\"\u0010#\u0012\u0004\b(\u0010\u0015\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\"\u0010/\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010R\"\u0010<\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\f\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R*\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b@\u0010A\u0012\u0004\bF\u0010\u0015\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER(\u0010G\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bG\u0010\f\u0012\u0004\bJ\u0010\u0015\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R(\u0010K\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bK\u0010\f\u0012\u0004\bN\u0010\u0015\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010\u0010R\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006V"}, d2 = {"Lkotlinx/serialization/json/JsonBuilder;", BuildConfig.FLAVOR, "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/Json;)V", "Lkotlinx/serialization/json/JsonConfiguration;", "build$kotlinx_serialization_json", "()Lkotlinx/serialization/json/JsonConfiguration;", "build", BuildConfig.FLAVOR, "encodeDefaults", "Z", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "explicitNulls", "getExplicitNulls", "setExplicitNulls", "getExplicitNulls$annotations", "()V", "ignoreUnknownKeys", "getIgnoreUnknownKeys", "setIgnoreUnknownKeys", "isLenient", "setLenient", "allowStructuredMapKeys", "getAllowStructuredMapKeys", "setAllowStructuredMapKeys", "prettyPrint", "getPrettyPrint", "setPrettyPrint", BuildConfig.FLAVOR, "prettyPrintIndent", "Ljava/lang/String;", "getPrettyPrintIndent", "()Ljava/lang/String;", "setPrettyPrintIndent", "(Ljava/lang/String;)V", "getPrettyPrintIndent$annotations", "coerceInputValues", "getCoerceInputValues", "setCoerceInputValues", "useArrayPolymorphism", "getUseArrayPolymorphism", "setUseArrayPolymorphism", "classDiscriminator", "getClassDiscriminator", "setClassDiscriminator", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "classDiscriminatorMode", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "allowSpecialFloatingPointValues", "getAllowSpecialFloatingPointValues", "setAllowSpecialFloatingPointValues", "useAlternativeNames", "getUseAlternativeNames", "setUseAlternativeNames", "Lkotlinx/serialization/json/JsonNamingStrategy;", "namingStrategy", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "setNamingStrategy", "(Lkotlinx/serialization/json/JsonNamingStrategy;)V", "getNamingStrategy$annotations", "decodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive", "setDecodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive$annotations", "allowTrailingComma", "getAllowTrailingComma", "setAllowTrailingComma", "getAllowTrailingComma$annotations", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonBuilder {
    private boolean allowSpecialFloatingPointValues;
    private boolean allowStructuredMapKeys;
    private boolean allowTrailingComma;
    private String classDiscriminator;
    private ClassDiscriminatorMode classDiscriminatorMode;
    private boolean coerceInputValues;
    private boolean decodeEnumsCaseInsensitive;
    private boolean encodeDefaults;
    private boolean explicitNulls;
    private boolean ignoreUnknownKeys;
    private boolean isLenient;
    private JsonNamingStrategy namingStrategy;
    private boolean prettyPrint;
    private String prettyPrintIndent;
    private SerializersModule serializersModule;
    private boolean useAlternativeNames;
    private boolean useArrayPolymorphism;

    public JsonBuilder(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.encodeDefaults = json.getConfiguration().getEncodeDefaults();
        this.explicitNulls = json.getConfiguration().getExplicitNulls();
        this.ignoreUnknownKeys = json.getConfiguration().getIgnoreUnknownKeys();
        this.isLenient = json.getConfiguration().getIsLenient();
        this.allowStructuredMapKeys = json.getConfiguration().getAllowStructuredMapKeys();
        this.prettyPrint = json.getConfiguration().getPrettyPrint();
        this.prettyPrintIndent = json.getConfiguration().getPrettyPrintIndent();
        this.coerceInputValues = json.getConfiguration().getCoerceInputValues();
        this.useArrayPolymorphism = json.getConfiguration().getUseArrayPolymorphism();
        this.classDiscriminator = json.getConfiguration().getClassDiscriminator();
        this.classDiscriminatorMode = json.getConfiguration().getClassDiscriminatorMode();
        this.allowSpecialFloatingPointValues = json.getConfiguration().getAllowSpecialFloatingPointValues();
        this.useAlternativeNames = json.getConfiguration().getUseAlternativeNames();
        json.getConfiguration().getNamingStrategy();
        this.decodeEnumsCaseInsensitive = json.getConfiguration().getDecodeEnumsCaseInsensitive();
        this.allowTrailingComma = json.getConfiguration().getAllowTrailingComma();
        this.serializersModule = json.getSerializersModule();
    }

    public final JsonConfiguration build$kotlinx_serialization_json() {
        if (this.useArrayPolymorphism) {
            if (!Intrinsics.areEqual(this.classDiscriminator, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
            }
            if (this.classDiscriminatorMode != ClassDiscriminatorMode.POLYMORPHIC) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.");
            }
        }
        if (this.prettyPrint) {
            if (!Intrinsics.areEqual(this.prettyPrintIndent, "    ")) {
                String str = this.prettyPrintIndent;
                for (int i5 = 0; i5 < str.length(); i5++) {
                    char charAt = str.charAt(i5);
                    if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.prettyPrintIndent).toString());
                    }
                }
            }
        } else if (!Intrinsics.areEqual(this.prettyPrintIndent, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new JsonConfiguration(this.encodeDefaults, this.ignoreUnknownKeys, this.isLenient, this.allowStructuredMapKeys, this.prettyPrint, this.explicitNulls, this.prettyPrintIndent, this.coerceInputValues, this.useArrayPolymorphism, this.classDiscriminator, this.allowSpecialFloatingPointValues, this.useAlternativeNames, null, this.decodeEnumsCaseInsensitive, this.allowTrailingComma, this.classDiscriminatorMode);
    }

    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void setEncodeDefaults(boolean z5) {
        this.encodeDefaults = z5;
    }

    public final void setExplicitNulls(boolean z5) {
        this.explicitNulls = z5;
    }

    public final void setIgnoreUnknownKeys(boolean z5) {
        this.ignoreUnknownKeys = z5;
    }

    public final void setLenient(boolean z5) {
        this.isLenient = z5;
    }

    public final void setPrettyPrint(boolean z5) {
        this.prettyPrint = z5;
    }
}
