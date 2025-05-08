package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* loaded from: classes2.dex */
public abstract class LibraryVersionComponent {

    /* loaded from: classes2.dex */
    public interface VersionExtractor<T> {
        String extract(T t5);
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(LibraryVersion.create(str, str2), LibraryVersion.class);
    }

    public static Component<?> fromContext(final String str, final VersionExtractor<Context> versionExtractor) {
        return Component.intoSetBuilder(LibraryVersion.class).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: X0.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                LibraryVersion lambda$fromContext$0;
                lambda$fromContext$0 = LibraryVersionComponent.lambda$fromContext$0(str, versionExtractor, componentContainer);
                return lambda$fromContext$0;
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LibraryVersion lambda$fromContext$0(String str, VersionExtractor versionExtractor, ComponentContainer componentContainer) {
        return LibraryVersion.create(str, versionExtractor.extract((Context) componentContainer.get(Context.class)));
    }
}
