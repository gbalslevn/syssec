package dk.molslinjen.core.log;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Molslinjen_sharedKt;
import uniffi.molslinjen_shared.RustLoggerLevel;
import uniffi.molslinjen_shared.RustLoggerTrait;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J;\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/core/log/RustLogger;", "Luniffi/molslinjen_shared/RustLoggerTrait;", "<init>", "()V", "setup", BuildConfig.FLAVOR, "log", "level", "Luniffi/molslinjen_shared/RustLoggerLevel;", "message", BuildConfig.FLAVOR, "path", "file", "line", "Lkotlin/UInt;", "log-H3638Bo", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RustLogger implements RustLoggerTrait {
    public static final RustLogger INSTANCE = new RustLogger();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RustLoggerLevel.values().length];
            try {
                iArr[RustLoggerLevel.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RustLoggerLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RustLoggerLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RustLoggerLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RustLoggerLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RustLogger() {
    }

    @Override // uniffi.molslinjen_shared.RustLoggerTrait
    /* renamed from: log-H3638Bo, reason: not valid java name */
    public void mo3194logH3638Bo(RustLoggerLevel level, String message, String path, String file, UInt line) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(message, "message");
        if (file == null || (str = StringsKt.substringAfterLast$default(file, '/', (String) null, 2, (Object) null)) == null) {
            str = "<unknown file>";
        }
        if (path == null || (str2 = StringsKt.substringAfterLast$default(path, "::", (String) null, 2, (Object) null)) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        int data = line != null ? line.getData() : 0;
        StringBuilder sb = new StringBuilder();
        sb.append("[" + str + ":" + data + "] ");
        if (str2.length() > 0) {
            sb.append(str2 + ": ");
        }
        sb.append(message);
        String sb2 = sb.toString();
        int i5 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i5 == 1) {
            Logger.INSTANCE.log(sb2, "RustLogger", 2);
            return;
        }
        if (i5 == 2) {
            Logger.INSTANCE.log(sb2, "RustLogger", 3);
            return;
        }
        if (i5 == 3) {
            Logger.INSTANCE.log(sb2, "RustLogger", 4);
        } else if (i5 == 4) {
            Logger.INSTANCE.log(sb2, "RustLogger", 5);
        } else {
            if (i5 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.INSTANCE.log(sb2, "RustLogger", 6);
        }
    }

    public final void setup() {
        Molslinjen_sharedKt.setRustLogger(INSTANCE, RustLoggerLevel.INFO);
    }
}
