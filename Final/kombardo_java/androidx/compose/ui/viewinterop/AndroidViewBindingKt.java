package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewbinding.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ViewKt;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aY\u0010\f\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0087\u0001\u0010\f\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\u0010\u001a%\u0010\u0013\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/viewbinding/ViewBinding;", "T", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", BuildConfig.FLAVOR, "factory", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", BuildConfig.FLAVOR, "update", "AndroidViewBinding", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "onReset", "onRelease", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroid/view/View;", "binding", "setBinding", "(Landroid/view/View;Landroidx/viewbinding/ViewBinding;)V", "getBinding", "(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", "viewGroup", "Landroidx/fragment/app/FragmentContainerView;", "action", "forEachFragmentContainerView", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "ui-viewbinding_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidViewBindingKt {
    public static final <T extends ViewBinding> void AndroidViewBinding(final Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> function3, Modifier modifier, Function1<? super T, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1985291610);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i9 != 0) {
                function1 = new Function1<T, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$1
                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                    public final void invoke(ViewBinding viewBinding) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke((ViewBinding) obj);
                        return Unit.INSTANCE;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985291610, i7, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:79)");
            }
            AndroidViewBinding(function3, modifier, null, null, function1, startRestartGroup, (i7 & 14) | 384 | (i7 & 112) | ((i7 << 6) & 57344), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final Function1<? super T, Unit> function12 = function1;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    AndroidViewBindingKt.AndroidViewBinding(function3, modifier2, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachFragmentContainerView(ViewGroup viewGroup, Function1<? super FragmentContainerView, Unit> function1) {
        if (viewGroup instanceof FragmentContainerView) {
            function1.invoke(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            if (childAt instanceof ViewGroup) {
                forEachFragmentContainerView((ViewGroup) childAt, function1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends ViewBinding> T getBinding(View view) {
        Object tag = view.getTag(R$id.binding_reference);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type T of androidx.compose.ui.viewinterop.AndroidViewBindingKt.getBinding");
        return (T) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends ViewBinding> void setBinding(View view, T t5) {
        view.setTag(R$id.binding_reference, t5);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(51:1|(1:3)(2:122|(3:124|(1:126)(1:128)|127)(1:129))|4|(1:6)(2:115|(49:117|(1:119)(1:121)|120|8|(1:10)(2:108|(46:110|(1:112)(1:114)|113|12|(1:14)(2:101|(43:103|(1:105)(1:107)|106|16|(1:18)(2:94|(7:96|(1:98)(1:100)|99|20|(26:(1:32)(1:93)|33|(1:35)(1:92)|(1:37)|(1:39)|40|(1:42)|43|(4:86|87|88|89)|47|(1:49)(1:85)|50|(1:84)|54|(1:56)(3:78|(1:83)|82)|57|(1:59)(1:77)|60|(1:76)|64|(1:66)|67|(1:75)|71|(1:73)|74)(1:24)|25|(2:27|28)(1:30)))|19|20|(1:22)|(0)(0)|33|(0)(0)|(0)|(0)|40|(0)|43|(1:45)|86|87|88|89|47|(0)(0)|50|(1:52)|84|54|(0)(0)|57|(0)(0)|60|(1:62)|76|64|(0)|67|(1:69)|75|71|(0)|74|25|(0)(0)))|15|16|(0)(0)|19|20|(0)|(0)(0)|33|(0)(0)|(0)|(0)|40|(0)|43|(0)|86|87|88|89|47|(0)(0)|50|(0)|84|54|(0)(0)|57|(0)(0)|60|(0)|76|64|(0)|67|(0)|75|71|(0)|74|25|(0)(0)))|11|12|(0)(0)|15|16|(0)(0)|19|20|(0)|(0)(0)|33|(0)(0)|(0)|(0)|40|(0)|43|(0)|86|87|88|89|47|(0)(0)|50|(0)|84|54|(0)(0)|57|(0)(0)|60|(0)|76|64|(0)|67|(0)|75|71|(0)|74|25|(0)(0)))|7|8|(0)(0)|11|12|(0)(0)|15|16|(0)(0)|19|20|(0)|(0)(0)|33|(0)(0)|(0)|(0)|40|(0)|43|(0)|86|87|88|89|47|(0)(0)|50|(0)|84|54|(0)(0)|57|(0)(0)|60|(0)|76|64|(0)|67|(0)|75|71|(0)|74|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00eb, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends ViewBinding> void AndroidViewBinding(final Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends T> function3, Modifier modifier, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12, Function1<? super T, Unit> function13, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Function1<? super T, Unit> function14;
        int i9;
        final Function1<? super T, Unit> function15;
        int i10;
        final Function1<? super T, Unit> function16;
        Modifier modifier3;
        final Function1<? super T, Unit> function17;
        boolean changed;
        Object rememberedValue;
        boolean changedInstance;
        Object rememberedValue2;
        Function1 function18;
        boolean changedInstance2;
        Object rememberedValue3;
        boolean z5;
        Object rememberedValue4;
        final Function1<? super T, Unit> function19;
        final Function1<? super T, Unit> function110;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(509101952);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function14 = function1;
                i7 |= startRestartGroup.changedInstance(function14) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    function15 = function12;
                    i7 |= startRestartGroup.changedInstance(function15) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        function16 = function13;
                        i7 |= startRestartGroup.changedInstance(function16) ? 16384 : 8192;
                        if ((i7 & 9363) != 9362 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            function19 = function14;
                            function110 = function15;
                        } else {
                            modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            function17 = i8 != 0 ? null : function14;
                            if (i9 != 0) {
                                function15 = new Function1<T, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$3
                                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                                    public final void invoke(ViewBinding viewBinding) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                        invoke((ViewBinding) obj);
                                        return Unit.INSTANCE;
                                    }
                                };
                            }
                            if (i10 != 0) {
                                function16 = new Function1<T, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$4
                                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                                    public final void invoke(ViewBinding viewBinding) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                        invoke((ViewBinding) obj);
                                        return Unit.INSTANCE;
                                    }
                                };
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(509101952, i7, -1, "androidx.compose.ui.viewinterop.AndroidViewBinding (AndroidViewBinding.kt:156)");
                            }
                            View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                            changed = startRestartGroup.changed(view);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = ViewKt.findFragment(view);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final Fragment fragment = (Fragment) rememberedValue;
                            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            changedInstance = ((i7 & 14) == 4) | startRestartGroup.changedInstance(fragment);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1<Context, View>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$5$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final View invoke(Context context2) {
                                        LayoutInflater from;
                                        Fragment fragment2 = Fragment.this;
                                        if (fragment2 == null || (from = fragment2.getLayoutInflater()) == null) {
                                            from = LayoutInflater.from(context2);
                                        }
                                        ViewBinding viewBinding = (ViewBinding) function3.invoke(from, new FrameLayout(context2), Boolean.FALSE);
                                        View root = viewBinding.getRoot();
                                        AndroidViewBindingKt.setBinding(root, viewBinding);
                                        return root;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            Function1 function111 = (Function1) rememberedValue2;
                            if (function17 == null) {
                                startRestartGroup.startReplaceGroup(1526457000);
                                startRestartGroup.endReplaceGroup();
                                function18 = null;
                            } else {
                                startRestartGroup.startReplaceGroup(1526457001);
                                boolean changed2 = startRestartGroup.changed(function17);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$6$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                                            invoke2(view2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(View view2) {
                                            ViewBinding binding;
                                            Function1<T, Unit> function112 = function17;
                                            binding = AndroidViewBindingKt.getBinding(view2);
                                            function112.invoke(binding);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceGroup();
                                function18 = (Function1) rememberedValue5;
                            }
                            changedInstance2 = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(fragment) | startRestartGroup.changedInstance(context);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                                        invoke2(view2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(View view2) {
                                        ViewBinding binding;
                                        FragmentManager childFragmentManager;
                                        Function1<T, Unit> function112 = function15;
                                        binding = AndroidViewBindingKt.getBinding(view2);
                                        function112.invoke(binding);
                                        final FragmentManager fragmentManager = null;
                                        ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
                                        if (viewGroup != null) {
                                            Fragment fragment2 = fragment;
                                            Context context2 = context;
                                            if (fragment2 == null || (childFragmentManager = fragment2.getChildFragmentManager()) == null) {
                                                FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                                                if (fragmentActivity != null) {
                                                    fragmentManager = fragmentActivity.getSupportFragmentManager();
                                                }
                                            } else {
                                                fragmentManager = childFragmentManager;
                                            }
                                            AndroidViewBindingKt.forEachFragmentContainerView(viewGroup, new Function1<FragmentContainerView, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(FragmentContainerView fragmentContainerView) {
                                                    invoke2(fragmentContainerView);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(FragmentContainerView fragmentContainerView) {
                                                    FragmentManager fragmentManager2 = FragmentManager.this;
                                                    Fragment findFragmentById = fragmentManager2 != null ? fragmentManager2.findFragmentById(fragmentContainerView.getId()) : null;
                                                    if (findFragmentById == null || FragmentManager.this.isStateSaved()) {
                                                        return;
                                                    }
                                                    FragmentTransaction beginTransaction = FragmentManager.this.beginTransaction();
                                                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                                                    beginTransaction.remove(findFragmentById);
                                                    beginTransaction.commitNow();
                                                }
                                            });
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            Function1 function112 = (Function1) rememberedValue3;
                            z5 = (57344 & i7) == 16384;
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$8$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                                        invoke2(view2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(View view2) {
                                        ViewBinding binding;
                                        Function1<T, Unit> function113 = function16;
                                        binding = AndroidViewBindingKt.getBinding(view2);
                                        function113.invoke(binding);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            Function1<? super T, Unit> function113 = function15;
                            Function1<? super T, Unit> function114 = function17;
                            AndroidView_androidKt.AndroidView(function111, modifier3, function18, function112, (Function1) rememberedValue4, startRestartGroup, i7 & 112, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function19 = function114;
                            function110 = function113;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            final Function1<? super T, Unit> function115 = function16;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$9
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i12) {
                                    AndroidViewBindingKt.AndroidViewBinding(function3, modifier4, function19, function110, function115, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function16 = function13;
                    if ((i7 & 9363) != 9362) {
                    }
                    if (i11 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    View view2 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                    changed = startRestartGroup.changed(view2);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = ViewKt.findFragment(view2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final Fragment fragment2 = (Fragment) rememberedValue;
                    final Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    changedInstance = ((i7 & 14) == 4) | startRestartGroup.changedInstance(fragment2);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue2 = new Function1<Context, View>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$5$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final View invoke(Context context22) {
                            LayoutInflater from;
                            Fragment fragment22 = Fragment.this;
                            if (fragment22 == null || (from = fragment22.getLayoutInflater()) == null) {
                                from = LayoutInflater.from(context22);
                            }
                            ViewBinding viewBinding = (ViewBinding) function3.invoke(from, new FrameLayout(context22), Boolean.FALSE);
                            View root = viewBinding.getRoot();
                            AndroidViewBindingKt.setBinding(root, viewBinding);
                            return root;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    Function1 function1112 = (Function1) rememberedValue2;
                    if (function17 == null) {
                    }
                    changedInstance2 = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(fragment2) | startRestartGroup.changedInstance(context2);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance2) {
                    }
                    rememberedValue3 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view22) {
                            invoke2(view22);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(View view22) {
                            ViewBinding binding;
                            FragmentManager childFragmentManager;
                            Function1<T, Unit> function1122 = function15;
                            binding = AndroidViewBindingKt.getBinding(view22);
                            function1122.invoke(binding);
                            final FragmentManager fragmentManager = null;
                            ViewGroup viewGroup = view22 instanceof ViewGroup ? (ViewGroup) view22 : null;
                            if (viewGroup != null) {
                                Fragment fragment22 = fragment2;
                                Context context22 = context2;
                                if (fragment22 == null || (childFragmentManager = fragment22.getChildFragmentManager()) == null) {
                                    FragmentActivity fragmentActivity = context22 instanceof FragmentActivity ? (FragmentActivity) context22 : null;
                                    if (fragmentActivity != null) {
                                        fragmentManager = fragmentActivity.getSupportFragmentManager();
                                    }
                                } else {
                                    fragmentManager = childFragmentManager;
                                }
                                AndroidViewBindingKt.forEachFragmentContainerView(viewGroup, new Function1<FragmentContainerView, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(FragmentContainerView fragmentContainerView) {
                                        invoke2(fragmentContainerView);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(FragmentContainerView fragmentContainerView) {
                                        FragmentManager fragmentManager2 = FragmentManager.this;
                                        Fragment findFragmentById = fragmentManager2 != null ? fragmentManager2.findFragmentById(fragmentContainerView.getId()) : null;
                                        if (findFragmentById == null || FragmentManager.this.isStateSaved()) {
                                            return;
                                        }
                                        FragmentTransaction beginTransaction = FragmentManager.this.beginTransaction();
                                        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                                        beginTransaction.remove(findFragmentById);
                                        beginTransaction.commitNow();
                                    }
                                });
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    Function1 function1122 = (Function1) rememberedValue3;
                    if ((57344 & i7) == 16384) {
                    }
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue4 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$8$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view22) {
                            invoke2(view22);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(View view22) {
                            ViewBinding binding;
                            Function1<T, Unit> function1132 = function16;
                            binding = AndroidViewBindingKt.getBinding(view22);
                            function1132.invoke(binding);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    Function1<? super T, Unit> function1132 = function15;
                    Function1<? super T, Unit> function1142 = function17;
                    AndroidView_androidKt.AndroidView(function1112, modifier3, function18, function1122, (Function1) rememberedValue4, startRestartGroup, i7 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function19 = function1142;
                    function110 = function1132;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function15 = function12;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                function16 = function13;
                if ((i7 & 9363) != 9362) {
                }
                if (i11 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                View view22 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                changed = startRestartGroup.changed(view22);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = ViewKt.findFragment(view22);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final Fragment fragment22 = (Fragment) rememberedValue;
                final Context context22 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                changedInstance = ((i7 & 14) == 4) | startRestartGroup.changedInstance(fragment22);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue2 = new Function1<Context, View>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$5$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final View invoke(Context context222) {
                        LayoutInflater from;
                        Fragment fragment222 = Fragment.this;
                        if (fragment222 == null || (from = fragment222.getLayoutInflater()) == null) {
                            from = LayoutInflater.from(context222);
                        }
                        ViewBinding viewBinding = (ViewBinding) function3.invoke(from, new FrameLayout(context222), Boolean.FALSE);
                        View root = viewBinding.getRoot();
                        AndroidViewBindingKt.setBinding(root, viewBinding);
                        return root;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                Function1 function11122 = (Function1) rememberedValue2;
                if (function17 == null) {
                }
                changedInstance2 = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(fragment22) | startRestartGroup.changedInstance(context22);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changedInstance2) {
                }
                rememberedValue3 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view222) {
                        invoke2(view222);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view222) {
                        ViewBinding binding;
                        FragmentManager childFragmentManager;
                        Function1<T, Unit> function11222 = function15;
                        binding = AndroidViewBindingKt.getBinding(view222);
                        function11222.invoke(binding);
                        final FragmentManager fragmentManager = null;
                        ViewGroup viewGroup = view222 instanceof ViewGroup ? (ViewGroup) view222 : null;
                        if (viewGroup != null) {
                            Fragment fragment222 = fragment22;
                            Context context222 = context22;
                            if (fragment222 == null || (childFragmentManager = fragment222.getChildFragmentManager()) == null) {
                                FragmentActivity fragmentActivity = context222 instanceof FragmentActivity ? (FragmentActivity) context222 : null;
                                if (fragmentActivity != null) {
                                    fragmentManager = fragmentActivity.getSupportFragmentManager();
                                }
                            } else {
                                fragmentManager = childFragmentManager;
                            }
                            AndroidViewBindingKt.forEachFragmentContainerView(viewGroup, new Function1<FragmentContainerView, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(FragmentContainerView fragmentContainerView) {
                                    invoke2(fragmentContainerView);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(FragmentContainerView fragmentContainerView) {
                                    FragmentManager fragmentManager2 = FragmentManager.this;
                                    Fragment findFragmentById = fragmentManager2 != null ? fragmentManager2.findFragmentById(fragmentContainerView.getId()) : null;
                                    if (findFragmentById == null || FragmentManager.this.isStateSaved()) {
                                        return;
                                    }
                                    FragmentTransaction beginTransaction = FragmentManager.this.beginTransaction();
                                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                                    beginTransaction.remove(findFragmentById);
                                    beginTransaction.commitNow();
                                }
                            });
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                Function1 function11222 = (Function1) rememberedValue3;
                if ((57344 & i7) == 16384) {
                }
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue4 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$8$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view222) {
                        invoke2(view222);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view222) {
                        ViewBinding binding;
                        Function1<T, Unit> function11322 = function16;
                        binding = AndroidViewBindingKt.getBinding(view222);
                        function11322.invoke(binding);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                Function1<? super T, Unit> function11322 = function15;
                Function1<? super T, Unit> function11422 = function17;
                AndroidView_androidKt.AndroidView(function11122, modifier3, function18, function11222, (Function1) rememberedValue4, startRestartGroup, i7 & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function19 = function11422;
                function110 = function11322;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function14 = function1;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function15 = function12;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            function16 = function13;
            if ((i7 & 9363) != 9362) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            View view222 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            changed = startRestartGroup.changed(view222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = ViewKt.findFragment(view222);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final Fragment fragment222 = (Fragment) rememberedValue;
            final Context context222 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            changedInstance = ((i7 & 14) == 4) | startRestartGroup.changedInstance(fragment222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue2 = new Function1<Context, View>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final View invoke(Context context2222) {
                    LayoutInflater from;
                    Fragment fragment2222 = Fragment.this;
                    if (fragment2222 == null || (from = fragment2222.getLayoutInflater()) == null) {
                        from = LayoutInflater.from(context2222);
                    }
                    ViewBinding viewBinding = (ViewBinding) function3.invoke(from, new FrameLayout(context2222), Boolean.FALSE);
                    View root = viewBinding.getRoot();
                    AndroidViewBindingKt.setBinding(root, viewBinding);
                    return root;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            Function1 function111222 = (Function1) rememberedValue2;
            if (function17 == null) {
            }
            changedInstance2 = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(fragment222) | startRestartGroup.changedInstance(context222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue3 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2222) {
                    invoke2(view2222);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view2222) {
                    ViewBinding binding;
                    FragmentManager childFragmentManager;
                    Function1<T, Unit> function112222 = function15;
                    binding = AndroidViewBindingKt.getBinding(view2222);
                    function112222.invoke(binding);
                    final FragmentManager fragmentManager = null;
                    ViewGroup viewGroup = view2222 instanceof ViewGroup ? (ViewGroup) view2222 : null;
                    if (viewGroup != null) {
                        Fragment fragment2222 = fragment222;
                        Context context2222 = context222;
                        if (fragment2222 == null || (childFragmentManager = fragment2222.getChildFragmentManager()) == null) {
                            FragmentActivity fragmentActivity = context2222 instanceof FragmentActivity ? (FragmentActivity) context2222 : null;
                            if (fragmentActivity != null) {
                                fragmentManager = fragmentActivity.getSupportFragmentManager();
                            }
                        } else {
                            fragmentManager = childFragmentManager;
                        }
                        AndroidViewBindingKt.forEachFragmentContainerView(viewGroup, new Function1<FragmentContainerView, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FragmentContainerView fragmentContainerView) {
                                invoke2(fragmentContainerView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FragmentContainerView fragmentContainerView) {
                                FragmentManager fragmentManager2 = FragmentManager.this;
                                Fragment findFragmentById = fragmentManager2 != null ? fragmentManager2.findFragmentById(fragmentContainerView.getId()) : null;
                                if (findFragmentById == null || FragmentManager.this.isStateSaved()) {
                                    return;
                                }
                                FragmentTransaction beginTransaction = FragmentManager.this.beginTransaction();
                                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                                beginTransaction.remove(findFragmentById);
                                beginTransaction.commitNow();
                            }
                        });
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            Function1 function112222 = (Function1) rememberedValue3;
            if ((57344 & i7) == 16384) {
            }
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue4 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$8$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2222) {
                    invoke2(view2222);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view2222) {
                    ViewBinding binding;
                    Function1<T, Unit> function113222 = function16;
                    binding = AndroidViewBindingKt.getBinding(view2222);
                    function113222.invoke(binding);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            Function1<? super T, Unit> function113222 = function15;
            Function1<? super T, Unit> function114222 = function17;
            AndroidView_androidKt.AndroidView(function111222, modifier3, function18, function112222, (Function1) rememberedValue4, startRestartGroup, i7 & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function19 = function114222;
            function110 = function113222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function14 = function1;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function15 = function12;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        function16 = function13;
        if ((i7 & 9363) != 9362) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        View view2222 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        changed = startRestartGroup.changed(view2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = ViewKt.findFragment(view2222);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final Fragment fragment2222 = (Fragment) rememberedValue;
        final Context context2222 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        changedInstance = ((i7 & 14) == 4) | startRestartGroup.changedInstance(fragment2222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = new Function1<Context, View>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final View invoke(Context context22222) {
                LayoutInflater from;
                Fragment fragment22222 = Fragment.this;
                if (fragment22222 == null || (from = fragment22222.getLayoutInflater()) == null) {
                    from = LayoutInflater.from(context22222);
                }
                ViewBinding viewBinding = (ViewBinding) function3.invoke(from, new FrameLayout(context22222), Boolean.FALSE);
                View root = viewBinding.getRoot();
                AndroidViewBindingKt.setBinding(root, viewBinding);
                return root;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        Function1 function1112222 = (Function1) rememberedValue2;
        if (function17 == null) {
        }
        changedInstance2 = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(fragment2222) | startRestartGroup.changedInstance(context2222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue3 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view22222) {
                invoke2(view22222);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view22222) {
                ViewBinding binding;
                FragmentManager childFragmentManager;
                Function1<T, Unit> function1122222 = function15;
                binding = AndroidViewBindingKt.getBinding(view22222);
                function1122222.invoke(binding);
                final FragmentManager fragmentManager = null;
                ViewGroup viewGroup = view22222 instanceof ViewGroup ? (ViewGroup) view22222 : null;
                if (viewGroup != null) {
                    Fragment fragment22222 = fragment2222;
                    Context context22222 = context2222;
                    if (fragment22222 == null || (childFragmentManager = fragment22222.getChildFragmentManager()) == null) {
                        FragmentActivity fragmentActivity = context22222 instanceof FragmentActivity ? (FragmentActivity) context22222 : null;
                        if (fragmentActivity != null) {
                            fragmentManager = fragmentActivity.getSupportFragmentManager();
                        }
                    } else {
                        fragmentManager = childFragmentManager;
                    }
                    AndroidViewBindingKt.forEachFragmentContainerView(viewGroup, new Function1<FragmentContainerView, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$7$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FragmentContainerView fragmentContainerView) {
                            invoke2(fragmentContainerView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FragmentContainerView fragmentContainerView) {
                            FragmentManager fragmentManager2 = FragmentManager.this;
                            Fragment findFragmentById = fragmentManager2 != null ? fragmentManager2.findFragmentById(fragmentContainerView.getId()) : null;
                            if (findFragmentById == null || FragmentManager.this.isStateSaved()) {
                                return;
                            }
                            FragmentTransaction beginTransaction = FragmentManager.this.beginTransaction();
                            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                            beginTransaction.remove(findFragmentById);
                            beginTransaction.commitNow();
                        }
                    });
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        Function1 function1122222 = (Function1) rememberedValue3;
        if ((57344 & i7) == 16384) {
        }
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue4 = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewBindingKt$AndroidViewBinding$8$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view22222) {
                invoke2(view22222);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view22222) {
                ViewBinding binding;
                Function1<T, Unit> function1132222 = function16;
                binding = AndroidViewBindingKt.getBinding(view22222);
                function1132222.invoke(binding);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        Function1<? super T, Unit> function1132222 = function15;
        Function1<? super T, Unit> function1142222 = function17;
        AndroidView_androidKt.AndroidView(function1112222, modifier3, function18, function1122222, (Function1) rememberedValue4, startRestartGroup, i7 & 112, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function19 = function1142222;
        function110 = function1132222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
