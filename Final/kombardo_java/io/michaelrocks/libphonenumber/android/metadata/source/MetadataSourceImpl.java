package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.MetadataLoader;
import io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata;
import io.michaelrocks.libphonenumber.android.internal.GeoEntityUtility;
import io.michaelrocks.libphonenumber.android.metadata.init.MetadataParser;

/* loaded from: classes2.dex */
public final class MetadataSourceImpl implements MetadataSource {
    private final MetadataBootstrappingGuard<CompositeMetadataContainer> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public MetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataBootstrappingGuard<CompositeMetadataContainer> metadataBootstrappingGuard) {
        this.phoneMetadataFileNameProvider = phoneMetadataFileNameProvider;
        this.bootstrappingGuard = metadataBootstrappingGuard;
    }

    @Override // io.michaelrocks.libphonenumber.android.metadata.source.RegionMetadataSource
    public Phonemetadata$PhoneMetadata getMetadataForRegion(String str) {
        if (GeoEntityUtility.isGeoEntity(str)) {
            return this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(str)).getMetadataBy(str);
        }
        throw new IllegalArgumentException(str + " region code is a non-geo entity");
    }

    public MetadataSourceImpl(PhoneMetadataFileNameProvider phoneMetadataFileNameProvider, MetadataLoader metadataLoader, MetadataParser metadataParser) {
        this(phoneMetadataFileNameProvider, new BlockingMetadataBootstrappingGuard(metadataLoader, metadataParser, new CompositeMetadataContainer()));
    }
}
