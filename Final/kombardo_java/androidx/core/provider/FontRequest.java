package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray = 0;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(str);
        this.mProviderPackage = (String) Preconditions.checkNotNull(str2);
        this.mQuery = (String) Preconditions.checkNotNull(str3);
        this.mCertificates = (List) Preconditions.checkNotNull(list);
        this.mIdentifier = createIdentifier(str, str2, str3);
    }

    private String createIdentifier(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i5 = 0; i5 < this.mCertificates.size(); i5++) {
            sb.append(" [");
            List<byte[]> list = this.mCertificates.get(i5);
            for (int i6 = 0; i6 < list.size(); i6++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i6), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
