package info.novatec.testit.livingdoc.training.exercises;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.proxy.FirefoxFactory;
import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.XPath;
import info.novatec.testit.webtester.pages.Page;


public class WebTesterReleaseUiTest {

    static Browser browser;

    @BeforeAll
    static void initBrowser() {
        browser = new FirefoxFactory().createBrowser();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
    }

    @Test
    void runTest() {
        browser.open("http://github.com/testit-webtester/webtester2-core");
        List<String> versionTitles = browser.create(CodePage.class)
            .numberSummaries()
            .clickReleases()
            .getVersionTitles();
        assertThat(versionTitles).contains("v2.0.4", "v2.0.3", "v2.0.2", "v2.0.1", "v2.0.0");
    }

    public interface CodePage extends Page {

        @IdentifyUsing(".numbers-summary")
        NumberSummaries numberSummaries();

    }

    public interface ReleasePage extends Page {

        @IdentifyUsing(".release-title")
        Stream<PageFragment> versionTitles();

        default List<String> getVersionTitles() {
            return versionTitles().map(PageFragment::getVisibleText).collect(toList());
        }

    }

    public interface NumberSummaries extends PageFragment {

        @IdentifyUsing(value = "./li[3]/a", how = XPath.class)
        Link releasesLink();

        default ReleasePage clickReleases() {
            releasesLink().click();
            return create(ReleasePage.class);
        }

    }

}
