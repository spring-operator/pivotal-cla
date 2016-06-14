package io.pivotal.cla.webdriver.pages.github;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.pivotal.cla.webdriver.pages.SignClaPage;

/**
 * Represents a Pull Request Page. For example:
 *
 * https://github.com/pivotal-cla/cla-test/pull/1
 *
 * @author Rob Winch
 *
 */
public class GitHubPullRequestPage {
	final WebDriver driver;

	public GitHubPullRequestPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void assertCommentPleaseSignFor(String gitHubUsername) {
		List<WebElement> comments = driver.findElements(By.cssSelector(".comment-content"));

		assertThat(comments).extracting(e-> e.getText().replaceAll("\n", " ")).contains("@" + gitHubUsername + " Please sign the Contributor License Agreement! Click here to manually synchronize the status of this Pull Request. See the FAQ for frequently asked questions.");
	}

	public void assertCommentThankYouFor(String gitHubUsername) {
		List<WebElement> comments = driver.findElements(By.cssSelector(".comment-content"));

		assertThat(comments).extracting(WebElement::getText).contains("@" + gitHubUsername + " Thank you for signing the Contributor License Agreement!");
	}

	public void assertBuildStatusSign() {
		List<WebElement> buildStatuses = driver.findElements(By.cssSelector(".build-status-item"));

		assertThat(buildStatuses).extracting(e-> e.getText().replaceAll("\n", " ")).contains("Details ci/pivotal-cla — Please sign the Contributor License Agreement!");
	}

	public void assertBuildStatusSuccess() {
		List<WebElement> buildStatuses = driver.findElements(By.cssSelector(".build-status-item"));

		assertThat(buildStatuses).extracting(e-> e.getText().replaceAll("\n", " ")).contains("Details ci/pivotal-cla — Thank you for signing the Contributor License Agreement!");
	}

	public SignClaPage details() {
		WebElement details = driver.findElement(By.cssSelector(".build-status-item a.build-status-details"));
		details.click();

		new GitHubAuthorizePage(driver).authorizeIfNecessary();

		return PageFactory.initElements(driver, SignClaPage.class);
	}
}
