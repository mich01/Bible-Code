import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

public class HiddenMessage
{
    public static int Distance=0;
    public static StringBuilder Temp_HiddenMessage;
    public static boolean Stage1Found;
    public static boolean Stage2Found;
    public static boolean Stage3Found;
    public static int Keypos1=0;
    public static int Keypos2=0;
    static StringBuilder HiddenMessage ;
    public static void main(String [] args)
    {
        Stage1Found =false;
        Stage2Found =false;
        Stage3Found =false;
        String Found ="NotFound";
        String Message_Cipher="Hello there and warm greetings to you my friends.? Todd did you hear about this years calls about party for the initiation of news anchor list joinning communnial agency? I want you to be our custodian and lead the team coordinating retailers attendance and attire for the event. Also make sure three slots are set asside. Estimate all calls and do aggregate all entries.";
        String Key = "atm";
        BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Message_Cipher);
        System.out.println("Enter the Key to extract the hidden message\t");
        try {
            Key = BF.readLine();
            System.out.println("They Key Entered is: "+Key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Starting Extraction "+Key);
        HiddenMessage =  new StringBuilder();
        System.out.println("Test");
        for (int i=0;i<Message_Cipher.length();i=i+Keypos1)
        {
            if(Decrypt(i, Message_Cipher, Key).equals("Found"))
            {
                System.out.println("Yap");
                break;
            }
            else
            {
                System.out.println("Nope");
            }

        }
        if(HiddenMessage.length()<1)
        {
            System.out.println("No message found");
        }
        else
        {

            System.out.println("Hidden Message: " + HiddenMessage.toString().substring(1,HiddenMessage.length()/2));
        }
    }
    private static String Decrypt(int StartPosition,String Message_Cipher,String Key)
    {
        return DecipherText(Message_Cipher, Key, StartPosition, 0, 0);
    }
    public static String DecipherText(String Phrase, String Cypher_Key, int Phrase_position, int Key_position, int Distance)
    {
        String Found ="NotFound";
        if(Key_position==0)
        {
            for(int i=Phrase_position;i<Phrase.length();i++)
            {
                if(Phrase.charAt(i)==Cypher_Key.charAt(0))
                {
                    System.out.println("First Match Found at position: "+i);
                    Phrase_position=i;
                    Keypos1=i;
                    DecipherText(Phrase, Cypher_Key, Phrase_position+1, Key_position+1, i);
                    break;
                }
            }
        }
        else if(Key_position==1)
        {
            for(int i=Phrase_position;i<Phrase.length();i++)
            {
                if(Phrase.charAt(i)==Cypher_Key.charAt(Key_position))
                {
                    Distance =i-Keypos1;
                    Keypos2=Key_position+1;
                    System.out.println("Second Match Found at position: "+i+" at a distance of "+Distance);
                    Found="Found";
                    Compare_Subsequent(Phrase,  Cypher_Key, Keypos2, Distance, i);
                    break;
                }
            }
        }
        return Found;
    }
    public static  String Compare_Subsequent(String Phrase, String Key, int Key_pos,int Distance, int PhrasePosition)
    {
        String Found = "NotFound";
        if(PhrasePosition+Distance<Phrase.length()-1) {
            if (Key_pos > Key.length() - 1) {
                Find_Others(Phrase, PhrasePosition, Distance);
                Found = "Found";
            } else {
                System.out.println("Comparing " + Phrase.charAt(PhrasePosition + Distance) + " and " + Key.charAt(Key_pos));
                if (Phrase.charAt(PhrasePosition + Distance) == Key.charAt(Key_pos)) {
                    System.out.println("Yap Found: " + Phrase.charAt(PhrasePosition + Distance));
                    Compare_Subsequent(Phrase, Key, Key_pos + 1, Distance, PhrasePosition + Distance);
                } else {
                    System.out.println("Nope No match " + Phrase.charAt(PhrasePosition + Distance));
                    DecipherText(Phrase, Key, PhrasePosition + 1, 1, Distance);
                }
            }
        }
        return Found;
    }
    public static String Find_Others(String Phrase,int Phrase_pos,int Distance)
    {
        //HiddenMessage=new StringBuilder();
        //System.out.println("Length of string "+Phrase.length()+" vs "+Phrase_pos);
        System.out.println("Extracting Rest of Hidden Message: "+Phrase.charAt(Phrase_pos));
        HiddenMessage.append(Phrase.charAt(Phrase_pos));
        Phrase_pos = Phrase_pos + Distance;
        if((Phrase_pos)<Phrase.length())
        {
            Find_Others(Phrase, Phrase_pos, Distance);
        }
        return "Found";
    }
}
