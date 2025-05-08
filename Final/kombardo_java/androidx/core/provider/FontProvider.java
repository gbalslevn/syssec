package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.tracing.Trace;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class FontProvider {
    private static final LruCache<ProviderCacheKey, ProviderInfo> sProviderCache = new LruCache<>(2);
    private static final Comparator<byte[]> sByteArrayComparator = new Comparator() { // from class: androidx.core.provider.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int lambda$static$0;
            lambda$static$0 = FontProvider.lambda$static$0((byte[]) obj, (byte[]) obj2);
            return lambda$static$0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface ContentQueryWrapper {
        static ContentQueryWrapper make(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }

        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e5) {
                Log.w("FontsProvider", "Unable to query the content provider", e5);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ProviderCacheKey {
        String mAuthority;
        List<List<byte[]>> mCertificates;
        String mPackageName;

        ProviderCacheKey(String str, String str2, List<List<byte[]>> list) {
            this.mAuthority = str;
            this.mPackageName = str2;
            this.mCertificates = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProviderCacheKey)) {
                return false;
            }
            ProviderCacheKey providerCacheKey = (ProviderCacheKey) obj;
            return Objects.equals(this.mAuthority, providerCacheKey.mAuthority) && Objects.equals(this.mPackageName, providerCacheKey.mPackageName) && Objects.equals(this.mCertificates, providerCacheKey.mCertificates);
        }

        public int hashCode() {
            return Objects.hash(this.mAuthority, this.mPackageName, this.mCertificates);
        }
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!Arrays.equals(list.get(i5), list2.get(i5))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, List<FontRequest> list, CancellationSignal cancellationSignal) {
        Trace.beginSection("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                FontRequest fontRequest = list.get(i5);
                ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
                if (provider == null) {
                    return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
                }
                arrayList.add(query(context, fontRequest, provider.authority, cancellationSignal));
            }
            return FontsContractCompat.FontFamilyResult.create(0, arrayList);
        } finally {
            Trace.endSection();
        }
    }

    static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        Trace.beginSection("FontProvider.getProvider");
        try {
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            ProviderCacheKey providerCacheKey = new ProviderCacheKey(fontRequest.getProviderAuthority(), fontRequest.getProviderPackage(), certificates);
            ProviderInfo providerInfo = sProviderCache.get(providerCacheKey);
            if (providerInfo != null) {
                return providerInfo;
            }
            String providerAuthority = fontRequest.getProviderAuthority();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
            }
            if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
            }
            List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            for (int i5 = 0; i5 < certificates.size(); i5++) {
                ArrayList arrayList = new ArrayList(certificates.get(i5));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    sProviderCache.put(providerCacheKey, resolveContentProvider);
                    return resolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b5 = bArr[i5];
            byte b6 = bArr2[i5];
            if (b5 != b6) {
                return b5 - b6;
            }
        }
        return 0;
    }

    static FontsContractCompat.FontInfo[] query(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        Uri withAppendedId;
        boolean z5;
        Trace.beginSection("FontProvider.query");
        try {
            ArrayList arrayList2 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            ContentQueryWrapper make = ContentQueryWrapper.make(context, build);
            Cursor cursor = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection("ContentQueryWrapper.query");
                try {
                    cursor = make.query(build, strArr, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
                    Trace.endSection();
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            int i5 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                            int i6 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            int i7 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : Constants.MINIMAL_ERROR_STATUS_CODE;
                            if (columnIndex6 != -1) {
                                z5 = true;
                                if (cursor.getInt(columnIndex6) == 1) {
                                    FontsContractCompat.FontInfo create = FontsContractCompat.FontInfo.create(withAppendedId, i6, i7, z5, i5);
                                    arrayList3 = arrayList;
                                    arrayList3.add(create);
                                }
                            }
                            z5 = false;
                            FontsContractCompat.FontInfo create2 = FontsContractCompat.FontInfo.create(withAppendedId, i6, i7, z5, i5);
                            arrayList3 = arrayList;
                            arrayList3.add(create2);
                        }
                        arrayList2 = arrayList3;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    make.close();
                    return (FontsContractCompat.FontInfo[]) arrayList2.toArray(new FontsContractCompat.FontInfo[0]);
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                make.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
