package com.example.demo.whiteship;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudyDashboard {

    private final String authToken;
    private final String repositoryName;


    public static void main(String[] args) throws IOException {

        StudyDashboard studyDashboard = new StudyDashboard("token", "whiteship/live-study");
        GHRepository GHRepo = studyDashboard.getGhRepository();
        List<GHIssue> GHIssues = GHRepo.getIssues(GHIssueState.ALL);

        studyDashboard.printIssuePercentage(GHIssues.size(), studyDashboard.getCalculatingIssues(GHIssues));
    }

    public StudyDashboard(String authToken, String repositoryName) {
        this.authToken = authToken;
        this.repositoryName = repositoryName;
    }

    public GHRepository getGhRepository() throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(authToken).build();
        return github.getRepository(repositoryName);
    }

    public Map<String,Long> getCalculatingIssues(List<GHIssue> GHIssues) throws IOException {

        Map<String,Long> calculatedIssues = GHIssues.stream().flatMap(v -> {
            try {
                return v.getComments().stream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).map(vv -> {
            try {
                return vv.getUser().getLogin();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return calculatedIssues;
    }

    public void printIssuePercentage(int ghIssuesSize, Map<String, Long> maps) {
        maps.forEach((k,v) -> {
            System.out.println("이름 = " + k + " 참여율 = " + getIssuePercentage(ghIssuesSize, v) + "%");
        });
    }

    public String getIssuePercentage(int size, double v) {
        return String.format("%.2f", (double)( ((v * 100) / size) ));
    }
}
