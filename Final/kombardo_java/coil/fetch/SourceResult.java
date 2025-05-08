package coil.fetch;

import coil.decode.DataSource;
import coil.decode.ImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcoil/fetch/SourceResult;", "Lcoil/fetch/FetchResult;", "Lcoil/decode/ImageSource;", "source", BuildConfig.FLAVOR, "mimeType", "Lcoil/decode/DataSource;", "dataSource", "<init>", "(Lcoil/decode/ImageSource;Ljava/lang/String;Lcoil/decode/DataSource;)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Lcoil/decode/ImageSource;", "getSource", "()Lcoil/decode/ImageSource;", "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "Lcoil/decode/DataSource;", "getDataSource", "()Lcoil/decode/DataSource;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SourceResult extends FetchResult {
    private final DataSource dataSource;
    private final String mimeType;
    private final ImageSource source;

    public SourceResult(ImageSource imageSource, String str, DataSource dataSource) {
        super(null);
        this.source = imageSource;
        this.mimeType = str;
        this.dataSource = dataSource;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SourceResult) {
            SourceResult sourceResult = (SourceResult) other;
            if (Intrinsics.areEqual(this.source, sourceResult.source) && Intrinsics.areEqual(this.mimeType, sourceResult.mimeType) && this.dataSource == sourceResult.dataSource) {
                return true;
            }
        }
        return false;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final ImageSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.dataSource.hashCode();
    }
}
