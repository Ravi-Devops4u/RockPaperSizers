import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import lib.*;
import lib.interfaci.IGameLogicStrategy;
import lib.interfaci.IGameLogicStrategyResolver;
import lib.interfaci.IPlayerFactory;
import lib.interfaci.IUserWeaponChoiceProvider;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(IPlayerFactory.class).to(PlayerFactory.class);

        Multibinder<IGameLogicStrategy> strategyMultibinder = Multibinder.newSetBinder(binder(), IGameLogicStrategy.class);

        strategyMultibinder.addBinding().to(BasicGameLogicStrategy.class);
        strategyMultibinder.addBinding().to(ExtendedGameLogicStrategy.class);

        bind(IUserWeaponChoiceProvider.class).to(UserWeaponChoiceProvider.class);

        bind(IGameLogicStrategyResolver.class).to(GameLogicStrategyResolver.class);

        bind(Game.class).to(Game.class);

        /*Injector injector = Guice.createInjector(new AppModule());
         Game game  = injector.getInstance(Game.class);*/
    }
}