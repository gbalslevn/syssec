package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {54, 76, 79}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {31}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "R", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00681<T> implements FlowCollector {
            final /* synthetic */ int $i;
            final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;

            C00681(Channel<IndexedValue<Object>> channel, int i5) {
                this.$resultChannel = channel;
                this.$i = i5;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T t5, Continuation<? super Unit> continuation) {
                CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                Object coroutine_suspended;
                int i5;
                if (continuation instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                    combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuation;
                    int i6 = combineKt$combineInternal$2$1$1$emit$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        combineKt$combineInternal$2$1$1$emit$1.label = i6 - Integer.MIN_VALUE;
                        Object obj = combineKt$combineInternal$2$1$1$emit$1.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = combineKt$combineInternal$2$1$1$emit$1.label;
                        if (i5 != 0) {
                            ResultKt.throwOnFailure(obj);
                            Channel<IndexedValue<Object>> channel = this.$resultChannel;
                            IndexedValue<Object> indexedValue = new IndexedValue<>(this.$i, t5);
                            combineKt$combineInternal$2$1$1$emit$1.label = 1;
                            if (channel.send(indexedValue, combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        combineKt$combineInternal$2$1$1$emit$1.label = 2;
                        if (YieldKt.yield(combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                Object obj2 = combineKt$combineInternal$2$1$1$emit$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = combineKt$combineInternal$2$1$1$emit$1.label;
                if (i5 != 0) {
                }
                combineKt$combineInternal$2$1$1$emit$1.label = 2;
                if (YieldKt.yield(combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T>[] flowArr, int i5, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$i = i5;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger atomicInteger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow[] flowArr = this.$flows;
                    int i6 = this.$i;
                    Flow flow = flowArr[i6];
                    C00681 c00681 = new C00681(this.$resultChannel, i6);
                    this.label = 1;
                    if (flow.collect(c00681, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                }
                return Unit.INSTANCE;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef A[EDGE_INSN: B:38:0x00ef->B:27:0x00ef BREAK  A[LOOP:0: B:19:0x00ca->B:37:?], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [kotlinx.coroutines.flow.Flow[], kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0135 -> B:10:0x0137). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object[] objArr;
        byte b5;
        byte[] bArr;
        int i5;
        Channel channel;
        Object obj2;
        Object[] objArr2;
        byte b6;
        IndexedValue indexedValue;
        int index;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int length = this.$flows.length;
            if (length == 0) {
                return Unit.INSTANCE;
            }
            objArr = new Object[length];
            ArraysKt.fill$default(objArr, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (Object) null);
            Channel Channel$default = ChannelKt.Channel$default(length, null, null, 6, null);
            AtomicInteger atomicInteger = new AtomicInteger(length);
            b5 = 0;
            int i7 = 0;
            while (i7 < length) {
                int i8 = i7;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$flows, i8, atomicInteger, Channel$default, null), 3, null);
                i7 = i8 + 1;
                atomicInteger = atomicInteger;
            }
            bArr = new byte[length];
            i5 = length;
            channel = Channel$default;
            b6 = (byte) (b5 + 1);
            this.L$0 = objArr;
            this.L$1 = channel;
            this.L$2 = bArr;
            this.I$0 = i5;
            this.I$1 = b6;
            this.label = 1;
            obj2 = channel.mo3765receiveCatchingJP2dKIU(this);
            if (obj2 != coroutine_suspended) {
            }
        } else if (i6 == 1) {
            ?? r22 = this.I$1;
            i5 = this.I$0;
            byte[] bArr2 = (byte[]) this.L$2;
            Channel channel2 = (Channel) this.L$1;
            objArr2 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = ((ChannelResult) obj).getHolder();
            b6 = r22;
            bArr = bArr2;
            channel = channel2;
            indexedValue = (IndexedValue) ChannelResult.m3772getOrNullimpl(obj2);
            if (indexedValue == null) {
            }
            do {
                index = indexedValue.getIndex();
                obj3 = objArr2[index];
                objArr2[index] = indexedValue.getValue();
                if (obj3 == NullSurrogateKt.UNINITIALIZED) {
                }
                if (bArr[index] != b6) {
                }
            } while (indexedValue != null);
            if (i5 == 0) {
            }
            b5 = b6;
            objArr = objArr2;
            b6 = (byte) (b5 + 1);
            this.L$0 = objArr;
            this.L$1 = channel;
            this.L$2 = bArr;
            this.I$0 = i5;
            this.I$1 = b6;
            this.label = 1;
            obj2 = channel.mo3765receiveCatchingJP2dKIU(this);
            if (obj2 != coroutine_suspended) {
            }
        } else {
            if (i6 != 2 && i6 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ?? r23 = this.I$1;
            i5 = this.I$0;
            byte[] bArr3 = (byte[]) this.L$2;
            Channel channel3 = (Channel) this.L$1;
            objArr2 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            b5 = r23;
            bArr = bArr3;
            channel = channel3;
            objArr = objArr2;
            b6 = (byte) (b5 + 1);
            this.L$0 = objArr;
            this.L$1 = channel;
            this.L$2 = bArr;
            this.I$0 = i5;
            this.I$1 = b6;
            this.label = 1;
            obj2 = channel.mo3765receiveCatchingJP2dKIU(this);
            if (obj2 != coroutine_suspended) {
                return coroutine_suspended;
            }
            objArr2 = objArr;
            indexedValue = (IndexedValue) ChannelResult.m3772getOrNullimpl(obj2);
            if (indexedValue == null) {
                return Unit.INSTANCE;
            }
            do {
                index = indexedValue.getIndex();
                obj3 = objArr2[index];
                objArr2[index] = indexedValue.getValue();
                if (obj3 == NullSurrogateKt.UNINITIALIZED) {
                    i5--;
                }
                if (bArr[index] != b6) {
                    break;
                }
                bArr[index] = b6;
                indexedValue = (IndexedValue) ChannelResult.m3772getOrNullimpl(channel.mo3766tryReceivePtdJZtk());
            } while (indexedValue != null);
            if (i5 == 0) {
                Object[] objArr3 = (Object[]) this.$arrayFactory.invoke();
                if (objArr3 == null) {
                    Function3 function3 = this.$transform;
                    Object obj4 = this.$this_combineInternal;
                    this.L$0 = objArr2;
                    this.L$1 = channel;
                    this.L$2 = bArr;
                    this.I$0 = i5;
                    this.I$1 = b6;
                    this.label = 2;
                    if (function3.invoke(obj4, objArr2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    ArraysKt.copyInto$default(objArr2, objArr3, 0, 0, 0, 14, (Object) null);
                    Function3 function32 = this.$transform;
                    Object obj5 = this.$this_combineInternal;
                    this.L$0 = objArr2;
                    this.L$1 = channel;
                    this.L$2 = bArr;
                    this.I$0 = i5;
                    this.I$1 = b6;
                    this.label = 3;
                    if (function32.invoke(obj5, objArr3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            b5 = b6;
            objArr = objArr2;
            b6 = (byte) (b5 + 1);
            this.L$0 = objArr;
            this.L$1 = channel;
            this.L$2 = bArr;
            this.I$0 = i5;
            this.I$1 = b6;
            this.label = 1;
            obj2 = channel.mo3765receiveCatchingJP2dKIU(this);
            if (obj2 != coroutine_suspended) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
