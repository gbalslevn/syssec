package dk.molslinjen.api.services.saleOnBoard.request;

import com.adjust.sdk.Constants;
import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 N2\u00020\u0001:\bGHIJKLMNBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014B\u008d\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J}\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u000bHÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\bFR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001aR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001aR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006O"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "phoneIncludingRegionCode", "email", "notificationMethod", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;", "timetableId", "storeNumber", "timeSlotId", BuildConfig.FLAVOR, "lines", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters;", "transactionId", "paymentMethodCode", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters;", "notificationLanguage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getPhoneIncludingRegionCode$annotations", "()V", "getPhoneIncludingRegionCode", "getEmail", "getNotificationMethod", "()Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;", "getTimetableId$annotations", "getTimetableId", "getStoreNumber$annotations", "getStoreNumber", "getTimeSlotId$annotations", "getTimeSlotId", "()I", "getLines", "()Ljava/util/List;", "getTransactionId", "getPaymentMethodCode", "()Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters;", "getNotificationLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "LineRequestParameters", "LineItemRequestParameters", "AddOnRequestParameters", "VariantRequestParameters", "NotificationTypeRequestParameters", "PaymentMethodRequestParameters", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PatchOrderRequestParameters {
    private final String email;
    private final List<LineRequestParameters> lines;
    private final String name;
    private final String notificationLanguage;
    private final NotificationTypeRequestParameters notificationMethod;
    private final PaymentMethodRequestParameters paymentMethodCode;
    private final String phoneIncludingRegionCode;
    private final String storeNumber;
    private final int timeSlotId;
    private final String timetableId;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, NotificationTypeRequestParameters.INSTANCE.serializer(), null, null, null, new ArrayListSerializer(LineRequestParameters.INSTANCE.serializer()), null, PaymentMethodRequestParameters.INSTANCE.serializer(), null};

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$AddOnRequestParameters;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters;", "itemNumber", BuildConfig.FLAVOR, "description", "price", BuildConfig.FLAVOR, "quantity", BuildConfig.FLAVOR, "addOn", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;DIZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;DIZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemNumber$annotations", "()V", "getItemNumber", "()Ljava/lang/String;", "getDescription", "getPrice", "()D", "getQuantity", "()I", "getAddOn", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class AddOnRequestParameters extends LineRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean addOn;
        private final String description;
        private final String itemNumber;
        private final double price;
        private final int quantity;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$AddOnRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$AddOnRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<AddOnRequestParameters> serializer() {
                return PatchOrderRequestParameters$AddOnRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AddOnRequestParameters(int i5, String str, String str2, double d5, int i6, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
            super(i5, serializationConstructorMarker);
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, PatchOrderRequestParameters$AddOnRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.itemNumber = str;
            this.description = str2;
            this.price = d5;
            this.quantity = i6;
            this.addOn = z5;
        }

        public static /* synthetic */ AddOnRequestParameters copy$default(AddOnRequestParameters addOnRequestParameters, String str, String str2, double d5, int i5, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = addOnRequestParameters.itemNumber;
            }
            if ((i6 & 2) != 0) {
                str2 = addOnRequestParameters.description;
            }
            String str3 = str2;
            if ((i6 & 4) != 0) {
                d5 = addOnRequestParameters.price;
            }
            double d6 = d5;
            if ((i6 & 8) != 0) {
                i5 = addOnRequestParameters.quantity;
            }
            int i7 = i5;
            if ((i6 & 16) != 0) {
                z5 = addOnRequestParameters.addOn;
            }
            return addOnRequestParameters.copy(str, str3, d6, i7, z5);
        }

        public static /* synthetic */ void getItemNumber$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(AddOnRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            LineRequestParameters.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.itemNumber);
            output.encodeStringElement(serialDesc, 1, self.getDescription());
            output.encodeDoubleElement(serialDesc, 2, self.price);
            output.encodeIntElement(serialDesc, 3, self.quantity);
            output.encodeBooleanElement(serialDesc, 4, self.addOn);
        }

        /* renamed from: component1, reason: from getter */
        public final String getItemNumber() {
            return this.itemNumber;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final double getPrice() {
            return this.price;
        }

        /* renamed from: component4, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAddOn() {
            return this.addOn;
        }

        public final AddOnRequestParameters copy(String itemNumber, String description, double price, int quantity, boolean addOn) {
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            Intrinsics.checkNotNullParameter(description, "description");
            return new AddOnRequestParameters(itemNumber, description, price, quantity, addOn);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddOnRequestParameters)) {
                return false;
            }
            AddOnRequestParameters addOnRequestParameters = (AddOnRequestParameters) other;
            return Intrinsics.areEqual(this.itemNumber, addOnRequestParameters.itemNumber) && Intrinsics.areEqual(this.description, addOnRequestParameters.description) && Double.compare(this.price, addOnRequestParameters.price) == 0 && this.quantity == addOnRequestParameters.quantity && this.addOn == addOnRequestParameters.addOn;
        }

        public final boolean getAddOn() {
            return this.addOn;
        }

        @Override // dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.LineRequestParameters
        public String getDescription() {
            return this.description;
        }

        public final String getItemNumber() {
            return this.itemNumber;
        }

        public final double getPrice() {
            return this.price;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            return (((((((this.itemNumber.hashCode() * 31) + this.description.hashCode()) * 31) + Double.hashCode(this.price)) * 31) + Integer.hashCode(this.quantity)) * 31) + Boolean.hashCode(this.addOn);
        }

        public String toString() {
            return "AddOnRequestParameters(itemNumber=" + this.itemNumber + ", description=" + this.description + ", price=" + this.price + ", quantity=" + this.quantity + ", addOn=" + this.addOn + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddOnRequestParameters(String itemNumber, String description, double d5, int i5, boolean z5) {
            super(null);
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            Intrinsics.checkNotNullParameter(description, "description");
            this.itemNumber = itemNumber;
            this.description = description;
            this.price = d5;
            this.quantity = i5;
            this.addOn = z5;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PatchOrderRequestParameters> serializer() {
            return PatchOrderRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineItemRequestParameters;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters;", "itemNumber", BuildConfig.FLAVOR, "description", "price", BuildConfig.FLAVOR, "quantity", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;DI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;DILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemNumber$annotations", "()V", "getItemNumber", "()Ljava/lang/String;", "getDescription", "getPrice", "()D", "getQuantity", "()I", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class LineItemRequestParameters extends LineRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;
        private final String itemNumber;
        private final double price;
        private final int quantity;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineItemRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineItemRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<LineItemRequestParameters> serializer() {
                return PatchOrderRequestParameters$LineItemRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LineItemRequestParameters(int i5, String str, String str2, double d5, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i5, serializationConstructorMarker);
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, PatchOrderRequestParameters$LineItemRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.itemNumber = str;
            this.description = str2;
            this.price = d5;
            this.quantity = i6;
        }

        public static /* synthetic */ LineItemRequestParameters copy$default(LineItemRequestParameters lineItemRequestParameters, String str, String str2, double d5, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = lineItemRequestParameters.itemNumber;
            }
            if ((i6 & 2) != 0) {
                str2 = lineItemRequestParameters.description;
            }
            String str3 = str2;
            if ((i6 & 4) != 0) {
                d5 = lineItemRequestParameters.price;
            }
            double d6 = d5;
            if ((i6 & 8) != 0) {
                i5 = lineItemRequestParameters.quantity;
            }
            return lineItemRequestParameters.copy(str, str3, d6, i5);
        }

        public static /* synthetic */ void getItemNumber$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(LineItemRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            LineRequestParameters.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.itemNumber);
            output.encodeStringElement(serialDesc, 1, self.getDescription());
            output.encodeDoubleElement(serialDesc, 2, self.price);
            output.encodeIntElement(serialDesc, 3, self.quantity);
        }

        /* renamed from: component1, reason: from getter */
        public final String getItemNumber() {
            return this.itemNumber;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final double getPrice() {
            return this.price;
        }

        /* renamed from: component4, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        public final LineItemRequestParameters copy(String itemNumber, String description, double price, int quantity) {
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            Intrinsics.checkNotNullParameter(description, "description");
            return new LineItemRequestParameters(itemNumber, description, price, quantity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LineItemRequestParameters)) {
                return false;
            }
            LineItemRequestParameters lineItemRequestParameters = (LineItemRequestParameters) other;
            return Intrinsics.areEqual(this.itemNumber, lineItemRequestParameters.itemNumber) && Intrinsics.areEqual(this.description, lineItemRequestParameters.description) && Double.compare(this.price, lineItemRequestParameters.price) == 0 && this.quantity == lineItemRequestParameters.quantity;
        }

        @Override // dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.LineRequestParameters
        public String getDescription() {
            return this.description;
        }

        public final String getItemNumber() {
            return this.itemNumber;
        }

        public final double getPrice() {
            return this.price;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            return (((((this.itemNumber.hashCode() * 31) + this.description.hashCode()) * 31) + Double.hashCode(this.price)) * 31) + Integer.hashCode(this.quantity);
        }

        public String toString() {
            return "LineItemRequestParameters(itemNumber=" + this.itemNumber + ", description=" + this.description + ", price=" + this.price + ", quantity=" + this.quantity + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LineItemRequestParameters(String itemNumber, String description, double d5, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            Intrinsics.checkNotNullParameter(description, "description");
            this.itemNumber = itemNumber;
            this.description = description;
            this.price = d5;
            this.quantity = i5;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0003\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters;", BuildConfig.FLAVOR, "<init>", "()V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "description", BuildConfig.FLAVOR, "getDescription", "()Ljava/lang/String;", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$AddOnRequestParameters;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineItemRequestParameters;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$VariantRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static abstract class LineRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: r1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = PatchOrderRequestParameters.LineRequestParameters._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) LineRequestParameters.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<LineRequestParameters> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ LineRequestParameters(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new SealedClassSerializer("dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.LineRequestParameters", Reflection.getOrCreateKotlinClass(LineRequestParameters.class), new KClass[]{Reflection.getOrCreateKotlinClass(AddOnRequestParameters.class), Reflection.getOrCreateKotlinClass(LineItemRequestParameters.class), Reflection.getOrCreateKotlinClass(VariantRequestParameters.class)}, new KSerializer[]{PatchOrderRequestParameters$AddOnRequestParameters$$serializer.INSTANCE, PatchOrderRequestParameters$LineItemRequestParameters$$serializer.INSTANCE, PatchOrderRequestParameters$VariantRequestParameters$$serializer.INSTANCE}, new Annotation[0]);
        }

        public static final /* synthetic */ void write$Self(LineRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        }

        public abstract String getDescription();

        private LineRequestParameters() {
        }

        public /* synthetic */ LineRequestParameters(int i5, SerializationConstructorMarker serializationConstructorMarker) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Sms", "Push", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final class NotificationTypeRequestParameters {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NotificationTypeRequestParameters[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final NotificationTypeRequestParameters Sms = new NotificationTypeRequestParameters("Sms", 0);
        public static final NotificationTypeRequestParameters Push = new NotificationTypeRequestParameters("Push", 1);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) NotificationTypeRequestParameters.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<NotificationTypeRequestParameters> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ NotificationTypeRequestParameters[] $values() {
            return new NotificationTypeRequestParameters[]{Sms, Push};
        }

        static {
            NotificationTypeRequestParameters[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: r1.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = PatchOrderRequestParameters.NotificationTypeRequestParameters._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
        }

        private NotificationTypeRequestParameters(String str, int i5) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.NotificationTypeRequestParameters", values(), new String[]{"sms", Constants.PUSH}, new Annotation[][]{null, null}, null);
        }

        public static EnumEntries<NotificationTypeRequestParameters> getEntries() {
            return $ENTRIES;
        }

        public static NotificationTypeRequestParameters valueOf(String str) {
            return (NotificationTypeRequestParameters) Enum.valueOf(NotificationTypeRequestParameters.class, str);
        }

        public static NotificationTypeRequestParameters[] values() {
            return (NotificationTypeRequestParameters[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "VisaMastercard", "Dankort", "Other", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final class PaymentMethodRequestParameters {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PaymentMethodRequestParameters[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String rawValue;
        public static final PaymentMethodRequestParameters VisaMastercard = new PaymentMethodRequestParameters("VisaMastercard", 0, "937");
        public static final PaymentMethodRequestParameters Dankort = new PaymentMethodRequestParameters("Dankort", 1, "901");
        public static final PaymentMethodRequestParameters Other = new PaymentMethodRequestParameters("Other", 2, "000");

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$PaymentMethodRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) PaymentMethodRequestParameters.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<PaymentMethodRequestParameters> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ PaymentMethodRequestParameters[] $values() {
            return new PaymentMethodRequestParameters[]{VisaMastercard, Dankort, Other};
        }

        static {
            PaymentMethodRequestParameters[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: r1.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = PatchOrderRequestParameters.PaymentMethodRequestParameters._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
        }

        private PaymentMethodRequestParameters(String str, int i5, String str2) {
            this.rawValue = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.PaymentMethodRequestParameters", values(), new String[]{"937", "901", "000"}, new Annotation[][]{null, null, null}, null);
        }

        public static EnumEntries<PaymentMethodRequestParameters> getEntries() {
            return $ENTRIES;
        }

        public static PaymentMethodRequestParameters valueOf(String str) {
            return (PaymentMethodRequestParameters) Enum.valueOf(PaymentMethodRequestParameters.class, str);
        }

        public static PaymentMethodRequestParameters[] values() {
            return (PaymentMethodRequestParameters[]) $VALUES.clone();
        }

        public final String getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$VariantRequestParameters;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$LineRequestParameters;", "description", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class VariantRequestParameters extends LineRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$VariantRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$VariantRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<VariantRequestParameters> serializer() {
                return PatchOrderRequestParameters$VariantRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VariantRequestParameters(int i5, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i5, serializationConstructorMarker);
            if (1 != (i5 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 1, PatchOrderRequestParameters$VariantRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.description = str;
        }

        public static /* synthetic */ VariantRequestParameters copy$default(VariantRequestParameters variantRequestParameters, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = variantRequestParameters.description;
            }
            return variantRequestParameters.copy(str);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(VariantRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            LineRequestParameters.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.getDescription());
        }

        /* renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final VariantRequestParameters copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new VariantRequestParameters(description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VariantRequestParameters) && Intrinsics.areEqual(this.description, ((VariantRequestParameters) other).description);
        }

        @Override // dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters.LineRequestParameters
        public String getDescription() {
            return this.description;
        }

        public int hashCode() {
            return this.description.hashCode();
        }

        public String toString() {
            return "VariantRequestParameters(description=" + this.description + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VariantRequestParameters(String description) {
            super(null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }
    }

    public /* synthetic */ PatchOrderRequestParameters(int i5, String str, String str2, String str3, NotificationTypeRequestParameters notificationTypeRequestParameters, String str4, String str5, int i6, List list, String str6, PaymentMethodRequestParameters paymentMethodRequestParameters, String str7, SerializationConstructorMarker serializationConstructorMarker) {
        if (1023 != (i5 & 1023)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1023, PatchOrderRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.phoneIncludingRegionCode = str2;
        this.email = str3;
        this.notificationMethod = notificationTypeRequestParameters;
        this.timetableId = str4;
        this.storeNumber = str5;
        this.timeSlotId = i6;
        this.lines = list;
        this.transactionId = str6;
        this.paymentMethodCode = paymentMethodRequestParameters;
        if ((i5 & 1024) == 0) {
            this.notificationLanguage = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "da") ? "da" : "en";
        } else {
            this.notificationLanguage = str7;
        }
    }

    public static /* synthetic */ void getPhoneIncludingRegionCode$annotations() {
    }

    public static /* synthetic */ void getStoreNumber$annotations() {
    }

    public static /* synthetic */ void getTimeSlotId$annotations() {
    }

    public static /* synthetic */ void getTimetableId$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(PatchOrderRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.phoneIncludingRegionCode);
        output.encodeStringElement(serialDesc, 2, self.email);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.notificationMethod);
        output.encodeStringElement(serialDesc, 4, self.timetableId);
        output.encodeStringElement(serialDesc, 5, self.storeNumber);
        output.encodeIntElement(serialDesc, 6, self.timeSlotId);
        output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.lines);
        output.encodeStringElement(serialDesc, 8, self.transactionId);
        output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.paymentMethodCode);
        if (!output.shouldEncodeElementDefault(serialDesc, 10)) {
            if (Intrinsics.areEqual(self.notificationLanguage, Intrinsics.areEqual(Locale.getDefault().getLanguage(), "da") ? "da" : "en")) {
                return;
            }
        }
        output.encodeStringElement(serialDesc, 10, self.notificationLanguage);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final PaymentMethodRequestParameters getPaymentMethodCode() {
        return this.paymentMethodCode;
    }

    /* renamed from: component11, reason: from getter */
    public final String getNotificationLanguage() {
        return this.notificationLanguage;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhoneIncludingRegionCode() {
        return this.phoneIncludingRegionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component4, reason: from getter */
    public final NotificationTypeRequestParameters getNotificationMethod() {
        return this.notificationMethod;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTimetableId() {
        return this.timetableId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStoreNumber() {
        return this.storeNumber;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTimeSlotId() {
        return this.timeSlotId;
    }

    public final List<LineRequestParameters> component8() {
        return this.lines;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    public final PatchOrderRequestParameters copy(String name, String phoneIncludingRegionCode, String email, NotificationTypeRequestParameters notificationMethod, String timetableId, String storeNumber, int timeSlotId, List<? extends LineRequestParameters> lines, String transactionId, PaymentMethodRequestParameters paymentMethodCode, String notificationLanguage) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneIncludingRegionCode, "phoneIncludingRegionCode");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(notificationMethod, "notificationMethod");
        Intrinsics.checkNotNullParameter(timetableId, "timetableId");
        Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(paymentMethodCode, "paymentMethodCode");
        Intrinsics.checkNotNullParameter(notificationLanguage, "notificationLanguage");
        return new PatchOrderRequestParameters(name, phoneIncludingRegionCode, email, notificationMethod, timetableId, storeNumber, timeSlotId, lines, transactionId, paymentMethodCode, notificationLanguage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchOrderRequestParameters)) {
            return false;
        }
        PatchOrderRequestParameters patchOrderRequestParameters = (PatchOrderRequestParameters) other;
        return Intrinsics.areEqual(this.name, patchOrderRequestParameters.name) && Intrinsics.areEqual(this.phoneIncludingRegionCode, patchOrderRequestParameters.phoneIncludingRegionCode) && Intrinsics.areEqual(this.email, patchOrderRequestParameters.email) && this.notificationMethod == patchOrderRequestParameters.notificationMethod && Intrinsics.areEqual(this.timetableId, patchOrderRequestParameters.timetableId) && Intrinsics.areEqual(this.storeNumber, patchOrderRequestParameters.storeNumber) && this.timeSlotId == patchOrderRequestParameters.timeSlotId && Intrinsics.areEqual(this.lines, patchOrderRequestParameters.lines) && Intrinsics.areEqual(this.transactionId, patchOrderRequestParameters.transactionId) && this.paymentMethodCode == patchOrderRequestParameters.paymentMethodCode && Intrinsics.areEqual(this.notificationLanguage, patchOrderRequestParameters.notificationLanguage);
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<LineRequestParameters> getLines() {
        return this.lines;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNotificationLanguage() {
        return this.notificationLanguage;
    }

    public final NotificationTypeRequestParameters getNotificationMethod() {
        return this.notificationMethod;
    }

    public final PaymentMethodRequestParameters getPaymentMethodCode() {
        return this.paymentMethodCode;
    }

    public final String getPhoneIncludingRegionCode() {
        return this.phoneIncludingRegionCode;
    }

    public final String getStoreNumber() {
        return this.storeNumber;
    }

    public final int getTimeSlotId() {
        return this.timeSlotId;
    }

    public final String getTimetableId() {
        return this.timetableId;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        return (((((((((((((((((((this.name.hashCode() * 31) + this.phoneIncludingRegionCode.hashCode()) * 31) + this.email.hashCode()) * 31) + this.notificationMethod.hashCode()) * 31) + this.timetableId.hashCode()) * 31) + this.storeNumber.hashCode()) * 31) + Integer.hashCode(this.timeSlotId)) * 31) + this.lines.hashCode()) * 31) + this.transactionId.hashCode()) * 31) + this.paymentMethodCode.hashCode()) * 31) + this.notificationLanguage.hashCode();
    }

    public String toString() {
        return "PatchOrderRequestParameters(name=" + this.name + ", phoneIncludingRegionCode=" + this.phoneIncludingRegionCode + ", email=" + this.email + ", notificationMethod=" + this.notificationMethod + ", timetableId=" + this.timetableId + ", storeNumber=" + this.storeNumber + ", timeSlotId=" + this.timeSlotId + ", lines=" + this.lines + ", transactionId=" + this.transactionId + ", paymentMethodCode=" + this.paymentMethodCode + ", notificationLanguage=" + this.notificationLanguage + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PatchOrderRequestParameters(String name, String phoneIncludingRegionCode, String email, NotificationTypeRequestParameters notificationMethod, String timetableId, String storeNumber, int i5, List<? extends LineRequestParameters> lines, String transactionId, PaymentMethodRequestParameters paymentMethodCode, String notificationLanguage) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneIncludingRegionCode, "phoneIncludingRegionCode");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(notificationMethod, "notificationMethod");
        Intrinsics.checkNotNullParameter(timetableId, "timetableId");
        Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(paymentMethodCode, "paymentMethodCode");
        Intrinsics.checkNotNullParameter(notificationLanguage, "notificationLanguage");
        this.name = name;
        this.phoneIncludingRegionCode = phoneIncludingRegionCode;
        this.email = email;
        this.notificationMethod = notificationMethod;
        this.timetableId = timetableId;
        this.storeNumber = storeNumber;
        this.timeSlotId = i5;
        this.lines = lines;
        this.transactionId = transactionId;
        this.paymentMethodCode = paymentMethodCode;
        this.notificationLanguage = notificationLanguage;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PatchOrderRequestParameters(String str, String str2, String str3, NotificationTypeRequestParameters notificationTypeRequestParameters, String str4, String str5, int i5, List list, String str6, PaymentMethodRequestParameters paymentMethodRequestParameters, String str7, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, notificationTypeRequestParameters, str4, str5, i5, list, str6, paymentMethodRequestParameters, r12);
        String str8;
        if ((i6 & 1024) != 0) {
            str8 = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "da") ? "da" : "en";
        } else {
            str8 = str7;
        }
    }
}
