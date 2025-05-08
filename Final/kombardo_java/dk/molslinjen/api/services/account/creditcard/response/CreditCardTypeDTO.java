package dk.molslinjen.api.services.account.creditcard.response;

import dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Dankort", "Visa", "MasterCard", "Maestro", "Other", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class CreditCardTypeDTO {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CreditCardTypeDTO[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final CreditCardTypeDTO Dankort = new CreditCardTypeDTO("Dankort", 0);
    public static final CreditCardTypeDTO Visa = new CreditCardTypeDTO("Visa", 1);
    public static final CreditCardTypeDTO MasterCard = new CreditCardTypeDTO("MasterCard", 2);
    public static final CreditCardTypeDTO Maestro = new CreditCardTypeDTO("Maestro", 3);
    public static final CreditCardTypeDTO Other = new CreditCardTypeDTO("Other", 4);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CreditCardTypeDTO.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CreditCardTypeDTO> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ CreditCardTypeDTO[] $values() {
        return new CreditCardTypeDTO[]{Dankort, Visa, MasterCard, Maestro, Other};
    }

    static {
        CreditCardTypeDTO[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: q1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = CreditCardTypeDTO._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }

    private CreditCardTypeDTO(String str, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO", values(), new String[]{"DANKORT", "VISA", "MASTERCARD", "MAESTRO", null}, new Annotation[][]{null, null, null, null, null}, null);
    }

    public static EnumEntries<CreditCardTypeDTO> getEntries() {
        return $ENTRIES;
    }

    public static CreditCardTypeDTO valueOf(String str) {
        return (CreditCardTypeDTO) Enum.valueOf(CreditCardTypeDTO.class, str);
    }

    public static CreditCardTypeDTO[] values() {
        return (CreditCardTypeDTO[]) $VALUES.clone();
    }
}
