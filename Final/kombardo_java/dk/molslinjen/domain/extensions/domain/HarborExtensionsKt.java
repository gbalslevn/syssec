package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.domain.model.config.HarborReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"harborName", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/HarborReference;", "useRegion", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class HarborExtensionsKt {
    public static final String harborName(HarborReference harborReference, boolean z5) {
        Intrinsics.checkNotNullParameter(harborReference, "<this>");
        return z5 ? harborReference.getRegion().getName() : harborReference.getName();
    }
}
