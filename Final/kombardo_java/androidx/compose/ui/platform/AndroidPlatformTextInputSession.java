package androidx.compose.ui.platform;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.text.input.TextInputService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View;", "view", "Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "coroutineScope", "<init>", "(Landroid/view/View;Landroidx/compose/ui/text/input/TextInputService;Lkotlinx/coroutines/CoroutineScope;)V", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "request", BuildConfig.FLAVOR, "startInputMethod", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "createInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroidx/compose/ui/text/input/TextInputService;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/InputMethodSession;", "methodSessionMutex", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", BuildConfig.FLAVOR, "isReadyForConnection", "()Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPlatformTextInputSession implements PlatformTextInputSession, CoroutineScope {
    private final CoroutineScope coroutineScope;
    private final AtomicReference methodSessionMutex = SessionMutex.m1252constructorimpl();
    private final TextInputService textInputService;
    private final View view;

    public AndroidPlatformTextInputSession(View view, TextInputService textInputService, CoroutineScope coroutineScope) {
        this.view = view;
        this.textInputService = textInputService;
        this.coroutineScope = coroutineScope;
    }

    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        InputMethodSession inputMethodSession = (InputMethodSession) SessionMutex.m1254getCurrentSessionimpl(this.methodSessionMutex);
        if (inputMethodSession != null) {
            return inputMethodSession.createInputConnection(outAttrs);
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineScope.getCoroutineContext();
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputSession
    public View getView() {
        return this.view;
    }

    public final boolean isReadyForConnection() {
        InputMethodSession inputMethodSession = (InputMethodSession) SessionMutex.m1254getCurrentSessionimpl(this.methodSessionMutex);
        return inputMethodSession != null && inputMethodSession.isActive();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.ui.platform.PlatformTextInputSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startInputMethod(final PlatformTextInputMethodRequest platformTextInputMethodRequest, Continuation<?> continuation) {
        AndroidPlatformTextInputSession$startInputMethod$1 androidPlatformTextInputSession$startInputMethod$1;
        int i5;
        if (continuation instanceof AndroidPlatformTextInputSession$startInputMethod$1) {
            androidPlatformTextInputSession$startInputMethod$1 = (AndroidPlatformTextInputSession$startInputMethod$1) continuation;
            int i6 = androidPlatformTextInputSession$startInputMethod$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                androidPlatformTextInputSession$startInputMethod$1.label = i6 - Integer.MIN_VALUE;
                Object obj = androidPlatformTextInputSession$startInputMethod$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = androidPlatformTextInputSession$startInputMethod$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AtomicReference atomicReference = this.methodSessionMutex;
                    Function1<CoroutineScope, InputMethodSession> function1 = new Function1<CoroutineScope, InputMethodSession>() { // from class: androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final InputMethodSession invoke(CoroutineScope coroutineScope) {
                            PlatformTextInputMethodRequest platformTextInputMethodRequest2 = PlatformTextInputMethodRequest.this;
                            final AndroidPlatformTextInputSession androidPlatformTextInputSession = this;
                            return new InputMethodSession(platformTextInputMethodRequest2, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$2.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    CoroutineScope coroutineScope2;
                                    coroutineScope2 = AndroidPlatformTextInputSession.this.coroutineScope;
                                    CoroutineScopeKt.cancel$default(coroutineScope2, null, 1, null);
                                }
                            });
                        }
                    };
                    AndroidPlatformTextInputSession$startInputMethod$3 androidPlatformTextInputSession$startInputMethod$3 = new AndroidPlatformTextInputSession$startInputMethod$3(this, null);
                    androidPlatformTextInputSession$startInputMethod$1.label = 1;
                    if (SessionMutex.m1255withSessionCancellingPreviousimpl(atomicReference, function1, androidPlatformTextInputSession$startInputMethod$3, androidPlatformTextInputSession$startInputMethod$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        androidPlatformTextInputSession$startInputMethod$1 = new AndroidPlatformTextInputSession$startInputMethod$1(this, continuation);
        Object obj2 = androidPlatformTextInputSession$startInputMethod$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = androidPlatformTextInputSession$startInputMethod$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }
}
