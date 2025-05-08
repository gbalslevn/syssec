package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.domain.model.booking.RouteDirection;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/RouteDirection;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Outbound", "Return", "flip", "toDTO", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class RouteDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RouteDirection[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final RouteDirection Outbound = new RouteDirection("Outbound", 0);
    public static final RouteDirection Return = new RouteDirection("Return", 1);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/RouteDirection$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "dto", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DirectionDTO.values().length];
                try {
                    iArr[DirectionDTO.Outbound.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DirectionDTO.Return.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) RouteDirection.$cachedSerializer$delegate.getValue();
        }

        public final RouteDirection invoke(DirectionDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return RouteDirection.Outbound;
            }
            if (i5 == 2) {
                return RouteDirection.Return;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final KSerializer<RouteDirection> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RouteDirection.values().length];
            try {
                iArr[RouteDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RouteDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ RouteDirection[] $values() {
        return new RouteDirection[]{Outbound, Return};
    }

    static {
        RouteDirection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: K1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = RouteDirection._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }

    private RouteDirection(String str, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.RouteDirection", values());
    }

    public static EnumEntries<RouteDirection> getEntries() {
        return $ENTRIES;
    }

    public static RouteDirection valueOf(String str) {
        return (RouteDirection) Enum.valueOf(RouteDirection.class, str);
    }

    public static RouteDirection[] values() {
        return (RouteDirection[]) $VALUES.clone();
    }

    public final RouteDirection flip() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return Return;
        }
        if (i5 == 2) {
            return Outbound;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final DirectionDTO toDTO() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return DirectionDTO.Outbound;
        }
        if (i5 == 2) {
            return DirectionDTO.Return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
