package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001aB\u0010\f\u001a\u00020\u0004*\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082@¢\u0006\u0004\b\f\u0010\r\"\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "establishTextInputSession", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "chainedInterceptor", "session", "interceptedTextInputSession", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalChainedPlatformTextInputInterceptor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal<ChainedPlatformTextInputInterceptor> LocalChainedPlatformTextInputInterceptor = CompositionLocalKt.staticCompositionLocalOf(new Function0<ChainedPlatformTextInputInterceptor>() { // from class: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$LocalChainedPlatformTextInputInterceptor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChainedPlatformTextInputInterceptor invoke() {
            return null;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ChainedPlatformTextInputInterceptor invoke() {
            invoke();
            return null;
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object establishTextInputSession(PlatformTextInputModifierNode platformTextInputModifierNode, Function2<Object, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        PlatformTextInputModifierNodeKt$establishTextInputSession$1 platformTextInputModifierNodeKt$establishTextInputSession$1;
        int i5;
        if (continuation instanceof PlatformTextInputModifierNodeKt$establishTextInputSession$1) {
            platformTextInputModifierNodeKt$establishTextInputSession$1 = (PlatformTextInputModifierNodeKt$establishTextInputSession$1) continuation;
            int i6 = platformTextInputModifierNodeKt$establishTextInputSession$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                platformTextInputModifierNodeKt$establishTextInputSession$1.label = i6 - Integer.MIN_VALUE;
                Object obj = platformTextInputModifierNodeKt$establishTextInputSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = platformTextInputModifierNodeKt$establishTextInputSession$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!platformTextInputModifierNode.getNode().getIsAttached()) {
                        throw new IllegalArgumentException("establishTextInputSession called from an unattached node");
                    }
                    Owner requireOwner = DelegatableNodeKt.requireOwner(platformTextInputModifierNode);
                    android.support.v4.media.session.a.a(DelegatableNodeKt.requireLayoutNode(platformTextInputModifierNode).getCompositionLocalMap().get(LocalChainedPlatformTextInputInterceptor));
                    platformTextInputModifierNodeKt$establishTextInputSession$1.label = 1;
                    if (interceptedTextInputSession(requireOwner, null, function2, platformTextInputModifierNodeKt$establishTextInputSession$1) == coroutine_suspended) {
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
        platformTextInputModifierNodeKt$establishTextInputSession$1 = new PlatformTextInputModifierNodeKt$establishTextInputSession$1(continuation);
        Object obj2 = platformTextInputModifierNodeKt$establishTextInputSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = platformTextInputModifierNodeKt$establishTextInputSession$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object interceptedTextInputSession(Owner owner, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, Function2<Object, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 platformTextInputModifierNodeKt$interceptedTextInputSession$1;
        int i5;
        if (continuation instanceof PlatformTextInputModifierNodeKt$interceptedTextInputSession$1) {
            platformTextInputModifierNodeKt$interceptedTextInputSession$1 = (PlatformTextInputModifierNodeKt$interceptedTextInputSession$1) continuation;
            int i6 = platformTextInputModifierNodeKt$interceptedTextInputSession$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                platformTextInputModifierNodeKt$interceptedTextInputSession$1.label = i6 - Integer.MIN_VALUE;
                Object obj = platformTextInputModifierNodeKt$interceptedTextInputSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = platformTextInputModifierNodeKt$interceptedTextInputSession$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    platformTextInputModifierNodeKt$interceptedTextInputSession$1.label = 1;
                    if (owner.textInputSession(function2, platformTextInputModifierNodeKt$interceptedTextInputSession$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        throw new KotlinNothingValueException();
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        platformTextInputModifierNodeKt$interceptedTextInputSession$1 = new PlatformTextInputModifierNodeKt$interceptedTextInputSession$1(continuation);
        Object obj2 = platformTextInputModifierNodeKt$interceptedTextInputSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = platformTextInputModifierNodeKt$interceptedTextInputSession$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }
}
