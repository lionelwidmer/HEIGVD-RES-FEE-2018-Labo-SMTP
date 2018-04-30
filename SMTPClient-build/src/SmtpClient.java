import catalog.ConfigManager;
import catalog.Group;
import catalog.Person;
import catalog.Prank;
import client.MailClient;
import java.io.IOException;

public class SmtpClient {
    public static void main(String[] args) throws IOException{
        // Exit if there are not exactly 3 arguments passed
        if (args.length != 3) {
            System.out.println("Error, you must pass exactly 3 arguments (group id, prank id, sender number");
            return;
        }

        // Save arguments in human-readable variable names
        int groupId = Integer.parseInt(args[0]);
        int prankId = Integer.parseInt(args[1]);
        int userId = Integer.parseInt(args[2]);
        String senderEMail = "";

        // Load the configuration (groups, pranks)
        ConfigManager configManager = new ConfigManager("config");
        for (Group g : configManager.getGroups()) {
            if (g.numberOfMembers() < 3) {
                System.out.println("Group " + g.getName() + " has less than 3 members. Exiting");
                return;
            }
        }
        // Get prank from configuration
        Prank prank = configManager.getPranks().get(prankId);

        // Connect to the server
        MailClient mailClient = new MailClient();
        mailClient.connect(configManager.getSmtpServer(), configManager.getSmtpPort());

        // Get group and loop through all members to find out sender
        Group group = configManager.getGroups().get(groupId);
        senderEMail = group.members().get(userId).getEmail();

        for (int i = 0; i < group.members().size(); i++) {
            // Do not send the email to the person that is the originator of the email
            if (i != userId) {
                System.out.println("Sending e-mail from " + senderEMail + " to " + group.members().get(i).getEmail());
                mailClient.sendMail(senderEMail, group.members().get(i).getEmail(), prank.getSubject(), prank.getBody());
            }
        }
        mailClient.disconnect();
    }
}
