package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.appcompat.R$styleable;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u001e\u001a\u00020\u0016*\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010 J\u001c\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%J#\u0010)\u001a\u00020\u00162\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b)\u0010*J\u0018\u0010-\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u00106R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u00109R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b:\u00109R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010DR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010ER \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010FR\u001a\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0019\u0010G\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "state", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "selectionManager", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", BuildConfig.FLAVOR, "editable", "singleLine", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "preparedSelectionState", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/foundation/text/UndoManager;", "undoManager", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyCombiner", "Landroidx/compose/foundation/text/KeyMapping;", "keyMapping", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "<init>", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/DeadKeyCombiner;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/input/EditCommand;", "apply", "(Ljava/util/List;)V", "(Landroidx/compose/ui/text/input/EditCommand;)V", "Landroidx/compose/ui/input/key/KeyEvent;", "event", "Landroidx/compose/ui/text/input/CommitTextCommand;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "typedCommand", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "block", "commandExecutionContext", "(Lkotlin/jvm/functions/Function1;)V", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "process", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "Z", "getEditable", "()Z", "getSingleLine", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "Landroidx/compose/foundation/text/UndoManager;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "Landroidx/compose/foundation/text/KeyMapping;", "Lkotlin/jvm/functions/Function1;", "I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKeyInput {
    private final boolean editable;
    private final int imeAction;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final LegacyTextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z5, boolean z6, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(legacyTextFieldState, textFieldSelectionManager, textFieldValue, z5, z6, textPreparedSelectionState, offsetMapping, undoManager, deadKeyCombiner, keyMapping, function1, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(List<? extends EditCommand> list) {
        EditProcessor processor = this.state.getProcessor();
        List<? extends EditCommand> mutableList = CollectionsKt.toMutableList((Collection) list);
        mutableList.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(processor.apply(mutableList));
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> block) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        block.invoke(textFieldPreparedSelection);
        if (TextRange.m2278equalsimpl0(textFieldPreparedSelection.getSelection(), this.value.getSelection()) && Intrinsics.areEqual(textFieldPreparedSelection.getAnnotatedString(), this.value.getText())) {
            return;
        }
        this.onValueChange.invoke(textFieldPreparedSelection.getValue());
    }

    /* renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m537typedCommandZmokQxo(KeyEvent event) {
        Integer m477consumeZmokQxo;
        if (TextFieldKeyInput_androidKt.m541isTypedEventZmokQxo(event) && (m477consumeZmokQxo = this.keyCombiner.m477consumeZmokQxo(event)) != null) {
            return new CommitTextCommand(StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), m477consumeZmokQxo.intValue()).toString(), 1);
        }
        return null;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m538processZmokQxo(KeyEvent event) {
        final KeyCommand mo479mapZmokQxo;
        CommitTextCommand m537typedCommandZmokQxo = m537typedCommandZmokQxo(event);
        if (m537typedCommandZmokQxo != null) {
            if (!this.editable) {
                return false;
            }
            apply(m537typedCommandZmokQxo);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        if (!KeyEventType.m1822equalsimpl0(KeyEvent_androidKt.m1827getTypeZmokQxo(event), KeyEventType.INSTANCE.m1823getKeyDownCS__XNY()) || (mo479mapZmokQxo = this.keyMapping.mo479mapZmokQxo(event)) == null || (mo479mapZmokQxo.getEditsText() && !this.editable)) {
            return false;
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        commandExecutionContext(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[KeyCommand.values().length];
                    try {
                        iArr[KeyCommand.COPY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[KeyCommand.PASTE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[KeyCommand.CUT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[KeyCommand.UP.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    try {
                        iArr[KeyCommand.DOWN.ordinal()] = 11;
                    } catch (NoSuchFieldError unused11) {
                    }
                    try {
                        iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
                    } catch (NoSuchFieldError unused12) {
                    }
                    try {
                        iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
                    } catch (NoSuchFieldError unused13) {
                    }
                    try {
                        iArr[KeyCommand.LINE_START.ordinal()] = 14;
                    } catch (NoSuchFieldError unused14) {
                    }
                    try {
                        iArr[KeyCommand.LINE_END.ordinal()] = 15;
                    } catch (NoSuchFieldError unused15) {
                    }
                    try {
                        iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
                    } catch (NoSuchFieldError unused16) {
                    }
                    try {
                        iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
                    } catch (NoSuchFieldError unused17) {
                    }
                    try {
                        iArr[KeyCommand.HOME.ordinal()] = 18;
                    } catch (NoSuchFieldError unused18) {
                    }
                    try {
                        iArr[KeyCommand.END.ordinal()] = 19;
                    } catch (NoSuchFieldError unused19) {
                    }
                    try {
                        iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
                    } catch (NoSuchFieldError unused20) {
                    }
                    try {
                        iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
                    } catch (NoSuchFieldError unused21) {
                    }
                    try {
                        iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
                    } catch (NoSuchFieldError unused22) {
                    }
                    try {
                        iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
                    } catch (NoSuchFieldError unused23) {
                    }
                    try {
                        iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
                    } catch (NoSuchFieldError unused24) {
                    }
                    try {
                        iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
                    } catch (NoSuchFieldError unused25) {
                    }
                    try {
                        iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
                    } catch (NoSuchFieldError unused26) {
                    }
                    try {
                        iArr[KeyCommand.TAB.ordinal()] = 27;
                    } catch (NoSuchFieldError unused27) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
                    } catch (NoSuchFieldError unused28) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
                    } catch (NoSuchFieldError unused29) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
                    } catch (NoSuchFieldError unused30) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
                    } catch (NoSuchFieldError unused31) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
                    } catch (NoSuchFieldError unused32) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
                    } catch (NoSuchFieldError unused33) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
                    } catch (NoSuchFieldError unused34) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
                    } catch (NoSuchFieldError unused35) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
                    } catch (NoSuchFieldError unused36) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
                    } catch (NoSuchFieldError unused37) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
                    } catch (NoSuchFieldError unused38) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
                    } catch (NoSuchFieldError unused39) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
                    } catch (NoSuchFieldError unused40) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
                    } catch (NoSuchFieldError unused41) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
                    } catch (NoSuchFieldError unused42) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
                    } catch (NoSuchFieldError unused43) {
                    }
                    try {
                        iArr[KeyCommand.SELECT_END.ordinal()] = 44;
                    } catch (NoSuchFieldError unused44) {
                    }
                    try {
                        iArr[KeyCommand.DESELECT.ordinal()] = 45;
                    } catch (NoSuchFieldError unused45) {
                    }
                    try {
                        iArr[KeyCommand.UNDO.ordinal()] = 46;
                    } catch (NoSuchFieldError unused46) {
                    }
                    try {
                        iArr[KeyCommand.REDO.ordinal()] = 47;
                    } catch (NoSuchFieldError unused47) {
                    }
                    try {
                        iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
                    } catch (NoSuchFieldError unused48) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
                invoke2(textFieldPreparedSelection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldPreparedSelection textFieldPreparedSelection) {
                int i5;
                TextFieldValue undo;
                Function1 function1;
                TextFieldValue redo;
                Function1 function12;
                switch (WhenMappings.$EnumSwitchMapping$0[KeyCommand.this.ordinal()]) {
                    case 1:
                        this.getSelectionManager().copy$foundation_release(false);
                        return;
                    case 2:
                        this.getSelectionManager().paste$foundation_release();
                        return;
                    case 3:
                        this.getSelectionManager().cut$foundation_release();
                        return;
                    case 4:
                        textFieldPreparedSelection.collapseLeftOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                invoke2(textFieldPreparedSelection2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                textFieldPreparedSelection2.moveCursorLeft();
                            }
                        });
                        return;
                    case 5:
                        textFieldPreparedSelection.collapseRightOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                invoke2(textFieldPreparedSelection2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                textFieldPreparedSelection2.moveCursorRight();
                            }
                        });
                        return;
                    case 6:
                        textFieldPreparedSelection.moveCursorLeftByWord();
                        return;
                    case 7:
                        textFieldPreparedSelection.moveCursorRightByWord();
                        return;
                    case 8:
                        textFieldPreparedSelection.moveCursorPrevByParagraph();
                        return;
                    case 9:
                        textFieldPreparedSelection.moveCursorNextByParagraph();
                        return;
                    case 10:
                        textFieldPreparedSelection.moveCursorUpByLine();
                        return;
                    case 11:
                        textFieldPreparedSelection.moveCursorDownByLine();
                        return;
                    case 12:
                        textFieldPreparedSelection.moveCursorUpByPage();
                        return;
                    case 13:
                        textFieldPreparedSelection.moveCursorDownByPage();
                        return;
                    case 14:
                        textFieldPreparedSelection.moveCursorToLineStart();
                        return;
                    case 15:
                        textFieldPreparedSelection.moveCursorToLineEnd();
                        return;
                    case 16:
                        textFieldPreparedSelection.moveCursorToLineLeftSide();
                        return;
                    case 17:
                        textFieldPreparedSelection.moveCursorToLineRightSide();
                        return;
                    case 18:
                        textFieldPreparedSelection.moveCursorToHome();
                        return;
                    case 19:
                        textFieldPreparedSelection.moveCursorToEnd();
                        return;
                    case 20:
                        List<EditCommand> deleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                return new DeleteSurroundingTextCommand(TextRange.m2280getEndimpl(textFieldPreparedSelection2.getSelection()) - textFieldPreparedSelection2.getPrecedingCharacterIndex(), 0);
                            }
                        });
                        if (deleteIfSelectedOr != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr);
                            return;
                        }
                        return;
                    case 21:
                        List<EditCommand> deleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                int nextCharacterIndex = textFieldPreparedSelection2.getNextCharacterIndex();
                                if (nextCharacterIndex != -1) {
                                    return new DeleteSurroundingTextCommand(0, nextCharacterIndex - TextRange.m2280getEndimpl(textFieldPreparedSelection2.getSelection()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr2 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr2);
                            return;
                        }
                        return;
                    case 22:
                        List<EditCommand> deleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.5
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer previousWordOffset = textFieldPreparedSelection2.getPreviousWordOffset();
                                if (previousWordOffset == null) {
                                    return null;
                                }
                                return new DeleteSurroundingTextCommand(TextRange.m2280getEndimpl(textFieldPreparedSelection2.getSelection()) - previousWordOffset.intValue(), 0);
                            }
                        });
                        if (deleteIfSelectedOr3 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr3);
                            return;
                        }
                        return;
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                        List<EditCommand> deleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.6
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer nextWordOffset = textFieldPreparedSelection2.getNextWordOffset();
                                if (nextWordOffset != null) {
                                    return new DeleteSurroundingTextCommand(0, nextWordOffset.intValue() - TextRange.m2280getEndimpl(textFieldPreparedSelection2.getSelection()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr4 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr4);
                            return;
                        }
                        return;
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        List<EditCommand> deleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.7
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer lineStartByOffset = textFieldPreparedSelection2.getLineStartByOffset();
                                if (lineStartByOffset == null) {
                                    return null;
                                }
                                return new DeleteSurroundingTextCommand(TextRange.m2280getEndimpl(textFieldPreparedSelection2.getSelection()) - lineStartByOffset.intValue(), 0);
                            }
                        });
                        if (deleteIfSelectedOr5 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr5);
                            return;
                        }
                        return;
                    case 25:
                        List<EditCommand> deleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.8
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Integer lineEndByOffset = textFieldPreparedSelection2.getLineEndByOffset();
                                if (lineEndByOffset != null) {
                                    return new DeleteSurroundingTextCommand(0, lineEndByOffset.intValue() - TextRange.m2280getEndimpl(textFieldPreparedSelection2.getSelection()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr6 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr6);
                            return;
                        }
                        return;
                    case 26:
                        if (!this.getSingleLine()) {
                            this.apply(new CommitTextCommand("\n", 1));
                            return;
                        }
                        Function1<ImeAction, Unit> onImeActionPerformed = this.getState().getOnImeActionPerformed();
                        i5 = this.imeAction;
                        onImeActionPerformed.invoke(ImeAction.m2375boximpl(i5));
                        return;
                    case 27:
                        if (!this.getSingleLine()) {
                            this.apply(new CommitTextCommand("\t", 1));
                            return;
                        } else {
                            ref$BooleanRef.element = false;
                            return;
                        }
                    case 28:
                        textFieldPreparedSelection.selectAll();
                        return;
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                        textFieldPreparedSelection.moveCursorLeft().selectMovement();
                        return;
                    case 30:
                        textFieldPreparedSelection.moveCursorRight().selectMovement();
                        return;
                    case 31:
                        textFieldPreparedSelection.moveCursorLeftByWord().selectMovement();
                        return;
                    case 32:
                        textFieldPreparedSelection.moveCursorRightByWord().selectMovement();
                        return;
                    case 33:
                        textFieldPreparedSelection.moveCursorPrevByParagraph().selectMovement();
                        return;
                    case 34:
                        textFieldPreparedSelection.moveCursorNextByParagraph().selectMovement();
                        return;
                    case 35:
                        textFieldPreparedSelection.moveCursorToLineStart().selectMovement();
                        return;
                    case 36:
                        textFieldPreparedSelection.moveCursorToLineEnd().selectMovement();
                        return;
                    case 37:
                        textFieldPreparedSelection.moveCursorToLineLeftSide().selectMovement();
                        return;
                    case 38:
                        textFieldPreparedSelection.moveCursorToLineRightSide().selectMovement();
                        return;
                    case 39:
                        textFieldPreparedSelection.moveCursorUpByLine().selectMovement();
                        return;
                    case 40:
                        textFieldPreparedSelection.moveCursorDownByLine().selectMovement();
                        return;
                    case 41:
                        textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                        return;
                    case 42:
                        textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                        return;
                    case 43:
                        textFieldPreparedSelection.moveCursorToHome().selectMovement();
                        return;
                    case 44:
                        textFieldPreparedSelection.moveCursorToEnd().selectMovement();
                        return;
                    case 45:
                        textFieldPreparedSelection.deselect();
                        return;
                    case 46:
                        UndoManager undoManager = this.getUndoManager();
                        if (undoManager != null) {
                            undoManager.makeSnapshot(textFieldPreparedSelection.getValue());
                        }
                        UndoManager undoManager2 = this.getUndoManager();
                        if (undoManager2 == null || (undo = undoManager2.undo()) == null) {
                            return;
                        }
                        function1 = this.onValueChange;
                        function1.invoke(undo);
                        return;
                    case 47:
                        UndoManager undoManager3 = this.getUndoManager();
                        if (undoManager3 == null || (redo = undoManager3.redo()) == null) {
                            return;
                        }
                        function12 = this.onValueChange;
                        function12.invoke(redo);
                        return;
                    case 48:
                        KeyEventHelpers_androidKt.showCharacterPalette();
                        return;
                    default:
                        return;
                }
            }
        });
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
        return ref$BooleanRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z5, boolean z6, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1<? super TextFieldValue, Unit> function1, int i5) {
        this.state = legacyTextFieldState;
        this.selectionManager = textFieldSelectionManager;
        this.value = textFieldValue;
        this.editable = z5;
        this.singleLine = z6;
        this.preparedSelectionState = textPreparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = deadKeyCombiner;
        this.keyMapping = keyMapping;
        this.onValueChange = function1;
        this.imeAction = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(EditCommand editCommand) {
        apply(CollectionsKt.listOf(editCommand));
    }

    public /* synthetic */ TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z5, boolean z6, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(legacyTextFieldState, textFieldSelectionManager, (i6 & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null) : textFieldValue, (i6 & 8) != 0 ? true : z5, (i6 & 16) != 0 ? false : z6, textPreparedSelectionState, (i6 & 64) != 0 ? OffsetMapping.INSTANCE.getIdentity() : offsetMapping, (i6 & 128) != 0 ? null : undoManager, deadKeyCombiner, (i6 & 512) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : keyMapping, (i6 & 1024) != 0 ? new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue2) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                invoke2(textFieldValue2);
                return Unit.INSTANCE;
            }
        } : function1, i5, null);
    }
}
