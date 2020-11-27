package Not_Sys;

import javax.management.Notification;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "notification")
public class NotificationHandler extends Blueprint implements operation {

    public NotificationHandler() {
        super();
    }

    public NotificationHandler(String header, String content, String language) {
        super(header, content, language);
    }


    @Override
    public boolean create(ArrayList<ArrayList<String>> arr) {
        try {
            Blueprint Notify = new NotificationHandler();
            Inventory inventory = new MYSQLInventory();
            Blueprint temp = inventory.get(Integer.parseInt(arr.get(0).get(0)), "template");
            String Header = temp.getHeader();
            String Content = temp.getContent();
            for (int i = 0; i < arr.get(1).size(); i++) {
                Content = Content.replaceFirst("\\$", arr.get(1).get(i));
            }
            Notify.setContent(Content);
            Notify.setHeader(Header);
            Notify.setLanguage(temp.getLanguage());
            if (!inventory.store(Notify)) {
                throw new Exception("Error: Can't Store Notification DB Error");
            }
        } catch (Exception Error) {
            System.out.println(Error.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, Blueprint obj) {

        try {
            Inventory inventory = new MYSQLInventory();
            if (!inventory.update(id,obj)) {
                throw new Exception("Error: Can't update Message DB Error.");
            }
        } catch (Exception Error) {
            System.out.println(Error.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Inventory inventory = new MYSQLInventory();
            if (!inventory.delete(id, "notification")) {
                throw new Exception("Error: Can't Delete Message DB Error.");
            }
        } catch (Exception Error) {
            System.out.println(Error.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Blueprint read(int id) {
        Blueprint Msg = null;

        try {
            Inventory inventory = new MYSQLInventory();
            Msg=inventory.get(id, "notification");
            if (Msg != null) {
                return Msg;
            } else {
                throw new Exception("Error: Can't Read Message DB Error.");
            }

        } catch (Exception Error) {
            System.out.println(Error.getMessage());
        }
        return Msg;

    }

    @Override
    public String toString() {
        return "Notification " + id + "\n" + header + "\n" + content + "\n" + language + '\n';
    }
}
