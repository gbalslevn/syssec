package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TransportFactory lambda$getComponents$0(ComponentContainer componentContainer) {
        TransportRuntime.initialize((Context) componentContainer.get(Context.class));
        return TransportRuntime.getInstance().newFactory(CCTDestination.LEGACY_INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TransportFactory lambda$getComponents$1(ComponentContainer componentContainer) {
        TransportRuntime.initialize((Context) componentContainer.get(Context.class));
        return TransportRuntime.getInstance().newFactory(CCTDestination.LEGACY_INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TransportFactory lambda$getComponents$2(ComponentContainer componentContainer) {
        TransportRuntime.initialize((Context) componentContainer.get(Context.class));
        return TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(TransportFactory.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: N0.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                TransportFactory lambda$getComponents$0;
                lambda$getComponents$0 = TransportRegistrar.lambda$getComponents$0(componentContainer);
                return lambda$getComponents$0;
            }
        }).build(), Component.builder(Qualified.qualified(LegacyTransportBackend.class, TransportFactory.class)).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: N0.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                TransportFactory lambda$getComponents$1;
                lambda$getComponents$1 = TransportRegistrar.lambda$getComponents$1(componentContainer);
                return lambda$getComponents$1;
            }
        }).build(), Component.builder(Qualified.qualified(TransportBackend.class, TransportFactory.class)).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: N0.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                TransportFactory lambda$getComponents$2;
                lambda$getComponents$2 = TransportRegistrar.lambda$getComponents$2(componentContainer);
                return lambda$getComponents$2;
            }
        }).build(), LibraryVersionComponent.create(LIBRARY_NAME, "19.0.0"));
    }
}
