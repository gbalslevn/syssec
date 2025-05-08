package org.conscrypt;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class OpenSSLBIOInputStream extends FilterInputStream {
    private long ctx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLBIOInputStream(InputStream inputStream, boolean z5) {
        super(inputStream);
        this.ctx = NativeCrypto.create_BIO_InputStream(this, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getBioContext() {
        return this.ctx;
    }

    int gets(byte[] bArr) {
        int read;
        int i5 = 0;
        if (bArr != null && bArr.length != 0) {
            while (i5 < bArr.length && (read = read()) != -1) {
                if (read != 10) {
                    bArr[i5] = (byte) read;
                    i5++;
                } else if (i5 != 0) {
                    break;
                }
            }
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        NativeCrypto.BIO_free_all(this.ctx);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        if (i5 < 0 || i6 < 0 || i6 > bArr.length - i5) {
            throw new IndexOutOfBoundsException("Invalid bounds");
        }
        int i7 = 0;
        if (i6 == 0) {
            return 0;
        }
        do {
            int read = super.read(bArr, i5 + i7, (i6 - i7) - i5);
            if (read == -1) {
                break;
            }
            i7 += read;
        } while (i5 + i7 < i6);
        if (i7 == 0) {
            return -1;
        }
        return i7;
    }
}
