package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * requires ANDROID_HOME to be set in the environment
 */
public class PrintStackTraceDetectorTest extends LintDetectorTest {

    @Test
    public void testPrintStackTracePresent() throws Exception {

        lint().files(java(""
                + "package foo;\n"
                + "import android.content.Context;\n"
                + "import android.os.Bundle;\n"
                + "import androidx.appcompat.app.AppCompatActivity;\n"
                + "public class MainActivity extends AppCompatActivity {\n"
                + "    @Override\n"
                + "    protected void onCreate(Bundle savedInstanceState) { \n"
                + "        super.onCreate(savedInstanceState); \n"
                + "        setContentView(R.layout.activity_main); \n"
                + "        try { \n"
                + "            this.getSystemService(Context.TELEPHONY_SERVICE); \n"
                + "        } catch (Exception e) { \n"
                + "            e.printStackTrace();\n"
                + "        }\n"
                + "    }\n"
                + "}")).run()
                .expect("src/foo/MainActivity.java:13: Error: Do not use printStackTrace [PrintStackTrace]\n"
                        + "            e.printStackTrace();\n"
                        + "            ~~~~~~~~~~~~~~~~~~~\n"
                        + "1 errors, 0 warnings\n");
    }

    @Override
    protected Detector getDetector() {
        return new PrintStackTraceDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(PrintStackTraceDetector.ISSUE_PRINT_STACK_TRACE);
    }

    @Override
    protected boolean allowCompilationErrors() {
        return true;
    }
}