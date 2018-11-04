package WatchStateMachine;

public class IContext {
    WatchState state = null;

    public void setState(WatchState state){
        if(this.state != null) {
            this.state.onStateExit(this);
        }
        this.state=state;
        this.state.onStateEnter(this);
    }
}
