package dk.molslinjen.ui.views.reusable.barcode;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.ImageBitmap;
import com.sun.jna.Function;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt$BarcodeView$2$1", f = "BarcodeView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class BarcodeViewKt$BarcodeView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ImageBitmap> $barcodeBitmap;
    final /* synthetic */ float $heightPixels;
    final /* synthetic */ int $resolutionFactor;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ BarcodeViewType $type;
    final /* synthetic */ String $value;
    final /* synthetic */ float $widthPixels;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt$BarcodeView$2$1$1", f = "BarcodeView.kt", l = {Function.ALT_CONVENTION}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt$BarcodeView$2$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<ImageBitmap> $barcodeBitmap;
        final /* synthetic */ float $heightPixels;
        final /* synthetic */ int $resolutionFactor;
        final /* synthetic */ BarcodeViewType $type;
        final /* synthetic */ String $value;
        final /* synthetic */ float $widthPixels;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt$BarcodeView$2$1$1$1", f = "BarcodeView.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt$BarcodeView$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableState<ImageBitmap> $barcodeBitmap;
            final /* synthetic */ float $heightPixels;
            final /* synthetic */ int $resolutionFactor;
            final /* synthetic */ BarcodeViewType $type;
            final /* synthetic */ String $value;
            final /* synthetic */ float $widthPixels;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00481(MutableState<ImageBitmap> mutableState, BarcodeViewType barcodeViewType, float f5, int i5, float f6, String str, Continuation<? super C00481> continuation) {
                super(2, continuation);
                this.$barcodeBitmap = mutableState;
                this.$type = barcodeViewType;
                this.$widthPixels = f5;
                this.$resolutionFactor = i5;
                this.$heightPixels = f6;
                this.$value = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00481(this.$barcodeBitmap, this.$type, this.$widthPixels, this.$resolutionFactor, this.$heightPixels, this.$value, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ImageBitmap imageBitmap;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutableState<ImageBitmap> mutableState = this.$barcodeBitmap;
                try {
                    BarcodeViewType barcodeViewType = this.$type;
                    float f5 = this.$widthPixels;
                    int i5 = this.$resolutionFactor;
                    imageBitmap = barcodeViewType.getImageBitmap$app_kombardoProd((int) (f5 * i5), (int) (this.$heightPixels * i5), this.$value);
                } catch (Exception e5) {
                    Logger.INSTANCE.logCritical(new CriticalLog("Invalid Barcode Format: " + e5.getMessage()));
                    imageBitmap = null;
                }
                mutableState.setValue(imageBitmap);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<ImageBitmap> mutableState, BarcodeViewType barcodeViewType, float f5, int i5, float f6, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$barcodeBitmap = mutableState;
            this.$type = barcodeViewType;
            this.$widthPixels = f5;
            this.$resolutionFactor = i5;
            this.$heightPixels = f6;
            this.$value = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$barcodeBitmap, this.$type, this.$widthPixels, this.$resolutionFactor, this.$heightPixels, this.$value, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                C00481 c00481 = new C00481(this.$barcodeBitmap, this.$type, this.$widthPixels, this.$resolutionFactor, this.$heightPixels, this.$value, null);
                this.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, c00481, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarcodeViewKt$BarcodeView$2$1(CoroutineScope coroutineScope, MutableState<ImageBitmap> mutableState, BarcodeViewType barcodeViewType, float f5, int i5, float f6, String str, Continuation<? super BarcodeViewKt$BarcodeView$2$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$barcodeBitmap = mutableState;
        this.$type = barcodeViewType;
        this.$widthPixels = f5;
        this.$resolutionFactor = i5;
        this.$heightPixels = f6;
        this.$value = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BarcodeViewKt$BarcodeView$2$1(this.$scope, this.$barcodeBitmap, this.$type, this.$widthPixels, this.$resolutionFactor, this.$heightPixels, this.$value, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass1(this.$barcodeBitmap, this.$type, this.$widthPixels, this.$resolutionFactor, this.$heightPixels, this.$value, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BarcodeViewKt$BarcodeView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
