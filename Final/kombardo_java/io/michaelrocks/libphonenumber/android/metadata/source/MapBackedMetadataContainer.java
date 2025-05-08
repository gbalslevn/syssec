package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
final class MapBackedMetadataContainer<T> implements MetadataContainer {
    private final KeyProvider<T> keyProvider;
    private final ConcurrentMap<T, Phonemetadata$PhoneMetadata> metadataMap = new ConcurrentHashMap();

    /* loaded from: classes2.dex */
    interface KeyProvider<T> {
        T getKeyOf(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata);
    }

    private MapBackedMetadataContainer(KeyProvider<T> keyProvider) {
        this.keyProvider = keyProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapBackedMetadataContainer<Integer> byCountryCallingCode() {
        return new MapBackedMetadataContainer<>(new KeyProvider<Integer>() { // from class: io.michaelrocks.libphonenumber.android.metadata.source.MapBackedMetadataContainer.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.michaelrocks.libphonenumber.android.metadata.source.MapBackedMetadataContainer.KeyProvider
            public Integer getKeyOf(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
                return Integer.valueOf(phonemetadata$PhoneMetadata.getCountryCode());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapBackedMetadataContainer<String> byRegionCode() {
        return new MapBackedMetadataContainer<>(new KeyProvider<String>() { // from class: io.michaelrocks.libphonenumber.android.metadata.source.MapBackedMetadataContainer.1
            @Override // io.michaelrocks.libphonenumber.android.metadata.source.MapBackedMetadataContainer.KeyProvider
            public String getKeyOf(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
                return phonemetadata$PhoneMetadata.getId();
            }
        });
    }

    @Override // io.michaelrocks.libphonenumber.android.metadata.source.MetadataContainer
    public void accept(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        this.metadataMap.put(this.keyProvider.getKeyOf(phonemetadata$PhoneMetadata), phonemetadata$PhoneMetadata);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyProvider<T> getKeyProvider() {
        return this.keyProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata$PhoneMetadata getMetadataBy(T t5) {
        if (t5 != null) {
            return this.metadataMap.get(t5);
        }
        return null;
    }
}
