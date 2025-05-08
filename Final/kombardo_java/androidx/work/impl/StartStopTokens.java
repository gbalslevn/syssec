package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0005\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/work/impl/StartStopTokens;", BuildConfig.FLAVOR, "Landroidx/work/impl/model/WorkGenerationalId;", Constants.ID_ATTRIBUTE_KEY, "Landroidx/work/impl/StartStopToken;", "tokenFor", "(Landroidx/work/impl/model/WorkGenerationalId;)Landroidx/work/impl/StartStopToken;", "remove", BuildConfig.FLAVOR, "workSpecId", BuildConfig.FLAVOR, "(Ljava/lang/String;)Ljava/util/List;", BuildConfig.FLAVOR, "contains", "(Landroidx/work/impl/model/WorkGenerationalId;)Z", "Landroidx/work/impl/model/WorkSpec;", "spec", "(Landroidx/work/impl/model/WorkSpec;)Landroidx/work/impl/StartStopToken;", "Companion", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface StartStopTokens {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/StartStopTokens$Companion;", BuildConfig.FLAVOR, "()V", "create", "Landroidx/work/impl/StartStopTokens;", "synchronized", BuildConfig.FLAVOR, "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ StartStopTokens create$default(Companion companion, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = true;
            }
            return companion.create(z5);
        }

        public final StartStopTokens create() {
            return create$default(this, false, 1, null);
        }

        public final StartStopTokens create(boolean r22) {
            StartStopTokensImpl startStopTokensImpl = new StartStopTokensImpl();
            return r22 ? new SynchronizedStartStopTokensImpl(startStopTokensImpl) : startStopTokensImpl;
        }
    }

    static StartStopTokens create() {
        return INSTANCE.create();
    }

    boolean contains(WorkGenerationalId id);

    StartStopToken remove(WorkGenerationalId id);

    List<StartStopToken> remove(String workSpecId);

    StartStopToken tokenFor(WorkGenerationalId id);

    default StartStopToken tokenFor(WorkSpec spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        return tokenFor(WorkSpecKt.generationalId(spec));
    }

    static StartStopTokens create(boolean z5) {
        return INSTANCE.create(z5);
    }
}
