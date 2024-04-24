import data.Participant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantManager {
    public static final int MAXIMUM_PARTICIPANTS = 100;
    private final List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        if (participants.size() < MAXIMUM_PARTICIPANTS) {
            System.out.println("Participant has been connected");
            participants.add(participant);
            return;
        }

        System.out.println("The system is currently full");
    }

    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public void removeAllParticipants() {
        participants.clear();
    }

    public Participant getParticipant(int id) {
        for (Participant participant : participants) {
            if (participant.getId() == id)
                return participant;
        }
        return null;
    }

    public boolean isLoggedIn(Participant participant) {
        for (Participant p : participants) {
            if (p == participant)
                return true;
        }
        return false;
    }
}
