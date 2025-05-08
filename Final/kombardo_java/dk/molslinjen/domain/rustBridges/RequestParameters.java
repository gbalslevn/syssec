package dk.molslinjen.domain.rustBridges;

import dk.molslinjen.core.extensions.LocaleExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Molslinjen_sharedKt;
import uniffi.molslinjen_shared.RequestParametersBridge;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/rustBridges/RequestParameters;", "Luniffi/molslinjen_shared/RequestParametersBridge;", "<init>", "()V", "language", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestParameters implements RequestParametersBridge {
    public RequestParameters() {
        Molslinjen_sharedKt.ffiInitializeRequestParametersBridge(this);
    }

    @Override // uniffi.molslinjen_shared.RequestParametersBridge
    public String language() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return LocaleExtensionsKt.defaultLanguageString(locale);
    }
}
