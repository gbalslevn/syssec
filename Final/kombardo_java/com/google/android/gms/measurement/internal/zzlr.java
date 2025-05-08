package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlr implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzlo zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzlp zzf;

    public zzlr(zzlp zzlpVar, String str, URL url, byte[] bArr, Map<String, String> map, zzlo zzloVar) {
        this.zzf = zzlpVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzloVar);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzloVar;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        Map<String, List<String>> map3;
        Map<String, List<String>> map4;
        ?? r5;
        ?? r52;
        Map<String, List<String>> headerFields;
        byte[] zza;
        this.zzf.zzt();
        int i5 = 0;
        try {
            URLConnection zza2 = com.google.android.gms.internal.measurement.zzda.zza().zza(this.zza, "client-measurement");
            if (!(zza2 instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) zza2;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                try {
                    Map<String, String> map5 = this.zze;
                    if (map5 != null) {
                        for (Map.Entry<String, String> entry : map5.entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    byte[] bArr = this.zzb;
                    if (bArr != null) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            this.zzf.zzj().zzq().zza("Uploading data. size", Integer.valueOf(byteArray.length));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                            httpURLConnection.setFixedLengthStreamingMode(byteArray.length);
                            httpURLConnection.connect();
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            try {
                                outputStream.write(byteArray);
                                outputStream.close();
                            } catch (IOException e5) {
                                map3 = null;
                                r52 = outputStream;
                                e = e5;
                                if (r52 != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                zza(i5, e, null, map3);
                            } catch (Throwable th) {
                                map4 = null;
                                r5 = outputStream;
                                th = th;
                                if (r5 != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                zza(i5, null, null, map4);
                                throw th;
                            }
                        } catch (IOException e6) {
                            this.zzf.zzj().zzg().zza("Failed to gzip post request content", e6);
                            throw e6;
                        }
                    }
                    i5 = httpURLConnection.getResponseCode();
                    headerFields = httpURLConnection.getHeaderFields();
                } catch (Throwable th2) {
                    th = th2;
                    map = null;
                    map4 = map;
                    r5 = map;
                    if (r5 != 0) {
                        try {
                            r5.close();
                        } catch (IOException e7) {
                            this.zzf.zzj().zzg().zza("Error closing HTTP compressed POST connection output stream. appId", zzgo.zza(this.zzd), e7);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zza(i5, null, null, map4);
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                map2 = null;
                map3 = map2;
                r52 = map2;
                if (r52 != 0) {
                    try {
                        r52.close();
                    } catch (IOException e9) {
                        this.zzf.zzj().zzg().zza("Error closing HTTP compressed POST connection output stream. appId", zzgo.zza(this.zzd), e9);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zza(i5, e, null, map3);
            }
            try {
                zzlp zzlpVar = this.zzf;
                zza = zzlp.zza(httpURLConnection);
                httpURLConnection.disconnect();
                zza(i5, null, zza, headerFields);
            } catch (IOException e10) {
                map3 = headerFields;
                e = e10;
                r52 = 0;
                if (r52 != 0) {
                }
                if (httpURLConnection != null) {
                }
                zza(i5, e, null, map3);
            } catch (Throwable th3) {
                map4 = headerFields;
                th = th3;
                r5 = 0;
                if (r5 != 0) {
                }
                if (httpURLConnection != null) {
                }
                zza(i5, null, null, map4);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            map = null;
        }
    }

    private final void zza(final int i5, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.zzf.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlq
            @Override // java.lang.Runnable
            public final void run() {
                r0.zzc.zza(zzlr.this.zzd, i5, exc, bArr, map);
            }
        });
    }
}
