package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.client.api.JavaEvaluator;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.PsiMethod;

import org.jetbrains.uast.UCallExpression;

import java.util.Collections;
import java.util.List;

/**
 * Created by David Pearson on 2017-05-09
 * <p>
 * a detector that looks for the use of <code>Throwable.printStackTrace()</code>
 */
public final class PrintStackTraceDetector extends Detector implements Detector.UastScanner {

    public static final Issue ISSUE_PRINT_STACK_TRACE =
            Issue.create("PrintStackTrace", "Use of printStackTrace",
                    "Instead of printStackTrace, use one of the logging libraries",
                    Category.MESSAGES, 5, Severity.ERROR,
                    new Implementation(PrintStackTraceDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("printStackTrace");
    }

    @Override
    public void visitMethodCall(JavaContext context, UCallExpression call, PsiMethod method) {

        String methodName = call.getMethodName();
        JavaEvaluator evaluator = context.getEvaluator();

        if ("printStackTrace".equals(methodName) &&
                evaluator.isMemberInClass(method, "java.lang.Throwable")) {
            context.report(ISSUE_PRINT_STACK_TRACE, call,
                    context.getLocation(call), "Do not use printStackTrace");
            return;
        }
    }
}
