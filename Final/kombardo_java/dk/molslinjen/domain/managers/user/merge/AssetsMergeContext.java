package dk.molslinjen.domain.managers.user.merge;

import android.content.Context;
import dagger.hilt.android.EntryPointAccessors;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.MergeResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\b\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010RB\u0010\u0004\u001a4\b\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006#"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeContext;", BuildConfig.FLAVOR, "authToken", "Ldk/molslinjen/domain/model/account/AuthToken;", "merge", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeType;", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/account/MergeResult;", "applicationContext", "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroid/content/Context;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAuthToken-VBrIOyk", "()Ljava/lang/String;", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function3;", "items", BuildConfig.FLAVOR, "assetsMergers", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "[Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "getMergersFromHilt", "context", "(Landroid/content/Context;)[Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "mergePending", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "method", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;", "(Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssetsMergeContextEntryPoint", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssetsMergeContext {
    private IAssetsMerger[] assetsMergers;
    private final String authToken;
    private final List<AssetsMergeType<?>> items;
    private final Function3<List<? extends AssetsMergeType<?>>, AuthToken, Continuation<? super ManagerResult<MergeResult>>, Object> merge;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.user.merge.AssetsMergeContext$1", f = "AssetsMergeContext.kt", l = {34}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.user.merge.AssetsMergeContext$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x003d -> B:5:0x0040). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int length;
            int i5;
            IAssetsMerger[] iAssetsMergerArr;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.label;
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                IAssetsMerger[] iAssetsMergerArr2 = AssetsMergeContext.this.assetsMergers;
                if (iAssetsMergerArr2 != null) {
                    length = iAssetsMergerArr2.length;
                    i5 = 0;
                    iAssetsMergerArr = iAssetsMergerArr2;
                    if (i5 < length) {
                    }
                }
                return Unit.INSTANCE;
            }
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = this.I$1;
            i5 = this.I$0;
            iAssetsMergerArr = (IAssetsMerger[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            i5++;
            if (i5 < length) {
                IAssetsMerger iAssetsMerger = iAssetsMergerArr[i5];
                this.L$0 = iAssetsMergerArr;
                this.I$0 = i5;
                this.I$1 = length;
                this.label = 1;
                if (iAssetsMerger.reportLocalAssets(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i5++;
                if (i5 < length) {
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeContext$AssetsMergeContextEntryPoint;", BuildConfig.FLAVOR, "assetsMergers", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "()[Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface AssetsMergeContextEntryPoint {
        IAssetsMerger[] assetsMergers();
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AssetsMergeMethod.values().length];
            try {
                iArr[AssetsMergeMethod.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AssetsMergeMethod.Discard.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AssetsMergeContext(String str, Function3 function3, Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function3, context);
    }

    private final IAssetsMerger[] getMergersFromHilt(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return ((AssetsMergeContextEntryPoint) EntryPointAccessors.fromApplication(applicationContext, AssetsMergeContextEntryPoint.class)).assetsMergers();
    }

    /* renamed from: getAuthToken-VBrIOyk, reason: not valid java name and from getter */
    public final String getAuthToken() {
        return this.authToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00a3 -> B:11:0x00a4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object merge(AssetsMergeMethod assetsMergeMethod, Continuation<? super ManagerResult<MergeResult>> continuation) {
        AssetsMergeContext$merge$1 assetsMergeContext$merge$1;
        int i5;
        AssetsMergeContext assetsMergeContext;
        Object success;
        AssetsMergeContext assetsMergeContext2;
        IAssetsMerger[] iAssetsMergerArr;
        Object obj;
        int length;
        if (continuation instanceof AssetsMergeContext$merge$1) {
            assetsMergeContext$merge$1 = (AssetsMergeContext$merge$1) continuation;
            int i6 = assetsMergeContext$merge$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                assetsMergeContext$merge$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = assetsMergeContext$merge$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = assetsMergeContext$merge$1.label;
                int i7 = 0;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    int i8 = WhenMappings.$EnumSwitchMapping$0[assetsMergeMethod.ordinal()];
                    if (i8 == 1) {
                        Function3<List<? extends AssetsMergeType<?>>, AuthToken, Continuation<? super ManagerResult<MergeResult>>, Object> function3 = this.merge;
                        List<AssetsMergeType<?>> list = this.items;
                        AuthToken m3209boximpl = AuthToken.m3209boximpl(this.authToken);
                        assetsMergeContext$merge$1.L$0 = this;
                        assetsMergeContext$merge$1.label = 1;
                        obj2 = function3.invoke(list, m3209boximpl, assetsMergeContext$merge$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        assetsMergeContext = this;
                    } else {
                        if (i8 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        success = new ManagerResult.Success(new MergeResult(false));
                        assetsMergeContext2 = this;
                        iAssetsMergerArr = assetsMergeContext2.assetsMergers;
                        if (iAssetsMergerArr == null) {
                            return success;
                        }
                        obj = success;
                        length = iAssetsMergerArr.length;
                        if (i7 < length) {
                        }
                    }
                } else if (i5 == 1) {
                    assetsMergeContext = (AssetsMergeContext) assetsMergeContext$merge$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    length = assetsMergeContext$merge$1.I$1;
                    int i9 = assetsMergeContext$merge$1.I$0;
                    IAssetsMerger[] iAssetsMergerArr2 = (IAssetsMerger[]) assetsMergeContext$merge$1.L$1;
                    obj = (ManagerResult) assetsMergeContext$merge$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    iAssetsMergerArr = iAssetsMergerArr2;
                    i7 = i9 + 1;
                    if (i7 < length) {
                        IAssetsMerger iAssetsMerger = iAssetsMergerArr[i7];
                        assetsMergeContext$merge$1.L$0 = obj;
                        assetsMergeContext$merge$1.L$1 = iAssetsMergerArr;
                        assetsMergeContext$merge$1.I$0 = i7;
                        assetsMergeContext$merge$1.I$1 = length;
                        assetsMergeContext$merge$1.label = 2;
                        if (iAssetsMerger.removeLocalAssets(assetsMergeContext$merge$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i9 = i7;
                        i7 = i9 + 1;
                        if (i7 < length) {
                            return obj;
                        }
                    }
                }
                Object obj3 = (ManagerResult) obj2;
                assetsMergeContext2 = assetsMergeContext;
                success = obj3;
                iAssetsMergerArr = assetsMergeContext2.assetsMergers;
                if (iAssetsMergerArr == null) {
                }
            }
        }
        assetsMergeContext$merge$1 = new AssetsMergeContext$merge$1(this, continuation);
        Object obj22 = assetsMergeContext$merge$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = assetsMergeContext$merge$1.label;
        int i72 = 0;
        if (i5 != 0) {
        }
        Object obj32 = (ManagerResult) obj22;
        assetsMergeContext2 = assetsMergeContext;
        success = obj32;
        iAssetsMergerArr = assetsMergeContext2.assetsMergers;
        if (iAssetsMergerArr == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8 A[EDGE_INSN: B:34:0x00c8->B:24:0x00c8 BREAK  A[LOOP:0: B:27:0x00af->B:33:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007b -> B:10:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mergePending(Continuation<? super Boolean> continuation) {
        AssetsMergeContext$mergePending$1 assetsMergeContext$mergePending$1;
        int i5;
        List<AssetsMergeType<?>> list;
        AssetsMergeContext assetsMergeContext;
        List<AssetsMergeType<?>> list2;
        IAssetsMerger[] iAssetsMergerArr;
        int length;
        Collection<? extends AssetsMergeType<?>> collection;
        int i6;
        List emptyList;
        List<AssetsMergeType<?>> list3;
        Iterator<T> it;
        if (continuation instanceof AssetsMergeContext$mergePending$1) {
            assetsMergeContext$mergePending$1 = (AssetsMergeContext$mergePending$1) continuation;
            int i7 = assetsMergeContext$mergePending$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                assetsMergeContext$mergePending$1.label = i7 - Integer.MIN_VALUE;
                Object obj = assetsMergeContext$mergePending$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = assetsMergeContext$mergePending$1.label;
                boolean z5 = false;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    list = this.items;
                    IAssetsMerger[] iAssetsMergerArr2 = this.assetsMergers;
                    if (iAssetsMergerArr2 == null) {
                        assetsMergeContext = this;
                        emptyList = CollectionsKt.emptyList();
                        list2 = list;
                        list2.addAll(emptyList);
                        list3 = assetsMergeContext.items;
                        if (list3 instanceof Collection) {
                        }
                        it = list3.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                            }
                        }
                        return Boxing.boxBoolean(z5);
                    }
                    ArrayList arrayList = new ArrayList(iAssetsMergerArr2.length);
                    assetsMergeContext = this;
                    list2 = list;
                    iAssetsMergerArr = iAssetsMergerArr2;
                    length = iAssetsMergerArr2.length;
                    collection = arrayList;
                    i6 = 0;
                    if (i6 < length) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    length = assetsMergeContext$mergePending$1.I$1;
                    i6 = assetsMergeContext$mergePending$1.I$0;
                    collection = (Collection) assetsMergeContext$mergePending$1.L$4;
                    list2 = (List) assetsMergeContext$mergePending$1.L$3;
                    Collection<? extends AssetsMergeType<?>> collection2 = (Collection) assetsMergeContext$mergePending$1.L$2;
                    iAssetsMergerArr = (IAssetsMerger[]) assetsMergeContext$mergePending$1.L$1;
                    assetsMergeContext = (AssetsMergeContext) assetsMergeContext$mergePending$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    collection.add((AssetsMergeType) obj);
                    i6++;
                    collection = collection2;
                    if (i6 < length) {
                        IAssetsMerger iAssetsMerger = iAssetsMergerArr[i6];
                        assetsMergeContext$mergePending$1.L$0 = assetsMergeContext;
                        assetsMergeContext$mergePending$1.L$1 = iAssetsMergerArr;
                        assetsMergeContext$mergePending$1.L$2 = collection;
                        assetsMergeContext$mergePending$1.L$3 = list2;
                        assetsMergeContext$mergePending$1.L$4 = collection;
                        assetsMergeContext$mergePending$1.I$0 = i6;
                        assetsMergeContext$mergePending$1.I$1 = length;
                        assetsMergeContext$mergePending$1.label = 1;
                        obj = iAssetsMerger.reportLocalAssets(assetsMergeContext$mergePending$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection2 = collection;
                        collection.add((AssetsMergeType) obj);
                        i6++;
                        collection = collection2;
                        if (i6 < length) {
                            List list4 = (List) collection;
                            if (list4 == null) {
                                list = list2;
                                emptyList = CollectionsKt.emptyList();
                                list2 = list;
                                list2.addAll(emptyList);
                                list3 = assetsMergeContext.items;
                                if (list3 instanceof Collection) {
                                }
                                it = list3.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                    }
                                }
                                return Boxing.boxBoolean(z5);
                            }
                            emptyList = list4;
                            list2.addAll(emptyList);
                            list3 = assetsMergeContext.items;
                            if ((list3 instanceof Collection) || !list3.isEmpty()) {
                                it = list3.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    if (!((AssetsMergeType) it.next()).getItems().isEmpty()) {
                                        z5 = true;
                                        break;
                                    }
                                }
                            }
                            return Boxing.boxBoolean(z5);
                        }
                    }
                }
            }
        }
        assetsMergeContext$mergePending$1 = new AssetsMergeContext$mergePending$1(this, continuation);
        Object obj2 = assetsMergeContext$mergePending$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = assetsMergeContext$mergePending$1.label;
        boolean z52 = false;
        if (i5 != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AssetsMergeContext(String authToken, Function3<? super List<? extends AssetsMergeType<?>>, ? super AuthToken, ? super Continuation<? super ManagerResult<MergeResult>>, ? extends Object> merge, Context applicationContext) {
        Intrinsics.checkNotNullParameter(authToken, "authToken");
        Intrinsics.checkNotNullParameter(merge, "merge");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.authToken = authToken;
        this.merge = merge;
        this.items = new ArrayList();
        this.assetsMergers = getMergersFromHilt(applicationContext);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
    }
}
