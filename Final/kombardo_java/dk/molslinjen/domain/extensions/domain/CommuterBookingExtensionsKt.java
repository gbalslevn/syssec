package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.domain.extensions.domain.CommuterBookingExtensionsKt;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterBooking;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"sortedForDisplay", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CommuterBookingExtensionsKt {
    public static final List<BornholmCommuterBooking> sortedForDisplay(List<BornholmCommuterBooking> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.sortedWith(list, ComparisonsKt.compareBy(new Function1() { // from class: x1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Comparable sortedForDisplay$lambda$0;
                sortedForDisplay$lambda$0 = CommuterBookingExtensionsKt.sortedForDisplay$lambda$0((BornholmCommuterBooking) obj);
                return sortedForDisplay$lambda$0;
            }
        }, new Function1() { // from class: x1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Comparable sortedForDisplay$lambda$1;
                sortedForDisplay$lambda$1 = CommuterBookingExtensionsKt.sortedForDisplay$lambda$1((BornholmCommuterBooking) obj);
                return sortedForDisplay$lambda$1;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable sortedForDisplay$lambda$0(BornholmCommuterBooking it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable sortedForDisplay$lambda$1(BornholmCommuterBooking it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDepartureTime();
    }
}
