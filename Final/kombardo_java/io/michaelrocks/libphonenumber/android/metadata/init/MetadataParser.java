package io.michaelrocks.libphonenumber.android.metadata.init;

import io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class MetadataParser {
    private static final Logger logger = Logger.getLogger(MetadataParser.class.getName());
    private final boolean strictMode;

    private MetadataParser(boolean z5) {
        this.strictMode = z5;
    }

    private void close(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e5) {
            logger.log(Level.WARNING, "Error closing input stream (ignored)", (Throwable) e5);
        }
    }

    private List<Phonemetadata$PhoneMetadata> handleNullSource() {
        if (this.strictMode) {
            throw new IllegalArgumentException("Source cannot be null");
        }
        return Collections.emptyList();
    }

    public static MetadataParser newLenientParser() {
        return new MetadataParser(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Type inference failed for: r0v7, types: [io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadataCollection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<Phonemetadata$PhoneMetadata> parse(InputStream inputStream) {
        Throwable th;
        IOException e5;
        if (inputStream == null) {
            return handleNullSource();
        }
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                try {
                    ?? r02 = new Externalizable() { // from class: io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadataCollection
                        private static final long serialVersionUID = 1;
                        private List<Phonemetadata$PhoneMetadata> metadata_ = new ArrayList();

                        public int getMetadataCount() {
                            return this.metadata_.size();
                        }

                        public List<Phonemetadata$PhoneMetadata> getMetadataList() {
                            return this.metadata_;
                        }

                        @Override // java.io.Externalizable
                        public void readExternal(ObjectInput objectInput) {
                            int readInt = objectInput.readInt();
                            for (int i5 = 0; i5 < readInt; i5++) {
                                Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata = new Phonemetadata$PhoneMetadata();
                                phonemetadata$PhoneMetadata.readExternal(objectInput);
                                this.metadata_.add(phonemetadata$PhoneMetadata);
                            }
                        }

                        @Override // java.io.Externalizable
                        public void writeExternal(ObjectOutput objectOutput) {
                            int metadataCount = getMetadataCount();
                            objectOutput.writeInt(metadataCount);
                            for (int i5 = 0; i5 < metadataCount; i5++) {
                                this.metadata_.get(i5).writeExternal(objectOutput);
                            }
                        }
                    };
                    r02.readExternal(objectInputStream);
                    if (r02.getMetadataList().isEmpty()) {
                        throw new IllegalStateException("Empty metadata");
                    }
                    List<Phonemetadata$PhoneMetadata> metadataList = r02.getMetadataList();
                    close(objectInputStream);
                    return metadataList;
                } catch (IOException e6) {
                    e5 = e6;
                    throw new IllegalStateException("Unable to parse metadata file", e5);
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 == 0) {
                    close(null);
                } else {
                    close(inputStream);
                }
                throw th;
            }
        } catch (IOException e7) {
            e5 = e7;
        } catch (Throwable th3) {
            th = th3;
            if (0 == 0) {
            }
            throw th;
        }
    }
}
