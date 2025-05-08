package androidx.work;

/* loaded from: classes.dex */
public interface Operation {
    public static final State.IN_PROGRESS IN_PROGRESS;
    public static final State.SUCCESS SUCCESS;

    /* loaded from: classes.dex */
    public static abstract class State {

        /* loaded from: classes.dex */
        public static final class FAILURE extends State {
            private final Throwable mThrowable;

            public FAILURE(Throwable th) {
                this.mThrowable = th;
            }

            public String toString() {
                return "FAILURE (" + this.mThrowable.getMessage() + ")";
            }
        }

        /* loaded from: classes.dex */
        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }
        }

        /* loaded from: classes.dex */
        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }
        }

        State() {
        }
    }

    static {
        SUCCESS = new State.SUCCESS();
        IN_PROGRESS = new State.IN_PROGRESS();
    }
}
