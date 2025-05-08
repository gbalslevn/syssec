package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.MetadataLoader;
import io.michaelrocks.libphonenumber.android.metadata.init.MetadataParser;

/* loaded from: classes2.dex */
public final class RegionMetadataSourceImpl implements RegionMetadataSource {
    private final MetadataBootstrappingGuard<MapBackedMetadataContainer<String>> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public RegionMetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataBootstrappingGuard<MapBackedMetadataContainer<String>> metadataBootstrappingGuard) {
        this.phoneMetadataFileNameProvider = phoneMetadataFileNameProvider;
        this.bootstrappingGuard = metadataBootstrappingGuard;
    }

    public RegionMetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataLoader metadataLoader, MetadataParser metadataParser) {
        this(phoneMetadataFileNameProvider, new BlockingMetadataBootstrappingGuard(metadataLoader, metadataParser, MapBackedMetadataContainer.byRegionCode()));
    }
}
