package viewC;

/*********************
 * Andre Stadler
 *****************+**/
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import model.Phonebook;
import java.io.IOException;

public class PhonebookC
{


    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PhonebookC.class.getResource("PhoneBookV.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("ColorCalc");
            stage.setScene(new Scene(root, 700, 560));
            stage.show();
        }
        catch (IOException e) {
            System.err.println("Something wrong with ColorCalcV.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }


    @FXML
    private TextField nameTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField phoneTxt;
    @FXML
    private Label page_count;

    private Phonebook pb = new Phonebook();

    private int page;

    public void display(int i)
    {
        Person p = pb.getPerson(i-1);
        nameTxt.setText(p.getName());
        phoneTxt.setText(p.getPhoneNum());
        addressTxt.setText(p.getAdress());

        page_count.setText("Seite" + (i) + "|" + pb.size());

    }

    public void addPage()
    {
        pb.addPage();
        page = pb.size();
        display(page);

    }

    public void nextPage()
    {
        if(page < pb.size())
        {
            page++;
            display(page);
        }

        else
        {
            page = 1;
            display(page);
        }
    }

    public void previousPage()
    {
        if(page > 1)
        {
            page--;
            display(page);
        }

        else {
            page = pb.size();
            display(page);
        }
    }

    public void save()
    {
        pb.save(nameTxt.getText(), addressTxt.getText(), phoneTxt.getText(), page-1);
    }

    public void delete()
    {
        if(page == 1)
        {
            System.out.printf("Löschen nicht möglich ");
        }

        else

            {
                pb.delete(page-1);
                page--;
                display(page);
        }


    }

    public void load_csv()
    {
        pb.CSV_load();
        page = 1;
        display(page);
    }

    public void save_csv()
    {
        pb.CSV_save();
    }

}
