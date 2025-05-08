package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", f = "AndroidOverscroll.android.kt", l = {638}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", f = "AndroidOverscroll.android.kt", l = {639, 643}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = androidEdgeEffectOverscrollEffect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x007e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:6:0x0067). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L67
            L17:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1f:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L40
            L27:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                r1 = r13
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                r12.L$0 = r1
                r12.label = r4
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r5 = r1
                r8 = r12
                java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r13 != r0) goto L40
                return r0
            L40:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r5 = r12.this$0
                long r6 = r13.getId()
                androidx.compose.ui.input.pointer.PointerId r6 = androidx.compose.ui.input.pointer.PointerId.m1869boximpl(r6)
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r5, r6)
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r5 = r12.this$0
                long r6 = r13.getPosition()
                androidx.compose.ui.geometry.Offset r13 = androidx.compose.ui.geometry.Offset.m1328boximpl(r6)
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerPosition$p(r5, r13)
            L5c:
                r12.L$0 = r1
                r12.label = r2
                java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r1, r3, r12, r4, r3)
                if (r13 != r0) goto L67
                return r0
            L67:
                androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                java.util.List r13 = r13.getChanges()
                java.util.ArrayList r5 = new java.util.ArrayList
                int r6 = r13.size()
                r5.<init>(r6)
                int r6 = r13.size()
                r7 = 0
                r8 = r7
            L7c:
                if (r8 >= r6) goto L91
                java.lang.Object r9 = r13.get(r8)
                r10 = r9
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r10 = r10.getPressed()
                if (r10 == 0) goto L8e
                r5.add(r9)
            L8e:
                int r8 = r8 + 1
                goto L7c
            L91:
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r12.this$0
                int r6 = r5.size()
            L97:
                if (r7 >= r6) goto Lb2
                java.lang.Object r8 = r5.get(r7)
                r9 = r8
                androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                long r9 = r9.getId()
                androidx.compose.ui.input.pointer.PointerId r11 = androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$getPointerId$p(r13)
                boolean r9 = androidx.compose.ui.input.pointer.PointerId.m1871equalsimpl(r9, r11)
                if (r9 == 0) goto Laf
                goto Lb3
            Laf:
                int r7 = r7 + 1
                goto L97
            Lb2:
                r8 = r3
            Lb3:
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                if (r8 != 0) goto Lbe
                java.lang.Object r13 = kotlin.collections.CollectionsKt.firstOrNull(r5)
                r8 = r13
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            Lbe:
                if (r8 == 0) goto Lda
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r12.this$0
                long r6 = r8.getId()
                androidx.compose.ui.input.pointer.PointerId r6 = androidx.compose.ui.input.pointer.PointerId.m1869boximpl(r6)
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r13, r6)
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r12.this$0
                long r6 = r8.getPosition()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m1328boximpl(r6)
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerPosition$p(r13, r6)
            Lda:
                boolean r13 = r5.isEmpty()
                if (r13 == 0) goto L5c
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = r12.this$0
                androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.access$setPointerId$p(r13, r3)
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == coroutine_suspended) {
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
}
