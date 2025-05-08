package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/OffsetSerializer;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "Landroidx/compose/ui/geometry/Offset;", "<init>", "()V", "toRouteString", BuildConfig.FLAVOR, "value", "toRouteString-k-4lQ0M", "(J)Ljava/lang/String;", "fromRouteString", "routeStr", "fromRouteString-tuRUvjQ", "(Ljava/lang/String;)J", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OffsetSerializer implements DestinationsNavTypeSerializer<Offset> {
    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
    public /* bridge */ /* synthetic */ Offset fromRouteString(String str) {
        return Offset.m1328boximpl(m3380fromRouteStringtuRUvjQ(str));
    }

    /* renamed from: fromRouteString-tuRUvjQ, reason: not valid java name */
    public long m3380fromRouteStringtuRUvjQ(String routeStr) {
        Intrinsics.checkNotNullParameter(routeStr, "routeStr");
        List split$default = StringsKt.split$default((CharSequence) routeStr, new String[]{","}, false, 0, 6, (Object) null);
        return OffsetKt.Offset(Float.parseFloat((String) split$default.get(0)), Float.parseFloat((String) split$default.get(1)));
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
    public /* bridge */ /* synthetic */ String toRouteString(Offset offset) {
        return m3381toRouteStringk4lQ0M(offset.getPackedValue());
    }

    /* renamed from: toRouteString-k-4lQ0M, reason: not valid java name */
    public String m3381toRouteStringk4lQ0M(long value) {
        return Offset.m1337getXimpl(value) + "," + Offset.m1338getYimpl(value);
    }
}
