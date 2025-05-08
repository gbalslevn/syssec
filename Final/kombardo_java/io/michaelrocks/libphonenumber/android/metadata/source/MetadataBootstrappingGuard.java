package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.metadata.source.MetadataContainer;

/* loaded from: classes2.dex */
public interface MetadataBootstrappingGuard<T extends MetadataContainer> {
    T getOrBootstrap(String str);
}
