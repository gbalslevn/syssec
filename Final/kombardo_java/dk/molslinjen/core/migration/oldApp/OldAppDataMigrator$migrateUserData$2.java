package dk.molslinjen.core.migration.oldApp;

import android.content.Context;
import dk.molslinjen.core.migration.oldApp.OldAppDataMigrator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2", f = "OldAppDataMigrator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OldAppDataMigrator$migrateUserData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ OldAppUser $oldAppUser;
    final /* synthetic */ List<OldAppDataMigrator.MigrationResult> $results;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OldAppDataMigrator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$1", f = "OldAppDataMigrator.kt", l = {94}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ OldAppUser $oldAppUser;
        final /* synthetic */ List<OldAppDataMigrator.MigrationResult> $results;
        Object L$0;
        int label;
        final /* synthetic */ OldAppDataMigrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<OldAppDataMigrator.MigrationResult> list, OldAppDataMigrator oldAppDataMigrator, OldAppUser oldAppUser, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$results = list;
            this.this$0 = oldAppDataMigrator;
            this.$oldAppUser = oldAppUser;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$results, this.this$0, this.$oldAppUser, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object migrateBookings;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                List<OldAppDataMigrator.MigrationResult> list2 = this.$results;
                OldAppDataMigrator oldAppDataMigrator = this.this$0;
                OldAppUser oldAppUser = this.$oldAppUser;
                Context context = this.$context;
                this.L$0 = list2;
                this.label = 1;
                migrateBookings = oldAppDataMigrator.migrateBookings(oldAppUser, context, this);
                if (migrateBookings == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = migrateBookings;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.add(obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$2", f = "OldAppDataMigrator.kt", l = {95}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ OldAppUser $oldAppUser;
        final /* synthetic */ List<OldAppDataMigrator.MigrationResult> $results;
        Object L$0;
        int label;
        final /* synthetic */ OldAppDataMigrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<OldAppDataMigrator.MigrationResult> list, OldAppDataMigrator oldAppDataMigrator, OldAppUser oldAppUser, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$results = list;
            this.this$0 = oldAppDataMigrator;
            this.$oldAppUser = oldAppUser;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$results, this.this$0, this.$oldAppUser, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object migrateUserInfo;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                List<OldAppDataMigrator.MigrationResult> list2 = this.$results;
                OldAppDataMigrator oldAppDataMigrator = this.this$0;
                OldAppUser oldAppUser = this.$oldAppUser;
                Context context = this.$context;
                this.L$0 = list2;
                this.label = 1;
                migrateUserInfo = oldAppDataMigrator.migrateUserInfo(oldAppUser, context, this);
                if (migrateUserInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = migrateUserInfo;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.add(obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$3", f = "OldAppDataMigrator.kt", l = {96}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ OldAppUser $oldAppUser;
        final /* synthetic */ List<OldAppDataMigrator.MigrationResult> $results;
        Object L$0;
        int label;
        final /* synthetic */ OldAppDataMigrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<OldAppDataMigrator.MigrationResult> list, OldAppDataMigrator oldAppDataMigrator, OldAppUser oldAppUser, Context context, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$results = list;
            this.this$0 = oldAppDataMigrator;
            this.$oldAppUser = oldAppUser;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$results, this.this$0, this.$oldAppUser, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object migrateAgreements;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                List<OldAppDataMigrator.MigrationResult> list2 = this.$results;
                OldAppDataMigrator oldAppDataMigrator = this.this$0;
                OldAppUser oldAppUser = this.$oldAppUser;
                Context context = this.$context;
                this.L$0 = list2;
                this.label = 1;
                migrateAgreements = oldAppDataMigrator.migrateAgreements(oldAppUser, context, this);
                if (migrateAgreements == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = migrateAgreements;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.add(obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$4", f = "OldAppDataMigrator.kt", l = {97}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ OldAppUser $oldAppUser;
        final /* synthetic */ List<OldAppDataMigrator.MigrationResult> $results;
        Object L$0;
        int label;
        final /* synthetic */ OldAppDataMigrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(List<OldAppDataMigrator.MigrationResult> list, OldAppDataMigrator oldAppDataMigrator, OldAppUser oldAppUser, Context context, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$results = list;
            this.this$0 = oldAppDataMigrator;
            this.$oldAppUser = oldAppUser;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$results, this.this$0, this.$oldAppUser, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object migratePassengers;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                List<OldAppDataMigrator.MigrationResult> list2 = this.$results;
                OldAppDataMigrator oldAppDataMigrator = this.this$0;
                OldAppUser oldAppUser = this.$oldAppUser;
                Context context = this.$context;
                this.L$0 = list2;
                this.label = 1;
                migratePassengers = oldAppDataMigrator.migratePassengers(oldAppUser, context, this);
                if (migratePassengers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = migratePassengers;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.add(obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$5", f = "OldAppDataMigrator.kt", l = {98}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateUserData$2$5, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ OldAppUser $oldAppUser;
        final /* synthetic */ List<OldAppDataMigrator.MigrationResult> $results;
        Object L$0;
        int label;
        final /* synthetic */ OldAppDataMigrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(List<OldAppDataMigrator.MigrationResult> list, OldAppDataMigrator oldAppDataMigrator, OldAppUser oldAppUser, Context context, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$results = list;
            this.this$0 = oldAppDataMigrator;
            this.$oldAppUser = oldAppUser;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$results, this.this$0, this.$oldAppUser, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object migrateCreditCards;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                List<OldAppDataMigrator.MigrationResult> list2 = this.$results;
                OldAppDataMigrator oldAppDataMigrator = this.this$0;
                OldAppUser oldAppUser = this.$oldAppUser;
                Context context = this.$context;
                this.L$0 = list2;
                this.label = 1;
                migrateCreditCards = oldAppDataMigrator.migrateCreditCards(oldAppUser, context, this);
                if (migrateCreditCards == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = migrateCreditCards;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.add(obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldAppDataMigrator$migrateUserData$2(List<OldAppDataMigrator.MigrationResult> list, OldAppDataMigrator oldAppDataMigrator, OldAppUser oldAppUser, Context context, Continuation<? super OldAppDataMigrator$migrateUserData$2> continuation) {
        super(2, continuation);
        this.$results = list;
        this.this$0 = oldAppDataMigrator;
        this.$oldAppUser = oldAppUser;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OldAppDataMigrator$migrateUserData$2 oldAppDataMigrator$migrateUserData$2 = new OldAppDataMigrator$migrateUserData$2(this.$results, this.this$0, this.$oldAppUser, this.$context, continuation);
        oldAppDataMigrator$migrateUserData$2.L$0 = obj;
        return oldAppDataMigrator$migrateUserData$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$results, this.this$0, this.$oldAppUser, this.$context, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$results, this.this$0, this.$oldAppUser, this.$context, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(this.$results, this.this$0, this.$oldAppUser, this.$context, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass4(this.$results, this.this$0, this.$oldAppUser, this.$context, null), 3, null);
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass5(this.$results, this.this$0, this.$oldAppUser, this.$context, null), 3, null);
        return launch$default;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((OldAppDataMigrator$migrateUserData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
