package dk.molslinjen.ui.views.global.navigation;

import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingSectionId;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/FerrySeatingSectionIdSerializer;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "<init>", "()V", "toRouteString", BuildConfig.FLAVOR, "value", "fromRouteString", "routeStr", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FerrySeatingSectionIdSerializer implements DestinationsNavTypeSerializer<FerrySeatingSectionId> {
    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
    public FerrySeatingSectionId fromRouteString(String routeStr) {
        Intrinsics.checkNotNullParameter(routeStr, "routeStr");
        return new FerrySeatingSectionId(Integer.parseInt(routeStr));
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
    public String toRouteString(FerrySeatingSectionId value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return String.valueOf(value.getValue());
    }
}
