package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata;
import io.michaelrocks.libphonenumber.android.internal.GeoEntityUtility;

/* loaded from: classes2.dex */
final class CompositeMetadataContainer implements MetadataContainer {
    private final MapBackedMetadataContainer<Integer> metadataByCountryCode = MapBackedMetadataContainer.byCountryCallingCode();
    private final MapBackedMetadataContainer<String> metadataByRegionCode = MapBackedMetadataContainer.byRegionCode();

    @Override // io.michaelrocks.libphonenumber.android.metadata.source.MetadataContainer
    public void accept(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        if (GeoEntityUtility.isGeoEntity(this.metadataByRegionCode.getKeyProvider().getKeyOf(phonemetadata$PhoneMetadata))) {
            this.metadataByRegionCode.accept(phonemetadata$PhoneMetadata);
        } else {
            this.metadataByCountryCode.accept(phonemetadata$PhoneMetadata);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata$PhoneMetadata getMetadataBy(String str) {
        return this.metadataByRegionCode.getMetadataBy(str);
    }
}
