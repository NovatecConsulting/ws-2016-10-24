package info.novatec.testit.livingdoc.training.exercises.lessons;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.converter.TypeConverter;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;
import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.proxy.FirefoxFactory;
import info.novatec.testit.webtester.pagefragments.PageFragment;


@FixtureClass("WebTester Releases")
public class WebTesterReleasesFixture {

    private static final Logger log = LoggerFactory.getLogger(WebTesterReleasesFixture.class);

    private Browser browser;
    private String repositoryName;

    @BeforeTable
    public void openBrowser() {
        LivingDoc.register(new ReleaseListTypeConverter());
        browser = new FirefoxFactory().createBrowser();
    }

    @AfterTable
    public void closeBrowser() {
        LivingDoc.unregisterLastAddedCustomConverter();
        browser.close();
    }

    @Alias("the GitHub repository")
    public boolean setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
        return true;
    }

    @Alias("navigating to releases")
    public boolean navigateToReleases() {
        String url = "http://github.com/" + repositoryName + "/releases";
        browser.open(url);
        return true;
    }

    @Alias("the following releases are displayed")
    public boolean checkReleases(ReleaseList releases) {
        List<String> actualReleases = browser.findMany(".release-title").map(PageFragment::getVisibleText).collect(toList());
        List<String> expectedReleases = releases.getReleases();
        boolean result = actualReleases.containsAll(expectedReleases);
        if (!result) {
            log.error("not all expected releases where displayed.\n\texpected: {}\n\tactual: {}", expectedReleases,
                actualReleases);
        }
        return result;
    }

    private static class ReleaseList {

        private final List<String> releases;

        private ReleaseList(List<String> releases) {
            this.releases = releases;
        }

        public List<String> getReleases() {
            return releases;
        }

    }

    public static class ReleaseListTypeConverter implements TypeConverter {

        @Override
        public boolean canConvertTo(Class<?> type) {
            return ReleaseList.class.equals(type);
        }

        @Override
        public Object parse(String value, Class<?> type) {
            String[] releases = StringUtils.split(value, ',');
            List<String> trimmedReleases = Arrays.stream(releases).map(String::trim).collect(toList());
            return new ReleaseList(trimmedReleases);
        }

        @Override
        public String toString(Object value) {
            ReleaseList releases = ( ReleaseList ) value;
            return StringUtils.join(releases.getReleases(), " \r\n");
        }

    }

}
