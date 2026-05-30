package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToIframe implements Interaction {

    private final String iframeLocator;

    public SwitchToIframe(String iframeLocator) {
        this.iframeLocator = iframeLocator;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().frame(
                driver.findElement(By.cssSelector(iframeLocator))
        );
    }

    public static SwitchToIframe locatedBy(String cssLocator) {
        return new SwitchToIframe(cssLocator);
    }
}