package org.threeten.bp.zone;

import e.AbstractC0321h;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class ZoneRulesInitializer {
    public static final ZoneRulesInitializer DO_NOTHING = new DoNothingZoneRulesInitializer();
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    private static final AtomicReference<ZoneRulesInitializer> INITIALIZER = new AtomicReference<>();

    /* loaded from: classes3.dex */
    static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        DoNothingZoneRulesInitializer() {
        }

        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        protected void initializeProviders() {
        }
    }

    /* loaded from: classes3.dex */
    static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        ServiceLoaderZoneRulesInitializer() {
        }

        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        protected void initializeProviders() {
            Iterator it = ServiceLoader.load(ZoneRulesProvider.class, ZoneRulesProvider.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    ZoneRulesProvider.registerProvider((ZoneRulesProvider) it.next());
                } catch (ServiceConfigurationError e5) {
                    if (!(e5.getCause() instanceof SecurityException)) {
                        throw e5;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize() {
        if (INITIALIZED.getAndSet(true)) {
            throw new IllegalStateException("Already initialized");
        }
        AtomicReference<ZoneRulesInitializer> atomicReference = INITIALIZER;
        AbstractC0321h.a(atomicReference, null, new ServiceLoaderZoneRulesInitializer());
        atomicReference.get().initializeProviders();
    }

    public static void setInitializer(ZoneRulesInitializer zoneRulesInitializer) {
        if (INITIALIZED.get()) {
            throw new IllegalStateException("Already initialized");
        }
        if (!AbstractC0321h.a(INITIALIZER, null, zoneRulesInitializer)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    protected abstract void initializeProviders();
}
