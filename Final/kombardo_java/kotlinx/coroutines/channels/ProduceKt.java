package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001ab\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2*\b\u0001\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0096\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016j\u0004\u0018\u0001`\u00182*\b\u0001\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "block", "awaitClose", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", BuildConfig.FLAVOR, "capacity", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/channels/ReceiveChannel;", "produce", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitClose(ProducerScope<?> producerScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        ProduceKt$awaitClose$1 produceKt$awaitClose$1;
        int i5;
        try {
            if (continuation instanceof ProduceKt$awaitClose$1) {
                produceKt$awaitClose$1 = (ProduceKt$awaitClose$1) continuation;
                int i6 = produceKt$awaitClose$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    produceKt$awaitClose$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = produceKt$awaitClose$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = produceKt$awaitClose$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (produceKt$awaitClose$1.getContext().get(Job.INSTANCE) != producerScope) {
                            throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                        }
                        produceKt$awaitClose$1.L$0 = producerScope;
                        produceKt$awaitClose$1.L$1 = function0;
                        produceKt$awaitClose$1.label = 1;
                        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(produceKt$awaitClose$1), 1);
                        cancellableContinuationImpl.initCancellability();
                        producerScope.invokeOnClose(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                            }
                        });
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(produceKt$awaitClose$1);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function0 = (Function0) produceKt$awaitClose$1.L$1;
                        ResultKt.throwOnFailure(obj);
                    }
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            }
            if (i5 != 0) {
            }
            function0.invoke();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            function0.invoke();
            throw th;
        }
        produceKt$awaitClose$1 = new ProduceKt$awaitClose$1(continuation);
        Object obj2 = produceKt$awaitClose$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = produceKt$awaitClose$1.label;
    }

    public static /* synthetic */ Object awaitClose$default(ProducerScope producerScope, Function0 function0, Continuation continuation, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            function0 = new Function0<Unit>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return awaitClose(producerScope, function0, continuation);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i5, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return produce(coroutineScope, coroutineContext, i5, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, function2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i5, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return produce(coroutineScope, coroutineContext, i5, function2);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i5, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1<? super Throwable, Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), ChannelKt.Channel$default(i5, bufferOverflow, null, 4, null));
        if (function1 != null) {
            producerCoroutine.invokeOnCompletion(function1);
        }
        producerCoroutine.start(coroutineStart, producerCoroutine, function2);
        return producerCoroutine;
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i5, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        int i7 = i5;
        if ((i6 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i6 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i6 & 16) != 0) {
            function1 = null;
        }
        return produce(coroutineScope, coroutineContext2, i7, bufferOverflow2, coroutineStart2, function1, function2);
    }
}
