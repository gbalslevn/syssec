package com.google.firebase.perf.v1;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum ApplicationProcessState implements Internal.EnumLite {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);

    private static final Internal.EnumLiteMap<ApplicationProcessState> internalValueMap = new Internal.EnumLiteMap<ApplicationProcessState>() { // from class: com.google.firebase.perf.v1.ApplicationProcessState.1
    };
    private final int value;

    /* loaded from: classes2.dex */
    private static final class ApplicationProcessStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ApplicationProcessStateVerifier();

        private ApplicationProcessStateVerifier() {
        }
    }

    ApplicationProcessState(int i5) {
        this.value = i5;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ApplicationProcessStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
