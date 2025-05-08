package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ProtobufValueEncoderContext implements ValueEncoderContext {
    private FieldDescriptor field;
    private final ProtobufDataEncoderContext objEncoderCtx;
    private boolean encoded = false;
    private boolean skipDefault = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    private void checkNotUsed() {
        if (this.encoded) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.encoded = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(String str) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, str, this.skipDefault);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetContext(FieldDescriptor fieldDescriptor, boolean z5) {
        this.encoded = false;
        this.field = fieldDescriptor;
        this.skipDefault = z5;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(boolean z5) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z5, this.skipDefault);
        return this;
    }
}
