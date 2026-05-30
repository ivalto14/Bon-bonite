package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CurrentPageUrl implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return net.serenitybdd.core.Serenity.getDriver().getCurrentUrl();
    }

    public static CurrentPageUrl value() {
        return new CurrentPageUrl();
    }
}
