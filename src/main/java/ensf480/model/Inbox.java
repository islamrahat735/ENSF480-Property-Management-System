package ensf480.model;
import java.util.ArrayList;

public class Inbox {
        private ArrayList<Email> inbox = new ArrayList<>();

        public ArrayList<Email> getInbox() {
            return inbox;
        }

        public Email getEmail(int index) {
            return inbox.get(index);
        }

        public void addEmail(Email email) {
            inbox.add(email);
        }
    
        public void removeEmail(int index) {
            inbox.remove(index);
        }
    
        public void clearInbox() {
            inbox.clear();
        }
    
}
