package dk.molslinjen.core.hilt;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.AgillicHandler;
import uniffi.molslinjen_shared.AgillicHandlerInterface;
import uniffi.molslinjen_shared.DepartureLowPriceHandler;
import uniffi.molslinjen_shared.DepartureLowPriceHandlerInterface;
import uniffi.molslinjen_shared.SelectSeatingHandler;
import uniffi.molslinjen_shared.SelectSeatingHandlerInterface;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/core/hilt/HandlerProviderModule;", BuildConfig.FLAVOR, "<init>", "()V", "bindSelectSeatingHandler", "Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;", "bindDepartureLowPriceHandler", "Luniffi/molslinjen_shared/DepartureLowPriceHandlerInterface;", "bindAgillicHandler", "Luniffi/molslinjen_shared/AgillicHandlerInterface;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HandlerProviderModule {
    public static final HandlerProviderModule INSTANCE = new HandlerProviderModule();

    private HandlerProviderModule() {
    }

    public final AgillicHandlerInterface bindAgillicHandler() {
        return new AgillicHandler();
    }

    public final DepartureLowPriceHandlerInterface bindDepartureLowPriceHandler() {
        return new DepartureLowPriceHandler();
    }

    public final SelectSeatingHandlerInterface bindSelectSeatingHandler() {
        return new SelectSeatingHandler();
    }
}
