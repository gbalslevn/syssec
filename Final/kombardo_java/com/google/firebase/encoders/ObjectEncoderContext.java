package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d5);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i5);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j5);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z5);
}
