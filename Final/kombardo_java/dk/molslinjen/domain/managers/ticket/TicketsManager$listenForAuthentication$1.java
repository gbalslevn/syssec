package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1", f = "TicketsManager.kt", l = {93}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$listenForAuthentication$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "newAuthenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1", f = "TicketsManager.kt", l = {94}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<AuthenticationType, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TicketsManager this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1$1", f = "TicketsManager.kt", l = {97, 99}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00391 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TicketsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00391(TicketsManager ticketsManager, Continuation<? super C00391> continuation) {
                super(1, continuation);
                this.this$0 = ticketsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00391(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object updateWithBookingsFromCommuterManager;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    TicketsManager ticketsManager = this.this$0;
                    this.label = 1;
                    if (ticketsManager.removeLocalAssets(this) == coroutine_suspended) {
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
                TicketsManager ticketsManager2 = this.this$0;
                this.label = 2;
                updateWithBookingsFromCommuterManager = ticketsManager2.updateWithBookingsFromCommuterManager(this);
                if (updateWithBookingsFromCommuterManager == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00391) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1$2", f = "TicketsManager.kt", l = {102, 104}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TicketsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TicketsManager ticketsManager, Continuation<? super AnonymousClass2> continuation) {
                super(1, continuation);
                this.this$0 = ticketsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object updateWithBookingsFromCommuterManager;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    TicketsManager ticketsManager = this.this$0;
                    this.label = 1;
                    if (ticketsManager.updateLocalBookings(this) == coroutine_suspended) {
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
                TicketsManager ticketsManager2 = this.this$0;
                this.label = 2;
                updateWithBookingsFromCommuterManager = ticketsManager2.updateWithBookingsFromCommuterManager(this);
                if (updateWithBookingsFromCommuterManager == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1$3", f = "TicketsManager.kt", l = {107, 108, 110}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.ticket.TicketsManager$listenForAuthentication$1$1$3, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TicketsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TicketsManager ticketsManager, Continuation<? super AnonymousClass3> continuation) {
                super(1, continuation);
                this.this$0 = ticketsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object updateWithBookingsFromCommuterManager;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    TicketsManager ticketsManager = this.this$0;
                    this.label = 1;
                    if (ticketsManager.removeLocalAssets(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        TicketsManager ticketsManager2 = this.this$0;
                        this.label = 3;
                        updateWithBookingsFromCommuterManager = ticketsManager2.updateWithBookingsFromCommuterManager(this);
                        if (updateWithBookingsFromCommuterManager == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                TicketsManager ticketsManager3 = this.this$0;
                this.label = 2;
                if (ticketsManager3.updateLocalBookings(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TicketsManager ticketsManager22 = this.this$0;
                this.label = 3;
                updateWithBookingsFromCommuterManager = ticketsManager22.updateWithBookingsFromCommuterManager(this);
                if (updateWithBookingsFromCommuterManager == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TicketsManager ticketsManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = ticketsManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AuthenticationType authenticationType, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(authenticationType, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AuthenticationType authenticationType;
            AuthenticationType authenticationType2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                AuthenticationType authenticationType3 = (AuthenticationType) this.L$0;
                authenticationType = this.this$0.previousAuthenticationType;
                C00391 c00391 = new C00391(this.this$0, null);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, null);
                this.L$0 = authenticationType3;
                this.label = 1;
                if (authenticationType.onNewAuthenticationType(authenticationType3, c00391, anonymousClass2, anonymousClass3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authenticationType2 = authenticationType3;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                authenticationType2 = (AuthenticationType) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.previousAuthenticationType = authenticationType2;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$listenForAuthentication$1(TicketsManager ticketsManager, Continuation<? super TicketsManager$listenForAuthentication$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsManager$listenForAuthentication$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserManager iUserManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserManager = this.this$0.userManager;
            StateFlow<AuthenticationType> authenticationType = iUserManager.getAuthenticationType();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(authenticationType, anonymousClass1, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsManager$listenForAuthentication$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
