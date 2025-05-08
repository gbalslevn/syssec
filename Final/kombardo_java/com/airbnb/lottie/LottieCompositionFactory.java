package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes.dex */
public abstract class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
    private static final Set<Object> taskIdleListeners = new HashSet();
    private static final byte[] MAGIC = {80, 75, 3, 4};

    private static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable() { // from class: b0.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult lambda$cache$8;
                    lambda$cache$8 = LottieCompositionFactory.lambda$cache$8(LottieComposition.this);
                    return lambda$cache$8;
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.addListener(new LottieListener() { // from class: b0.c
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.lambda$cache$9(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask.addFailureListener(new LottieListener() { // from class: b0.d
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.lambda$cache$10(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, LottieTask<LottieComposition>> map2 = taskCache;
                map2.put(str, lottieTask);
                if (map2.size() == 1) {
                    notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask;
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z5) {
        try {
            try {
                LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, parse);
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
                if (z5) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (Exception e5) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e5);
                if (z5) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z5) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i5) {
        return fromRawRes(context, i5, rawResCacheKey(context, i5));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i5, String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i5)));
            return isZipCompressed(buffer).booleanValue() ? fromZipStreamSync(context, new ZipInputStream(buffer.inputStream()), str) : fromJsonInputStreamSync(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e5) {
            return new LottieResult<>((Throwable) e5);
        }
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(context, zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        if (!name.contains(".ttf") && !name.contains(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        String[] split = name.split("/");
                        String str2 = split[split.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        new FileOutputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Throwable th) {
                            Logger.warning("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Typeface createFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                Logger.warning("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            hashMap2.put(str3, createFromFile);
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                            break;
                        }
                    }
                    String[] split2 = name.split("/");
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z5 = false;
                for (Font font : lottieComposition.getFonts().values()) {
                    if (font.getFamily().equals(entry2.getKey())) {
                        font.setTypeface((Typeface) entry2.getValue());
                        z5 = true;
                    }
                }
                if (!z5) {
                    Logger.warning("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                Iterator<Map.Entry<String, LottieImageAsset>> it = lottieComposition.getImages().entrySet().iterator();
                while (it.hasNext()) {
                    LottieImageAsset value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String fileName = value.getFileName();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                            value.setBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e5) {
                            Logger.warning("data URL did not have correct base64 format.", e5);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry3 : lottieComposition.getImages().entrySet()) {
                if (entry3.getValue().getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e6) {
            return new LottieResult<>((Throwable) e6);
        }
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b5 : MAGIC) {
                if (peek.readByte() != b5) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e5) {
            Logger.error("Failed to check zip file header", e5);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$10(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$cache$8(LottieComposition lottieComposition) {
        return new LottieResult(lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$9(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromRawRes$2(WeakReference weakReference, Context context, int i5, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i5, str);
    }

    private static void notifyTaskCacheIdleListeners(boolean z5) {
        ArrayList arrayList = new ArrayList(taskIdleListeners);
        if (arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.a.a(arrayList.get(0));
        throw null;
    }

    private static String rawResCacheKey(Context context, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(isNightMode(context) ? "_night_" : "_day_");
        sb.append(i5);
        return sb.toString();
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z5) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z5) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i5, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: b0.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult lambda$fromRawRes$2;
                lambda$fromRawRes$2 = LottieCompositionFactory.lambda$fromRawRes$2(weakReference, applicationContext, i5, str);
                return lambda$fromRawRes$2;
            }
        });
    }
}
