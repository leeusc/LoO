public class Rooms {

    String roomName;
    int roomCost;
    Patient patient;

    public Rooms( String roomName,int roomCost ) {
        this.roomName = roomName;
        this.roomCost = roomCost;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName( String roomName ) {
        this.roomName = roomName;
    }

    public int getRoomCost() {
        return roomCost;
    }

    public void setRoomCost( int roomCost ) {
        this.roomCost = roomCost;
    }
    public Patient getPatient(){
        return patient;
    }

    @Override
    public String toString() {
        return "Room Type: " + roomName;
    }
}
