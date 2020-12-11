package com.example.demo.whiteship;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudyDashboardTest {

    final String authToken = "token";
    final String repositoryName = "whiteship/live-study";
    StudyDashboard studyDashboard;

    @BeforeAll
    void init() {
        studyDashboard = new StudyDashboard(authToken, repositoryName);
    }

    @DisplayName("퍼센티지 계산 - 성공")
    @Test
    void test1() {

        String issuePercentage = studyDashboard.getIssuePercentage(18, 1);

        assertTrue(issuePercentage.equals("5.56"));
    }

    @DisplayName("퍼센티지 계산 - 실패")
    @Test
    void test2() {

        String issuePercentage = studyDashboard.getIssuePercentage(0, 0);

        assertTrue(issuePercentage.equals("NaN"));
    }

    @DisplayName("이슈에 댓글단 사람목록 가져오기")
    @Test
    void test3() throws IOException {

        GHRepository GHRepo = studyDashboard.getGhRepository();
        List<GHIssue> GHIssues = GHRepo.getIssues(GHIssueState.ALL);

        Map<String, Long> calculatingIssues = studyDashboard.getCalculatingIssues(GHIssues);

        assertTrue(calculatingIssues.size() > 0);

    }


}
