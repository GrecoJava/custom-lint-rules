package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.client.api.JavaEvaluator;
import com.android.tools.lint.detector.api.*;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.uast.UCallExpression;

import java.util.Collections;
import java.util.List;

/**
 * A detector that looks for the use of <code>Throwable.printStackTrace()</code>
 * <p>
 * Alan was always annoyed by Android Studio automatically adding
 * <code>Throwable.printStackTrace()</code>
 * to try / catch blocks and the developers not cleaning them up.
 * <p>
 * Created by David Pearson on 2017-05-09
 */
public final class PrintStackTraceDetector extends Detector implements Detector.UastScanner {

    public static final Issue ISSUE_PRINT_STACK_TRACE =
            Issue.create(
                    "PrintStackTrace", "Use of printStackTrace",
                    "Instead of printStackTrace, use one of the logging libraries",
                    Category.MESSAGES, 5, Severity.ERROR,
                    new Implementation(PrintStackTraceDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("printStackTrace");
    }

    @Override
    public void visitMethodCall(@NotNull JavaContext context, @NotNull UCallExpression call,
            @NotNull PsiMethod method) {

        String methodName = call.getMethodName();
        JavaEvaluator evaluator = context.getEvaluator();

        if ("printStackTrace".equals(methodName) &&
                evaluator.isMemberInClass(method, "java.lang.Throwable")) {
            context.report(
                    ISSUE_PRINT_STACK_TRACE, call,
                    context.getLocation(call), "Do not use printStackTrace");
        }
    }
}
