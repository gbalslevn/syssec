package dk.molslinjen.core;

import dk.molslinjen.core.ApiEnvironment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/ApiEnvironment;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "QA", "Stage", "Prod", "Companion", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class ApiEnvironment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiEnvironment[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ApiEnvironment QA = new ApiEnvironment("QA", 0);
    public static final ApiEnvironment Stage = new ApiEnvironment("Stage", 1);
    public static final ApiEnvironment Prod = new ApiEnvironment("Prod", 2);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/core/ApiEnvironment$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "from", "Ldk/molslinjen/core/ApiEnvironment;", "environment", "Ldk/molslinjen/core/Environment;", "serializer", "Lkotlinx/serialization/KSerializer;", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Environment.values().length];
                try {
                    iArr[Environment.Dev.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Environment.Test.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Environment.ProdTest.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Environment.Prod.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) ApiEnvironment.$cachedSerializer$delegate.getValue();
        }

        public final ApiEnvironment from(Environment environment) {
            Intrinsics.checkNotNullParameter(environment, "environment");
            int i5 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
            if (i5 == 1) {
                return ApiEnvironment.QA;
            }
            if (i5 == 2) {
                return ApiEnvironment.Stage;
            }
            if (i5 == 3 || i5 == 4) {
                return ApiEnvironment.Prod;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final KSerializer<ApiEnvironment> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ApiEnvironment[] $values() {
        return new ApiEnvironment[]{QA, Stage, Prod};
    }

    static {
        ApiEnvironment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: t1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = ApiEnvironment._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }

    private ApiEnvironment(String str, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("dk.molslinjen.core.ApiEnvironment", values());
    }

    public static ApiEnvironment valueOf(String str) {
        return (ApiEnvironment) Enum.valueOf(ApiEnvironment.class, str);
    }

    public static ApiEnvironment[] values() {
        return (ApiEnvironment[]) $VALUES.clone();
    }
}
