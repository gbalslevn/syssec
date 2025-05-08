package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.MetadataLoader;
import io.michaelrocks.libphonenumber.android.metadata.init.MetadataParser;

/* loaded from: classes2.dex */
public final class FormattingMetadataSourceImpl implements FormattingMetadataSource {
    private final MetadataBootstrappingGuard<MapBackedMetadataContainer<Integer>> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public FormattingMetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataBootstrappingGuard<MapBackedMetadataContainer<Integer>> metadataBootstrappingGuard) {
        this.phoneMetadataFileNameProvider = phoneMetadataFileNameProvider;
        this.bootstrappingGuard = metadataBootstrappingGuard;
    }

    public FormattingMetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataLoader metadataLoader, MetadataParser metadataParser) {
        this(phoneMetadataFileNameProvider, new BlockingMetadataBootstrappingGuard(metadataLoader, metadataParser, MapBackedMetadataContainer.byCountryCallingCode()));
    }
}
