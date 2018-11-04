package WatchStateMachine;

public interface WatchState {
    public void onStateEnter(IContext context);
    public void onStateExit(IContext context);
    public void onPress(IContext context, int button);
}
