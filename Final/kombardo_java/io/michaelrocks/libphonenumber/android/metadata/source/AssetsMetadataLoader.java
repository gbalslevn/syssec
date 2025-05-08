package io.michaelrocks.libphonenumber.android.metadata.source;

import android.content.res.AssetManager;
import io.michaelrocks.libphonenumber.android.MetadataLoader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class AssetsMetadataLoader implements MetadataLoader {
    private final AssetManager assetManager;

    public AssetsMetadataLoader(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataLoader
    public InputStream loadMetadata(String str) {
        try {
            return this.assetManager.open(str.substring(1));
        } catch (IOException unused) {
            return null;
        }
    }
}
