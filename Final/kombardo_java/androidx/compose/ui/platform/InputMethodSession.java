package androidx.compose.ui.platform;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper_androidKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0006R$\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/InputMethodSession;", BuildConfig.FLAVOR, "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "onAllConnectionsClosed", "Lkotlin/Function0;", BuildConfig.FLAVOR, "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/jvm/functions/Function0;)V", "connections", "Landroidx/compose/runtime/collection/MutableVector;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "Landroidx/compose/ui/node/WeakReference;", "disposed", BuildConfig.FLAVOR, "isActive", "()Z", "lock", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "dispose", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InputMethodSession {
    private boolean disposed;
    private final Function0<Unit> onAllConnectionsClosed;
    private final PlatformTextInputMethodRequest request;
    private final Object lock = new Object();
    private MutableVector<WeakReference<NullableInputConnectionWrapper>> connections = new MutableVector<>(new WeakReference[16], 0);

    public InputMethodSession(PlatformTextInputMethodRequest platformTextInputMethodRequest, Function0<Unit> function0) {
        this.request = platformTextInputMethodRequest;
        this.onAllConnectionsClosed = function0;
    }

    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        synchronized (this.lock) {
            if (this.disposed) {
                return null;
            }
            NullableInputConnectionWrapper NullableInputConnectionWrapper = NullableInputConnectionWrapper_androidKt.NullableInputConnectionWrapper(this.request.createInputConnection(outAttrs), new Function1<NullableInputConnectionWrapper, Unit>() { // from class: androidx.compose.ui.platform.InputMethodSession$createInputConnection$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NullableInputConnectionWrapper nullableInputConnectionWrapper) {
                    invoke2(nullableInputConnectionWrapper);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
                /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
                /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(NullableInputConnectionWrapper nullableInputConnectionWrapper) {
                    MutableVector mutableVector;
                    int i5;
                    MutableVector mutableVector2;
                    Function0 function0;
                    MutableVector mutableVector3;
                    nullableInputConnectionWrapper.disposeDelegate();
                    mutableVector = InputMethodSession.this.connections;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        i5 = 0;
                        while (!Intrinsics.areEqual((WeakReference) content[i5], nullableInputConnectionWrapper)) {
                            i5++;
                            if (i5 >= size) {
                            }
                        }
                        if (i5 >= 0) {
                            mutableVector3 = InputMethodSession.this.connections;
                            mutableVector3.removeAt(i5);
                        }
                        mutableVector2 = InputMethodSession.this.connections;
                        if (mutableVector2.isEmpty()) {
                            return;
                        }
                        function0 = InputMethodSession.this.onAllConnectionsClosed;
                        function0.invoke();
                        return;
                    }
                    i5 = -1;
                    if (i5 >= 0) {
                    }
                    mutableVector2 = InputMethodSession.this.connections;
                    if (mutableVector2.isEmpty()) {
                    }
                }
            });
            this.connections.add(new WeakReference<>(NullableInputConnectionWrapper));
            return NullableInputConnectionWrapper;
        }
    }

    public final void dispose() {
        synchronized (this.lock) {
            try {
                this.disposed = true;
                MutableVector<WeakReference<NullableInputConnectionWrapper>> mutableVector = this.connections;
                int size = mutableVector.getSize();
                if (size > 0) {
                    WeakReference<NullableInputConnectionWrapper>[] content = mutableVector.getContent();
                    int i5 = 0;
                    do {
                        NullableInputConnectionWrapper nullableInputConnectionWrapper = content[i5].get();
                        if (nullableInputConnectionWrapper != null) {
                            nullableInputConnectionWrapper.disposeDelegate();
                        }
                        i5++;
                    } while (i5 < size);
                }
                this.connections.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isActive() {
        return !this.disposed;
    }
}
