import data.Participant;

import java.util.List;

public class ParticipantManager {
    public static final int MAXIMUM_PARTICIPANTS = 100;
    private List<Participant> participants;

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

    public Participant getParticipant(int id) {
        for (Participant participant : participants) {
            if (participant.getId() == id)
                return participant;
        }
        return null;
    }
}
