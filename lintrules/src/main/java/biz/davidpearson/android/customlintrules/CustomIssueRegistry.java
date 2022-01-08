package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;

import java.util.Collections;
import java.util.List;


/**
 * Created by David Pearson on 2017-05-09
 * <p>
 * Registry which provides a list of checks to be performed
 * <p>
 * https://googlesamples.github.io/android-custom-lint-rules/api-guide.html
 */
public class CustomIssueRegistry extends IssueRegistry {

    @Override
    public List<Issue> getIssues() {
        return Collections.singletonList(PrintStackTraceDetector.ISSUE_PRINT_STACK_TRACE);
    }

    @Override
    public int getApi() {
        return com.android.tools.lint.detector.api.ApiKt.CURRENT_API;
    }
}
