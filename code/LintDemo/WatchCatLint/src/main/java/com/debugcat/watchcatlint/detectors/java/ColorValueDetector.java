package com.debugcat.watchcatlint.detectors.java;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.lang.jvm.JvmParameter;
import com.intellij.psi.PsiMethod;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.uast.UCallExpression;

import java.util.Arrays;
import java.util.List;

/**
 *  检测Java代码中的颜色值硬编码
 */
public class ColorValueDetector extends Detector implements Detector.UastScanner {

    static {
        System.out.println("********************************************");
        System.out.println("****************lint 进入Detector*************");
        System.out.println("********************************************");

    }

    private static final Implementation IMPLEMENTATION =  new Implementation(ColorValueDetector.class, Scope.JAVA_FILE_SCOPE);


    //创建Issue
    public static final Issue ISSUE = Issue.create("ColorValue_Java",
            "Java代码中使用颜色值硬编码", "请将颜色值写入values.xml后引入", Category.USABILITY, 5, Severity.ERROR,
            IMPLEMENTATION);


    //目标方法
    private static final String SET_TEXT_COLOR          = "setTextColor";
    private static final String SET_COLOR               = "setColor";    //paint使用
    private static final String SET_BACKGROUND          = "setBackground";
    private static final String SET_BACKGROUND_COLOR    = "setBackgroundColor";
    private static final String SET_COLOR_FILTER        = "setColorFilter";


    @Override
    public List<String> getApplicableMethodNames() {
        System.out.println("*******************getApplicableMethodNames()*************************");
        return Arrays.asList(SET_TEXT_COLOR, SET_COLOR, SET_BACKGROUND, SET_BACKGROUND_COLOR, SET_COLOR_FILTER);
    }

    @Override
    public void visitMethodCall(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod method) {
        super.visitMethodCall(context, node, method);
        System.out.println("*******************visitMethodCall()*************************");
        JvmParameter[] params = method.getParameters();
        System.out.println("method: " + method.getName() + " params: " + params + " length: " + params.length);
        if (params.length > 0 && params[0] != null) {
            System.out.println("name: " + params[0].getName() + " type: " + params[0].getType() + " getSourceElement "
                    + params[0].getSourceElement() + " canNavigateToSource " + params[0].canNavigateToSource());
        }
    }

}
