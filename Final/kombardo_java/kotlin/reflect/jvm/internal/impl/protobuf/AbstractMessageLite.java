package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* loaded from: classes3.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        newInstance.writeRawVarint32(serializedSize);
        writeTo(newInstance);
        newInstance.flush();
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        /* loaded from: classes3.dex */
        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            /* JADX INFO: Access modifiers changed from: package-private */
            public LimitedInputStream(InputStream inputStream, int i5) {
                super(inputStream);
                this.limit = i5;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.limit <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.limit--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j5) {
                long skip = super.skip(Math.min(j5, this.limit));
                if (skip >= 0) {
                    this.limit = (int) (this.limit - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i5, int i6) {
                int i7 = this.limit;
                if (i7 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i5, Math.min(i6, i7));
                if (read >= 0) {
                    this.limit -= read;
                }
                return read;
            }
        }
    }
}
