package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import coil.ImageLoader;
import coil.content.Bitmaps;
import coil.content.Utils;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0013\u0010\u000e\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "Lcoil/decode/ImageSource;", "source", "Lcoil/request/Options;", "options", "Lkotlinx/coroutines/sync/Semaphore;", "parallelismLock", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "Landroid/graphics/BitmapFactory$Options;", "Lcoil/decode/DecodeResult;", "decode", "(Landroid/graphics/BitmapFactory$Options;)Lcoil/decode/DecodeResult;", "Lcoil/decode/ExifData;", "exifData", BuildConfig.FLAVOR, "configureConfig", "(Landroid/graphics/BitmapFactory$Options;Lcoil/decode/ExifData;)V", "configureScale", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/decode/ImageSource;", "Lcoil/request/Options;", "Lkotlinx/coroutines/sync/Semaphore;", "Lcoil/decode/ExifOrientationPolicy;", "Companion", "ExceptionCatchingSource", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitmapFactoryDecoder implements Decoder {
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", BuildConfig.FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long byteCount) {
            try {
                return super.read(sink, byteCount);
            } catch (Exception e5) {
                this.exception = e5;
                throw e5;
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", BuildConfig.FLAVOR, "maxParallelism", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(ILcoil/decode/ExifOrientationPolicy;)V", "Lcoil/fetch/SourceResult;", "result", "Lcoil/request/Options;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/decode/Decoder;", "create", "(Lcoil/fetch/SourceResult;Lcoil/request/Options;Lcoil/ImageLoader;)Lcoil/decode/Decoder;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcoil/decode/ExifOrientationPolicy;", "Lkotlinx/coroutines/sync/Semaphore;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        public Factory(int i5, ExifOrientationPolicy exifOrientationPolicy) {
            this.exifOrientationPolicy = exifOrientationPolicy;
            this.parallelismLock = SemaphoreKt.Semaphore$default(i5, 0, 2, null);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(result.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object other) {
            return other instanceof Factory;
        }

        public int hashCode() {
            return Factory.class.hashCode();
        }
    }

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphore;
        this.exifOrientationPolicy = exifOrientationPolicy;
    }

    private final void configureConfig(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config config = this.options.getConfig();
        if (exifData.getIsFlipped() || ExifUtilsKt.isRotated(exifData)) {
            config = Bitmaps.toSoftware(config);
        }
        if (this.options.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap.Config config2 = options.outConfig;
        Bitmap.Config config3 = Bitmap.Config.RGBA_F16;
        if (config2 == config3 && config != Bitmap.Config.HARDWARE) {
            config = config3;
        }
        options.inPreferredConfig = config;
    }

    private final void configureScale(BitmapFactory.Options options, ExifData exifData) {
        ImageSource.Metadata metadata = this.source.getMetadata();
        if ((metadata instanceof ResourceMetadata) && Sizes.isOriginal(this.options.getSize())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((ResourceMetadata) metadata).getDensity();
            options.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i5 = ExifUtilsKt.isSwapped(exifData) ? options.outHeight : options.outWidth;
        int i6 = ExifUtilsKt.isSwapped(exifData) ? options.outWidth : options.outHeight;
        Size size = this.options.getSize();
        int px = Sizes.isOriginal(size) ? i5 : Utils.toPx(size.getWidth(), this.options.getScale());
        Size size2 = this.options.getSize();
        int px2 = Sizes.isOriginal(size2) ? i6 : Utils.toPx(size2.getHeight(), this.options.getScale());
        int calculateInSampleSize = DecodeUtils.calculateInSampleSize(i5, i6, px, px2, this.options.getScale());
        options.inSampleSize = calculateInSampleSize;
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i5 / calculateInSampleSize, i6 / calculateInSampleSize, px, px2, this.options.getScale());
        if (this.options.getAllowInexactSize()) {
            computeSizeMultiplier = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
        }
        boolean z5 = computeSizeMultiplier == 1.0d;
        options.inScaled = !z5;
        if (z5) {
            return;
        }
        if (computeSizeMultiplier > 1.0d) {
            options.inDensity = MathKt.roundToInt(Integer.MAX_VALUE / computeSizeMultiplier);
            options.inTargetDensity = Integer.MAX_VALUE;
        } else {
            options.inDensity = Integer.MAX_VALUE;
            options.inTargetDensity = MathKt.roundToInt(Integer.MAX_VALUE * computeSizeMultiplier);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decode(Continuation<? super DecodeResult> continuation) {
        BitmapFactoryDecoder$decode$1 bitmapFactoryDecoder$decode$1;
        Object coroutine_suspended;
        int i5;
        Semaphore semaphore;
        final BitmapFactoryDecoder bitmapFactoryDecoder;
        Semaphore semaphore2;
        Throwable th;
        Object runInterruptible$default;
        try {
            if (continuation instanceof BitmapFactoryDecoder$decode$1) {
                bitmapFactoryDecoder$decode$1 = (BitmapFactoryDecoder$decode$1) continuation;
                int i6 = bitmapFactoryDecoder$decode$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    bitmapFactoryDecoder$decode$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = bitmapFactoryDecoder$decode$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = bitmapFactoryDecoder$decode$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        semaphore = this.parallelismLock;
                        bitmapFactoryDecoder$decode$1.L$0 = this;
                        bitmapFactoryDecoder$decode$1.L$1 = semaphore;
                        bitmapFactoryDecoder$decode$1.label = 1;
                        if (semaphore.acquire(bitmapFactoryDecoder$decode$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bitmapFactoryDecoder = this;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            semaphore2 = (Semaphore) bitmapFactoryDecoder$decode$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                DecodeResult decodeResult = (DecodeResult) obj;
                                semaphore2.release();
                                return decodeResult;
                            } catch (Throwable th2) {
                                th = th2;
                                semaphore2.release();
                                throw th;
                            }
                        }
                        Semaphore semaphore3 = (Semaphore) bitmapFactoryDecoder$decode$1.L$1;
                        bitmapFactoryDecoder = (BitmapFactoryDecoder) bitmapFactoryDecoder$decode$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        semaphore = semaphore3;
                    }
                    Function0<DecodeResult> function0 = new Function0<DecodeResult>() { // from class: coil.decode.BitmapFactoryDecoder$decode$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final DecodeResult invoke() {
                            DecodeResult decode;
                            decode = BitmapFactoryDecoder.this.decode(new BitmapFactory.Options());
                            return decode;
                        }
                    };
                    bitmapFactoryDecoder$decode$1.L$0 = semaphore;
                    bitmapFactoryDecoder$decode$1.L$1 = null;
                    bitmapFactoryDecoder$decode$1.label = 2;
                    runInterruptible$default = InterruptibleKt.runInterruptible$default(null, function0, bitmapFactoryDecoder$decode$1, 1, null);
                    if (runInterruptible$default != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    semaphore2 = semaphore;
                    obj = runInterruptible$default;
                    DecodeResult decodeResult2 = (DecodeResult) obj;
                    semaphore2.release();
                    return decodeResult2;
                }
            }
            Function0<DecodeResult> function02 = new Function0<DecodeResult>() { // from class: coil.decode.BitmapFactoryDecoder$decode$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DecodeResult invoke() {
                    DecodeResult decode;
                    decode = BitmapFactoryDecoder.this.decode(new BitmapFactory.Options());
                    return decode;
                }
            };
            bitmapFactoryDecoder$decode$1.L$0 = semaphore;
            bitmapFactoryDecoder$decode$1.L$1 = null;
            bitmapFactoryDecoder$decode$1.label = 2;
            runInterruptible$default = InterruptibleKt.runInterruptible$default(null, function02, bitmapFactoryDecoder$decode$1, 1, null);
            if (runInterruptible$default != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            semaphore2 = semaphore;
            th = th3;
            semaphore2.release();
            throw th;
        }
        bitmapFactoryDecoder$decode$1 = new BitmapFactoryDecoder$decode$1(this, continuation);
        Object obj2 = bitmapFactoryDecoder$decode$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bitmapFactoryDecoder$decode$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DecodeResult decode(BitmapFactory.Options options) {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.source.source());
        BufferedSource buffer = Okio.buffer(exceptionCatchingSource);
        boolean z5 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(buffer.peek().inputStream(), null, options);
        Exception exception = exceptionCatchingSource.getException();
        if (exception == null) {
            options.inJustDecodeBounds = false;
            ExifUtils exifUtils = ExifUtils.INSTANCE;
            ExifData exifData = exifUtils.getExifData(options.outMimeType, buffer, this.exifOrientationPolicy);
            Exception exception2 = exceptionCatchingSource.getException();
            if (exception2 == null) {
                options.inMutable = false;
                if (this.options.getColorSpace() != null) {
                    options.inPreferredColorSpace = this.options.getColorSpace();
                }
                options.inPremultiplied = this.options.getPremultipliedAlpha();
                configureConfig(options, exifData);
                configureScale(options, exifData);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(buffer.inputStream(), null, options);
                    CloseableKt.closeFinally(buffer, null);
                    Exception exception3 = exceptionCatchingSource.getException();
                    if (exception3 != null) {
                        throw exception3;
                    }
                    if (decodeStream != null) {
                        decodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), exifUtils.reverseTransformations(decodeStream, exifData));
                        if (options.inSampleSize <= 1 && !options.inScaled) {
                            z5 = false;
                        }
                        return new DecodeResult(bitmapDrawable, z5);
                    }
                    throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                } finally {
                }
            } else {
                throw exception2;
            }
        } else {
            throw exception;
        }
    }
}
