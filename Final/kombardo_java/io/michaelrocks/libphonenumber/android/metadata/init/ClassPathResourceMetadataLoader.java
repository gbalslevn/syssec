package io.michaelrocks.libphonenumber.android.metadata.init;

import io.michaelrocks.libphonenumber.android.MetadataLoader;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class ClassPathResourceMetadataLoader implements MetadataLoader {
    private static final Logger logger = Logger.getLogger(ClassPathResourceMetadataLoader.class.getName());

    @Override // io.michaelrocks.libphonenumber.android.MetadataLoader
    public InputStream loadMetadata(String str) {
        InputStream resourceAsStream = ClassPathResourceMetadataLoader.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            logger.log(Level.WARNING, String.format("File %s not found", str));
        }
        return resourceAsStream;
    }
}
