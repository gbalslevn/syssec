package io.michaelrocks.libphonenumber.android.metadata;

import io.michaelrocks.libphonenumber.android.MetadataLoader;
import io.michaelrocks.libphonenumber.android.metadata.init.ClassPathResourceMetadataLoader;
import io.michaelrocks.libphonenumber.android.metadata.init.MetadataParser;
import io.michaelrocks.libphonenumber.android.metadata.source.FormattingMetadataSource;
import io.michaelrocks.libphonenumber.android.metadata.source.FormattingMetadataSourceImpl;
import io.michaelrocks.libphonenumber.android.metadata.source.MetadataSource;
import io.michaelrocks.libphonenumber.android.metadata.source.MetadataSourceImpl;
import io.michaelrocks.libphonenumber.android.metadata.source.MultiFileModeFileNameProvider;
import io.michaelrocks.libphonenumber.android.metadata.source.PhoneMetadataFileNameProvider;
import io.michaelrocks.libphonenumber.android.metadata.source.RegionMetadataSource;
import io.michaelrocks.libphonenumber.android.metadata.source.RegionMetadataSourceImpl;

/* loaded from: classes2.dex */
public final class DefaultMetadataDependenciesProvider {
    private static final DefaultMetadataDependenciesProvider INSTANCE = new DefaultMetadataDependenciesProvider();
    private final PhoneMetadataFileNameProvider alternateFormatsMetadataFileNameProvider;
    private final FormattingMetadataSource alternateFormatsMetadataSource;
    private final MetadataLoader metadataLoader;
    private final MetadataParser metadataParser;
    private final PhoneMetadataFileNameProvider phoneNumberMetadataFileNameProvider;
    private final MetadataSource phoneNumberMetadataSource;
    private final PhoneMetadataFileNameProvider shortNumberMetadataFileNameProvider;
    private final RegionMetadataSource shortNumberMetadataSource;

    public DefaultMetadataDependenciesProvider() {
        this(new ClassPathResourceMetadataLoader());
    }

    public MetadataParser getMetadataParser() {
        return this.metadataParser;
    }

    public PhoneMetadataFileNameProvider getPhoneNumberMetadataFileNameProvider() {
        return this.phoneNumberMetadataFileNameProvider;
    }

    public DefaultMetadataDependenciesProvider(MetadataLoader metadataLoader) {
        MetadataParser newLenientParser = MetadataParser.newLenientParser();
        this.metadataParser = newLenientParser;
        MultiFileModeFileNameProvider multiFileModeFileNameProvider = new MultiFileModeFileNameProvider("/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto");
        this.phoneNumberMetadataFileNameProvider = multiFileModeFileNameProvider;
        MultiFileModeFileNameProvider multiFileModeFileNameProvider2 = new MultiFileModeFileNameProvider("/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto");
        this.shortNumberMetadataFileNameProvider = multiFileModeFileNameProvider2;
        MultiFileModeFileNameProvider multiFileModeFileNameProvider3 = new MultiFileModeFileNameProvider("/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto");
        this.alternateFormatsMetadataFileNameProvider = multiFileModeFileNameProvider3;
        if (metadataLoader != null) {
            this.metadataLoader = metadataLoader;
            this.phoneNumberMetadataSource = new MetadataSourceImpl(multiFileModeFileNameProvider, metadataLoader, newLenientParser);
            this.shortNumberMetadataSource = new RegionMetadataSourceImpl(multiFileModeFileNameProvider2, metadataLoader, newLenientParser);
            this.alternateFormatsMetadataSource = new FormattingMetadataSourceImpl(multiFileModeFileNameProvider3, metadataLoader, newLenientParser);
            return;
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }
}
