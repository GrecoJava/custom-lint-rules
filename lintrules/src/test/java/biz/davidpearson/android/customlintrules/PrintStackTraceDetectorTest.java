package biz.davidpearson.android.customlintrules;

import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;

import org.intellij.lang.annotations.Language;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PrintStackTraceDetectorTest extends LintDetectorTest {

    public void testPrintStackTracePresent() throws Exception {

        System.out.println("\n\n\ntestPrintStackTracePresent called\n\n\n");

        //@formatter:off
        @Language("JAVA") String source = ""
                + "package foo;\n"
                + "import android.content.Context;\n"
                + "import android.os.Bundle;\n"
                + "import android.support.v7.app.AppCompatActivity;\n"
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
                + "}";

        @Language("JAVA") String foo = "";


        assertThat(lintProject(java(source))).isEqualTo("src/foo/Example.java:13: "
                + "Example.java:13: Do not use printStackTrace [PrintStackTrace]\n"
                + "    } catch (Exception e) {\n"
                + "        e.printStackTrace();\n"
                + "          ~~~~~~~~~~~~~~~\n"
                + "    }\n"
                + "1 errors, 0 warnings\n");

        //@formatter:on
    }

    @Override
    protected Detector getDetector() {
        return new PrintStackTraceDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Arrays.asList(PrintStackTraceDetector.ISSUE_PRINT_STACK_TRACE);
    }

    @Override
    protected boolean allowCompilationErrors() {
        return true;
    }
}