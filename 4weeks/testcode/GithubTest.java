package com.example.demo.whiteship;

import com.example.demo.whiteship.StudyDashboard;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.kohsuke.github.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class GithubTest {

    final String authToken = "token";
    final String repositoryName = "whiteship/live-study";

    GitHub github;
    GHRepository githubRepo;


    @BeforeEach
    void init() throws IOException {
        github = new GitHubBuilder().withOAuthToken(authToken).build();
        githubRepo = github.getRepository(repositoryName);
    }


    @DisplayName("라이브러리 레포지토리 연결 - 실패")
    @Test
    void test1() {
        assertThrows(GHFileNotFoundException.class , () -> github.getRepository("whiteship/live-study-kkkkk"));
    }

    @DisplayName("라이브러리 레포지토리 연결 - 성공")
    @Test
    void test2() {
       assertDoesNotThrow(() -> github.getRepository("whiteship/live-study"));
    }

    @DisplayName("라이브러리 레포지토리 이슈 가져오기 - 성공")
    @Test
    void test3() {
        assertDoesNotThrow(() -> githubRepo.getIssues(GHIssueState.ALL));
    }

    @DisplayName("라이브러리 레포지토리 각 이슈별 제목 가져오기 - 성공")
    @Test
    void test4() throws IOException {

        Instant a = Instant.now();

        long aa = a.getEpochSecond();

        try {

            List<GHIssue> GHIssues = githubRepo.getIssues(GHIssueState.ALL);

            assertTrue(GHIssues.size() > 0);
            assertEquals(GHIssues.get( GHIssues.size() -1 ).getTitle(), "1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("라이브러리 레포지토리 각 이슈별 코멘트 아이디 가져오기 - 성공")
    @Test
    void test5() throws IOException {

        Instant a = Instant.now();

        long aa = a.getEpochSecond();

        try {


            List<GHIssue> GHIssues = githubRepo.getIssues(GHIssueState.ALL);
            GHIssue ghIssue = GHIssues.get(GHIssues.size() - 1);

            assertTrue(ghIssue.getComments().size() > 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
