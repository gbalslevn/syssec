package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    /* loaded from: classes2.dex */
    private static final class ProtobufImpl implements Protobuf {
        private final Protobuf.IntEncoding intEncoding;
        private final int tag;

        ProtobufImpl(int i5, Protobuf.IntEncoding intEncoding) {
            this.tag = i5;
            this.intEncoding = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.tag == protobuf.tag() && this.intEncoding.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.tag) + (this.intEncoding.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.tag;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.tag + "intEncoding=" + this.intEncoding + ')';
        }
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public Protobuf build() {
        return new ProtobufImpl(this.tag, this.intEncoding);
    }

    public AtProtobuf tag(int i5) {
        this.tag = i5;
        return this;
    }
}
