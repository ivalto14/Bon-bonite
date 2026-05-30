package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickSafe implements Interaction {

    private final Target target;

    public ClickSafe(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(target)
        );
    }

    public static ClickSafe on(Target target) {
        return Tasks.instrumented(ClickSafe.class, target);
    }
}
