package WatchStateMachine;

public class TimeState implements WatchState {
    private static TimeState timeStateInstance = null;

    private TimeState(){}

    public static TimeState getInstance(){
        if(timeStateInstance==null){
            timeStateInstance = new TimeState();
        }
        return timeStateInstance;
    }
    @Override
    public void onStateEnter(IContext context) {

    }

    @Override
    public void onStateExit(IContext iContext) {

    }

    @Override
    public void onPress(IContext context, int button) {
        switch (button) {
            case 0:
                context.setState(TimeKeepingState.getInstance());
            case 2:
                context.setState(AlarmState.getInstance());
            default:
        }

    }
}
