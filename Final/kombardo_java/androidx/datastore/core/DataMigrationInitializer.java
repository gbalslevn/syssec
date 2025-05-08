package androidx.datastore.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", "T", BuildConfig.FLAVOR, "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DataMigrationInitializer<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0082@¢\u0006\u0004\b\u000b\u0010\fJI\u0010\u000f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "T", BuildConfig.FLAVOR, "Landroidx/datastore/core/DataMigration;", "migrations", "Landroidx/datastore/core/InitializerApi;", "api", BuildConfig.FLAVOR, "runMigrations", "(Ljava/util/List;Landroidx/datastore/core/InitializerApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "getInitializer", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Throwable, T] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0088 -> B:13:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008b -> B:13:0x006b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object runMigrations(List<? extends DataMigration<T>> list, InitializerApi<T> initializerApi, Continuation<? super Unit> continuation) {
            DataMigrationInitializer$Companion$runMigrations$1 dataMigrationInitializer$Companion$runMigrations$1;
            int i5;
            List list2;
            Ref$ObjectRef ref$ObjectRef;
            Iterator<T> it;
            Throwable th;
            if (continuation instanceof DataMigrationInitializer$Companion$runMigrations$1) {
                dataMigrationInitializer$Companion$runMigrations$1 = (DataMigrationInitializer$Companion$runMigrations$1) continuation;
                int i6 = dataMigrationInitializer$Companion$runMigrations$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    dataMigrationInitializer$Companion$runMigrations$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = dataMigrationInitializer$Companion$runMigrations$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = dataMigrationInitializer$Companion$runMigrations$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList = new ArrayList();
                        Function2<? super T, ? super Continuation<? super T>, ? extends Object> dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2<>(list, arrayList, null);
                        dataMigrationInitializer$Companion$runMigrations$1.L$0 = arrayList;
                        dataMigrationInitializer$Companion$runMigrations$1.label = 1;
                        if (initializerApi.updateData(dataMigrationInitializer$Companion$runMigrations$2, dataMigrationInitializer$Companion$runMigrations$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list2 = arrayList;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            it = (Iterator) dataMigrationInitializer$Companion$runMigrations$1.L$1;
                            ref$ObjectRef = (Ref$ObjectRef) dataMigrationInitializer$Companion$runMigrations$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Throwable 
                            /*  JADX ERROR: Method code generation error
                                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:367)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:330)
                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                */
                            /*
                                this = this;
                                boolean r0 = r9 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                                if (r0 == 0) goto L13
                                r0 = r9
                                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                                r0.<init>(r6, r9)
                            L18:
                                java.lang.Object r9 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 2
                                r4 = 1
                                if (r2 == 0) goto L46
                                if (r2 == r4) goto L3e
                                if (r2 != r3) goto L36
                                java.lang.Object r7 = r0.L$1
                                java.util.Iterator r7 = (java.util.Iterator) r7
                                java.lang.Object r8 = r0.L$0
                                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
                                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L34
                                goto L6b
                            L34:
                                r9 = move-exception
                                goto L84
                            L36:
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r8)
                                throw r7
                            L3e:
                                java.lang.Object r7 = r0.L$0
                                java.util.List r7 = (java.util.List) r7
                                kotlin.ResultKt.throwOnFailure(r9)
                                goto L60
                            L46:
                                kotlin.ResultKt.throwOnFailure(r9)
                                java.util.ArrayList r9 = new java.util.ArrayList
                                r9.<init>()
                                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r2 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                                r5 = 0
                                r2.<init>(r7, r9, r5)
                                r0.L$0 = r9
                                r0.label = r4
                                java.lang.Object r7 = r8.updateData(r2, r0)
                                if (r7 != r1) goto L5f
                                return r1
                            L5f:
                                r7 = r9
                            L60:
                                kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
                                r8.<init>()
                                java.lang.Iterable r7 = (java.lang.Iterable) r7
                                java.util.Iterator r7 = r7.iterator()
                            L6b:
                                boolean r9 = r7.hasNext()
                                if (r9 == 0) goto L94
                                java.lang.Object r9 = r7.next()
                                kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                                r0.L$0 = r8     // Catch: java.lang.Throwable -> L34
                                r0.L$1 = r7     // Catch: java.lang.Throwable -> L34
                                r0.label = r3     // Catch: java.lang.Throwable -> L34
                                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                                if (r9 != r1) goto L6b
                                return r1
                            L84:
                                T r2 = r8.element
                                if (r2 != 0) goto L8b
                                r8.element = r9
                                goto L6b
                            L8b:
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                                java.lang.Throwable r2 = (java.lang.Throwable) r2
                                kotlin.ExceptionsKt.addSuppressed(r2, r9)
                                goto L6b
                            L94:
                                T r7 = r8.element
                                java.lang.Throwable r7 = (java.lang.Throwable) r7
                                if (r7 != 0) goto L9d
                                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                return r7
                            L9d:
                                throw r7
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.runMigrations(java.util.List, androidx.datastore.core.InitializerApi, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        public final <T> Function2<InitializerApi<T>, Continuation<? super Unit>, Object> getInitializer(List<? extends DataMigration<T>> migrations) {
                            Intrinsics.checkNotNullParameter(migrations, "migrations");
                            return new DataMigrationInitializer$Companion$getInitializer$1(migrations, null);
                        }

                        private Companion() {
                        }
                    }
                }
