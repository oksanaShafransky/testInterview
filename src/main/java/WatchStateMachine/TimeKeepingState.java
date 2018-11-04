package WatchStateMachine;

public class TimeKeepingState implements WatchState{
    private static TimeKeepingState timeKeepingState = null;

    private TimeKeepingState(){
    }

    public static TimeKeepingState getInstance(){
        if(timeKeepingState == null){
            timeKeepingState = new TimeKeepingState();
        }
        return timeKeepingState;
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
                    context.setState(TimeState.getInstance());
                case 2:
                    context.setState(AlarmState.getInstance());
                default:
        }
    }
}
