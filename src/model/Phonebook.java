package model;
/*********************
 * Andre Stadler
 *****************+**/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class Phonebook
{

    private List<Person> pb = new LinkedList<Person>();


    public Phonebook()
    {
        this.addPage();
    }


    public void addPage()
    {
        pb.add(new Person());
    }


    public Person getPerson(int i)
    {
        Person p = null;
        try {
            p = pb.get(i);
        }
        catch (Exception e) {}
        return p;
    }

    public void delete(int i)
    {
        pb.remove(i);
    }

    public int size()
    {
        return pb.size();
    }

    public void save(String name, String adress, String phone, int i)

    {
        Person p = pb.get(i);
        p.setName(name);
        p.setAdress(adress);
        p.setPhoneNum(phone);
    }

    public void CSV_save()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("phoneBook.csv")))
        {
            for (int i = 0; i < pb.size(); i++)
            {
                bw.write(pb.get(i).toString());
                bw.newLine();
            }

        }
        catch (Exception e)
        {
            System.out.printf("Speichern fehlgeschlagen");
        }
    }

    public void CSV_load()
    {
        pb.clear();

        try(BufferedReader br = new BufferedReader(new FileReader("phoneBook.csv")))
        {
            String s = "";
            while ((s = br.readLine()) != null)
            {
                String split[] = s.split(",");
                pb.add(new Person(split[0], split[1], split[2]));
            }
        }catch (Exception e)
        {
            System.out.printf("Laden Fehlgeschlagen");
        }
    }
}
