package io.michaelrocks.libphonenumber.android.metadata.source;

import io.michaelrocks.libphonenumber.android.MetadataLoader;
import io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata;
import io.michaelrocks.libphonenumber.android.metadata.init.MetadataParser;
import io.michaelrocks.libphonenumber.android.metadata.source.MetadataContainer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class BlockingMetadataBootstrappingGuard<T extends MetadataContainer> implements MetadataBootstrappingGuard<T> {
    private final Map<String, String> loadedFiles = new ConcurrentHashMap();
    private final T metadataContainer;
    private final MetadataLoader metadataLoader;
    private final MetadataParser metadataParser;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockingMetadataBootstrappingGuard(MetadataLoader metadataLoader, MetadataParser metadataParser, T t5) {
        this.metadataLoader = metadataLoader;
        this.metadataParser = metadataParser;
        this.metadataContainer = t5;
    }

    private synchronized void bootstrapMetadata(String str) {
        try {
            if (this.loadedFiles.containsKey(str)) {
                return;
            }
            Iterator<Phonemetadata$PhoneMetadata> it = read(str).iterator();
            while (it.hasNext()) {
                this.metadataContainer.accept(it.next());
            }
            this.loadedFiles.put(str, str);
        } catch (Throwable th) {
            throw th;
        }
    }

    private Collection<Phonemetadata$PhoneMetadata> read(String str) {
        try {
            return this.metadataParser.parse(this.metadataLoader.loadMetadata(str));
        } catch (IllegalArgumentException | IllegalStateException e5) {
            throw new IllegalStateException("Failed to read file " + str, e5);
        }
    }

    @Override // io.michaelrocks.libphonenumber.android.metadata.source.MetadataBootstrappingGuard
    public T getOrBootstrap(String str) {
        if (!this.loadedFiles.containsKey(str)) {
            bootstrapMetadata(str);
        }
        return this.metadataContainer;
    }
}
