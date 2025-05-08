package dk.molslinjen.domain.model.shared;

import dk.molslinjen.api.services.account.response.AccountInfoResponseDTO;
import dk.molslinjen.api.services.account.response.AccountUpdateInfoResponseDTO;
import dk.molslinjen.api.shared.response.PhoneNumberDTO;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.core.extensions.LocaleExtensionsKt;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bB/\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0005\u0010\u0010J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/shared/PhoneNumber;", BuildConfig.FLAVOR, "countryCode", BuildConfig.FLAVOR, "nationalNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "accountInfo", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "(Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;)V", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "(Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCountryCode", "()Ljava/lang/String;", "getNationalNumber", "toFormattedString", "toDto", "Ldk/molslinjen/api/shared/response/PhoneNumberDTO;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PhoneNumber {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String countryCode;
    private final String nationalNumber;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/model/shared/PhoneNumber$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "asValidPhoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "countryCode", BuildConfig.FLAVOR, "nationalNumber", "default", "locale", "Ljava/util/Locale;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ PhoneNumber default$default(Companion companion, Locale locale, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                locale = Locale.getDefault();
            }
            return companion.m3247default(locale);
        }

        public final PhoneNumber asValidPhoneNumber(String countryCode, String nationalNumber) {
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            Intrinsics.checkNotNullParameter(nationalNumber, "nationalNumber");
            return new PhoneNumber(StringExtensionsKt.toFormattedCountryCode(countryCode), nationalNumber);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: default, reason: not valid java name */
        public final PhoneNumber m3247default(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            String phoneNumberCountryCode = LocaleExtensionsKt.getPhoneNumberCountryCode(locale);
            if (phoneNumberCountryCode == null && (phoneNumberCountryCode = LocaleExtensionsKt.getPhoneNumberCountryCode(Constants.Defaults.INSTANCE.getDefaultNationality())) == null) {
                phoneNumberCountryCode = BuildConfig.FLAVOR;
            }
            return new PhoneNumber(phoneNumberCountryCode, (String) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public final KSerializer<PhoneNumber> serializer() {
            return PhoneNumber$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneNumber() {
        this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ PhoneNumber copy$default(PhoneNumber phoneNumber, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = phoneNumber.countryCode;
        }
        if ((i5 & 2) != 0) {
            str2 = phoneNumber.nationalNumber;
        }
        return phoneNumber.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(PhoneNumber self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.countryCode, BuildConfig.FLAVOR)) {
            output.encodeStringElement(serialDesc, 0, self.countryCode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.nationalNumber, BuildConfig.FLAVOR)) {
            return;
        }
        output.encodeStringElement(serialDesc, 1, self.nationalNumber);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNationalNumber() {
        return this.nationalNumber;
    }

    public final PhoneNumber copy(String countryCode, String nationalNumber) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(nationalNumber, "nationalNumber");
        return new PhoneNumber(countryCode, nationalNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) other;
        return Intrinsics.areEqual(this.countryCode, phoneNumber.countryCode) && Intrinsics.areEqual(this.nationalNumber, phoneNumber.nationalNumber);
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getNationalNumber() {
        return this.nationalNumber;
    }

    public int hashCode() {
        return (this.countryCode.hashCode() * 31) + this.nationalNumber.hashCode();
    }

    public final PhoneNumberDTO toDto() {
        return new PhoneNumberDTO(this.countryCode, this.nationalNumber);
    }

    public final String toFormattedString() {
        return this.countryCode + " " + AccessibilityKt.splitNumberForAccessibility(this.nationalNumber);
    }

    public String toString() {
        return "PhoneNumber(countryCode=" + this.countryCode + ", nationalNumber=" + this.nationalNumber + ")";
    }

    public /* synthetic */ PhoneNumber(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i5 & 1) == 0) {
            this.countryCode = BuildConfig.FLAVOR;
        } else {
            this.countryCode = str;
        }
        if ((i5 & 2) == 0) {
            this.nationalNumber = BuildConfig.FLAVOR;
        } else {
            this.nationalNumber = str2;
        }
    }

    public PhoneNumber(String countryCode, String nationalNumber) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(nationalNumber, "nationalNumber");
        this.countryCode = countryCode;
        this.nationalNumber = nationalNumber;
    }

    public /* synthetic */ PhoneNumber(String str, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhoneNumber(AccountInfoResponseDTO accountInfo) {
        this(StringExtensionsKt.toFormattedCountryCode(accountInfo.getPhoneNumberPrefix()), accountInfo.getPhoneNumber());
        Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhoneNumber(AccountUpdateInfoResponseDTO accountInfo) {
        this(StringExtensionsKt.toFormattedCountryCode(accountInfo.getPhoneNumberPrefix()), accountInfo.getPhoneNumber());
        Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
    }
}
