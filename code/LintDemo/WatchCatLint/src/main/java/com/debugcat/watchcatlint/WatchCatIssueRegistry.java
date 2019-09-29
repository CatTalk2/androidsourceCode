package com.debugcat.watchcatlint;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.debugcat.watchcatlint.detectors.java.ColorValueDetector;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Issue registry
 */
public class WatchCatIssueRegistry extends IssueRegistry {

    static {
        System.out.println("********************************************");
        System.out.println("****************lint 读取配置文件*************");
        System.out.println("********************************************");

    }

    @NotNull
    @Override
    public List<Issue> getIssues() {
        System.out.println("*****************走Issues**************");
        return Arrays.asList(ColorValueDetector.ISSUE);
    }
}
