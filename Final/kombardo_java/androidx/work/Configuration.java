package androidx.work;

import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\u00020\u0001:\u0003RQSB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\nR\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001f\u0010,\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\u001f\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R\u001f\u00101\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+R\u0019\u00104\u001a\u0004\u0018\u0001038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u00109\u001a\u0002088G¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010=\u001a\u0002088\u0006¢\u0006\f\n\u0004\b=\u0010:\u001a\u0004\b>\u0010<R\u0017\u0010?\u001a\u0002088\u0006¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<R\u0017\u0010A\u001a\u0002088\u0006¢\u0006\f\n\u0004\bA\u0010:\u001a\u0004\bB\u0010<R\u0017\u0010C\u001a\u0002088G¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010<R\u0017\u0010F\u001a\u00020E8G¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bF\u0010HR \u0010I\u001a\u00020E8GX\u0087\u0004¢\u0006\u0012\n\u0004\bI\u0010G\u0012\u0004\bJ\u0010K\u001a\u0004\bI\u0010HR\u0017\u0010M\u001a\u00020L8G¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Landroidx/work/Configuration;", BuildConfig.FLAVOR, "Landroidx/work/Configuration$Builder;", "builder", "<init>", "(Landroidx/work/Configuration$Builder;)V", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "Lkotlin/coroutines/CoroutineContext;", "workerCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getWorkerCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "taskExecutor", "getTaskExecutor", "Landroidx/work/Clock;", "clock", "Landroidx/work/Clock;", "getClock", "()Landroidx/work/Clock;", "Landroidx/work/WorkerFactory;", "workerFactory", "Landroidx/work/WorkerFactory;", "getWorkerFactory", "()Landroidx/work/WorkerFactory;", "Landroidx/work/InputMergerFactory;", "inputMergerFactory", "Landroidx/work/InputMergerFactory;", "getInputMergerFactory", "()Landroidx/work/InputMergerFactory;", "Landroidx/work/RunnableScheduler;", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "getRunnableScheduler", "()Landroidx/work/RunnableScheduler;", "Landroidx/core/util/Consumer;", BuildConfig.FLAVOR, "initializationExceptionHandler", "Landroidx/core/util/Consumer;", "getInitializationExceptionHandler", "()Landroidx/core/util/Consumer;", "schedulingExceptionHandler", "getSchedulingExceptionHandler", "Landroidx/work/WorkerExceptionInfo;", "workerInitializationExceptionHandler", "getWorkerInitializationExceptionHandler", "workerExecutionExceptionHandler", "getWorkerExecutionExceptionHandler", BuildConfig.FLAVOR, "defaultProcessName", "Ljava/lang/String;", "getDefaultProcessName", "()Ljava/lang/String;", BuildConfig.FLAVOR, "minimumLoggingLevel", "I", "getMinimumLoggingLevel", "()I", "minJobSchedulerId", "getMinJobSchedulerId", "maxJobSchedulerId", "getMaxJobSchedulerId", "contentUriTriggerWorkersLimit", "getContentUriTriggerWorkersLimit", "maxSchedulerLimit", "getMaxSchedulerLimit", BuildConfig.FLAVOR, "isUsingDefaultTaskExecutor", "Z", "()Z", "isMarkingJobsAsImportantWhileForeground", "isMarkingJobsAsImportantWhileForeground$annotations", "()V", "Landroidx/work/Tracer;", "tracer", "Landroidx/work/Tracer;", "getTracer", "()Landroidx/work/Tracer;", "Companion", "Builder", "Provider", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Configuration {
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;
    private final String defaultProcessName;
    private final Executor executor;
    private final Consumer<Throwable> initializationExceptionHandler;
    private final InputMergerFactory inputMergerFactory;
    private final boolean isMarkingJobsAsImportantWhileForeground;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;
    private final RunnableScheduler runnableScheduler;
    private final Consumer<Throwable> schedulingExceptionHandler;
    private final Executor taskExecutor;
    private final Tracer tracer;
    private final CoroutineContext workerCoroutineContext;
    private final Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;
    private final WorkerFactory workerFactory;
    private final Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R$\u0010)\u001a\u0004\u0018\u00010(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010>\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R*\u0010B\u001a\n\u0012\u0004\u0012\u00020A\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u00109\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=R*\u0010E\u001a\n\u0012\u0004\u0012\u00020A\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bE\u00109\u001a\u0004\bF\u0010;\"\u0004\bG\u0010=R$\u0010I\u001a\u0004\u0018\u00010H8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR\"\u0010Y\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010Q\u001a\u0004\bZ\u0010S\"\u0004\b[\u0010UR\"\u0010\\\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\\\u0010Q\u001a\u0004\b]\u0010S\"\u0004\b^\u0010UR\"\u0010_\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b_\u0010Q\u001a\u0004\b`\u0010S\"\u0004\ba\u0010UR\"\u0010c\u001a\u00020b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006p"}, d2 = {"Landroidx/work/Configuration$Builder;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/work/WorkerFactory;", "workerFactory", "setWorkerFactory", "(Landroidx/work/WorkerFactory;)Landroidx/work/Configuration$Builder;", "Landroidx/work/Configuration;", "build", "()Landroidx/work/Configuration;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor$work_runtime_release", "()Ljava/util/concurrent/Executor;", "setExecutor$work_runtime_release", "(Ljava/util/concurrent/Executor;)V", "Lkotlin/coroutines/CoroutineContext;", "workerContext", "Lkotlin/coroutines/CoroutineContext;", "getWorkerContext$work_runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "setWorkerContext$work_runtime_release", "(Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/work/WorkerFactory;", "getWorkerFactory$work_runtime_release", "()Landroidx/work/WorkerFactory;", "setWorkerFactory$work_runtime_release", "(Landroidx/work/WorkerFactory;)V", "Landroidx/work/InputMergerFactory;", "inputMergerFactory", "Landroidx/work/InputMergerFactory;", "getInputMergerFactory$work_runtime_release", "()Landroidx/work/InputMergerFactory;", "setInputMergerFactory$work_runtime_release", "(Landroidx/work/InputMergerFactory;)V", "taskExecutor", "getTaskExecutor$work_runtime_release", "setTaskExecutor$work_runtime_release", "Landroidx/work/Clock;", "clock", "Landroidx/work/Clock;", "getClock$work_runtime_release", "()Landroidx/work/Clock;", "setClock$work_runtime_release", "(Landroidx/work/Clock;)V", "Landroidx/work/RunnableScheduler;", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "getRunnableScheduler$work_runtime_release", "()Landroidx/work/RunnableScheduler;", "setRunnableScheduler$work_runtime_release", "(Landroidx/work/RunnableScheduler;)V", "Landroidx/core/util/Consumer;", BuildConfig.FLAVOR, "initializationExceptionHandler", "Landroidx/core/util/Consumer;", "getInitializationExceptionHandler$work_runtime_release", "()Landroidx/core/util/Consumer;", "setInitializationExceptionHandler$work_runtime_release", "(Landroidx/core/util/Consumer;)V", "schedulingExceptionHandler", "getSchedulingExceptionHandler$work_runtime_release", "setSchedulingExceptionHandler$work_runtime_release", "Landroidx/work/WorkerExceptionInfo;", "workerInitializationExceptionHandler", "getWorkerInitializationExceptionHandler$work_runtime_release", "setWorkerInitializationExceptionHandler$work_runtime_release", "workerExecutionExceptionHandler", "getWorkerExecutionExceptionHandler$work_runtime_release", "setWorkerExecutionExceptionHandler$work_runtime_release", BuildConfig.FLAVOR, "defaultProcessName", "Ljava/lang/String;", "getDefaultProcessName$work_runtime_release", "()Ljava/lang/String;", "setDefaultProcessName$work_runtime_release", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "loggingLevel", "I", "getLoggingLevel$work_runtime_release", "()I", "setLoggingLevel$work_runtime_release", "(I)V", "minJobSchedulerId", "getMinJobSchedulerId$work_runtime_release", "setMinJobSchedulerId$work_runtime_release", "maxJobSchedulerId", "getMaxJobSchedulerId$work_runtime_release", "setMaxJobSchedulerId$work_runtime_release", "maxSchedulerLimit", "getMaxSchedulerLimit$work_runtime_release", "setMaxSchedulerLimit$work_runtime_release", "contentUriTriggerWorkersLimit", "getContentUriTriggerWorkersLimit$work_runtime_release", "setContentUriTriggerWorkersLimit$work_runtime_release", BuildConfig.FLAVOR, "markJobsAsImportantWhileForeground", "Z", "getMarkJobsAsImportantWhileForeground$work_runtime_release", "()Z", "setMarkJobsAsImportantWhileForeground$work_runtime_release", "(Z)V", "Landroidx/work/Tracer;", "tracer", "Landroidx/work/Tracer;", "getTracer$work_runtime_release", "()Landroidx/work/Tracer;", "setTracer$work_runtime_release", "(Landroidx/work/Tracer;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private Clock clock;
        private String defaultProcessName;
        private Executor executor;
        private Consumer<Throwable> initializationExceptionHandler;
        private InputMergerFactory inputMergerFactory;
        private int minJobSchedulerId;
        private RunnableScheduler runnableScheduler;
        private Consumer<Throwable> schedulingExceptionHandler;
        private Executor taskExecutor;
        private Tracer tracer;
        private CoroutineContext workerContext;
        private Consumer<WorkerExceptionInfo> workerExecutionExceptionHandler;
        private WorkerFactory workerFactory;
        private Consumer<WorkerExceptionInfo> workerInitializationExceptionHandler;
        private int loggingLevel = 4;
        private int maxJobSchedulerId = Integer.MAX_VALUE;
        private int maxSchedulerLimit = 20;
        private int contentUriTriggerWorkersLimit = 8;
        private boolean markJobsAsImportantWhileForeground = true;

        public final Configuration build() {
            return new Configuration(this);
        }

        /* renamed from: getClock$work_runtime_release, reason: from getter */
        public final Clock getClock() {
            return this.clock;
        }

        /* renamed from: getContentUriTriggerWorkersLimit$work_runtime_release, reason: from getter */
        public final int getContentUriTriggerWorkersLimit() {
            return this.contentUriTriggerWorkersLimit;
        }

        /* renamed from: getDefaultProcessName$work_runtime_release, reason: from getter */
        public final String getDefaultProcessName() {
            return this.defaultProcessName;
        }

        /* renamed from: getExecutor$work_runtime_release, reason: from getter */
        public final Executor getExecutor() {
            return this.executor;
        }

        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        /* renamed from: getInputMergerFactory$work_runtime_release, reason: from getter */
        public final InputMergerFactory getInputMergerFactory() {
            return this.inputMergerFactory;
        }

        /* renamed from: getLoggingLevel$work_runtime_release, reason: from getter */
        public final int getLoggingLevel() {
            return this.loggingLevel;
        }

        /* renamed from: getMarkJobsAsImportantWhileForeground$work_runtime_release, reason: from getter */
        public final boolean getMarkJobsAsImportantWhileForeground() {
            return this.markJobsAsImportantWhileForeground;
        }

        /* renamed from: getMaxJobSchedulerId$work_runtime_release, reason: from getter */
        public final int getMaxJobSchedulerId() {
            return this.maxJobSchedulerId;
        }

        /* renamed from: getMaxSchedulerLimit$work_runtime_release, reason: from getter */
        public final int getMaxSchedulerLimit() {
            return this.maxSchedulerLimit;
        }

        /* renamed from: getMinJobSchedulerId$work_runtime_release, reason: from getter */
        public final int getMinJobSchedulerId() {
            return this.minJobSchedulerId;
        }

        /* renamed from: getRunnableScheduler$work_runtime_release, reason: from getter */
        public final RunnableScheduler getRunnableScheduler() {
            return this.runnableScheduler;
        }

        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        /* renamed from: getTaskExecutor$work_runtime_release, reason: from getter */
        public final Executor getTaskExecutor() {
            return this.taskExecutor;
        }

        /* renamed from: getTracer$work_runtime_release, reason: from getter */
        public final Tracer getTracer() {
            return this.tracer;
        }

        /* renamed from: getWorkerContext$work_runtime_release, reason: from getter */
        public final CoroutineContext getWorkerContext() {
            return this.workerContext;
        }

        public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler$work_runtime_release() {
            return this.workerExecutionExceptionHandler;
        }

        /* renamed from: getWorkerFactory$work_runtime_release, reason: from getter */
        public final WorkerFactory getWorkerFactory() {
            return this.workerFactory;
        }

        public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler$work_runtime_release() {
            return this.workerInitializationExceptionHandler;
        }

        public final Builder setWorkerFactory(WorkerFactory workerFactory) {
            Intrinsics.checkNotNullParameter(workerFactory, "workerFactory");
            this.workerFactory = workerFactory;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/work/Configuration$Provider;", BuildConfig.FLAVOR, "workManagerConfiguration", "Landroidx/work/Configuration;", "getWorkManagerConfiguration", "()Landroidx/work/Configuration;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        CoroutineContext workerContext = builder.getWorkerContext();
        Executor executor = builder.getExecutor();
        if (executor == null) {
            executor = workerContext != null ? ConfigurationKt.access$asExecutor(workerContext) : null;
            if (executor == null) {
                executor = ConfigurationKt.access$createDefaultExecutor(false);
            }
        }
        this.executor = executor;
        this.workerCoroutineContext = workerContext == null ? builder.getExecutor() != null ? ExecutorsKt.from(executor) : Dispatchers.getDefault() : workerContext;
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor() == null;
        Executor taskExecutor = builder.getTaskExecutor();
        this.taskExecutor = taskExecutor == null ? ConfigurationKt.access$createDefaultExecutor(true) : taskExecutor;
        Clock clock = builder.getClock();
        this.clock = clock == null ? new SystemClock() : clock;
        WorkerFactory workerFactory = builder.getWorkerFactory();
        this.workerFactory = workerFactory == null ? DefaultWorkerFactory.INSTANCE : workerFactory;
        InputMergerFactory inputMergerFactory = builder.getInputMergerFactory();
        this.inputMergerFactory = inputMergerFactory == null ? NoOpInputMergerFactory.INSTANCE : inputMergerFactory;
        RunnableScheduler runnableScheduler = builder.getRunnableScheduler();
        this.runnableScheduler = runnableScheduler == null ? new DefaultRunnableScheduler() : runnableScheduler;
        this.minimumLoggingLevel = builder.getLoggingLevel();
        this.minJobSchedulerId = builder.getMinJobSchedulerId();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId();
        this.maxSchedulerLimit = builder.getMaxSchedulerLimit();
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.workerInitializationExceptionHandler = builder.getWorkerInitializationExceptionHandler$work_runtime_release();
        this.workerExecutionExceptionHandler = builder.getWorkerExecutionExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit();
        this.isMarkingJobsAsImportantWhileForeground = builder.getMarkJobsAsImportantWhileForeground();
        Tracer tracer = builder.getTracer();
        this.tracer = tracer == null ? ConfigurationKt.access$createDefaultTracer() : tracer;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    public final Tracer getTracer() {
        return this.tracer;
    }

    public final CoroutineContext getWorkerCoroutineContext() {
        return this.workerCoroutineContext;
    }

    public final Consumer<WorkerExceptionInfo> getWorkerExecutionExceptionHandler() {
        return this.workerExecutionExceptionHandler;
    }

    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    public final Consumer<WorkerExceptionInfo> getWorkerInitializationExceptionHandler() {
        return this.workerInitializationExceptionHandler;
    }

    /* renamed from: isMarkingJobsAsImportantWhileForeground, reason: from getter */
    public final boolean getIsMarkingJobsAsImportantWhileForeground() {
        return this.isMarkingJobsAsImportantWhileForeground;
    }
}
