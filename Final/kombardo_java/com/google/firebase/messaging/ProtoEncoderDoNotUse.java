package com.google.firebase.messaging;

import com.google.firebase.encoders.proto.ProtobufEncoder;

/* loaded from: classes2.dex */
public abstract class ProtoEncoderDoNotUse {
    private static final ProtobufEncoder ENCODER = ProtobufEncoder.builder().configureWith(AutoProtoEncoderDoNotUseEncoder.CONFIG).build();

    public static byte[] encode(Object obj) {
        return ENCODER.encode(obj);
    }
}
