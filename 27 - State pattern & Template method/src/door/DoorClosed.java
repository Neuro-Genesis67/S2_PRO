package door;

public class DoorClosed extends DoorState {
    private Door door;

    public DoorClosed(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "CLOSED";
    }

    @Override
    public void click() {
        //door.setState(door.getOpeningState()); 
        door.startTimer(3000, event -> {
            //door.setState(door.getOpenState());
            // TODO: ??
        });
    }
}
