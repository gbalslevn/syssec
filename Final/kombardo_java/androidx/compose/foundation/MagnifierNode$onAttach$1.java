package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", l = {380, 384}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class MagnifierNode$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagnifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierNode$onAttach$1(MagnifierNode magnifierNode, Continuation<? super MagnifierNode$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = magnifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MagnifierNode$onAttach$1(this.this$0, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0038 -> B:8:0x0021). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:6:0x0045). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L32
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)
        L21:
            androidx.compose.foundation.MagnifierNode r5 = r4.this$0
            kotlinx.coroutines.channels.Channel r5 = androidx.compose.foundation.MagnifierNode.access$getDrawSignalChannel$p(r5)
            if (r5 == 0) goto L32
            r4.label = r3
            java.lang.Object r5 = r5.receive(r4)
            if (r5 != r0) goto L32
            return r0
        L32:
            androidx.compose.foundation.MagnifierNode r5 = r4.this$0
            androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r5)
            if (r5 == 0) goto L21
            androidx.compose.foundation.MagnifierNode$onAttach$1$1 r5 = new kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit>() { // from class: androidx.compose.foundation.MagnifierNode$onAttach$1.1
                static {
                    /*
                        androidx.compose.foundation.MagnifierNode$onAttach$1$1 r0 = new androidx.compose.foundation.MagnifierNode$onAttach$1$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.MagnifierNode$onAttach$1$1) androidx.compose.foundation.MagnifierNode$onAttach$1.1.INSTANCE androidx.compose.foundation.MagnifierNode$onAttach$1$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.AnonymousClass1.<init>():void");
                }

                public final void invoke(long r1) {
                    /*
                        r0 = this;
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.AnonymousClass1.invoke(long):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Long r3) {
                    /*
                        r2 = this;
                        java.lang.Number r3 = (java.lang.Number) r3
                        long r0 = r3.longValue()
                        r2.invoke(r0)
                        kotlin.Unit r3 = kotlin.Unit.INSTANCE
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r4.label = r2
            java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r4)
            if (r5 != r0) goto L45
            return r0
        L45:
            androidx.compose.foundation.MagnifierNode r5 = r4.this$0
            androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.access$getMagnifier$p(r5)
            if (r5 == 0) goto L21
            r5.updateContent()
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MagnifierNode$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
