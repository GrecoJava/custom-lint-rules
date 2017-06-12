package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMethodCallExpression;
import com.intellij.psi.PsiReferenceExpression;

import java.util.Arrays;
import java.util.List;

/**
 * Created by David Pearson on 2017-05-09
 * <p>
 * a detector that looks for the use of <code>Throwable.printStackTrace()</code>
 */
public final class PrintStackTraceDetector extends Detector implements Detector.JavaPsiScanner {

    public static final Issue ISSUE_PRINT_STACK_TRACE =
            Issue.create("PrintStackTrace", "Use of printStackTrace",
                    "Instead of printStackTrace, use one of the logging libraries",
                    Category.MESSAGES, 5, Severity.ERROR,
                    new Implementation(PrintStackTraceDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public List<String> getApplicableMethodNames() {
        return Arrays.asList("printStackTrace");
    }

    @Override
    public void visitMethod(JavaContext context, JavaElementVisitor visitor,
                            PsiMethodCallExpression call, PsiMethod method) {


        PsiReferenceExpression methodExpression = call.getMethodExpression();

        String fullyQualifiedMethodName = methodExpression.getQualifiedName();

        if ("java.lang.Throwable.printStackTrace".equals(fullyQualifiedMethodName)) {
            context.report(ISSUE_PRINT_STACK_TRACE, methodExpression,
                    context.getLocation(methodExpression), "Do not use printStackTrace");
            return;
        }
    }
}
