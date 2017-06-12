package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;

import java.util.Arrays;
import java.util.List;

/**
 * Created by David Pearson on 2017-05-09
 * <p>
 * Registry which provides a list of checks to be performed
 */
public class CustomIssueRegistry extends IssueRegistry {

    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(PrintStackTraceDetector.ISSUE_PRINT_STACK_TRACE);
    }
}
