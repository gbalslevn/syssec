package com.facebook.appevents.cloudbridge;

import com.facebook.LoggingBehavior;
import com.facebook.appevents.cloudbridge.AppEventType;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004>?@AB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u0010\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u000bj\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u0001`\r2\u0006\u0010\n\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001f\u0010 JQ\u0010\"\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0018\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f0\u001eH\u0002¢\u0006\u0004\b\"\u0010#J\u008f\u0001\u0010'\u001a\u00020&2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112.\u0010!\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f0\u000bj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f`\r2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011H\u0002¢\u0006\u0004\b'\u0010(JG\u0010+\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b)\u0010*JW\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fH\u0000¢\u0006\u0004\b,\u0010-J\u008b\u0001\u00102\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020&2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0018\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f0\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b0\u00101J7\u00105\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fH\u0000¢\u0006\u0004\b3\u00104R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u0002060\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u00108R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020<0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b=\u00108¨\u0006B"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "field", "value", "transformValue$facebook_core_release", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "transformValue", "appEvents", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "transformEvents$facebook_core_release", "(Ljava/lang/String;)Ljava/util/ArrayList;", "transformEvents", BuildConfig.FLAVOR, "appData", "Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;", BuildConfig.FLAVOR, "transformAndUpdateAppData", "(Ljava/util/Map;Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;Ljava/lang/Object;)V", "userData", "transformAndUpdateUserData", "input", "transformEventName", "(Ljava/lang/String;)Ljava/lang/String;", "commonFields", "eventTime", BuildConfig.FLAVOR, "combineAllTransformedDataForMobileAppInstall", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/List;", "customEvents", "combineAllTransformedDataForCustom", "(Ljava/util/Map;Ljava/util/List;)Ljava/util/List;", "parameters", "restOfData", "Lcom/facebook/appevents/cloudbridge/AppEventType;", "splitAppEventParameters", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/ArrayList;Ljava/util/Map;)Lcom/facebook/appevents/cloudbridge/AppEventType;", "transformAndUpdateAppAndUserData$facebook_core_release", "(Ljava/util/Map;Ljava/util/Map;Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;Ljava/lang/Object;)V", "transformAndUpdateAppAndUserData", "combineCommonFields$facebook_core_release", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "combineCommonFields", "eventType", "combineAllTransformedData$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventType;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "combineAllTransformedData", "conversionsAPICompatibleEvent$facebook_core_release", "(Ljava/util/Map;)Ljava/util/List;", "conversionsAPICompatibleEvent", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionFieldMapping;", "topLevelTransformations", "Ljava/util/Map;", "Lcom/facebook/appevents/cloudbridge/CustomEventField;", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping;", "customEventTransformations", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIEventName;", "standardEventTransformations", "DataProcessingParameterName", "SectionCustomEventFieldMapping", "SectionFieldMapping", "ValueTransformationType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventsConversionsAPITransformer {
    public static final AppEventsConversionsAPITransformer INSTANCE = new AppEventsConversionsAPITransformer();
    public static final Map<CustomEventField, SectionCustomEventFieldMapping> customEventTransformations;
    public static final Map<String, ConversionsAPIEventName> standardEventTransformations;
    private static final Map<AppEventUserAndAppDataField, SectionFieldMapping> topLevelTransformations;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "OPTIONS", "COUNTRY", "STATE", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum DataProcessingParameterName {
        OPTIONS("data_processing_options"),
        COUNTRY("data_processing_options_country"),
        STATE("data_processing_options_state");


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String rawValue;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName$Companion;", BuildConfig.FLAVOR, "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName;", "rawValue", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final DataProcessingParameterName invoke(String rawValue) {
                Intrinsics.checkNotNullParameter(rawValue, "rawValue");
                for (DataProcessingParameterName dataProcessingParameterName : DataProcessingParameterName.valuesCustom()) {
                    if (Intrinsics.areEqual(dataProcessingParameterName.getRawValue(), rawValue)) {
                        return dataProcessingParameterName;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        DataProcessingParameterName(String str) {
            this.rawValue = str;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static DataProcessingParameterName[] valuesCustom() {
            DataProcessingParameterName[] valuesCustom = values();
            return (DataProcessingParameterName[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final String getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping;", BuildConfig.FLAVOR, "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "section", "Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "field", "<init>", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "getSection", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "setSection", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;)V", "Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "getField", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "setField", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class SectionCustomEventFieldMapping {
        private ConversionsAPICustomEventField field;
        private ConversionsAPISection section;

        public SectionCustomEventFieldMapping(ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField field) {
            Intrinsics.checkNotNullParameter(field, "field");
            this.section = conversionsAPISection;
            this.field = field;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionCustomEventFieldMapping)) {
                return false;
            }
            SectionCustomEventFieldMapping sectionCustomEventFieldMapping = (SectionCustomEventFieldMapping) other;
            return this.section == sectionCustomEventFieldMapping.section && this.field == sectionCustomEventFieldMapping.field;
        }

        public final ConversionsAPICustomEventField getField() {
            return this.field;
        }

        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public int hashCode() {
            ConversionsAPISection conversionsAPISection = this.section;
            return ((conversionsAPISection == null ? 0 : conversionsAPISection.hashCode()) * 31) + this.field.hashCode();
        }

        public String toString() {
            return "SectionCustomEventFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionFieldMapping;", BuildConfig.FLAVOR, "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "section", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "field", "<init>", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "getSection", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "setSection", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;)V", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "getField", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "setField", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class SectionFieldMapping {
        private ConversionsAPIUserAndAppDataField field;
        private ConversionsAPISection section;

        public SectionFieldMapping(ConversionsAPISection section, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            Intrinsics.checkNotNullParameter(section, "section");
            this.section = section;
            this.field = conversionsAPIUserAndAppDataField;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionFieldMapping)) {
                return false;
            }
            SectionFieldMapping sectionFieldMapping = (SectionFieldMapping) other;
            return this.section == sectionFieldMapping.section && this.field == sectionFieldMapping.field;
        }

        public final ConversionsAPIUserAndAppDataField getField() {
            return this.field;
        }

        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public int hashCode() {
            int hashCode = this.section.hashCode() * 31;
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = this.field;
            return hashCode + (conversionsAPIUserAndAppDataField == null ? 0 : conversionsAPIUserAndAppDataField.hashCode());
        }

        public String toString() {
            return "SectionFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "ARRAY", "BOOL", "INT", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum ValueTransformationType {
        ARRAY,
        BOOL,
        INT;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType$Companion;", BuildConfig.FLAVOR, "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType;", "rawValue", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ValueTransformationType invoke(String rawValue) {
                Intrinsics.checkNotNullParameter(rawValue, "rawValue");
                if (!Intrinsics.areEqual(rawValue, AppEventUserAndAppDataField.EXT_INFO.getRawValue()) && !Intrinsics.areEqual(rawValue, AppEventUserAndAppDataField.URL_SCHEMES.getRawValue()) && !Intrinsics.areEqual(rawValue, CustomEventField.CONTENT_IDS.getRawValue()) && !Intrinsics.areEqual(rawValue, CustomEventField.CONTENTS.getRawValue()) && !Intrinsics.areEqual(rawValue, DataProcessingParameterName.OPTIONS.getRawValue())) {
                    if (!Intrinsics.areEqual(rawValue, AppEventUserAndAppDataField.ADV_TE.getRawValue()) && !Intrinsics.areEqual(rawValue, AppEventUserAndAppDataField.APP_TE.getRawValue())) {
                        if (Intrinsics.areEqual(rawValue, CustomEventField.EVENT_TIME.getRawValue())) {
                            return ValueTransformationType.INT;
                        }
                        return null;
                    }
                    return ValueTransformationType.BOOL;
                }
                return ValueTransformationType.ARRAY;
            }

            private Companion() {
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ValueTransformationType[] valuesCustom() {
            ValueTransformationType[] valuesCustom = values();
            return (ValueTransformationType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ValueTransformationType.valuesCustom().length];
            iArr[ValueTransformationType.ARRAY.ordinal()] = 1;
            iArr[ValueTransformationType.BOOL.ordinal()] = 2;
            iArr[ValueTransformationType.INT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConversionsAPISection.valuesCustom().length];
            iArr2[ConversionsAPISection.APP_DATA.ordinal()] = 1;
            iArr2[ConversionsAPISection.USER_DATA.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AppEventType.valuesCustom().length];
            iArr3[AppEventType.MOBILE_APP_INSTALL.ordinal()] = 1;
            iArr3[AppEventType.CUSTOM.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    static {
        AppEventUserAndAppDataField appEventUserAndAppDataField = AppEventUserAndAppDataField.ANON_ID;
        ConversionsAPISection conversionsAPISection = ConversionsAPISection.USER_DATA;
        Pair pair = TuplesKt.to(appEventUserAndAppDataField, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.ANON_ID));
        Pair pair2 = TuplesKt.to(AppEventUserAndAppDataField.APP_USER_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.FB_LOGIN_ID));
        Pair pair3 = TuplesKt.to(AppEventUserAndAppDataField.ADVERTISER_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.MAD_ID));
        Pair pair4 = TuplesKt.to(AppEventUserAndAppDataField.PAGE_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.PAGE_ID));
        Pair pair5 = TuplesKt.to(AppEventUserAndAppDataField.PAGE_SCOPED_USER_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.PAGE_SCOPED_USER_ID));
        AppEventUserAndAppDataField appEventUserAndAppDataField2 = AppEventUserAndAppDataField.ADV_TE;
        ConversionsAPISection conversionsAPISection2 = ConversionsAPISection.APP_DATA;
        topLevelTransformations = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to(appEventUserAndAppDataField2, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.ADV_TE)), TuplesKt.to(AppEventUserAndAppDataField.APP_TE, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.APP_TE)), TuplesKt.to(AppEventUserAndAppDataField.CONSIDER_VIEWS, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.CONSIDER_VIEWS)), TuplesKt.to(AppEventUserAndAppDataField.DEVICE_TOKEN, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.DEVICE_TOKEN)), TuplesKt.to(AppEventUserAndAppDataField.EXT_INFO, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.EXT_INFO)), TuplesKt.to(AppEventUserAndAppDataField.INCLUDE_DWELL_DATA, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INCLUDE_DWELL_DATA)), TuplesKt.to(AppEventUserAndAppDataField.INCLUDE_VIDEO_DATA, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INCLUDE_VIDEO_DATA)), TuplesKt.to(AppEventUserAndAppDataField.INSTALL_REFERRER, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INSTALL_REFERRER)), TuplesKt.to(AppEventUserAndAppDataField.INSTALLER_PACKAGE, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INSTALLER_PACKAGE)), TuplesKt.to(AppEventUserAndAppDataField.RECEIPT_DATA, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.RECEIPT_DATA)), TuplesKt.to(AppEventUserAndAppDataField.URL_SCHEMES, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.URL_SCHEMES)), TuplesKt.to(AppEventUserAndAppDataField.USER_DATA, new SectionFieldMapping(conversionsAPISection, null)));
        Pair pair6 = TuplesKt.to(CustomEventField.EVENT_TIME, new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_TIME));
        Pair pair7 = TuplesKt.to(CustomEventField.EVENT_NAME, new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_NAME));
        CustomEventField customEventField = CustomEventField.VALUE_TO_SUM;
        ConversionsAPISection conversionsAPISection3 = ConversionsAPISection.CUSTOM_DATA;
        customEventTransformations = MapsKt.mapOf(pair6, pair7, TuplesKt.to(customEventField, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.VALUE_TO_SUM)), TuplesKt.to(CustomEventField.CONTENT_IDS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENT_IDS)), TuplesKt.to(CustomEventField.CONTENTS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENTS)), TuplesKt.to(CustomEventField.CONTENT_TYPE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENT_TYPE)), TuplesKt.to(CustomEventField.CURRENCY, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CURRENCY)), TuplesKt.to(CustomEventField.DESCRIPTION, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.DESCRIPTION)), TuplesKt.to(CustomEventField.LEVEL, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.LEVEL)), TuplesKt.to(CustomEventField.MAX_RATING_VALUE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.MAX_RATING_VALUE)), TuplesKt.to(CustomEventField.NUM_ITEMS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.NUM_ITEMS)), TuplesKt.to(CustomEventField.PAYMENT_INFO_AVAILABLE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.PAYMENT_INFO_AVAILABLE)), TuplesKt.to(CustomEventField.REGISTRATION_METHOD, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.REGISTRATION_METHOD)), TuplesKt.to(CustomEventField.SEARCH_STRING, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.SEARCH_STRING)), TuplesKt.to(CustomEventField.SUCCESS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.SUCCESS)), TuplesKt.to(CustomEventField.ORDER_ID, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.ORDER_ID)), TuplesKt.to(CustomEventField.AD_TYPE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.AD_TYPE)));
        standardEventTransformations = MapsKt.mapOf(TuplesKt.to("fb_mobile_achievement_unlocked", ConversionsAPIEventName.UNLOCKED_ACHIEVEMENT), TuplesKt.to("fb_mobile_activate_app", ConversionsAPIEventName.ACTIVATED_APP), TuplesKt.to("fb_mobile_add_payment_info", ConversionsAPIEventName.ADDED_PAYMENT_INFO), TuplesKt.to("fb_mobile_add_to_cart", ConversionsAPIEventName.ADDED_TO_CART), TuplesKt.to("fb_mobile_add_to_wishlist", ConversionsAPIEventName.ADDED_TO_WISHLIST), TuplesKt.to("fb_mobile_complete_registration", ConversionsAPIEventName.COMPLETED_REGISTRATION), TuplesKt.to("fb_mobile_content_view", ConversionsAPIEventName.VIEWED_CONTENT), TuplesKt.to("fb_mobile_initiated_checkout", ConversionsAPIEventName.INITIATED_CHECKOUT), TuplesKt.to("fb_mobile_level_achieved", ConversionsAPIEventName.ACHIEVED_LEVEL), TuplesKt.to("fb_mobile_purchase", ConversionsAPIEventName.PURCHASED), TuplesKt.to("fb_mobile_rate", ConversionsAPIEventName.RATED), TuplesKt.to("fb_mobile_search", ConversionsAPIEventName.SEARCHED), TuplesKt.to("fb_mobile_spent_credits", ConversionsAPIEventName.SPENT_CREDITS), TuplesKt.to("fb_mobile_tutorial_completion", ConversionsAPIEventName.COMPLETED_TUTORIAL));
    }

    private AppEventsConversionsAPITransformer() {
    }

    private final List<Map<String, Object>> combineAllTransformedDataForCustom(Map<String, ? extends Object> commonFields, List<? extends Map<String, ? extends Object>> customEvents) {
        if (customEvents.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = customEvents.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(commonFields);
            linkedHashMap.putAll(map);
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    private final List<Map<String, Object>> combineAllTransformedDataForMobileAppInstall(Map<String, ? extends Object> commonFields, Object eventTime) {
        if (eventTime == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(commonFields);
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_NAME.getRawValue(), OtherEventConstants.MOBILE_APP_INSTALL.getRawValue());
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_TIME.getRawValue(), eventTime);
        return CollectionsKt.listOf(linkedHashMap);
    }

    private final AppEventType splitAppEventParameters(Map<String, ? extends Object> parameters, Map<String, Object> userData, Map<String, Object> appData, ArrayList<Map<String, Object>> customEvents, Map<String, Object> restOfData) {
        Object obj = parameters.get(OtherEventConstants.EVENT.getRawValue());
        AppEventType.Companion companion = AppEventType.INSTANCE;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        AppEventType invoke = companion.invoke((String) obj);
        if (invoke == AppEventType.OTHER) {
            return invoke;
        }
        for (Map.Entry<String, ? extends Object> entry : parameters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            AppEventUserAndAppDataField invoke2 = AppEventUserAndAppDataField.INSTANCE.invoke(key);
            if (invoke2 != null) {
                INSTANCE.transformAndUpdateAppAndUserData$facebook_core_release(userData, appData, invoke2, value);
            } else {
                boolean areEqual = Intrinsics.areEqual(key, ConversionsAPISection.CUSTOM_EVENTS.getRawValue());
                boolean z5 = value instanceof String;
                if (invoke == AppEventType.CUSTOM && areEqual && z5) {
                    ArrayList<Map<String, Object>> transformEvents$facebook_core_release = transformEvents$facebook_core_release((String) value);
                    if (transformEvents$facebook_core_release != null) {
                        customEvents.addAll(transformEvents$facebook_core_release);
                    }
                } else if (DataProcessingParameterName.INSTANCE.invoke(key) != null) {
                    restOfData.put(key, value);
                }
            }
        }
        return invoke;
    }

    private final void transformAndUpdateAppData(Map<String, Object> appData, AppEventUserAndAppDataField field, Object value) {
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(field);
        ConversionsAPIUserAndAppDataField field2 = sectionFieldMapping == null ? null : sectionFieldMapping.getField();
        if (field2 == null) {
            return;
        }
        appData.put(field2.getRawValue(), value);
    }

    private final void transformAndUpdateUserData(Map<String, Object> userData, AppEventUserAndAppDataField field, Object value) {
        if (field == AppEventUserAndAppDataField.USER_DATA) {
            try {
                Utility utility = Utility.INSTANCE;
                userData.putAll(Utility.convertJSONObjectToHashMap(new JSONObject((String) value)));
                return;
            } catch (JSONException e5) {
                Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", value, e5);
                return;
            }
        }
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(field);
        ConversionsAPIUserAndAppDataField field2 = sectionFieldMapping == null ? null : sectionFieldMapping.getField();
        if (field2 == null) {
            return;
        }
        userData.put(field2.getRawValue(), value);
    }

    private final String transformEventName(String input) {
        Map<String, ConversionsAPIEventName> map = standardEventTransformations;
        if (!map.containsKey(input)) {
            return input;
        }
        ConversionsAPIEventName conversionsAPIEventName = map.get(input);
        return conversionsAPIEventName == null ? BuildConfig.FLAVOR : conversionsAPIEventName.getRawValue();
    }

    public static final ArrayList<Map<String, Object>> transformEvents$facebook_core_release(String appEvents) {
        Intrinsics.checkNotNullParameter(appEvents, "appEvents");
        ArrayList<Map> arrayList = new ArrayList();
        try {
            Utility utility = Utility.INSTANCE;
            for (String str : Utility.convertJSONArrayToList(new JSONArray(appEvents))) {
                Utility utility2 = Utility.INSTANCE;
                arrayList.add(Utility.convertJSONObjectToHashMap(new JSONObject(str)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            ArrayList<Map<String, Object>> arrayList2 = new ArrayList<>();
            for (Map map : arrayList) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (String str2 : map.keySet()) {
                    CustomEventField invoke = CustomEventField.INSTANCE.invoke(str2);
                    SectionCustomEventFieldMapping sectionCustomEventFieldMapping = customEventTransformations.get(invoke);
                    if (invoke != null && sectionCustomEventFieldMapping != null) {
                        ConversionsAPISection section = sectionCustomEventFieldMapping.getSection();
                        if (section == null) {
                            try {
                                String rawValue = sectionCustomEventFieldMapping.getField().getRawValue();
                                if (invoke == CustomEventField.EVENT_NAME && ((String) map.get(str2)) != null) {
                                    AppEventsConversionsAPITransformer appEventsConversionsAPITransformer = INSTANCE;
                                    Object obj = map.get(str2);
                                    if (obj == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    linkedHashMap2.put(rawValue, appEventsConversionsAPITransformer.transformEventName((String) obj));
                                } else if (invoke == CustomEventField.EVENT_TIME && ((Integer) map.get(str2)) != null) {
                                    Object obj2 = map.get(str2);
                                    if (obj2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                    Object transformValue$facebook_core_release = transformValue$facebook_core_release(str2, obj2);
                                    if (transformValue$facebook_core_release == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                    linkedHashMap2.put(rawValue, transformValue$facebook_core_release);
                                }
                            } catch (ClassCastException e5) {
                                Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents ClassCastException: \n %s ", ExceptionsKt.stackTraceToString(e5));
                            }
                        } else if (section == ConversionsAPISection.CUSTOM_DATA) {
                            String rawValue2 = sectionCustomEventFieldMapping.getField().getRawValue();
                            Object obj3 = map.get(str2);
                            if (obj3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                            }
                            Object transformValue$facebook_core_release2 = transformValue$facebook_core_release(str2, obj3);
                            if (transformValue$facebook_core_release2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                            }
                            linkedHashMap.put(rawValue2, transformValue$facebook_core_release2);
                        } else {
                            continue;
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put(ConversionsAPISection.CUSTOM_DATA.getRawValue(), linkedHashMap);
                }
                arrayList2.add(linkedHashMap2);
            }
            return arrayList2;
        } catch (JSONException e6) {
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", appEvents, e6);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.Map] */
    public static final Object transformValue$facebook_core_release(String field, Object value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        ValueTransformationType invoke = ValueTransformationType.INSTANCE.invoke(field);
        String str = value instanceof String ? (String) value : null;
        if (invoke == null || str == null) {
            return value;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[invoke.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return StringsKt.toIntOrNull(value.toString());
                }
                throw new NoWhenBranchMatchedException();
            }
            Integer intOrNull = StringsKt.toIntOrNull(str.toString());
            if (intOrNull != null) {
                return Boolean.valueOf(intOrNull.intValue() != 0);
            }
            return null;
        }
        try {
            Utility utility = Utility.INSTANCE;
            List<String> convertJSONArrayToList = Utility.convertJSONArrayToList(new JSONArray(str));
            ArrayList arrayList = new ArrayList();
            Iterator it = convertJSONArrayToList.iterator();
            while (it.hasNext()) {
                ?? r12 = (String) it.next();
                try {
                    try {
                        Utility utility2 = Utility.INSTANCE;
                        r12 = Utility.convertJSONObjectToHashMap(new JSONObject((String) r12));
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    Utility utility3 = Utility.INSTANCE;
                    r12 = Utility.convertJSONArrayToList(new JSONArray((String) r12));
                }
                arrayList.add(r12);
            }
            return arrayList;
        } catch (JSONException e5) {
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", value, e5);
            return Unit.INSTANCE;
        }
    }

    public final List<Map<String, Object>> combineAllTransformedData$facebook_core_release(AppEventType eventType, Map<String, Object> userData, Map<String, Object> appData, Map<String, Object> restOfData, List<? extends Map<String, ? extends Object>> customEvents, Object eventTime) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(restOfData, "restOfData");
        Intrinsics.checkNotNullParameter(customEvents, "customEvents");
        Map<String, Object> combineCommonFields$facebook_core_release = combineCommonFields$facebook_core_release(userData, appData, restOfData);
        int i5 = WhenMappings.$EnumSwitchMapping$2[eventType.ordinal()];
        if (i5 == 1) {
            return combineAllTransformedDataForMobileAppInstall(combineCommonFields$facebook_core_release, eventTime);
        }
        if (i5 != 2) {
            return null;
        }
        return combineAllTransformedDataForCustom(combineCommonFields$facebook_core_release, customEvents);
    }

    public final Map<String, Object> combineCommonFields$facebook_core_release(Map<String, ? extends Object> userData, Map<String, ? extends Object> appData, Map<String, ? extends Object> restOfData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(restOfData, "restOfData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(OtherEventConstants.ACTION_SOURCE.getRawValue(), OtherEventConstants.APP.getRawValue());
        linkedHashMap.put(ConversionsAPISection.USER_DATA.getRawValue(), userData);
        linkedHashMap.put(ConversionsAPISection.APP_DATA.getRawValue(), appData);
        linkedHashMap.putAll(restOfData);
        return linkedHashMap;
    }

    public final List<Map<String, Object>> conversionsAPICompatibleEvent$facebook_core_release(Map<String, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        AppEventType splitAppEventParameters = splitAppEventParameters(parameters, linkedHashMap, linkedHashMap2, arrayList, linkedHashMap3);
        if (splitAppEventParameters == AppEventType.OTHER) {
            return null;
        }
        return combineAllTransformedData$facebook_core_release(splitAppEventParameters, linkedHashMap, linkedHashMap2, linkedHashMap3, arrayList, parameters.get(OtherEventConstants.INSTALL_EVENT_TIME.getRawValue()));
    }

    public final void transformAndUpdateAppAndUserData$facebook_core_release(Map<String, Object> userData, Map<String, Object> appData, AppEventUserAndAppDataField field, Object value) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(field);
        if (sectionFieldMapping == null) {
            return;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$1[sectionFieldMapping.getSection().ordinal()];
        if (i5 == 1) {
            transformAndUpdateAppData(appData, field, value);
        } else {
            if (i5 != 2) {
                return;
            }
            transformAndUpdateUserData(userData, field, value);
        }
    }
}
