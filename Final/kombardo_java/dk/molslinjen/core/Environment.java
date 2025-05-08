package dk.molslinjen.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\r"}, d2 = {"Ldk/molslinjen/core/Environment;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Dev", "Test", "ProdTest", "Prod", "isCurrent", BuildConfig.FLAVOR, "description", BuildConfig.FLAVOR, "Companion", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Environment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Environment[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean isKombardo;
    private static boolean isMolslinjen;
    public static final Environment Dev = new Environment("Dev", 0);
    public static final Environment Test = new Environment("Test", 1);
    public static final Environment ProdTest = new Environment("ProdTest", 2);
    public static final Environment Prod = new Environment("Prod", 3);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/core/Environment$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "current", "Ldk/molslinjen/core/Environment;", "value", BuildConfig.FLAVOR, "isMolslinjen", "()Z", "isKombardo", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Environment current() {
            return Environment.Prod;
        }

        public final boolean isKombardo() {
            return Environment.isKombardo;
        }

        public final boolean isMolslinjen() {
            return Environment.isMolslinjen;
        }

        private Companion() {
        }
    }

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

    private static final /* synthetic */ Environment[] $values() {
        return new Environment[]{Dev, Test, ProdTest, Prod};
    }

    static {
        Environment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        isKombardo = true;
    }

    private Environment(String str, int i5) {
    }

    public static Environment valueOf(String str) {
        return (Environment) Enum.valueOf(Environment.class, str);
    }

    public static Environment[] values() {
        return (Environment[]) $VALUES.clone();
    }

    public final String description() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return "Dev";
        }
        if (i5 == 2) {
            return "Test";
        }
        if (i5 == 3) {
            return "ProdTest";
        }
        if (i5 == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isCurrent() {
        return this == INSTANCE.current();
    }
}
