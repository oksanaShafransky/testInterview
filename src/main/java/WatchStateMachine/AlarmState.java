package WatchStateMachine;

public class AlarmState implements WatchState{
    private static AlarmState alarmStateInstance = null;

    private AlarmState(){
    }

    public static AlarmState getInstance(){
        if(alarmStateInstance == null){
            alarmStateInstance = new AlarmState();
        }
        return alarmStateInstance;
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
                context.setState(TimeState.getInstance());
            default:
        }
    }
}
