package com.google.firebase.perf.v1;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum SessionVerbosity implements Internal.EnumLite {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);

    private static final Internal.EnumLiteMap<SessionVerbosity> internalValueMap = new Internal.EnumLiteMap<SessionVerbosity>() { // from class: com.google.firebase.perf.v1.SessionVerbosity.1
    };
    private final int value;

    /* loaded from: classes2.dex */
    private static final class SessionVerbosityVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SessionVerbosityVerifier();

        private SessionVerbosityVerifier() {
        }
    }

    SessionVerbosity(int i5) {
        this.value = i5;
    }

    public static SessionVerbosity forNumber(int i5) {
        if (i5 == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i5 != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SessionVerbosityVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
