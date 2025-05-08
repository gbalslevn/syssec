package kotlin.reflect.jvm.internal.impl.metadata;

import androidx.appcompat.R$styleable;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* loaded from: classes3.dex */
public final class ProtoBuf$Class extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Class> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Class> PARSER = new AbstractParser<ProtoBuf$Class>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Class parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Class(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Class defaultInstance;
    private int bitField0_;
    private int companionObjectName_;
    private List<ProtoBuf$Constructor> constructor_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private List<ProtoBuf$EnumEntry> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<ProtoBuf$Function> function_;
    private int inlineClassUnderlyingPropertyName_;
    private int inlineClassUnderlyingTypeId_;
    private ProtoBuf$Type inlineClassUnderlyingType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
    private List<Integer> multiFieldValueClassUnderlyingName_;
    private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
    private List<Integer> multiFieldValueClassUnderlyingTypeId_;
    private List<ProtoBuf$Type> multiFieldValueClassUnderlyingType_;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<ProtoBuf$Property> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<ProtoBuf$Type> supertype_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;
    private List<Integer> versionRequirement_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Class, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int companionObjectName_;
        private int fqName_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private int flags_ = 6;
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private List<ProtoBuf$Type> supertype_ = Collections.emptyList();
        private List<Integer> supertypeId_ = Collections.emptyList();
        private List<Integer> nestedClassName_ = Collections.emptyList();
        private List<ProtoBuf$Type> contextReceiverType_ = Collections.emptyList();
        private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
        private List<ProtoBuf$Constructor> constructor_ = Collections.emptyList();
        private List<ProtoBuf$Function> function_ = Collections.emptyList();
        private List<ProtoBuf$Property> property_ = Collections.emptyList();
        private List<ProtoBuf$TypeAlias> typeAlias_ = Collections.emptyList();
        private List<ProtoBuf$EnumEntry> enumEntry_ = Collections.emptyList();
        private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
        private ProtoBuf$Type inlineClassUnderlyingType_ = ProtoBuf$Type.getDefaultInstance();
        private List<Integer> multiFieldValueClassUnderlyingName_ = Collections.emptyList();
        private List<ProtoBuf$Type> multiFieldValueClassUnderlyingType_ = Collections.emptyList();
        private List<Integer> multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
        private ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        private List<Integer> versionRequirement_ = Collections.emptyList();
        private ProtoBuf$VersionRequirementTable versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$8700() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureConstructorIsMutable() {
            if ((this.bitField0_ & 512) != 512) {
                this.constructor_ = new ArrayList(this.constructor_);
                this.bitField0_ |= 512;
            }
        }

        private void ensureContextReceiverTypeIdIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 256;
            }
        }

        private void ensureContextReceiverTypeIsMutable() {
            if ((this.bitField0_ & 128) != 128) {
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 128;
            }
        }

        private void ensureEnumEntryIsMutable() {
            if ((this.bitField0_ & 8192) != 8192) {
                this.enumEntry_ = new ArrayList(this.enumEntry_);
                this.bitField0_ |= 8192;
            }
        }

        private void ensureFunctionIsMutable() {
            if ((this.bitField0_ & 1024) != 1024) {
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1024;
            }
        }

        private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
            if ((this.bitField0_ & 262144) != 262144) {
                this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ |= 262144;
            }
        }

        private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
            if ((this.bitField0_ & 1048576) != 1048576) {
                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ |= 1048576;
            }
        }

        private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
            if ((this.bitField0_ & 524288) != 524288) {
                this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ |= 524288;
            }
        }

        private void ensureNestedClassNameIsMutable() {
            if ((this.bitField0_ & 64) != 64) {
                this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                this.bitField0_ |= 64;
            }
        }

        private void ensurePropertyIsMutable() {
            if ((this.bitField0_ & 2048) != 2048) {
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2048;
            }
        }

        private void ensureSealedSubclassFqNameIsMutable() {
            if ((this.bitField0_ & 16384) != 16384) {
                this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                this.bitField0_ |= 16384;
            }
        }

        private void ensureSupertypeIdIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.supertypeId_ = new ArrayList(this.supertypeId_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureSupertypeIsMutable() {
            if ((this.bitField0_ & 16) != 16) {
                this.supertype_ = new ArrayList(this.supertype_);
                this.bitField0_ |= 16;
            }
        }

        private void ensureTypeAliasIsMutable() {
            if ((this.bitField0_ & 4096) != 4096) {
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4096;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 8) != 8) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 8;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 4194304) != 4194304) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4194304;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Class buildPartial() {
            ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$Class.flags_ = this.flags_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$Class.fqName_ = this.fqName_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$Class.companionObjectName_ = this.companionObjectName_;
            if ((this.bitField0_ & 8) == 8) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            }
            protoBuf$Class.typeParameter_ = this.typeParameter_;
            if ((this.bitField0_ & 16) == 16) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            }
            protoBuf$Class.supertype_ = this.supertype_;
            if ((this.bitField0_ & 32) == 32) {
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            }
            protoBuf$Class.supertypeId_ = this.supertypeId_;
            if ((this.bitField0_ & 64) == 64) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            }
            protoBuf$Class.nestedClassName_ = this.nestedClassName_;
            if ((this.bitField0_ & 128) == 128) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -129;
            }
            protoBuf$Class.contextReceiverType_ = this.contextReceiverType_;
            if ((this.bitField0_ & 256) == 256) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -257;
            }
            protoBuf$Class.contextReceiverTypeId_ = this.contextReceiverTypeId_;
            if ((this.bitField0_ & 512) == 512) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= -513;
            }
            protoBuf$Class.constructor_ = this.constructor_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Class.function_ = this.function_;
            if ((this.bitField0_ & 2048) == 2048) {
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -2049;
            }
            protoBuf$Class.property_ = this.property_;
            if ((this.bitField0_ & 4096) == 4096) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -4097;
            }
            protoBuf$Class.typeAlias_ = this.typeAlias_;
            if ((this.bitField0_ & 8192) == 8192) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -8193;
            }
            protoBuf$Class.enumEntry_ = this.enumEntry_;
            if ((this.bitField0_ & 16384) == 16384) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -16385;
            }
            protoBuf$Class.sealedSubclassFqName_ = this.sealedSubclassFqName_;
            if ((i5 & 32768) == 32768) {
                i6 |= 8;
            }
            protoBuf$Class.inlineClassUnderlyingPropertyName_ = this.inlineClassUnderlyingPropertyName_;
            if ((i5 & 65536) == 65536) {
                i6 |= 16;
            }
            protoBuf$Class.inlineClassUnderlyingType_ = this.inlineClassUnderlyingType_;
            if ((i5 & 131072) == 131072) {
                i6 |= 32;
            }
            protoBuf$Class.inlineClassUnderlyingTypeId_ = this.inlineClassUnderlyingTypeId_;
            if ((this.bitField0_ & 262144) == 262144) {
                this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ &= -262145;
            }
            protoBuf$Class.multiFieldValueClassUnderlyingName_ = this.multiFieldValueClassUnderlyingName_;
            if ((this.bitField0_ & 524288) == 524288) {
                this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ &= -524289;
            }
            protoBuf$Class.multiFieldValueClassUnderlyingType_ = this.multiFieldValueClassUnderlyingType_;
            if ((this.bitField0_ & 1048576) == 1048576) {
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ &= -1048577;
            }
            protoBuf$Class.multiFieldValueClassUnderlyingTypeId_ = this.multiFieldValueClassUnderlyingTypeId_;
            if ((i5 & 2097152) == 2097152) {
                i6 |= 64;
            }
            protoBuf$Class.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & 4194304) == 4194304) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4194305;
            }
            protoBuf$Class.versionRequirement_ = this.versionRequirement_;
            if ((i5 & 8388608) == 8388608) {
                i6 |= 128;
            }
            protoBuf$Class.versionRequirementTable_ = this.versionRequirementTable_;
            protoBuf$Class.bitField0_ = i6;
            return protoBuf$Class;
        }

        public Builder mergeInlineClassUnderlyingType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 65536) != 65536 || this.inlineClassUnderlyingType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.inlineClassUnderlyingType_ = protoBuf$Type;
            } else {
                this.inlineClassUnderlyingType_ = ProtoBuf$Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 65536;
            return this;
        }

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 2097152) != 2097152 || this.typeTable_ == ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = protoBuf$TypeTable;
            } else {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            }
            this.bitField0_ |= 2097152;
            return this;
        }

        public Builder mergeVersionRequirementTable(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if ((this.bitField0_ & 8388608) != 8388608 || this.versionRequirementTable_ == ProtoBuf$VersionRequirementTable.getDefaultInstance()) {
                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
            } else {
                this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(protoBuf$VersionRequirementTable).buildPartial();
            }
            this.bitField0_ |= 8388608;
            return this;
        }

        public Builder setCompanionObjectName(int i5) {
            this.bitField0_ |= 4;
            this.companionObjectName_ = i5;
            return this;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 1;
            this.flags_ = i5;
            return this;
        }

        public Builder setFqName(int i5) {
            this.bitField0_ |= 2;
            this.fqName_ = i5;
            return this;
        }

        public Builder setInlineClassUnderlyingPropertyName(int i5) {
            this.bitField0_ |= 32768;
            this.inlineClassUnderlyingPropertyName_ = i5;
            return this;
        }

        public Builder setInlineClassUnderlyingTypeId(int i5) {
            this.bitField0_ |= 131072;
            this.inlineClassUnderlyingTypeId_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Class build() {
            ProtoBuf$Class buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Class protoBuf$Class) {
            if (protoBuf$Class == ProtoBuf$Class.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Class.hasFlags()) {
                setFlags(protoBuf$Class.getFlags());
            }
            if (protoBuf$Class.hasFqName()) {
                setFqName(protoBuf$Class.getFqName());
            }
            if (protoBuf$Class.hasCompanionObjectName()) {
                setCompanionObjectName(protoBuf$Class.getCompanionObjectName());
            }
            if (!protoBuf$Class.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Class.typeParameter_;
                    this.bitField0_ &= -9;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Class.typeParameter_);
                }
            }
            if (!protoBuf$Class.supertype_.isEmpty()) {
                if (this.supertype_.isEmpty()) {
                    this.supertype_ = protoBuf$Class.supertype_;
                    this.bitField0_ &= -17;
                } else {
                    ensureSupertypeIsMutable();
                    this.supertype_.addAll(protoBuf$Class.supertype_);
                }
            }
            if (!protoBuf$Class.supertypeId_.isEmpty()) {
                if (this.supertypeId_.isEmpty()) {
                    this.supertypeId_ = protoBuf$Class.supertypeId_;
                    this.bitField0_ &= -33;
                } else {
                    ensureSupertypeIdIsMutable();
                    this.supertypeId_.addAll(protoBuf$Class.supertypeId_);
                }
            }
            if (!protoBuf$Class.nestedClassName_.isEmpty()) {
                if (this.nestedClassName_.isEmpty()) {
                    this.nestedClassName_ = protoBuf$Class.nestedClassName_;
                    this.bitField0_ &= -65;
                } else {
                    ensureNestedClassNameIsMutable();
                    this.nestedClassName_.addAll(protoBuf$Class.nestedClassName_);
                }
            }
            if (!protoBuf$Class.contextReceiverType_.isEmpty()) {
                if (this.contextReceiverType_.isEmpty()) {
                    this.contextReceiverType_ = protoBuf$Class.contextReceiverType_;
                    this.bitField0_ &= -129;
                } else {
                    ensureContextReceiverTypeIsMutable();
                    this.contextReceiverType_.addAll(protoBuf$Class.contextReceiverType_);
                }
            }
            if (!protoBuf$Class.contextReceiverTypeId_.isEmpty()) {
                if (this.contextReceiverTypeId_.isEmpty()) {
                    this.contextReceiverTypeId_ = protoBuf$Class.contextReceiverTypeId_;
                    this.bitField0_ &= -257;
                } else {
                    ensureContextReceiverTypeIdIsMutable();
                    this.contextReceiverTypeId_.addAll(protoBuf$Class.contextReceiverTypeId_);
                }
            }
            if (!protoBuf$Class.constructor_.isEmpty()) {
                if (this.constructor_.isEmpty()) {
                    this.constructor_ = protoBuf$Class.constructor_;
                    this.bitField0_ &= -513;
                } else {
                    ensureConstructorIsMutable();
                    this.constructor_.addAll(protoBuf$Class.constructor_);
                }
            }
            if (!protoBuf$Class.function_.isEmpty()) {
                if (this.function_.isEmpty()) {
                    this.function_ = protoBuf$Class.function_;
                    this.bitField0_ &= -1025;
                } else {
                    ensureFunctionIsMutable();
                    this.function_.addAll(protoBuf$Class.function_);
                }
            }
            if (!protoBuf$Class.property_.isEmpty()) {
                if (this.property_.isEmpty()) {
                    this.property_ = protoBuf$Class.property_;
                    this.bitField0_ &= -2049;
                } else {
                    ensurePropertyIsMutable();
                    this.property_.addAll(protoBuf$Class.property_);
                }
            }
            if (!protoBuf$Class.typeAlias_.isEmpty()) {
                if (this.typeAlias_.isEmpty()) {
                    this.typeAlias_ = protoBuf$Class.typeAlias_;
                    this.bitField0_ &= -4097;
                } else {
                    ensureTypeAliasIsMutable();
                    this.typeAlias_.addAll(protoBuf$Class.typeAlias_);
                }
            }
            if (!protoBuf$Class.enumEntry_.isEmpty()) {
                if (this.enumEntry_.isEmpty()) {
                    this.enumEntry_ = protoBuf$Class.enumEntry_;
                    this.bitField0_ &= -8193;
                } else {
                    ensureEnumEntryIsMutable();
                    this.enumEntry_.addAll(protoBuf$Class.enumEntry_);
                }
            }
            if (!protoBuf$Class.sealedSubclassFqName_.isEmpty()) {
                if (this.sealedSubclassFqName_.isEmpty()) {
                    this.sealedSubclassFqName_ = protoBuf$Class.sealedSubclassFqName_;
                    this.bitField0_ &= -16385;
                } else {
                    ensureSealedSubclassFqNameIsMutable();
                    this.sealedSubclassFqName_.addAll(protoBuf$Class.sealedSubclassFqName_);
                }
            }
            if (protoBuf$Class.hasInlineClassUnderlyingPropertyName()) {
                setInlineClassUnderlyingPropertyName(protoBuf$Class.getInlineClassUnderlyingPropertyName());
            }
            if (protoBuf$Class.hasInlineClassUnderlyingType()) {
                mergeInlineClassUnderlyingType(protoBuf$Class.getInlineClassUnderlyingType());
            }
            if (protoBuf$Class.hasInlineClassUnderlyingTypeId()) {
                setInlineClassUnderlyingTypeId(protoBuf$Class.getInlineClassUnderlyingTypeId());
            }
            if (!protoBuf$Class.multiFieldValueClassUnderlyingName_.isEmpty()) {
                if (this.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    this.multiFieldValueClassUnderlyingName_ = protoBuf$Class.multiFieldValueClassUnderlyingName_;
                    this.bitField0_ &= -262145;
                } else {
                    ensureMultiFieldValueClassUnderlyingNameIsMutable();
                    this.multiFieldValueClassUnderlyingName_.addAll(protoBuf$Class.multiFieldValueClassUnderlyingName_);
                }
            }
            if (!protoBuf$Class.multiFieldValueClassUnderlyingType_.isEmpty()) {
                if (this.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    this.multiFieldValueClassUnderlyingType_ = protoBuf$Class.multiFieldValueClassUnderlyingType_;
                    this.bitField0_ &= -524289;
                } else {
                    ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                    this.multiFieldValueClassUnderlyingType_.addAll(protoBuf$Class.multiFieldValueClassUnderlyingType_);
                }
            }
            if (!protoBuf$Class.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    this.multiFieldValueClassUnderlyingTypeId_ = protoBuf$Class.multiFieldValueClassUnderlyingTypeId_;
                    this.bitField0_ &= -1048577;
                } else {
                    ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                    this.multiFieldValueClassUnderlyingTypeId_.addAll(protoBuf$Class.multiFieldValueClassUnderlyingTypeId_);
                }
            }
            if (protoBuf$Class.hasTypeTable()) {
                mergeTypeTable(protoBuf$Class.getTypeTable());
            }
            if (!protoBuf$Class.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Class.versionRequirement_;
                    this.bitField0_ &= -4194305;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Class.versionRequirement_);
                }
            }
            if (protoBuf$Class.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(protoBuf$Class.getVersionRequirementTable());
            }
            mergeExtensionFields(protoBuf$Class);
            setUnknownFields(getUnknownFields().concat(protoBuf$Class.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Class protoBuf$Class = null;
            try {
                try {
                    ProtoBuf$Class parsePartialFrom = ProtoBuf$Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Class protoBuf$Class2 = (ProtoBuf$Class) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Class = protoBuf$Class2;
                        if (protoBuf$Class != null) {
                            mergeFrom(protoBuf$Class);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Class != null) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Kind implements Internal.EnumLite {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);

        private static Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public Kind findValueByNumber(int i5) {
                return Kind.valueOf(i5);
            }
        };
        private final int value;

        Kind(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Kind valueOf(int i5) {
            switch (i5) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
                default:
                    return null;
            }
        }
    }

    static {
        ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(true);
        defaultInstance = protoBuf$Class;
        protoBuf$Class.initFields();
    }

    public static ProtoBuf$Class getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.contextReceiverType_ = Collections.emptyList();
        this.contextReceiverTypeId_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.inlineClassUnderlyingPropertyName_ = 0;
        this.inlineClassUnderlyingType_ = ProtoBuf$Type.getDefaultInstance();
        this.inlineClassUnderlyingTypeId_ = 0;
        this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
        this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
        this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.access$8700();
    }

    public static ProtoBuf$Class parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public ProtoBuf$Constructor getConstructor(int i5) {
        return this.constructor_.get(i5);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<ProtoBuf$Constructor> getConstructorList() {
        return this.constructor_;
    }

    public ProtoBuf$Type getContextReceiverType(int i5) {
        return this.contextReceiverType_.get(i5);
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public ProtoBuf$EnumEntry getEnumEntry(int i5) {
        return this.enumEntry_.get(i5);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<ProtoBuf$EnumEntry> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public ProtoBuf$Function getFunction(int i5) {
        return this.function_.get(i5);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    public int getInlineClassUnderlyingPropertyName() {
        return this.inlineClassUnderlyingPropertyName_;
    }

    public ProtoBuf$Type getInlineClassUnderlyingType() {
        return this.inlineClassUnderlyingType_;
    }

    public int getInlineClassUnderlyingTypeId() {
        return this.inlineClassUnderlyingTypeId_;
    }

    public int getMultiFieldValueClassUnderlyingNameCount() {
        return this.multiFieldValueClassUnderlyingName_.size();
    }

    public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
        return this.multiFieldValueClassUnderlyingName_;
    }

    public ProtoBuf$Type getMultiFieldValueClassUnderlyingType(int i5) {
        return this.multiFieldValueClassUnderlyingType_.get(i5);
    }

    public int getMultiFieldValueClassUnderlyingTypeCount() {
        return this.multiFieldValueClassUnderlyingType_.size();
    }

    public int getMultiFieldValueClassUnderlyingTypeIdCount() {
        return this.multiFieldValueClassUnderlyingTypeId_.size();
    }

    public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
        return this.multiFieldValueClassUnderlyingTypeId_;
    }

    public List<ProtoBuf$Type> getMultiFieldValueClassUnderlyingTypeList() {
        return this.multiFieldValueClassUnderlyingType_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    public ProtoBuf$Property getProperty(int i5) {
        return this.property_.get(i5);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.supertypeId_.size(); i7++) {
            i6 += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i7).intValue());
        }
        int i8 = computeInt32Size + i6;
        if (!getSupertypeIdList().isEmpty()) {
            i8 = i8 + 1 + CodedOutputStream.computeInt32SizeNoTag(i6);
        }
        this.supertypeIdMemoizedSerializedSize = i6;
        if ((this.bitField0_ & 2) == 2) {
            i8 += CodedOutputStream.computeInt32Size(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i8 += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        }
        for (int i9 = 0; i9 < this.typeParameter_.size(); i9++) {
            i8 += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i9));
        }
        for (int i10 = 0; i10 < this.supertype_.size(); i10++) {
            i8 += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i10));
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.nestedClassName_.size(); i12++) {
            i11 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i12).intValue());
        }
        int i13 = i8 + i11;
        if (!getNestedClassNameList().isEmpty()) {
            i13 = i13 + 1 + CodedOutputStream.computeInt32SizeNoTag(i11);
        }
        this.nestedClassNameMemoizedSerializedSize = i11;
        for (int i14 = 0; i14 < this.constructor_.size(); i14++) {
            i13 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i14));
        }
        for (int i15 = 0; i15 < this.function_.size(); i15++) {
            i13 += CodedOutputStream.computeMessageSize(9, this.function_.get(i15));
        }
        for (int i16 = 0; i16 < this.property_.size(); i16++) {
            i13 += CodedOutputStream.computeMessageSize(10, this.property_.get(i16));
        }
        for (int i17 = 0; i17 < this.typeAlias_.size(); i17++) {
            i13 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i17));
        }
        for (int i18 = 0; i18 < this.enumEntry_.size(); i18++) {
            i13 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i18));
        }
        int i19 = 0;
        for (int i20 = 0; i20 < this.sealedSubclassFqName_.size(); i20++) {
            i19 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i20).intValue());
        }
        int i21 = i13 + i19;
        if (!getSealedSubclassFqNameList().isEmpty()) {
            i21 = i21 + 2 + CodedOutputStream.computeInt32SizeNoTag(i19);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = i19;
        if ((this.bitField0_ & 8) == 8) {
            i21 += CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i21 += CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            i21 += CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
        }
        for (int i22 = 0; i22 < this.contextReceiverType_.size(); i22++) {
            i21 += CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(i22));
        }
        int i23 = 0;
        for (int i24 = 0; i24 < this.contextReceiverTypeId_.size(); i24++) {
            i23 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i24).intValue());
        }
        int i25 = i21 + i23;
        if (!getContextReceiverTypeIdList().isEmpty()) {
            i25 = i25 + 2 + CodedOutputStream.computeInt32SizeNoTag(i23);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = i23;
        int i26 = 0;
        for (int i27 = 0; i27 < this.multiFieldValueClassUnderlyingName_.size(); i27++) {
            i26 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(i27).intValue());
        }
        int i28 = i25 + i26;
        if (!getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
            i28 = i28 + 2 + CodedOutputStream.computeInt32SizeNoTag(i26);
        }
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = i26;
        for (int i29 = 0; i29 < this.multiFieldValueClassUnderlyingType_.size(); i29++) {
            i28 += CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(i29));
        }
        int i30 = 0;
        for (int i31 = 0; i31 < this.multiFieldValueClassUnderlyingTypeId_.size(); i31++) {
            i30 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i31).intValue());
        }
        int i32 = i28 + i30;
        if (!getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
            i32 = i32 + 2 + CodedOutputStream.computeInt32SizeNoTag(i30);
        }
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = i30;
        if ((this.bitField0_ & 64) == 64) {
            i32 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int i33 = 0;
        for (int i34 = 0; i34 < this.versionRequirement_.size(); i34++) {
            i33 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i34).intValue());
        }
        int size = i32 + i33 + (getVersionRequirementList().size() * 2);
        if ((this.bitField0_ & 128) == 128) {
            size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$Type getSupertype(int i5) {
        return this.supertype_.get(i5);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<ProtoBuf$Type> getSupertypeList() {
        return this.supertype_;
    }

    public ProtoBuf$TypeAlias getTypeAlias(int i5) {
        return this.typeAlias_.get(i5);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public ProtoBuf$TypeParameter getTypeParameter(int i5) {
        return this.typeParameter_.get(i5);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasCompanionObjectName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasFqName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasInlineClassUnderlyingPropertyName() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasInlineClassUnderlyingType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasInlineClassUnderlyingTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 128) == 128;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b5 = this.memoizedIsInitialized;
        if (b5 == 1) {
            return true;
        }
        if (b5 == 0) {
            return false;
        }
        if (!hasFqName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getTypeParameterCount(); i5++) {
            if (!getTypeParameter(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getSupertypeCount(); i6++) {
            if (!getSupertype(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getContextReceiverTypeCount(); i7++) {
            if (!getContextReceiverType(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i8 = 0; i8 < getConstructorCount(); i8++) {
            if (!getConstructor(i8).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i9 = 0; i9 < getFunctionCount(); i9++) {
            if (!getFunction(i9).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < getPropertyCount(); i10++) {
            if (!getProperty(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < getTypeAliasCount(); i11++) {
            if (!getTypeAlias(i11).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < getEnumEntryCount(); i12++) {
            if (!getEnumEntry(i12).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i13 = 0; i13 < getMultiFieldValueClassUnderlyingTypeCount(); i13++) {
            if (!getMultiFieldValueClassUnderlyingType(i13).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (extensionsAreInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if (getSupertypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i5 = 0; i5 < this.supertypeId_.size(); i5++) {
            codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i5).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(4, this.companionObjectName_);
        }
        for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
            codedOutputStream.writeMessage(5, this.typeParameter_.get(i6));
        }
        for (int i7 = 0; i7 < this.supertype_.size(); i7++) {
            codedOutputStream.writeMessage(6, this.supertype_.get(i7));
        }
        if (getNestedClassNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(58);
            codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i8 = 0; i8 < this.nestedClassName_.size(); i8++) {
            codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i8).intValue());
        }
        for (int i9 = 0; i9 < this.constructor_.size(); i9++) {
            codedOutputStream.writeMessage(8, this.constructor_.get(i9));
        }
        for (int i10 = 0; i10 < this.function_.size(); i10++) {
            codedOutputStream.writeMessage(9, this.function_.get(i10));
        }
        for (int i11 = 0; i11 < this.property_.size(); i11++) {
            codedOutputStream.writeMessage(10, this.property_.get(i11));
        }
        for (int i12 = 0; i12 < this.typeAlias_.size(); i12++) {
            codedOutputStream.writeMessage(11, this.typeAlias_.get(i12));
        }
        for (int i13 = 0; i13 < this.enumEntry_.size(); i13++) {
            codedOutputStream.writeMessage(13, this.enumEntry_.get(i13));
        }
        if (getSealedSubclassFqNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(130);
            codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i14 = 0; i14 < this.sealedSubclassFqName_.size(); i14++) {
            codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i14).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(18, this.inlineClassUnderlyingType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(19, this.inlineClassUnderlyingTypeId_);
        }
        for (int i15 = 0; i15 < this.contextReceiverType_.size(); i15++) {
            codedOutputStream.writeMessage(20, this.contextReceiverType_.get(i15));
        }
        if (getContextReceiverTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(170);
            codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i16 = 0; i16 < this.contextReceiverTypeId_.size(); i16++) {
            codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i16).intValue());
        }
        if (getMultiFieldValueClassUnderlyingNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(178);
            codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
        }
        for (int i17 = 0; i17 < this.multiFieldValueClassUnderlyingName_.size(); i17++) {
            codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(i17).intValue());
        }
        for (int i18 = 0; i18 < this.multiFieldValueClassUnderlyingType_.size(); i18++) {
            codedOutputStream.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(i18));
        }
        if (getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(194);
            codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
        }
        for (int i19 = 0; i19 < this.multiFieldValueClassUnderlyingTypeId_.size(); i19++) {
            codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i19).intValue());
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i20 = 0; i20 < this.versionRequirement_.size(); i20++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i20).intValue());
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Class protoBuf$Class) {
        return newBuilder().mergeFrom(protoBuf$Class);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Class getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$Class(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Class, ?> extendableBuilder) {
        super(extendableBuilder);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Class(boolean z5) {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x003c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private ProtoBuf$Class(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        boolean z5;
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z6 = false;
        char c5 = 0;
        while (!z6) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            z5 = true;
                            z6 = true;
                            c5 = c5;
                        case 8:
                            z5 = true;
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            c5 = c5;
                        case 16:
                            int i5 = (c5 == true ? 1 : 0) & 32;
                            char c6 = c5;
                            if (i5 != 32) {
                                this.supertypeId_ = new ArrayList();
                                c6 = (c5 == true ? 1 : 0) | ' ';
                            }
                            this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c6;
                            z5 = true;
                            c5 = c5;
                        case 18:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i6 = (c5 == true ? 1 : 0) & 32;
                            char c7 = c5;
                            if (i6 != 32) {
                                c7 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.supertypeId_ = new ArrayList();
                                    c7 = (c5 == true ? 1 : 0) | ' ';
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            c5 = c7;
                            z5 = true;
                            c5 = c5;
                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            this.bitField0_ |= 2;
                            this.fqName_ = codedInputStream.readInt32();
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = codedInputStream.readInt32();
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        case 42:
                            int i7 = (c5 == true ? 1 : 0) & 8;
                            char c8 = c5;
                            if (i7 != 8) {
                                this.typeParameter_ = new ArrayList();
                                c8 = (c5 == true ? 1 : 0) | '\b';
                            }
                            this.typeParameter_.add(codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                            c5 = c8;
                            z5 = true;
                            c5 = c5;
                        case 50:
                            int i8 = (c5 == true ? 1 : 0) & 16;
                            char c9 = c5;
                            if (i8 != 16) {
                                this.supertype_ = new ArrayList();
                                c9 = (c5 == true ? 1 : 0) | 16;
                            }
                            this.supertype_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            c5 = c9;
                            z5 = true;
                            c5 = c5;
                        case 56:
                            int i9 = (c5 == true ? 1 : 0) & 64;
                            char c10 = c5;
                            if (i9 != 64) {
                                this.nestedClassName_ = new ArrayList();
                                c10 = (c5 == true ? 1 : 0) | '@';
                            }
                            this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c10;
                            z5 = true;
                            c5 = c5;
                        case 58:
                            int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i10 = (c5 == true ? 1 : 0) & 64;
                            char c11 = c5;
                            if (i10 != 64) {
                                c11 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.nestedClassName_ = new ArrayList();
                                    c11 = (c5 == true ? 1 : 0) | '@';
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit2);
                            c5 = c11;
                            z5 = true;
                            c5 = c5;
                        case 66:
                            int i11 = (c5 == true ? 1 : 0) & 512;
                            char c12 = c5;
                            if (i11 != 512) {
                                this.constructor_ = new ArrayList();
                                c12 = (c5 == true ? 1 : 0) | 512;
                            }
                            this.constructor_.add(codedInputStream.readMessage(ProtoBuf$Constructor.PARSER, extensionRegistryLite));
                            c5 = c12;
                            z5 = true;
                            c5 = c5;
                        case 74:
                            int i12 = (c5 == true ? 1 : 0) & 1024;
                            char c13 = c5;
                            if (i12 != 1024) {
                                this.function_ = new ArrayList();
                                c13 = (c5 == true ? 1 : 0) | 1024;
                            }
                            this.function_.add(codedInputStream.readMessage(ProtoBuf$Function.PARSER, extensionRegistryLite));
                            c5 = c13;
                            z5 = true;
                            c5 = c5;
                        case 82:
                            int i13 = (c5 == true ? 1 : 0) & 2048;
                            char c14 = c5;
                            if (i13 != 2048) {
                                this.property_ = new ArrayList();
                                c14 = (c5 == true ? 1 : 0) | 2048;
                            }
                            this.property_.add(codedInputStream.readMessage(ProtoBuf$Property.PARSER, extensionRegistryLite));
                            c5 = c14;
                            z5 = true;
                            c5 = c5;
                        case 90:
                            int i14 = (c5 == true ? 1 : 0) & 4096;
                            char c15 = c5;
                            if (i14 != 4096) {
                                this.typeAlias_ = new ArrayList();
                                c15 = (c5 == true ? 1 : 0) | 4096;
                            }
                            this.typeAlias_.add(codedInputStream.readMessage(ProtoBuf$TypeAlias.PARSER, extensionRegistryLite));
                            c5 = c15;
                            z5 = true;
                            c5 = c5;
                        case 106:
                            int i15 = (c5 == true ? 1 : 0) & 8192;
                            char c16 = c5;
                            if (i15 != 8192) {
                                this.enumEntry_ = new ArrayList();
                                c16 = (c5 == true ? 1 : 0) | 8192;
                            }
                            this.enumEntry_.add(codedInputStream.readMessage(ProtoBuf$EnumEntry.PARSER, extensionRegistryLite));
                            c5 = c16;
                            z5 = true;
                            c5 = c5;
                        case 128:
                            int i16 = (c5 == true ? 1 : 0) & 16384;
                            char c17 = c5;
                            if (i16 != 16384) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                c17 = (c5 == true ? 1 : 0) | 16384;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c17;
                            z5 = true;
                            c5 = c5;
                        case 130:
                            int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i17 = (c5 == true ? 1 : 0) & 16384;
                            char c18 = c5;
                            if (i17 != 16384) {
                                c18 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    c18 = (c5 == true ? 1 : 0) | 16384;
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit3);
                            c5 = c18;
                            z5 = true;
                            c5 = c5;
                        case ModuleDescriptor.MODULE_VERSION /* 136 */:
                            this.bitField0_ |= 8;
                            this.inlineClassUnderlyingPropertyName_ = codedInputStream.readInt32();
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        case 146:
                            ProtoBuf$Type.Builder builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.inlineClassUnderlyingType_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.inlineClassUnderlyingType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        case 152:
                            this.bitField0_ |= 32;
                            this.inlineClassUnderlyingTypeId_ = codedInputStream.readInt32();
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        case 162:
                            int i18 = (c5 == true ? 1 : 0) & 128;
                            char c19 = c5;
                            if (i18 != 128) {
                                this.contextReceiverType_ = new ArrayList();
                                c19 = (c5 == true ? 1 : 0) | 128;
                            }
                            this.contextReceiverType_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            c5 = c19;
                            z5 = true;
                            c5 = c5;
                        case 168:
                            int i19 = (c5 == true ? 1 : 0) & 256;
                            char c20 = c5;
                            if (i19 != 256) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                c20 = (c5 == true ? 1 : 0) | 256;
                            }
                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c20;
                            z5 = true;
                            c5 = c5;
                        case 170:
                            int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i20 = (c5 == true ? 1 : 0) & 256;
                            char c21 = c5;
                            if (i20 != 256) {
                                c21 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.contextReceiverTypeId_ = new ArrayList();
                                    c21 = (c5 == true ? 1 : 0) | 256;
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit4);
                            c5 = c21;
                            z5 = true;
                            c5 = c5;
                        case 176:
                            int i21 = (c5 == true ? 1 : 0) & 262144;
                            char c22 = c5;
                            if (i21 != 262144) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                c22 = (c5 == true ? 1 : 0) | 0;
                            }
                            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c22;
                            z5 = true;
                            c5 = c5;
                        case 178:
                            int pushLimit5 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i22 = (c5 == true ? 1 : 0) & 262144;
                            char c23 = c5;
                            if (i22 != 262144) {
                                c23 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                    c23 = (c5 == true ? 1 : 0) | 0;
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit5);
                            c5 = c23;
                            z5 = true;
                            c5 = c5;
                        case 186:
                            int i23 = (c5 == true ? 1 : 0) & 524288;
                            char c24 = c5;
                            if (i23 != 524288) {
                                this.multiFieldValueClassUnderlyingType_ = new ArrayList();
                                c24 = (c5 == true ? 1 : 0) | 0;
                            }
                            this.multiFieldValueClassUnderlyingType_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            c5 = c24;
                            z5 = true;
                            c5 = c5;
                        case 192:
                            int i24 = (c5 == true ? 1 : 0) & 1048576;
                            char c25 = c5;
                            if (i24 != 1048576) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                c25 = (c5 == true ? 1 : 0) | 0;
                            }
                            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c25;
                            z5 = true;
                            c5 = c5;
                        case 194:
                            int pushLimit6 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i25 = (c5 == true ? 1 : 0) & 1048576;
                            char c26 = c5;
                            if (i25 != 1048576) {
                                c26 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                    c26 = (c5 == true ? 1 : 0) | 0;
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit6);
                            c5 = c26;
                            z5 = true;
                            c5 = c5;
                        case 242:
                            ProtoBuf$TypeTable.Builder builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                            ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.readMessage(ProtoBuf$TypeTable.PARSER, extensionRegistryLite);
                            this.typeTable_ = protoBuf$TypeTable;
                            if (builder2 != null) {
                                builder2.mergeFrom(protoBuf$TypeTable);
                                this.typeTable_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 64;
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        case 248:
                            int i26 = (c5 == true ? 1 : 0) & 4194304;
                            char c27 = c5;
                            if (i26 != 4194304) {
                                this.versionRequirement_ = new ArrayList();
                                c27 = (c5 == true ? 1 : 0) | 0;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            c5 = c27;
                            z5 = true;
                            c5 = c5;
                        case 250:
                            int pushLimit7 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i27 = (c5 == true ? 1 : 0) & 4194304;
                            char c28 = c5;
                            if (i27 != 4194304) {
                                c28 = c5;
                                if (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    c28 = (c5 == true ? 1 : 0) | 0;
                                }
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit7);
                            c5 = c28;
                            z5 = true;
                            c5 = c5;
                        case 258:
                            ProtoBuf$VersionRequirementTable.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) codedInputStream.readMessage(ProtoBuf$VersionRequirementTable.PARSER, extensionRegistryLite);
                            this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
                            if (builder3 != null) {
                                builder3.mergeFrom(protoBuf$VersionRequirementTable);
                                this.versionRequirementTable_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            c5 = c5;
                            z5 = true;
                            c5 = c5;
                        default:
                            c5 = c5;
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z6 = true;
                                c5 = c5;
                            }
                            z5 = true;
                            c5 = c5;
                    }
                } catch (Throwable th) {
                    if (((c5 == true ? 1 : 0) & 32) == 32) {
                        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    }
                    if (((c5 == true ? 1 : 0) & 8) == 8) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (((c5 == true ? 1 : 0) & 16) == 16) {
                        this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    }
                    if (((c5 == true ? 1 : 0) & 64) == 64) {
                        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    }
                    if (((c5 == true ? 1 : 0) & 512) == 512) {
                        this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    }
                    if (((c5 == true ? 1 : 0) & 1024) == 1024) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (((c5 == true ? 1 : 0) & 2048) == 2048) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (((c5 == true ? 1 : 0) & 4096) == 4096) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    if (((c5 == true ? 1 : 0) & 8192) == 8192) {
                        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    }
                    if (((c5 == true ? 1 : 0) & 16384) == 16384) {
                        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    }
                    if (((c5 == true ? 1 : 0) & 128) == 128) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (((c5 == true ? 1 : 0) & 256) == 256) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (((c5 == true ? 1 : 0) & 262144) == 262144) {
                        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    }
                    if (((c5 == true ? 1 : 0) & 524288) == 524288) {
                        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    }
                    if (((c5 == true ? 1 : 0) & 1048576) == 1048576) {
                        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    }
                    if (((c5 == true ? 1 : 0) & 4194304) == 4194304) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e5) {
                throw e5.setUnfinishedMessage(this);
            } catch (IOException e6) {
                throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
            }
        }
        if (((c5 == true ? 1 : 0) & 32) == 32) {
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if (((c5 == true ? 1 : 0) & 8) == 8) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (((c5 == true ? 1 : 0) & 16) == 16) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if (((c5 == true ? 1 : 0) & 64) == 64) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if (((c5 == true ? 1 : 0) & 512) == 512) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if (((c5 == true ? 1 : 0) & 1024) == 1024) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if (((c5 == true ? 1 : 0) & 2048) == 2048) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if (((c5 == true ? 1 : 0) & 4096) == 4096) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if (((c5 == true ? 1 : 0) & 8192) == 8192) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if (((c5 == true ? 1 : 0) & 16384) == 16384) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        }
        if (((c5 == true ? 1 : 0) & 128) == 128) {
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        }
        if (((c5 == true ? 1 : 0) & 256) == 256) {
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        }
        if (((c5 == true ? 1 : 0) & 262144) == 262144) {
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        }
        if (((c5 == true ? 1 : 0) & 524288) == 524288) {
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        }
        if (((c5 == true ? 1 : 0) & 1048576) == 1048576) {
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        }
        if (((c5 == true ? 1 : 0) & 4194304) == 4194304) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        try {
            newInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = newOutput.toByteString();
            throw th3;
        }
        this.unknownFields = newOutput.toByteString();
        makeExtensionsImmutable();
    }
}
